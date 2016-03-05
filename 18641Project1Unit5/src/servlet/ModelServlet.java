package servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Automobile;

/**
 * Servlet implementation class ChooseModel
 */
@WebServlet("/ModelSevlet")
public class ModelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModelServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String modelName = request.getParameter("selectModel");
		System.out.println("This is model name:");
		System.out.println(modelName);
//		BuildAuto buildAuto = new BuildAuto();
//		Automobile auto = buildAuto.getModel(modelName);
//		auto.printModelInfo();
		
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
	    outStream.println(modelName);
	    outStream.println("Option read from server");
	    ObjectInputStream inputAuto = new ObjectInputStream(clientSocket.getInputStream());
	    Automobile auto = null;
        try {
            //get the automobile from server
            auto = (Automobile)inputAuto.readObject();
            auto.printModelInfo();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        request.getSession().setAttribute("automobile", auto);
        response.sendRedirect("ChooseOptions.jsp");
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
