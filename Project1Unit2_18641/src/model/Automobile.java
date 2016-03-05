package model;

import java.io.Serializable;

import exception.NoModel;

/**
 * @author-Rui Wang rw1
 */
public class Automobile implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = -1487135202332644676L;
    
    private String name;
    private float basePrice;
    private OptionSet[] opset;
    
    /***********************************unit1****************************************/
    // constructors
    public Automobile() { }
    
    public Automobile(String name, float basePrice, OptionSet[] opset) {
        this.name = name;
        this.basePrice = basePrice;
        this.opset = opset;
    }
    public Automobile(String name, float basePrice, int optionSetNum) {   // size is optionSetNum
        this.name = name;
        this.basePrice = basePrice;
        opset = new OptionSet[optionSetNum];
        for(int i = 0 ; i < optionSetNum; i++) {
            opset[i] = new OptionSet();
        }
    }
//    public void Model(int size, String n) {
//        opset = new OptionSet[size];
//        name = n;
//    }
    
    /******************* setter and getter ***********************/
    // setter and getter for name, basePrice
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    
    public void setBasePrice(float basePrice) {
        this.basePrice = basePrice;
    }
    public float getBasePrice() {
        return basePrice;
    }
    
    // set Option Set
    public void setOptionSet(int index, String optionSetName, int optionNum) {
        if(index >= 0 && index < opset.length) {                     // give the index to set optionSet if index is 
            opset[index] = new OptionSet(optionSetName, optionNum);
        } else {
            System.out.println("Index is out of boundary of optionSetNum");
        }
    }
    
    // No index, just add or new a new optionSet
    public void setOptionSet(String optionName, int optionNum) {
        for(int i = 0; i < opset.length; i++){
            if(opset[i] == null) {                                // find a null position to new and add the option set
                opset[i] = new OptionSet(optionName, optionNum); 
            }
        }
    }
    
    /******************** set option ****************/
    // set option
    public void setOption(String optionSetName, String optionName, float price) {
        for(int i = 0 ; i < opset.length; i++) {
            if(opset[i] == null) 
                continue;
            else if(opset[i].getName().equals(optionName)) {
                opset[i].setOption(optionSetName, optionName, price);
            } else {
                
            }
        }
    }
    
    // set Option
    public void setOption(String optionSetName, int index, String optionName, float price) {
        for(int i = 0; i < opset.length; i++) {
            if(opset[i] == null)
                continue;
            if(opset[i].getName().equals(optionName)) {
                opset[i].setOption(index, optionName, price);
            }
        }
    }
    // set option
    public void setOption(int indexSet, int indexOption, String optionName, float price) {
        if(indexSet >= 0 && indexSet < opset.length) {
            opset[indexSet].setOption(indexOption, optionName, price);
        } else {
            System.out.println("indexSet is out of boundary of option set.");
        }
    }
    
    // get OptionSet with name or index value
    public OptionSet getOptionSet(String optionSetName) {
        for(int i = 0; i < opset.length; i++) {
            if(opset[i] == null)
                continue;
            if(opset[i].getName().equals(optionSetName)) {
                return opset[i];
            }
        }
        return null;
    }
    // get option set
    public OptionSet getOptionSet(int index) {    
        if(index >= 0 && index < opset.length) {
            return opset[index];
        } else {
            return null;
        }
    }
    
    /***************** Find *****************************/
    // Find OptionSet with name
     public OptionSet findOptionSet(String optionSetName) {
         for(int i = 0; i < opset.length; i++){
             if(opset[i] == null)
                 continue;
             if(opset[i].getName().equals(optionSetName)){
                 return opset[i];
             }
         }
         return null;
     }
     
     public OptionSet findOptionSet(int index) {
         if(index >= 0 && index < opset.length){
             return opset[index];
         }
         return null;
     }
     
    // Find Option with name (in content of OptionSet)
     public OptionSet.Option findOption(String optionSetName, String optionName) {    
         OptionSet optionSet = findOptionSet(optionSetName);
         if(optionSet == null) {
             return null;
         }
         else {
             if(optionSet.getOption(optionName) == null) {
                 return null;
             }
             else {
                 return optionSet.getOption(optionName);
             }
                 
         }
             
     }

    /************** Delete **********************/
     // Delete an optionSet
     public void deletOptionSet(String optionSetName) {
         for(int i = 0; i < opset.length; i++) {
             if(opset[i] == null)
                 continue;
             if(opset[i].getName().equals(optionSetName)) {
                 opset[i] = null;
             }
         }
     }
     //delete optionSet
     public void deletOptionSet(int index) {
         if(index >= 0 && index < opset.length) {
             opset[index] = null;
         }
     }
     
     //Delete an option
     public void deleteOption(String optionSetName, String optionName) {
         for(int i = 0; i < opset.length; i++) {
             if(opset[i] == null)                      // if opset[i] == null, it is deleted or equals to null, continue check next one
                 continue;
             if(opset[i].getName().equals(optionSetName)) {
                 opset[i].deleteOption(optionName);
                 break;
             }
         }
     }
     
     public void deleteOption(String optionSetName, int index) {
         for(int i = 0; i < opset.length; i++) {
             if(opset[i] == null)                      // if opset[i] == null, it is deleted or equals to null, continue check next one
                 continue;
             if(opset[i].getName().equals(optionSetName)) {
                 opset[i].deleteOption(index);
                 break;
             }
         }
     }
    
    /*************** Update ***************************/
    // Update values of OptionSet
     public void updateOptionSet(String optionSetName, String newName) {
         for(int i = 0; i < opset.length; i++) {
             if(opset[i] == null)
                 continue;
             if(opset[i].getName().equals(optionSetName)) {     
                 opset[i].setName(newName);
                 return;
             }
         }
         System.out.println("No such optionSetName can be updated");
     }
     
    // Update values of Option
     public void updateOption(String optionSetName,String optionName, String newName, float newPrice) {   
         OptionSet optionSet = findOptionSet(optionSetName);   // find
         if(optionSet == null) 
             System.out.println("No [" + optionSetName + "] this option Set or this set has been deleted, Please add this option set first");
         else
             optionSet.setOption(optionName, newName, newPrice);   // set
     }
    
    // print method, print property of this class
    public void printInfo() {
        System.out.println("-----------------------Result------------------------");
        System.out.println("Finally, This automobile properties are:");
        System.out.println("Name is: " + this.name);
        System.out.println("Base price is: " + "$" + this.basePrice);
        System.out.println();
        for(int i = 0; i < this.opset.length; i++){
            if(opset[i] == null)
                continue;
            else
                opset[i].printInfo();                  // print every optionset information
        }
    }
    
    // print option set information
    public void printOptionSetInfo(OptionSet optionSet) {
        optionSet.printInfo();
    }
    
    // print option information
    public void printOptionInfo(OptionSet.Option option) {
        option.printInfo();
    }
    
    /**************************************** unit 2  **********************************
     * @throws NoModel *
     * 
     */
    public void updateOptionSetName(String Modelname, String optionSetName, String newName) throws NoModel {
        if(Modelname.equals(this.name)) {
            updateOptionSet(optionSetName, newName);
        } else {
            throw new NoModel();
        }
    }
    
    // update option price
    public void updateOptionPrice(String Modelname, String Optionname, String Option, float newprice) throws NoModel{
        if(Modelname.equals(Modelname)) {
            updateOption(Optionname, Option, Option, newprice);
        } else {
            throw new NoModel();
        }
    }
    
}
