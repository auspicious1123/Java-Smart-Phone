package servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.Automobile;
import model.OptionSet;

/**
 * Servlet implementation class OptionsSevlet
 */
@WebServlet("/OptionsSevlet")
public class OptionsSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OptionsSevlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	    String modelName = request.getParameter("modelName");
	    System.out.println(modelName);
	    System.out.println("This is option servlet.");
	    Socket clientSocket = null;
        PrintWriter outStream = null;
        BufferedReader inStream = null;
        try {
            clientSocket = new Socket("localhost", 7878);
            outStream = new PrintWriter(clientSocket.getOutputStream(), true);
            inStream = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        outStream.println("3");
        System.out.println(modelName);
        outStream.println(modelName);
        ObjectInputStream inputAuto = new ObjectInputStream(clientSocket.getInputStream());
        Automobile auto = null;
        try {
            //get the automobile from server
            auto = (Automobile)inputAuto.readObject();
            auto.printModelInfo();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList<OptionSet> optionSet = auto.getOptionSet();
        
	    String selects[] = new String[5];
	    for(int i = 0; i < 5; i++) {
	        selects[i] = request.getParameter("select"+i);
	        auto.setOptionChoice(optionSet.get(i).getName(), selects[i]);
	    }
	    auto.printChoice(auto.getChoice());
	    
	    String chosedModel[][] = new String[7][3];
	    chosedModel[0][0] = auto.getMake();
	    chosedModel[0][1] = "base price";
	    chosedModel[0][2] = auto.getBasePrice() + "";
	    int price = auto.getBasePrice();
	    for(int i = 0; i < 5; i++) {
	        chosedModel[i+1][0] = optionSet.get(i).getName();
	        chosedModel[i+1][1] = selects[i];
	        chosedModel[i+1][2] = auto.getChoice().get(i).getPrice() +"";
	        price += auto.getChoice().get(i).getPrice();
	    }
	    chosedModel[6][0] = "Total Cost";
	    chosedModel[6][1] = " ";
	    chosedModel[6][2] = "$" + price;   // auto.getTotalPrice()
	    System.out.println("Total price:");
	    System.out.println(price);
	    request.getSession().setAttribute("chosedModel", chosedModel);
	    response.sendRedirect("DisplayModel.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
