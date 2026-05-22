import java.io.IOException;
import java.util.Collections;

public class Neuralnetwork {

    static Layers[] l = new Layers[4];



    public static double bce(double[][] yHat, double[][] y) {
    double loss = 0.0;
    double eps = 1e-15;

    for (int i = 0; i < y.length; i++) {
        double a = yHat[i][0];

        // avoid log(0)
        if (a < eps) a = eps;
        if (a > 1.0 - eps) a = 1.0 - eps;

        loss += -(y[i][0] * Math.log(a) + (1 - y[i][0]) * Math.log(1 - a));
    }

    return loss;
}

public static int argmax(double[][] a) {
    int maxIndex = 0;

    for (int i = 1; i < a.length; i++) {
        if (a[i][0] > a[maxIndex][0]) {
            maxIndex = i;
        }
    }

    return maxIndex;
}




    public static void main(String[] args) throws IOException{

        Dataloader.loaddata();

        

        l[0] = new Layers(128, 784);
        l[1] = new Layers(64,128);
        l[2] = new Layers(32,64);
        l[3] = new Layers(10, 32);


        for(int j = 0  ; j < 5 ; j++){

            double totalloss = 0.0 ;
            int correct = 0;

            for(int i = 0 ; i < Dataloader.samples.size() ; i++){


                l[0].forward(Dataloader.samples.get(i).image);
                l[1].forward(l[0].A);
                l[2].forward(l[1].A);
                l[3].forward(l[2].A);


                double loss= bce(l[3].A , Dataloader.samples.get(i).label);
                totalloss+=loss;


                int predicted = argmax(l[3].A);
                int actual = argmax(Dataloader.samples.get(i).label);

                if (predicted == actual) {
                    correct++;
                }

                l[3].backpropagate_initial(Dataloader.samples.get(i).label);
                l[2].backpropagate(l[3].dz, l[3].w);
                l[1].backpropagate(l[2].dz, l[2].w);
                l[0].backpropagate(l[1].dz, l[1].w);

                l[0].update();
                l[1].update();
                l[2].update();
                l[3].update();




            }

                double avgCost = totalloss / Dataloader.samples.size();
                double accuracy = (double) correct / Dataloader.samples.size();

                
                System.out.println("Epoch : " + j + " Cost : " + avgCost + " accuracy : "+ accuracy);

            Collections.shuffle(Dataloader.samples);
        }


        Dataloader.loadtestdata();
        int correct = 0;
        int[][] confusionMatrix = new int[10][10];

         for(int i = 0 ; i < Dataloader.samples.size() ; i++){


                l[0].forward(Dataloader.samples.get(i).image);
                l[1].forward(l[0].A);
                l[2].forward(l[1].A);
                l[3].forward(l[2].A);


                int predicted = argmax(l[3].A);
            int actual = argmax(Dataloader.samples.get(i).label);

            confusionMatrix[actual][predicted]++;

            if (predicted == actual) {
                correct++;
            }
        }

        double accuracy = (double) correct / Dataloader.samples.size();

        System.out.println();
        System.out.println("Test accuracy : " + accuracy);
        System.out.println("Correct : " + correct + " / " + Dataloader.samples.size());
        System.out.println();
        System.out.println("Confusion Matrix");
        System.out.println("Rows = actual labels, Columns = predicted labels");

        System.out.print("      ");
        for (int i = 0; i < 10; i++) {
            System.out.printf("%5d", i);
        }
        System.out.println();

        for (int actual = 0; actual < 10; actual++) {
            System.out.printf("%5d ", actual);
            for (int predicted = 0; predicted < 10; predicted++) {
                System.out.printf("%5d", confusionMatrix[actual][predicted]);
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("Digit    TP      FP      TN      FN");

        for (int digit = 0; digit < 10; digit++) {
            int tp = confusionMatrix[digit][digit];
            int fp = 0;
            int fn = 0;

            for (int i = 0; i < 10; i++) {
                if (i != digit) {
                    fp += confusionMatrix[i][digit];
                    fn += confusionMatrix[digit][i];
                }
            }

            int tn = Dataloader.samples.size() - tp - fp - fn;

            System.out.printf("%5d %6d %7d %7d %7d%n", digit, tp, fp, tn, fn);
        }
    }





        







        
}
    

