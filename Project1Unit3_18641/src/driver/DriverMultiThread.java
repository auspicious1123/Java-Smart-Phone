package driver;

import adapter.BuildAuto;
import model.Automobile;
import scale.EditOptions;

/**
 * @author-Rui Wang rw1
 */
public class DriverMultiThread {
    public static void main(String[] args) {
        BuildAuto buildAuto = new BuildAuto();
        buildAuto.BuildAuto("Model.txt");
        Automobile auto = buildAuto.getAuto();
        String modelName = auto.getName();
        auto.setOptionChoice("Color", "Liquid Grey Clearcoat Metallic");
        auto.setOptionChoice("Transmission", "manual");
        auto.setOptionChoice("Brakes/Traction Control", "ABS");
        auto.setOptionChoice("Side Impact Air Bags", "selected");
        auto.setOptionChoice("Power Moonroof", "selected");
        auto.printChoice(auto.getChoice());
        
        System.out.println("Test: three threads running");
        System.out.println("Thread 1: change price of \"Liquid Grey Clearcoat Metallic\" to 520\n");
        System.out.println("Thread 2: change choice color to \"French Blue Clearcoat Metallic\"");
        System.out.println("Thread 3: change color \"Liquid Grey Clearcoat Metallic\" option name to \"French Blue Clearcoat Metallic\" ");
        
        // new three thread.
        EditOptions editOptionPrice = new EditOptions(EditOptions.OPTION_PRICE, auto, modelName);
        editOptionPrice.setOptionSetName("Color");
        editOptionPrice.setOptionName("Liquid Grey Clearcoat Metallic");
        editOptionPrice.setPrice(520);
        
        EditOptions editChoiceOption = new EditOptions(EditOptions.CHOICE, auto, modelName);
        editChoiceOption.setOptionName("Liquid Grey Clearcoat Metallic");
        editChoiceOption.setOptionNewName("French Blue Clearcoat Metallic");
        
        EditOptions editChoiceOption2 = new EditOptions(EditOptions.OPTION_NAME, auto, modelName);
        editChoiceOption2.setOptionSetName("Color");
        editChoiceOption2.setOptionName("CD Silver Clearcoat Metallic");
        editChoiceOption2.setOptionNewName("*Test new name*");
        
        System.out.println("Now, multiple thread running");
        
        // begin thread.
        editChoiceOption.start();
        editChoiceOption2.start();
        editOptionPrice.start();
        
        while(editChoiceOption.isAlive() || editChoiceOption2.isAlive() || editOptionPrice.isAlive()) { 
            
        }
        
        System.out.println("Edit finished, thread closed");
        System.out.println();
        System.out.println("Test result:");
        auto.printModelInfo();
        System.out.println();
        System.out.println("Choice edit result:");
        
        auto.printChoice(auto.getChoice());
        System.out.println();
        System.out.println("Total price: $" + auto.getTotalPrice());
    }
}
