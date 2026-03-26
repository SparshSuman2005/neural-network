public class neural_network{
    static double[] x = {4.0,5.0};
    double[] weighths={3.0,3.0};
    double bias = 1.0;
    public int sigmoid (double z){
        return (int)(1/(1+Math.exp(-z)));
    }
    public static void main(String[] args){
        neural_network nn = new neural_network();
        double z = nn.weighths[0]*nn.x[0] + nn.weighths[1]*nn.x[1] + nn.bias ;
        System.out.println( nn.sigmoid (z) );
    }
}