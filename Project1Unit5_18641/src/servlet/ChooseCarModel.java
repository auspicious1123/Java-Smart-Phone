package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import adapter.ServerAuto;
import model.Automobile;
import adapter.BuildAuto;

/**
 * @author-Rui Wang rw1
 */
public class ChooseCarModel extends HttpServlet{
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ServerAuto  buildAuto = new BuildAuto();
        String modelName = request.getParameter("modelName");
        Automobile auto = buildAuto.getAutoMobileByName("selectModel");
        request.getSession().setAttribute("automobile", auto);
        response.sendRedirect("BasicCarChoice");
        
    }

}
