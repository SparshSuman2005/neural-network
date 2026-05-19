//author@Sparsh

public class Matrixutilities {


    public static double[][] matmul(double[][] a , double[][] b){

        if(a[0].length != b.length){
            System.out.println("dimensions incomaptible !");
            return null ;
        }
        int rows = a.length;
        int cols = b[0].length;


        double[][] res = new double[rows][cols];
        

        for(int i = 0 ; i<rows ; i++){
            for(int j = 0 ; j<cols;j++){
                res[i][j]=0;
            }
        }

        for(int i = 0 ; i < rows; i++){
            for(int j = 0 ; j < cols  ; j++){
                for(int k =0 ; k <b.length ; k++){
                    res[i][j]+=a[i][k]*b[k][j];
                }
            }
        }

        return res;
    }



    public static double[][] transpose(double[][] a){
        int row = a[0].length;
        int col = a.length;

        double[][] res = new double[row][col];


         for(int i = 0 ; i<row ; i++){
            for(int j = 0 ; j<col;j++){
                res[i][j]=a[j][i];
            }
        }

        return res;

    }



    public static double[][] consmul(double[][] a , double k){
        int row = a.length;
        int col = a[0].length;


        for (int i = 0 ; i < row ; i++){
            for(int j = 0 ; j < col ; j++){
                a[i][j] = k*a[i][j];
            }
        }


        return a ;

    } 


    
    public static double[][] hadamard(double[][] a , double [][] b){
        int m = a.length;
        int n = a[0].length;

        double[][] res = new double[m][n];

        if(a.length==b.length && a[0].length == b[0].length){
            for(int i = 0 ; i < m ; i++){
                for(int j =0 ; j< n ; j++){
                    res[i][j] = a[i][j]*b[i][j];
                }
            }
        }
        else{
            System.out.println("Invalid Dimensions");
            return null;
        }

        return res ;
    }


    public static double[][] add(double[][] a , double [][] b){
        int m = a.length;
        int n = a[0].length;

        double[][] res = new double[m][n];

        if(a.length==b.length && a[0].length == b[0].length){
            for(int i = 0 ; i < m ; i++){
                for(int j =0 ; j< n ; j++){
                    res[i][j] = a[i][j]+b[i][j];
                }
            }
        }else{
            System.out.println("Invalid Dimensions");
            return null;
        }

        return res ;
    }


    public static double[][] substract(double[][] a , double [][] b){
        int m = a.length;
        int n = a[0].length;

        double[][] res = new double[m][n];

        if(a.length==b.length && a[0].length == b[0].length){
            for(int i = 0 ; i < m ; i++){
                for(int j =0 ; j< n ; j++){
                    res[i][j] = a[i][j]-b[i][j];
                }
            }
        }else{
            System.out.println("Invalid Dimensions");
            return null;
        }

        return res ;
    }


    public static void print(double[][] a ){
        int m = a.length;
        int n = a[0].length;

       for(int i = 0 ; i < m ; i++){
                for(int j =0 ; j< n ; j++){
                    System.out.print(a[i][j]+" ");
                }
                System.out.println();
            }
    }


    public static double[][] map(double[][] a){
        int m = a.length;
        int n = a[0].length;

       
            for(int i = 0 ; i < m ; i++){
                for(int j =0 ; j< n ; j++){
                    a[i][j] = Activations.sigmoid(a[i][j]);
                }
            }
        

        return a ;
    }




    public static int[] dim(double[][] x){
        int[] a = {x[0].length,x.length};
        return a ;
    }



    public static double[][] mapsigmoidderivative(double[][] var1) {
      int var2 = var1.length;
      int var3 = var1[0].length;

      for(int var4 = 0; var4 < var2; ++var4) {
         for(int var5 = 0; var5 < var3; ++var5) {
            var1[var4][var5] = Activations.sigmoidderivation(var1[var4][var5]);
         }
      }

      return var1;
   }


}
