package adapter;

/**
 * @author-Rui Wang rw1
 */
public interface UpdateAuto {
    /**
     * This function searches the Model for a given OptionSet and sets the name of OptionSet to
     * newName.
     * @param Modelname
     * @param optionSetName
     * @param newName
     */
    public void updateOptionSetName(String Modelname, String optionSetName, String newName) ;
    
    /**
     * This function searches the Model for a given OptionSet and Option name, and sets the price to
     * newPrice.
     * @param Modelname
     * @param Optionname
     * @param Option
     * @param newprice
     */
    public void updateOptionPrice(String Modelname, String Optionname, String Option, float newprice);
    
}
