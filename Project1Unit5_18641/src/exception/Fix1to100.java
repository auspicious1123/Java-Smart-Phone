package exception;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author-Rui Wang rw1
 */
public class Fix1to100 implements FixAuto {

    /* (non-Javadoc)
     * @see exception.FixAuto#fix(int)
     */
    @Override
    public String fix(int errno) {
        String result = null;
        switch(errno) {
        case 1: 
            result = fix1();     // missingFileName or wrong file name
            break;
        case 2: 
            result = fix2();     // Wrong input format
            break;
        case 3:
            result = fix3();     // missing auto base price
            break;
        case 4:
            result = fix4();     // missing option set name
            break;
        case 5:
            result = fix5();     // missing option price
            break;
        default:
            break;
        }
        return result;
    }
    
    public String fix1() {
        // missingFileName
        System.out.println("Missing filename or wrong filename, please input filename:(Model.txt)");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputFileName = "";
        try {
            inputFileName = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        return inputFileName;
        }
            
    public String fix2() {
        // Wrong input format
        System.out.println("fix2(): Using the default file, default_model.txt fix this problem.");
        System.out.println("-------------------------Default file fixed result--------------------------------");
        return "default_model.txt";
    }
    
    public String fix3() {
        // missing auto price
        System.out.println("fix3(): setting the auto base price as $18445.0");
        System.out.println("------------------------Missing Auto base price Fixed--------------------");
        return "18445";
    }
    
    public String fix4() {
     // missing option set
        System.out.println("fix4(): Please input this optionSet name:(This test case please input : Color)");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            return br.readLine();
        }catch(IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public String fix5() {
        // missing option price
        System.out.println("fix5(): setting the auto base price as $0.0");
        System.out.println("-----------------------Missing option price Fixed-----------------");
        return "0";
    }
}
