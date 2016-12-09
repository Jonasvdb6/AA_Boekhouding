/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

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
 * @author simon
 */
@WebServlet(name = "Ctrl", urlPatterns = {"/Ctrl"})
public class Controller extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String s = null;
        HttpSession sessie = null;
        
        /* Nog geen sessie -> Sessie aanmaken */
        if (request.getSession() == null){
            sessie = request.getSession(true);
            int pNummer = Integer.parseInt(request.getUserPrincipal().getName());
            sessie.setAttribute("pNummer", pNummer);
            gotoPage("overzicht", request, response);
        }
        /* Al een sessie aanwezig -> variabele s aanpassen */
        else{
            s = request.getParameter("goto");
        }
        
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
            sessie.invalidate();
            response.sendRedirect("Boekhouding-war/inloggen.jsp");
        }
        
    }
    
    protected void gotoPage(String naam, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        RequestDispatcher view = request.getRequestDispatcher(naam + ".jsp");
        view.forward(request, response);
    }    
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
