public class Layers {
    double[][] A;
    double[][] A_prev;
    double[][] w;
    double[][] z;
    double[][] b;
    int n ;
    
    
    Layers( int n , int n_prev){
        
        this.n = n;

        this.w = Initializers.xavieruniforminitialize( n , n_prev );
        this.b = Initializers.biasinitialize(n,1);


    }


    

    public void forward(double[][] A_prev){
        
        this.A_prev = A_prev;
        double[][] a = Matrixutilities.matmul(w,A_prev);
        this.z = Matrixutilities.add(a, b);
        this.A = Matrixutilities.map(z);

    }


    public void backpropagate(double[][] dz_next , double[][] w_next , double[][] A_prev){
        this.A_prev=A_prev;
        double lr = 0.1;
        double[][] dz = Matrixutilities.hadamard((Matrixutilities.matmul(Matrixutilities.transpose(w_next), dz_next)),  Matrixutilities.mapsigmoidderivative(z) );
        double[][] dw = Matrixutilities.matmul(dz, Matrixutilities.transpose(A_prev));
        double[][] db = dz;
        

        w = Matrixutilities.substract(w, Matrixutilities.consmul(dw, lr));
        b = Matrixutilities.substract(b, Matrixutilities.consmul(db, lr));


        
    }
    
}
