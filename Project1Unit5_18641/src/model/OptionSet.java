package model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author-Rui Wang rw1
 */
public class OptionSet implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = -2763734563574392940L;
    
    // instance variables
    private String name;
    private ArrayList<Option> options;
    private Option choice;   // set has a choice.
    
    // constructor
    protected OptionSet() { }
    
    protected OptionSet(String name) {
        this.name = name;
        options = new ArrayList<>();
        choice = new Option("null", 0);
        
    }
    
    protected OptionSet(String name, ArrayList<Option> options) {
         this.name = name;
         this.options = options;
    }
    
    // setters and getters
    protected void setName(String name) {
        this.name = name;
    }
    public ArrayList<Option> getOptions() {
        return this.options;
    }
    
    public String getName() {
        return name;
    }
    
    
    public Option getChoice() {
        return choice;
    }

    public void setOptionChoice(Option choice) {
        this.choice = choice;
    }
    
    public void setOptionChoice(String optionName) {
        choice.setName(optionName);
        for(int i = 0; i < options.size(); i++) {
            if(options.get(i).equals(optionName)) {
                choice.setPrice(options.get(i).getPrice());
            }
        }
    }
    
    public Option getOptionChoice() {
        return choice;
    }
    
    // set option properties according to option index or optionName
    protected void setOption(int index, String newName, int newPrice) {
        Option tempOption = new Option(newName, newPrice);
        options.add(index, tempOption);
    }
    
    protected void setOption(String optionName, int optionPrice) {
        options.add(new Option(optionName, optionPrice));  
    }
    
    //get option
    protected Option getOption(String optionName) {
        for(Option op : options) {
            if(op.getName().equals(optionName)) {
                return op;
            }
        }
        return null;
    }
    
//    protected Option getOption(int index) {
//        return options.get(index); 
//    }
    
    // delete option
    protected void deleteOption(String optionName){
        for(Option op : options) {
            if(op.getName().equals(optionName)) {
                options.remove(op);
            }
        }
    }
    
    //update option
    protected void updateOptionName(String optionName, String optionNewName) {
        for(Option op : options) {
            if(op.getName().equals(optionName)) {
                op.setName(optionNewName);
            }
        }
    }
    
    protected void updateOptionPrice(String optionName, int optionNewPrice) {
        for(Option op : options) {
            if(op.getName().equals(optionName)) {
                op.setPrice(optionNewPrice);
            }
        }
    }
    

    // instance method
    public void printOptionSetInfo() {
        System.out.println("OptionSet Name is: " + this.name);
        for(Option op : options) {
            op.printOPtionInfo();
        }
    }
    
    public int getOptionSize() {
        return options.size();
    }
    
    // Inner class
    protected class Option implements Serializable{
        /**
         * 
         */
        private static final long serialVersionUID = 536383207985651070L;
        private String name;
        private int price;
        // constructors
        protected Option() { }
        protected Option(String optionName, int price) {
            this.name = optionName;
            this.price = price;
        }
        protected Option(String name) {
            this.name = name;
        }
        // setter and getter
        protected void setName(String name) {
            this.name = name;
        }
        protected String getName() {
            return name;
        }
        protected void setPrice(int price) {
            this.price = price;
        }
        protected int getPrice() {
            return price;
        }
        // print options information
        protected void printOPtionInfo() {
            System.out.println("Option name: " + name + "; Price: " + "$" + price);
        }
    }
}
