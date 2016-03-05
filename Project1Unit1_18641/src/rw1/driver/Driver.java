package rw1.driver;

import rw1.model.Automotive;
import rw1.util.FileIO;

/**
 * @author-Rui Wang rw1
 */
public class Driver {

    /**
     * @param args
     */
    @SuppressWarnings("static-access")
    public static void main(String[] args) {
        Automotive FordZTW = new Automotive();
        FileIO io = new FileIO();
        System.out.println("*********************Automotive object build by FileIO:*********************");
        FordZTW = io.buildAutoObject("Model.txt", FordZTW);
        FordZTW.printInfo();
        
        System.out.println("*****************Seriablizable build automotive:**********************");
        io.seriablizableAuto(FordZTW);
        System.out.println("**************Seriablizable automotive into automotive.dat done.***********");
        
        System.out.println();
        System.out.println("************Deseriablizable automotive and the information are as follows:***********");
        Automotive newFordZTW = io.deseriablizableAuto("automotive.dat");
        newFordZTW.printInfo();
        
        System.out.println("***************** Test: ***************");
        System.out.println("Test case1 : test getter and setter:");
        System.out.println();
        
        System.out.println("Set base price as $2000, and print the base price throuth getBasePrice");
        newFordZTW.setBasePrice(2000);
        System.out.println(newFordZTW.getBasePrice());
        
        System.out.println();
        System.out.println("Test case2: test delete method: delete an option set and an option ");
        System.out.println();
        System.out.println("Delete 'Color' option set and delete automatic option:");
        newFordZTW.deletOptionSet("Color");  
        newFordZTW.deleteOption("Transmission", "automatic");
        newFordZTW.printInfo();

        System.out.println();
        System.out.println("Test case3: test update method: update an option set and an option ");
        System.out.println();
        newFordZTW.updateOptionSet("Power Moonroof", "*Test update option Set*");
        //newFordZTW.updateOption("Color", "Liquid Grey Clearcoat Metallic", "Red", 5);
        newFordZTW.updateOption("Side Impact Air Bags", "none","*test option*", 5);
        newFordZTW.printInfo();
        
        System.out.println();
        System.out.println("Test case4: test find method: find an option set and an option ");
        System.out.println();
        //newFordZTW.findOptionSet(2);   // according to index(or name) find option set
        newFordZTW.printOptionSetInfo(newFordZTW.findOptionSet(2));
        //newFordZTW.findOption("Brakes/Traction Control", "ABS with Advance Trac"); // based on name(or index) find option set and then find option 
        newFordZTW.printOptionInfo(newFordZTW.findOption("Brakes/Traction Control", "ABS with Advance Trac"));
        System.out.println("********************All test finished.**********************");
    }

}

