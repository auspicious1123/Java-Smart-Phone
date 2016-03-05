package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import model.Automobile;
import model.OptionSet;

/**
 * @author-Rui Wang rw1
 */
public class SelectCarOption {
    public void configure(Automobile auto) {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);
        for (OptionSet optionSet: auto.getOptionSet()) {
            optionSet.printOptionSetInfo();
            System.out.println("Please select one option name: ");
            String optionName = null;
            try {
                optionName = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            auto.setOptionChoice(optionSet.getName(), optionName);;
        }
        auto.printChoice(auto.getChoice());
        System.out.println("Total price is:" + auto.getTotalPrice());
    }
}
