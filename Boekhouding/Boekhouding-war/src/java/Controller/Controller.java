
package Controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import SessionBean.localStatelessLocal;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.ejb.EJB;
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
public class Controller extends HttpServlet 
{
    
    @EJB private localStatelessLocal stateless;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        HttpSession sessie = request.getSession();
        String goTo = request.getParameter("goto");
        
        /* INLOGGEN */
        System.out.println(" goto (processRequest): " + goTo + "\n\n");
        if( goTo == null )
        {
            int pNummer = Integer.parseInt(request.getUserPrincipal().getName());
            int bNummer = stateless.getBNumer(pNummer);
            
            sessie.setAttribute("pNummer", pNummer);
            sessie.setAttribute("bNummer", bNummer);
            
            gotoPage("overzicht", request, response);
        }
        
        /* INLOGGENERROR */
        else if(goTo.equals("inloggenError"))
        {
            gotoPage("inloggen", request, response);
        }
        
        /* OVERZICHT */
        else if(goTo.equals("nieuweOnkosten"))
        {
//            MOET CODE HEBBEN OM HOOGSTE ONOSTID OP TE VRAGEN UIT DATABASE
            int onkostId = 12345; //TIJDELIJK
            Date date = new Date();
            SimpleDateFormat dateformat = new SimpleDateFormat ("dd.MM.yyyy");
            sessie.setAttribute("onkostId", onkostId);
            sessie.setAttribute("datum", dateformat.format(date));
            gotoPage("nieuweOnkosten", request, response);
        }
        else if(goTo.equals("bekijkKrediet"))
        {
            gotoPage("bekijkKrediet", request, response);
        }
        else if(goTo.equals("goedkeurenKrediet"))
        {
            gotoPage("goedkeurenKrediet", request, response);
        }
        else if(goTo.equals("uitloggen"))
        {
            sessie.invalidate();
            response.sendRedirect("inloggen.jsp");
        }
        
        /* NIEUWE ONKOST */
        else if(goTo.equals("saveOnkost"))
        {
            String action = request.getParameter("action");
            if (action.equals("save")){
//                CODE OM ONKOST OP TE SLAAN

                gotoPage("overzicht", request, response);
            }
            if (action.equals("send")){
//                CODE OM ONKOST DOOR TE STUREN
                gotoPage("overzicht", request, response);
            }
            if (action.equals("overzicht")){
                gotoPage("overzicht", request, response);
            }
            if (action.equals("uitloggen")){
                sessie.invalidate();
                response.sendRedirect("inloggen.jsp");
            }
            
        }
        else if(goTo.equals("sendOnkost"))
        {
            gotoPage("overzicht", request, response);
        }
    }
  
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        processRequest(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
       processRequest(request, response);
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
