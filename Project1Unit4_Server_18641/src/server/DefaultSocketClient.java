package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;

import adapter.AutoServer;
import adapter.BuildAuto;
import model.Automobile;

/**
 * @author-Rui Wang rw1
 */
public class DefaultSocketClient extends Thread{
    
    private BufferedReader in;
    private PrintWriter out;
    private Socket socket;
    private static int clientNum = 0;
    private static ServerSocket serverSocket;
    
    /* (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {
        clientNum++;
        handleSession();
    }
    
    public void handleSession() {
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while(true) {
                String input;
                    input = in.readLine();
                    if(input == null)
                        continue;
                    out = new PrintWriter(socket.getOutputStream(),true);
                    switch(input) {
                    case "0":   // quit
                        out.println("Communication finished!");
                        System.out.println("Quit");
                        socket.close();
                        return;
                    case "1":   // send to automobile to server
                        ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
                        Properties properties = (Properties)inputStream.readObject();
                        BuildCarModelOptions buildCarModelOptions = new BuildCarModelOptions();
                        Automobile auto = buildCarModelOptions.buildAutoOptions(properties);
                        System.out.println("Receive Automobile:" + auto.getModel());
                        out.println("Automobile created successfully");
                        break;
                    case "2":  // give the automobile list to user
                        AutoServer server = new BuildAuto();
                        out.println(server.listAutomobileNames());
                        out.println("");
                        System.out.println("Return list of Automobiles:\n" + server.listAutomobileNames());
                        break;
                    case "3":  // configure the automobiles
                        String modelName = in.readLine();
                        System.out.println("Receive model name:" + modelName);
                        BuildAuto buildAuto = new BuildAuto();
                        Automobile automobile = buildAuto.getModel(modelName);
                        ObjectOutputStream outAuto = new ObjectOutputStream(socket.getOutputStream());
                        outAuto.writeObject(automobile);
                        System.out.println("Return Automobile " + automobile.getModel());
                        break;
                     default:
                        out.println("Please input valid number:0, 1, 2, or 3.");
                        System.out.println("Please input valid number:0, 1, 2, or 3.");
                        break;
                    }
            }
        } catch (IOException | ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                System.exit(1);
        }
    }
}
