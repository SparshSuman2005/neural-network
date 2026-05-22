import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;



public class Dataloader {

     public static ArrayList<Samplecontainer> samples = new ArrayList<>();

     public static void loaddata()throws IOException{
        samples.clear();
         DataInputStream images = new DataInputStream(
            new FileInputStream("archive/train-images-idx3-ubyte/train-images-idx3-ubyte")
        );

        int magic = images.readInt();
        int numberofimages = images.readInt();
        int rows = images.readInt();
        int cols = images.readInt();


        double[][][] x = new double[numberofimages][rows*cols][1];

        System.out.println("Images");

        


        for(int k = 0 ; k < numberofimages ; k++){
            int index = 0;
            for(int i = 0 ; i < rows ; i++){
            for(int j = 0 ; j < cols ; j++){
                
                int pixel = images.readUnsignedByte();
                x[k][index][0] = pixel / 255.0;
                index++;
            }
        }
    }
        images.close(); 

        System.out.println("Labels");



        
        DataInputStream labels = new DataInputStream(
            new FileInputStream("archive/train-labels-idx1-ubyte/train-labels-idx1-ubyte")
        );

        int labelMagic = labels.readInt();
        int numberOfLabels = labels.readInt();

        if(numberOfLabels!=numberofimages){
            System.out.println("Mismatch dataset!!");
            System.exit(0);
        }


        int[] y_ = new int[numberofimages];

        for(int k = 0 ; k < numberofimages ; k++){
            y_[k]=labels.readUnsignedByte();
        }

        labels.close();

        System.out.println(y_[0]);
        System.out.println(y_[1]);

        System.out.println("One-hot");





        //one-hot encoding
        double[][][] y = new double[numberofimages][10][1];

        for(int i = 0 ; i < numberofimages ; i++){

           int digit = y_[i];

           y[i][digit][0] = 1.0;
        }

        Samplecontainer[] sample = new Samplecontainer[numberofimages];

        System.out.println("container");

        

        for(int i = 0 ; i < numberofimages ; i++){
            sample[i] = new Samplecontainer(x[i],y[i]);
            samples.add(sample[i]);
        }


     }


     public static void loadtestdata() throws IOException {
        samples.clear();

        DataInputStream images = new DataInputStream(
            new FileInputStream("archive/t10k-images-idx3-ubyte/t10k-images-idx3-ubyte")
        );

        int magic = images.readInt();
        int numberofimages = images.readInt();
        int rows = images.readInt();
        int cols = images.readInt();

        double[][][] x = new double[numberofimages][rows * cols][1];

        System.out.println("Test Images");

        for (int k = 0; k < numberofimages; k++) {
            int index = 0;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    int pixel = images.readUnsignedByte();
                    x[k][index][0] = pixel / 255.0;
                    index++;
                }
            }
        }

        images.close();

        System.out.println("Test Labels");

        DataInputStream labels = new DataInputStream(
            new FileInputStream("archive/t10k-labels-idx1-ubyte/t10k-labels-idx1-ubyte")
        );

        int labelMagic = labels.readInt();
        int numberOfLabels = labels.readInt();

        if (numberOfLabels != numberofimages) {
            System.out.println("Mismatch dataset!!");
            System.exit(0);
        }

        int[] y_ = new int[numberofimages];

        for (int k = 0; k < numberofimages; k++) {
            y_[k] = labels.readUnsignedByte();
        }

        labels.close();

        double[][][] y = new double[numberofimages][10][1];

        for (int i = 0; i < numberofimages; i++) {
            int digit = y_[i];
            y[i][digit][0] = 1.0;
        }

        for (int i = 0; i < numberofimages; i++) {
            samples.add(new Samplecontainer(x[i], y[i]));
        }
    }

    public static void main(String[] args) throws IOException {

        loaddata();

        
        Matrixutilities.print(samples.get(10).image);
        Matrixutilities.print(samples.get(10).label);






        


    }
}