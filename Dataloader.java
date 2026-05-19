import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;



public class Dataloader {

    public static void main(String[] args) throws IOException {

        DataInputStream images = new DataInputStream(
            new FileInputStream("archive/train-images-idx3-ubyte/train-images-idx3-ubyte")
        );

        int magic = images.readInt();
        int numberofimages = images.readInt();
        int rows = images.readInt();
        int cols = images.readInt();


        double[][][] x = new double[numberofimages][rows*cols][1];

        


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

        System.out.println(x[0][0][0]);
        System.out.println(x[0][1][0]);
        System.out.println(x[0][2][0]);


        //one-hot encoding
        double[][][] y = new double[numberofimages][10][1];

        for(int i = 0 ; i < numberofimages ; i++){

           int digit = y_[i];

           y[i][digit][0] = 1.0;
        }

        System.out.println(y[0][0][0]);
        System.out.println(y[0][1][0]);
        System.out.println(y[0][2][0]);
        System.out.println(y[0][3][0]);
        System.out.println(y[0][4][0]);
        System.out.println(y[0][5][0]);
        System.out.println(y[0][6][0]);
        System.out.println(y[0][7][0]);
        System.out.println(y[0][8][0]);
        System.out.println(y[0][9][0]);







        


    }
}