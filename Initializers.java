import java.util.*;;
public class Initializers {

    public static double[][] xavieruniforminitialize(int rows , int cols){


        double[][] a = new double[rows][cols];


        double limit = Math.sqrt(6.0/(rows+cols));

        Random rand = new Random();

        for(int i = 0 ; i < rows ; i++){
            for(int j = 0 ; j < cols ; j++){
                a[i][j]= (rand.nextDouble())*2*limit-limit;

            }
        }

        return a;


    }


    public static double[][] biasinitialize(int rows , int cols){
        double[][] a = new double[rows][cols];


        for(int i = 0 ; i < rows ; i++){
            for(int j = 0 ; j < cols ; j++){
                a[i][j]= 0;

            }
        }

        return a;

    }


    
}
