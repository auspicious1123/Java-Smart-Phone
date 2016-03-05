package adapter;

import java.util.LinkedHashMap;

import exception.NoModel;
import model.Automobile;
import util.FileIO;

/**
 * @author-Rui Wang rw1 This class to implement all methods lists in the
 *             interface.
 */
public abstract class proxyAutomobile {
    /**
     * An instance of Automobile.
     */
    private static Automobile a1;

    /**
     * @param filename
     *            Given a text file name a method called BuildAuto can be
     *            written to build an instance of Automobile. This method does
     *            not have to return the Auto instance
     */
    public void BuildAuto(String filename) {
        FileIO io = new FileIO();
        a1 = io.buildAuto(filename);
    }
    
    public Automobile getAuto() {
        return a1;
    }

    /**
     * @return the model name
     */
    public String getModelName() {
        return a1.getName();
    }

    /**
     * @param a1
     *            the a1 to set
     */
    public int getBasePrice() {
        return a1.getBasePrice();
    }

    /**
     * This function searches and prints the properties of a given Automodel.
     * 
     * @param Modelname
     */
    public void printAuto(String Modelname) {
        a1.printModelInfo();
    }

    /**
     * This function searches the Model for a given OptionSet and sets the name
     * of OptionSet to newName.
     * 
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
     * This function searches the Model for a given OptionSet and Option name,
     * and sets the price to newPrice.
     * 
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
    
    /*
     * Build multiple automobiles
     */
    private static LinkedHashMap<String, Automobile> autoSet = new LinkedHashMap<>();

    public void bulidAutos() {
        FileIO io = new FileIO();
        Automobile auto = io.buildAuto("Model.tt");
        autoSet.put(auto.getName(), auto);
        Automobile auto2 = io.buildAuto("Model2.txt");
        autoSet.put(auto2.getName(), auto2);
    }

    public Automobile getModel(String modelName) {
        return autoSet.get(modelName);
    }

    public void updateUptionSetName(String modelName, String optionSetName, String newName) {
        Automobile mobi = autoSet.get(modelName);
        mobi.updateOptionSet(optionSetName, newName);
    }

//    public void updateOptionPrice(String modleName, String optionSetName, String optionName, int optionPrice) {
//        Automobile mobi = autoSet.get(modleName);
//        mobi.updateOption(optionSetName, optionName, optionPrice);
//    }

    public void printModel(String modelName) {
        Automobile mobi = autoSet.get(modelName);
        mobi.printModelInfo();
    }
    
    /* (non-Javadoc)
     * @see adapter.EditAuto#getAutoMobileByName(java.lang.String)
     */
    public Automobile getAutoMobileByName(String name) {
        // TODO Auto-generated method stub
        if(autoSet.get(name) != null){
            return autoSet.get(name);
        }
        return null;
    }
    
}
