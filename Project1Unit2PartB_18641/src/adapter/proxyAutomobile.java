package adapter;

import java.util.ArrayList;

import exception.NoModel;
import model.Automobile;
import util.FileIO;

/**
 * @author-Rui Wang rw1
 * This class to implement all methods lists in the interface.
 */
public abstract class proxyAutomobile {
    /**
     * An instance of Automobile.
     */
    private static Automobile a1;
    
    /**
     * @param filename
     * Given a text file name a method called BuildAuto can be written to build an instance of 
     * Automobile. This method does not have to return the Auto instance
     */
    public void BuildAuto(String filename) {
        FileIO io = new FileIO();
        a1 = io.buildAuto(filename);
    }
    /**
     * @return the model name
     */
    public String getModelName() {
        return a1.getName();
    }
    /**
     * @param a1 the a1 to set
     */
    public int getBasePrice() {
        return a1.getBasePrice();
    }
    /**
     * This function searches and prints the properties of a given Automodel.
     * @param Modelname
     */
    public void printAuto(String Modelname) {
        a1.printModelInfo();
    }
    /**
     * This function searches the Model for a given OptionSet and sets the name of OptionSet to
     * newName.
     * @param Modelname
     * @param optionSetName
     * @param newName
     */
    public void updateOptionSetName(String Modelname, String optionSetName, String newName) {
        try {
            a1.updateOptionSetName(Modelname, optionSetName, newName);
        } catch (NoModel e) {
            e.print();
        }
    }
    /**
     * This function searches the Model for a given OptionSet and Option name, and sets the price to
     * newPrice.
     * @param Modelname
     * @param Optionname
     * @param Option
     * @param newprice
     */
    public void updateOptionPrice(String Modelname, String Optionname, String Option, int newprice) {
        try {
            a1.updateOptionPrice(Modelname, Optionname, Option, newprice);
        } catch (NoModel e) {
            // TODO Auto-generated catch block
            e.print();
        }
    }
    
    public int getTotalPrice() {
        return a1.getTotalPrice();
    }
}
