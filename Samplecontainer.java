public class Samplecontainer {

    double[][] image = new double[784][1];
    double[][] label = new double[10][1];

    

    public Samplecontainer(double[][] image , double[][] label) {
        this.image=image;
        this.label=label;
    }

    
    
    
}