package model;

import java.io.Serializable;
import java.util.ArrayList;
import exception.NoModel;
import model.OptionSet.Option;

/**
 * @author-Rui Wang rw1
 */
public class Automobile implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = -1487135202332644676L;

    private String name;
    private int basePrice;
    private ArrayList<OptionSet> opset;
    private ArrayList<Option> choice;
    private String make;
    private String model;

    /*********************************** unit1 ****************************************/
    // constructors
    public Automobile() {
    }

    public Automobile(String name, int basePrice) {
        this.name = name;
        this.basePrice = basePrice;
        opset = new ArrayList<>();
        choice = new ArrayList<>();
    }

    public Automobile(String name, int basePrice, ArrayList<OptionSet> opset) {
        this.name = name;
        this.basePrice = basePrice;
        this.opset = opset;
    }


    /******************* setter and getter ***********************/
    // setter and getter for name, basePrice
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    /**
     * @return the choice
     */
    public ArrayList<Option> getChoice() {
        return this.choice;
    }

    /**
     * @param choice
     *            the choice to set
     */
    public void setChoice(ArrayList<Option> choice) {
        this.choice = choice;
    }
    
    public void printChoice(ArrayList<Option> choice) {
        for (int i = 0; i < choice.size(); i++) {
            Option op = choice.get(i);
            if (op != null) {
                printOptionInfo(op);
            }
        }
    }

    /**
     * @return the make
     */
    public String getMake() {
        return make;
    }

    /**
     * @param make
     *            the make to set
     */
    public void setMake(String make) {
        this.make = make;
    }

    /**
     * @return the model
     */
    public String getModel() {
        return model;
    }

    /**
     * @param model
     *            the model to set
     */
    public void setModel(String model) {
        this.model = model;
    }

    public void setBasePrice(int basePrice) {
        this.basePrice = basePrice;
    }

    public int getBasePrice() {
        return basePrice;
    }

    public void setOptionSet(String name) {
        opset.add(new OptionSet(name));
    }

    /******************** set option ****************/
    // set option
    public void setOption(String optionSetName, String optionName, int price) {
        for (OptionSet ops : opset) {
            if (ops.getName().equals(optionSetName)) {
                ops.setOption(optionName, price);
            }
        }
    }

    // set option choice
    public void setOptionChoice(String optionSetName, String optionName) {
        Option optionChoice = null;
        for(OptionSet ops : opset) {
            if(ops.getName().equals(optionSetName)) {
                optionChoice = ops.getOption(optionName);
            }
        }choice.add(optionChoice);
    }

    // get OptionSet with name or index value
    public OptionSet getOptionSet(String optionSetName) {
        for (int i = 0; i < opset.size(); i++) {
            if (opset.get(i).getName().equals(optionSetName)) {
                return opset.get(i);
            }
        }
        return null;
    }

    public OptionSet getOptionSet(int index) {
        if (index >= 0 && index < opset.size()) {
            return opset.get(index);
        } else {
            return null;
        }
    }

    /***************** Find *****************************/
    // Find OptionSet with name
    public OptionSet findOptionSet(String optionSetName) {
        for(OptionSet ops : opset) {
            ops.getName().equals(optionSetName);
            return ops;
        }
        return null;
    }

    public OptionSet findOptionSet(int index) {
        if (index >= 0 && index < opset.size()) {
            return opset.get(index);
        }
        return null;
    }

    // Find Option with name (in content of OptionSet)
    public Option findOption(String optionSetName, String optionName) {
        OptionSet optionSet = findOptionSet(optionSetName);
        if (optionSet == null) {
            return null;
        }
        
        if (optionSet.getOption(optionName) != null) {
           return optionSet.getOption(optionName);
        } else {
            return null;
        }
    }

    /************** Delete **********************/
    // Delete an optionSet
    public void deletOptionSet(String optionSetName) {
        for (int i = 0; i < opset.size(); i++) {
            if (opset.get(i) == null)
                continue;
            if (opset.get(i).getName().equals(optionSetName)) {
                opset.remove(i);
            }
        }
    }

    public void deletOptionSet(int index) {
        if (index >= 0 && index < opset.size()) {
            opset.remove(index);
        }
    }

    // Delete an option
    public void deleteOption(String optionSetName, String optionName) {
        for (int i = 0; i < opset.size(); i++) {
            if (opset.get(i) == null) // if opset[i] == null, it is deleted or
                                      // equals to null, continue check next one
                continue;
            if (opset.get(i).getName().equals(optionSetName)) {
                opset.get(i).deleteOption(optionName);
                break;
            }
        }
    }

    /*************** Update ***************************/
    // Update values of OptionSet
    public void updateOptionSet(String optionSetName, String newName) {
        for (int i = 0; i < opset.size(); i++) {
            if (opset.get(i) == null)
                continue;
            if (opset.get(i).getName().equals(optionSetName)) {
                opset.get(i).setName(newName);
                return;
            }
        }
        System.out.println("No such optionSetName can be updated");
    }

    // Update values of Option
    public void updateOption(String optionSetName, String newName, int newPrice) {
        OptionSet optionSet = findOptionSet(optionSetName); // find
        if (optionSet == null)
            System.out.println("No [" + optionSetName
                    + "] this option Set or this set has been deleted, Please add this option set first");
        else
            optionSet.setOption(newName, newPrice); // set
    }

    // print method, print property of this class
    public void printModelInfo() {
        System.out.println("-----------------------Result------------------------");
        System.out.println("Finally, This automobile properties are:");
        System.out.println("Name is: " + this.name);
        System.out.println("Base price is: " + "$" + this.basePrice);
        System.out.println();
        for (int i = 0; i < this.opset.size(); i++) {
            if (opset.get(i) == null)
                continue;
            else
                opset.get(i).printOptionSetInfo(); // print every optionset
                                                   // information
        }
    }

    // print option set information
    public void printOptionSetInfo(OptionSet optionSet) {
        optionSet.printOptionSetInfo();
    }

    // price option information
    public void printOptionInfo(Option option) {
        option.printOPtionInfo();
    }

    /****************************************
     * unit 2 **********************************
     * 
     */
    // return option price
    public Option getOptionChoice(String optionSetName) {
        return findOptionSet(optionSetName).getOptionChoice();
    }
    // get Option Choice Price
    public int getOptionChoicePrice(String OptionSetName) {
        return findOptionSet(OptionSetName).getOptionChoice().getPrice();
    }

    // calculate total price 
    public int getTotalPrice() {
        int totalPrice = getBasePrice();
        for (Option op : choice) {
            totalPrice = basePrice + op.getPrice();
        }
        return totalPrice;
    }

    //update Option set name
    public void updateOptionSetName(String Modelname, String optionSetName, String newName) throws NoModel {
        if (Modelname.equals(this.name)) {
            updateOptionSet(optionSetName, newName);
        } else {
            throw new NoModel();
        }
    }

    // update Option Price
    public void updateOptionPrice(String modelName, String OptionName, String optionName, int newPrice) throws NoModel {
        if (modelName.equals(modelName)) {
            updateOptionPrice(modelName, OptionName, optionName, newPrice);
        } else {
            throw new NoModel();
        }
    }

}
