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
    public synchronized void setName(String name) {
        this.name = name;
    }

    public synchronized String getName() {
        return name;
    }

    /**
     * @return the choice
     */
    public synchronized ArrayList<Option> getChoice() {
        return this.choice;
    }

    /**
     * @param choice
     *            the choice to set
     */
    public synchronized void setChoice(ArrayList<Option> choice) {
        this.choice = choice;
    }

    public synchronized void printChoice(ArrayList<Option> choice) {
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
    public synchronized String getMake() {
        return make;
    }

    /**
     * @param make
     *            the make to set
     */
    public synchronized void setMake(String make) {
        this.make = make;
    }

    /**
     * @return the model
     */
    public synchronized String getModel() {
        return model;
    }

    /**
     * @param model
     *            the model to set
     */
    public synchronized void setModel(String model) {
        this.model = model;
    }

    public synchronized void setBasePrice(int basePrice) {
        this.basePrice = basePrice;
    }

    public synchronized int getBasePrice() {
        return basePrice;
    }

    public synchronized void setOptionSet(String name) {
        
        opset.add(new OptionSet(name));
    }

    /******************** set option ****************/
    // set option
    public synchronized void setOption(String optionSetName, String optionName, int price) {
        for (OptionSet ops : opset) {
            if (ops.getName().equals(optionSetName)) {
                ops.setOption(optionName, price);
            }
        }
    }

    // set option choice
    public synchronized void setOptionChoice(String optionSetName, String optionName) {
        Option optionChoice = null;
        for (OptionSet ops : opset) {
            if (ops.getName().equals(optionSetName)) {
                optionChoice = ops.getOption(optionName);
            }
        }
        choice.add(optionChoice);
    }

    // get OptionSet with name or index value
    public synchronized OptionSet getOptionSet(String optionSetName) {
        for (int i = 0; i < opset.size(); i++) {
            if (opset.get(i).getName().equals(optionSetName)) {
                return opset.get(i);
            }
        }
        return null;
    }

    public synchronized OptionSet getOptionSet(int index) {
        if (index >= 0 && index < opset.size()) {
            return opset.get(index);
        } else {
            return null;
        }
    }

    /***************** Find *****************************/
    // Find OptionSet with name
    public synchronized OptionSet findOptionSet(String optionSetName) {
        for (OptionSet ops : opset) {
            ops.getName().equals(optionSetName);
            return ops;
        }
        return null;
    }

    public synchronized OptionSet findOptionSet(int index) {
        if (index >= 0 && index < opset.size()) {
            return opset.get(index);
        }
        return null;
    }

    // Find Option with name (in content of OptionSet)
    public synchronized Option findOption(String optionSetName, String optionName) {
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
    public synchronized void deletOptionSet(String optionSetName) {
        for (int i = 0; i < opset.size(); i++) {
            if (opset.get(i) == null)
                continue;
            if (opset.get(i).getName().equals(optionSetName)) {
                opset.remove(i);
            }
        }
    }

    public synchronized void deletOptionSet(int index) {
        if (index >= 0 && index < opset.size()) {
            opset.remove(index);
        }
    }

    // Delete an option
    public synchronized void deleteOption(String optionSetName, String optionName) {
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
    public synchronized void updateOptionSet(String optionSetName, String newName) {
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
    public synchronized void updateOption(String optionSetName, String newName, int newPrice) {
        OptionSet optionSet = findOptionSet(optionSetName); // find
        if (optionSet == null)
            System.out.println("No [" + optionSetName
                    + "] this option Set or this set has been deleted, Please add this option set first");
        else
            optionSet.setOption(newName, newPrice); // set
    }

    // print method, print property of this class
    public synchronized void printModelInfo() {
        System.out.println("Name is: " + this.name);
        System.out.println("Make is:" + this.make);
        System.out.println("Model is:" + this.model);
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
    public synchronized void printOptionSetInfo(OptionSet optionSet) {
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
    public synchronized Option getOptionChoice(String optionSetName) {
        return findOptionSet(optionSetName).getOptionChoice();
    }

    // get Option Choice Price
    public synchronized int getOptionChoicePrice(String OptionSetName) {
        return findOptionSet(OptionSetName).getOptionChoice().getPrice();
    }

    // calculate total price
    public synchronized int getTotalPrice() {
        int totalPrice = getBasePrice();
        for (Option op : choice) {
            totalPrice += op.getPrice();
        }
        return totalPrice;
    }

    // update Option set name
    public synchronized void updateOptionSetName(String Modelname, String optionSetName, String newName) throws NoModel {
        if (Modelname.equals(this.name)) {
            updateOptionSet(optionSetName, newName);
        } else {
            throw new NoModel();
        }
    }

    // update Option Price
    public synchronized void updateOptionPrice(String modelName, String OptionName, String optionName, int newPrice) throws NoModel {
        if (modelName.equals(modelName)) {
            updateOptionPrice(modelName, OptionName, optionName, newPrice);
        } else {
            throw new NoModel();
        }
    }

    /**
     * @param mOptionSetName
     * @param mOptionName
     * @param mOptionNewName
     */
    public  void updateOptionName(String mOptionSetName, String mOptionName, String mOptionNewName) {
        // TODO Auto-generated method stub
        for(OptionSet optionSet : opset) {
            if(optionSet.getName().equals(mOptionSetName)) {
                if(optionSet.getOption(mOptionName) == null)
                    return;
                optionSet.getOption(mOptionName).setName(mOptionNewName);
            }
        }
    }

    /**
     * @param mOptionSetName
     * @param mOptionName
     * @param mPrice
     */
    public void updateOptionPrice(String mOptionSetName, String mOptionName, int mPrice) {
        // TODO Auto-generated method stub
        for(OptionSet optionSet : opset) {
            if(optionSet.getName().equals(mOptionSetName)) {
                if(optionSet.getOption(mOptionName) == null)
                    return;
                optionSet.getOption(mOptionName).setPrice(mPrice);
            }
        }
    }

    /**
     * @param mOptionSetName
     * @param mOptionNewName
     */
    public void updateChoice(String mOptionName, String mOptionNewName) {
        // TODO Auto-generated method stub
        for(Option mChoice : choice) {
            if(mChoice.getName().equals(mOptionName)) {
                if(mChoice.getName() == null)
                    return;
                mChoice.setName(mOptionNewName);
            }
        }
    }

}
