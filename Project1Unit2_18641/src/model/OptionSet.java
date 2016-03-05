package model;

import java.io.Serializable;

/**
 * @author-Rui Wang rw1
 */
class OptionSet implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = -2763734563574392940L;
    
    // instance variables
    private String name;
    private Option[] options;
    
    // constructor
    protected OptionSet() { }
    
    protected OptionSet(String name, int size) {
         this.name = name;
         options = new Option[size];
         for(int i = 0; i < size; i++) {
             options[i] = new Option();
         }
    }
    // setters and getters
    protected void setName(String name) {
        this.name = name;
    }
    protected String getName() {
        return name;
    }
    // set option properties according to option index or optionName
    protected void setOption(int index, String newName, float newPrice) {
        if(index >= 0 && index < options.length) {
            options[index].setName(newName);
            options[index].setPrice(newPrice);
        } else {
            System.out.println("Option index is out of boundary of options.");
        }
    }
    protected void setOption(String optionName, String newName, float newPrice) {
        for(int i = 0; i < options.length; i++) {
            if(options[i] == null)
                continue;
            if(options[i].getName().equals(optionName)) {
                options[i].setName(newName);
                options[i].setPrice(newPrice);
                break;
            }
        }
        
    }
    
    //get option
    protected Option getOption(String optionName) {
        for(int i = 0; i < options.length; i++) {
            if(options[i] == null)
                continue;
            if(options[i].getName().equals(optionName)) {
                return options[i];
            }
        }
        return null;  
    }
    protected Option getOption(int index) {
        while(index >= 0 && index < options.length) {
            return options[index];
        }
        return null;  
    }
    // delete option
    protected void deleteOption(String optionName){
        for(int i = 0 ; i < options.length; i++) {
            if(options[i] == null)
                continue;
            if(options[i].getName().equals(optionName)) {
                options[i] = null;
            }
        }
    }
    protected void deleteOption(int index){
        if(index >= 0 && index < options.length) {
            options[index] = null;
        }
    }
    // instance method
    protected void printInfo() {
        System.out.println("OptionSet Name is: " + this.name);
        for(int i = 0; i < this.options.length; i++){
            if(options[i] == null)
                continue;
            else
                options[i].printInfo();                  // print every optionset information
        }
        System.out.println();
    }
    
    // Inner class
    protected class Option implements Serializable{
        /**
         * 
         */
        private static final long serialVersionUID = 536383207985651070L;
        private String name;
        private float price;
        // constructors
        protected Option() { }
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
        protected void setPrice(float price) {
            this.price = price;
        }
        protected float getPrice() {
            return price;
        }
        // print options information
        protected void printInfo() {
            System.out.println("Option name: " + name + "; Price: " + "$" + price);
        }
    }
}
