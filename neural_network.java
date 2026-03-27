/*author@Sparsh
trying to build a neural network from scratch */


public class neural_network{
    public static double lr = 0.01;
    static double[] x = {4.0,5.0};//inputs
    double[] weighths={3.0,3.0};//weights 
    double bias = 1.0;
    double error ;

    //activation function
    public double  sigmoid (double z){
        return (1/(1+Math.exp(-z)));
    }


    //main function
    public static void main(String[] args){
        neural_network nn = new neural_network();
        boolean flag = true;
        int count = 0;
        while(flag){
        double z = nn.weighths[0]*nn.x[0] + nn.weighths[1]*nn.x[1] + nn.bias ;
        int expected_output = 1;//target value
        double pred = nn.sigmoid(z);
        System.out.println("The prediction is "+pred);//predicted value
        nn.error =pred - expected_output;
        System.out.println("The loss is "+nn.error);

        double sensitivity = pred*(1-pred);


        for(int i = 0 ; i <= nn.weighths.length-1 ; i++){
            nn.weighths[i] = nn.weighths[i]-(nn.error*nn.x[i]*lr*sensitivity);
        }
        nn.bias = nn.bias - (nn.error*lr*sensitivity);

        if(Math.abs(nn.error)<Math.pow(10,-5)){
            flag = false;
        }
        count++;
        if(count >= 200){
            break;
        }
    }
    }
}