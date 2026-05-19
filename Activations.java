//author@SparshSuman
public class Activations {


    

    public static double sigmoid(double a){
        double b;

        b = 1/(1-Math.exp(-a));
        return b;
    }


    public static double sigmoidderivation(double a){

        return (sigmoid(a)*(1-sigmoid(a)));
    }
}

