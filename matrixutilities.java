//author@Sparsh

public class matrixutilities {


    public double[][] matmul(double[][] a , double[][] b){

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



    public double[][] transpose(double[][] a){
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



    public double[][] consmul(double[][] a , double k){
        int row = a.length;
        int col = a[0].length;


        for (int i = 0 ; i < row ; i++){
            for(int j = 0 ; j < col ; j++){
                a[i][j] = k*a[i][j];
            }
        }


        return a ;

    } 




    public double[][] initialize(int n , int m ){
        double[][] r = new double[n][m];

        for (int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                r[i][j] = Math.random();
            }
        }

        return r ;
    }



    public double[][] hadamard(double[][] a , double [][] b){
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


    public double[][] add(double[][] a , double [][] b){
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


    public double[][] substract(double[][] a , double [][] b){
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


    public void print(double[][] a ){
        int m = a.length;
        int n = a[0].length;

       for(int i = 0 ; i < m ; i++){
                for(int j =0 ; j< n ; j++){
                    System.out.print(a[i][j]+" ");
                }
                System.out.println();
            }
    }


    public double[][] map(double[][] a){
        int m = a.length;
        int n = a[0].length;

       
            for(int i = 0 ; i < m ; i++){
                for(int j =0 ; j< n ; j++){
                    a[i][j] = sigmoid(a[i][j]);
                }
            }
        

        return a ;
    }





}
