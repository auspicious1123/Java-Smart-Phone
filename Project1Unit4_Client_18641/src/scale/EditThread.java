package scale;

/**
 * @author-Rui Wang rw1
 */
public interface EditThread {
    public void updateOptionSetName(String Modelname, String optionSetName, String newName);
    public void updateOptionPrice(String Modelname, String Optionname, String Option, int newprice);
}
