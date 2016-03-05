package rw1.util;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import rw1.model.Automotive;

/**
 * @author-Rui Wang rw1
 */
public class FileIO {
    public static Automotive buildAutoObject(String filename, Automotive a1) {
        try {
            FileReader file = new FileReader(filename);
            BufferedReader buff = new BufferedReader(file);
            boolean eof = false;
            String autoName = buff.readLine();         //txt first-line automotive name
          
            String inputBasePrice = buff.readLine();    //txt second-line automotive baseName
            float autoBasePrice = Float.parseFloat(inputBasePrice);
            //auto.setName(autoName);
            //auto.setBasePrice(autoBasePrice);
            
            // following lines optionSet:option1 option2 option3 save into optionSet, each line is  an optionSet
            int num = 0;      // optionSet number
            int optionSetNum = 5;
            a1 = new Automotive(autoName, autoBasePrice, optionSetNum);
            while(!eof && num < optionSetNum) {
                String line = buff.readLine();
                if(line == null)
                    eof = true;
                else {
                    String[] readin = line.split(":"); // split into optionSet 和 options String
                    String[] str = readin[1].split(",");  // include option name*price
                    a1.setOptionSet(num, readin[0], str.length);
                    
                    //OptionSet optionSet = new OptionSet(readin[0], str.length);
                    for(int i = 0 ; i < str.length; i++){
                        //System.out.println(str[i]);
                        String[] optionAndPrice = str[i].split("#");  //first is option name, second is price
                        String name = optionAndPrice[0];
                        float price = Float.parseFloat(optionAndPrice[1]);

                        a1.setOption(num, i, name, price);
                    }
                    num++;            
                }
            }
            buff.close();
        } catch (IOException e) {
            System.out.println("Read file error­­ " + e.toString());
        }
        return a1;
    }   
    
    // Serializable
    public void seriablizableAuto(Automotive a1) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("automotive.dat"));
            out.writeObject(a1);
            out.close();
        } catch (Exception e) {
            System.out.print("Seriablizable error: " + e);
            System.exit(1);
        }
    }
    
    public Automotive deseriablizableAuto(String filename) {
        Automotive a1 = null;
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("automotive.dat"));
            a1 = (Automotive)in.readObject();
            in.close();
        } catch(Exception e) {
            System.out.print("Error " + e);
            System.exit(1);
        }
        return a1;
    }
}
