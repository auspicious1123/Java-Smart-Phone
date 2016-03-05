package driver;


import adapter.BuildAuto;
/**
 * @author-Rui Wang rw1
 */
public class Driver {

    /**
     * @param args test part A: exception and update option set and options.
     */
    
    public static void main(String[] args) {
        BuildAuto auto = new BuildAuto();
        System.out.println("-----------------------------------------------------------------");
        System.out.println("-------------------------Part A results.-------------------------");
        System.out.println();
        
        System.out.println();
        System.out.println("-----------------------------------------------------------------");
        System.out.println("-----Test case1: Create and print auto through CreateAuto --------");
        System.out.println("-----------------------------------------------------------------");
        
        System.out.println("-----------------------------------------------------------------");
        System.out.println("--------------Test case2: testing exceptions ---------------------");
        System.out.println("-----------------------------------------------------------------");
        System.out.println();
        auto.BuildAuto("Model.tt");
        auto.printAuto(auto.getModelName());
        BuildAuto testAuto = new BuildAuto();
        testAuto.BuildAuto("default_model.txt");
        System.out.println();
        System.out.println();
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("--------Test case3: update option setName to *Test updateSetName*-------------------");
        System.out.println("-------------and option: Power Moonroof,selected price to 50000----------------------");        
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println();
        testAuto.updateOptionSetName(testAuto.getModelName(), "Color", "*Test updateSetName*");
        testAuto.updateOptionPrice(testAuto.getModelName(), "Power Moonroof", "selected", 50000);
        testAuto.printAuto(testAuto.getModelName());
        
    }

}

