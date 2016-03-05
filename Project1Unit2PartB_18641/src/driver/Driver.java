package driver;

import java.nio.channels.ShutdownChannelGroupException;
import java.util.ArrayList;

import exception.NoModel;
import model.Automobile;
import model.Autos;

/**
 * @author-Rui Wang rw1
 */
public class Driver {

    /**
     * @param args
     *            test part A: exception and update option set and options.
     * @throws NoModel
     */

    public static void main(String[] args) {

        Autos autoes = new Autos();
        autoes.bulidAutos();
        System.out.println("-----------------------------------------------------------------");
        System.out.println("-------------------------Part B results.-------------------------");
        System.out.println("-----------------------------------------------------------------");

        System.out.println();
        System.out.println("--------Test case1: Print the first model information -----------");
        autoes.printModel("Focus Wagon ZTW");
        System.out.println();
        System.out.println("--------Test case2: Print the second model information------------");
        autoes.printModel("Model2");

        autoes.updateUptionSetName("Focus Wagon ZTW", "Color", "*Test updateSetName*");
        autoes.updateOptionPrice("Focus Wagon ZTW", "Power Moonroof", "selected", 50000);
        System.out.println();
        System.out.println("--------Test case3: update set name and option price------------");
        autoes.printModel("Focus Wagon ZTW");
        Automobile auto = autoes.getModel("Focus Wagon ZTW");
        auto.setOptionChoice("Transmission", "manual");
        auto.setOptionChoice("Brakes/Traction Control", "ABS");
        auto.setOptionChoice("Side Impact Air Bags", "selected");
        auto.setOptionChoice("Power Moonroof", "selected");
        System.out.println("--------Test case4: Set option choice------------");
        auto.printChoice(auto.getChoice());
        
        System.out.println("Total price: $" + auto.getTotalPrice());
    }

}
