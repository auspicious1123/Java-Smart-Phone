package adapter;

/**
 * @author-Rui Wang rw1
 */
public interface CreateAuto {
    /**
     * @param filename
     * Given a text file name a method called BuildAuto can be written to build an instance of 
     * Automobile. This method does not have to return the Auto instance
     */
    public void BuildAuto(String filename);
    
    /**
     * This function searches and prints the properties of a given Automodel.
     * @param Modelname
     */
    public void printAuto(String Modelname);

}
