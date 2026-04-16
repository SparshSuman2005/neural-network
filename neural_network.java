/*author@Sparsh
trying to build a neural network from scratch */


public class neural_network{
    public static double lr = 0.01;
    static double[] x = {4.0,5.0};//inputs
    double[] weighths={3.0,3.0};//weights 
    double bias = 1.0;
    double loss;

    //activation function
    public double  sigmoid (double z){
        return (1/(1+Math.exp(-z)));
    }

    public static double binary_cross_entropy(double y , double y_pred){

        double loss = -(y*Math.log(y_pred) + (1-y)*Math.log(1-y_pred)); 
        return loss;
    }


    //main function
    public static void main(String[] args){
        



        //code for one neuron

        //instantiation
    //     neural_network nn = new neural_network();

    //     boolean flag = true;
    //     int count = 0;
    //     while(flag){
    //     double z = nn.weighths[0]*nn.x[0] + nn.weighths[1]*nn.x[1] + nn.bias ;
    //     int expected_output = 1;//target value
    //     double pred = nn.sigmoid(z);
    //     System.out.println("The prediction is "+pred);//predicted value
    //     nn.loss = binary_cross_entropy(expected_output, pred);
    //     int i;
    //     double gradient = 0;
    //     for(i = 0 ; i < nn.weighths.length ; i++){

    //         gradient = 0;
    //         gradient =  (nn.x[i]*(pred-expected_output));
            
    //         nn.weighths[i] = nn.weighths[i] - (lr*gradient); 

    //     }

    //     if(Math.abs(nn.loss)<Math.pow(10,-5)){
    //         flag = false;
    //     }
    //     count++;
    //     if(count >= 200){
    //         break;
    //     }

    //     System.out.println("tye weights are ");
    //     for(int j = 0 ; j < nn.weighths.length ; j++){
    //         System.out.println(nn.weighths[j]);
    //     }
    // }




    //code for the entire network
    neural_network h1 = new neural_network();
    neural_network h2 = new neural_network();
    neural_network out = new neural_network();

    int[][] x = new int[4][2];
    int[] z = new int[4];


    int epochs = 10;
    for(int j = 0 ; j<epochs ; j++){
        for(int i  = 0 ; i<4 ; i++){



            //forward passes

            //hidden neuron 1 
            double[] H1 = {0.0,0.0};
            double[] bH1 = {0.0,0.0};
            for(int k = 0 ; k<h1.weighths.length ; k++){
                for(int l =0 ; i<2 ;i++){}
                bh1=bh1+(h1.weighths[i]*)
            }
            }
            
        }
    }




    }
}