package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Properties;

import model.Automobile;

/**
 * @author-Rui Wang rw1
 */
public class Client implements Runnable{
    
    
    /* (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {
        Socket clientSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;
        try {
            clientSocket = new Socket("localhost", 7878);
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // each thread need read input configuration information.
        BufferedReader userInputReader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println();
            System.out.println("Please choose your operation:");
            System.out.println("Input number 0,1,2 or 3:\n0.exit.\n1.Upload Properties file.\n2.List car model.\n3.Configure choice option of a car");
            String userInputRequest;
            try {
                userInputRequest = userInputReader.readLine();
                switch(userInputRequest) {
                case "0":  // exist.
                    out.println("0");
                    System.out.println("exist:" + in.readLine());
                    clientSocket.close();
                    return;
                case "1":  // upload properties and build automobile send to server.
                    System.out.println("Upload Properties,input Properties file name:(properties1.Properties/properties2.Properties/properties3.txt)");
                    String fileName = userInputReader.readLine();  // fileName can accept multiple type of file 
                    out.println("1");
                    // build choose car model options.
                    CarModelOptionsIO carModelOptionsIO = new CarModelOptionsIO();
                    Properties properties;
                    properties = carModelOptionsIO.readPropertiesFile(fileName);
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(clientSocket.getOutputStream());
                    objectOutputStream.writeObject(properties);
                    System.out.println("Server response: " + in.readLine());
                    break;
                case "2":  // get the list of automobiles
                    out.println("2");
                    System.out.println("The list of automobiles are:");
                    String readin; // read list from server
                    while(!(readin = in.readLine()).equals("")) {
                        System.out.println(readin);
                    }
                    break;
                case "3": // provide options for user to choose option
                    out.println("3");
                    System.out.println("Please input model name:");
                    String modelName = userInputReader.readLine();
                    out.println(modelName);
                    ObjectInputStream inputAuto = new ObjectInputStream(clientSocket.getInputStream());
                    Automobile auto = null;
                    try {
                        auto = (Automobile)inputAuto.readObject();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    SelectCarOption selectCarOption = new SelectCarOption();
                    selectCarOption.configure(auto);
                    break;
                default:
                        System.out.println("Please input the valid number");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
    }
 
    public static void main(String[] args) {
        Client client = new Client();
        Thread thread = new Thread(client);
        thread.start();
    }

    
}
