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
public class DefaultSocketClient extends Thread{
    
    private Socket clientSocket = null;
    ObjectInputStream in = null;
    ObjectOutputStream out = null;

    public void run() {
        handleSession();
    }
    
    public void handleSession() {
        try {
            clientSocket = new Socket("localhost", 7878);
            out = new ObjectOutputStream(clientSocket.getOutputStream());
            in = new ObjectInputStream(clientSocket.getInputStream());
        } catch (IOException e) {
            System.out.println("Cannot connet!");
            e.printStackTrace();
        }
        
        // each thread need read input configuration information.
        BufferedReader userInputReader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println();
            System.out.println("Please choose your operation:");
            System.out.println("Input number 0,1,2 or 3:\n0.exit.\n1.Upload Properties file.\n2.List car model.\n3.Configure choice option of a car");
            String userRequest;
            try {
                userRequest = userInputReader.readLine();
                switch(userRequest) {
                
                case "0":  // exist.
                    out.writeObject("0");
                    System.out.println("exist:" + (String)in.readObject());
                    clientSocket.close();
                    return;
                case "1":  // upload properties and build automobile send to server.
                    System.out.println("Upload Properties,input Properties file name:(properties1.Properties/properties2.Properties/properties3.txt)");
                    String fileName = userInputReader.readLine();
                    out.writeObject("1");
                    // build choose car model options.
                    CarModelOptionsIO carModelOptionsIO = new CarModelOptionsIO();
                    Properties properties;
                    properties = carModelOptionsIO.readPropertiesFile(fileName);
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(clientSocket.getOutputStream());
                    objectOutputStream.writeObject(properties);
                    System.out.println("Server response: " + (String)in.readObject());
                    break;
                case "2":  // get the list of automobiles
                    out.writeObject("2");
                    System.out.println("The list of automobiles are:");
                    String readin; // read list from server
                    while(!(readin = (String)in.readObject()).equals("")) {
                        System.out.println(readin);
                    }
                    break;
                case "3": // provide options for user to choose option
                    out.writeObject("3");
                    System.out.println("Please input model name:");
                    String modelName = userInputReader.readLine();
                    out.writeObject(modelName);
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
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        
    }
}
