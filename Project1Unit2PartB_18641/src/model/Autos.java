package model;

import java.util.LinkedHashMap;

import util.FileIO;

/**
 * @author-Rui Wang rw1
 */
public class Autos {
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
    
    public void updateOptionPrice(String modleName, String optionSetName, String optionName, int optionPrice) {
        Automobile mobi = autoSet.get(modleName);
        mobi.updateOption(optionSetName, optionName, optionPrice);
    }
    
    public void printModel(String modelName) {
        Automobile mobi = autoSet.get(modelName);
        mobi.printModelInfo();
    }
}
