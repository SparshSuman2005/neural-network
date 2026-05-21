public class Neuralnetwork {

    public static void main(String[] args){

        Layers[] l = new Layers[4];

        l[0] = new Layers(128, 784);
        l[1] = new Layers(64,128);
        l[2] = new Layers(32,64);
        l[3] = new Layers(10, 32);







        
    }
    
}
