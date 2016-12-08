package Controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author jonas & Simon
 */
@WebServlet(urlPatterns = {"/Controller"})
public class Controller extends HttpServlet {

  
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        HttpSession sessie = request.getSession(true);
        int pNummer = Integer.parseInt(request.getUserPrincipal().getName());
        sessie.setAttribute("pNummer", pNummer);
        gotoPage("overzicht", request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession sessie = request.getSession(true);
        String s = request.getParameter("goto");
        
        /* INLOGGEN */
        if(s.equals("inloggen") )
        {
            int pNummer = Integer.parseInt(request.getUserPrincipal().getName());
            sessie.setAttribute("pNummer", pNummer);
            gotoPage("overzicht", request, response);
        }
        
        /* INLOGGENERROR */
        if(s.equals("inloggenError"))
        {
            gotoPage("inloggen", request, response);
        }
        
        /* OVERZICHT */
        if(s.equals("nieuweOnkosten"))
        {
            gotoPage("nieuweOnkosten", request, response);
        }
        if(s.equals("bekijkKrediet"))
        {
            gotoPage("bekijkKrediet", request, response);
        }
        if(s.equals("goedkeurenKrediet"))
        {
            gotoPage("goedkeurenKrediet", request, response);
        }
        if(s.equals("uitloggen"))
        {
            request.getSession().invalidate();
            response.sendRedirect(request.getContextPath() + "/inloggen.jsp");
            //gotoPage("inloggen", request, response);
        }
       
    }
    
    protected void gotoPage(String naam, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        RequestDispatcher view = request.getRequestDispatcher(naam + ".jsp");
        view.forward(request, response);
    }
    
    public String getServletInfo() {
        return "Short description";
    }
}
