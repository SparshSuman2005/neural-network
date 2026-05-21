public class Layers {
    double[][] A;
    double[][] A_prev;
    double[][] w;
    double[][] z;
    double[][] b;
    int n ;
    double[][] dz;
    double[][] db;
    double[][] dw;
    
    
    Layers( int n , int n_prev){
        
        this.n = n;

        this.w = Initializers.xavieruniforminitialize( n , n_prev );
        this.b = Initializers.biasinitialize(n,1);


    }


    

    public double[][] forward(double[][] A_prev){
        
        this.A_prev = A_prev;
        double[][] a = Matrixutilities.matmul(w,A_prev);
        this.z = Matrixutilities.add(a, b);
        this.A = Matrixutilities.map(z);

        return this.A;
        }


    public void backpropagate(double[][] dz_next , double[][] w_next ){
        
        
        this.dz = Matrixutilities.hadamard((Matrixutilities.matmul(Matrixutilities.transpose(w_next), dz_next)),  Matrixutilities.mapsigmoidderivative(z) );
        this.dw = Matrixutilities.matmul(dz, Matrixutilities.transpose(this.A_prev));
        this.db = dz;
        
                
    }

    public void backpropagate_initial(double[][] Y ){
     
        this.dz =Matrixutilities.matmul( Matrixutilities.substract(A, Y)  , Matrixutilities.mapsigmoidderivative(z));
        this.dw=Matrixutilities.matmul(dz, Matrixutilities.transpose(this.A_prev));
        this.db = dz;
        
    }



    public void update(){

        double lr = 0.1;


        this.w = Matrixutilities.substract(this.w, Matrixutilities.consmul(this.dw, lr));
        this.b = Matrixutilities.substract(this.b, Matrixutilities.consmul(this.db, lr));



    }
    
}
