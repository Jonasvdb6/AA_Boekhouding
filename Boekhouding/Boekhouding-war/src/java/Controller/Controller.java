
package Controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import SessionBean.Kredieten;
import SessionBean.Onkosten;
import SessionBean.localStatelessLocal;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    /* globale variabelen */
    
    int pNummer;
    int bNummer;
    int werkType;
    int krNummer;
    int onkostId;
    List<Onkosten> onkList = new ArrayList<>();
    List<Kredieten> kredList = new ArrayList<>();
    Onkosten onkost;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        HttpSession sessie = request.getSession();
        String goTo = request.getParameter("goto");
        
        pNummer = Integer.parseInt(request.getUserPrincipal().getName());
        werkType = stateless.getWerkType(pNummer);
        onkList = stateless.getOnkosten(pNummer);
        
        /* INLOGGEN */
        System.out.println(" goto (processRequest): " + goTo + "\n\n");
        if( goTo == null )
        {
            sessie.setAttribute("werkType", werkType);
            sessie.setAttribute("pNummer", pNummer);
            sessie.setAttribute("onkList", onkList);
            
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
//            CODE OM HOOGSTE ONKOSTID OP TE VRAGEN UIT DATABASE
            onkostId = 12345; //TIJDELIJK
            sessie.setAttribute("onkostId", onkostId);
            gotoPage("nieuweOnkosten", request, response);
        }
        else if(goTo.equals("overzichtKrediet"))
        {
//            CODE OM KREDIETEN UIT DATABASE TE HALEN
            Kredieten k1 = new Kredieten(1,6513,1);             //TIJDELIJK
            Kredieten k2 = new Kredieten(2,21681,2);            //TIJDELIJK
            Kredieten k3 = new Kredieten(3,5846,1);             //TIJDELIJK
            kredList.add(k1);                                   //TIJDELIJK
            kredList.add(k2);                                   //TIJDELIJK
            kredList.add(k3);                                   //TIJDELIJK
            sessie.setAttribute("kredList", kredList);
            
            gotoPage("overzichtKrediet", request, response);
        }
        else if(goTo.equals("goedkeurenOnkost"))
        {
            gotoPage("goedkeurenOnkost", request, response);
        }
        else if(goTo.equals("bekijkOnkost"))
        {            
            onkostId = Integer.parseInt(request.getParameter("onkostId"));
            onkost = onkList.get(onkostId-1);
            sessie.setAttribute("Onkost", onkost);
            
            gotoPage("bekijkOnkost", request, response);
        }
        else if(goTo.equals("uitloggen"))
        {
            sessie.invalidate();
            response.sendRedirect("inloggen.jsp");
        }
        
        /* NIEUWE ONKOST + BEKIJK ONKOST*/
        else if(goTo.equals("saveOnkost"))
        {
            System.out.println("pnummer: " + pNummer + "\n\n");
            System.out.println("onkList: " + onkList + "\n\n");
            String action = request.getParameter("action");
            if (action.equals("save")){
//                CODE OM ONKOST OP TE SLAAN

                /* Data uit form halen */
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                Date datum = new Date();
                try {
                    datum = formatter.parse(request.getParameter("datum"));
                } catch (ParseException ex) {
                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
                double onkostenBedrag = Double.parseDouble(request.getParameter("bedrag"));
                String omschrijving = request.getParameter("omschrijving");
                String status = "in aanmaak";
                
                /* Data afprinten */
                System.out.println("datum : " + datum + "\n\n");
                System.out.println("onkostenBedrag : " + onkostenBedrag + "\n\n");
                System.out.println("omschrijving : " + omschrijving + "\n\n");

//            CODE OM UPDATE VAN ARRAYLIST VAN ONKOSTEN OP TE HALEN UIT DATABASE
                //sessie.setAttribute("onkList", onkList);
                
                gotoPage("overzicht", request, response);
            }
            if (action.equals("send")){

                /* Data uit form halen */
                SimpleDateFormat dateformat = new SimpleDateFormat ("dd/MM/yyyy");
                Date date = new Date();
                try {
                    date = dateformat.parse(request.getParameter("datum"));
                } catch (ParseException ex) {
                    System.out.println("EXCEPTION");
                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
                double onkostenBedrag = Double.parseDouble(request.getParameter("bedrag"));
                String omschrijving = request.getParameter("omschrijving");
                
                /* Data afprinten */
                System.out.println("datum : " + date + "\n\n");
                System.out.println("onkostenBedrag : " + onkostenBedrag + "\n\n");
                System.out.println("omschrijving : " + omschrijving + "\n\n");
                
//                CODE OM ARRAYLIST VAN KREDIETEN TE KRIJGEN 
//                EXTRA VARIABELE MEEGEVEN OM TE KIJKEN OF KREDIET ONDER 0 GAAT

                Kredieten k1 = new Kredieten(1,6513,1);             //TIJDELIJK
                Kredieten k2 = new Kredieten(2,21681,2);            //TIJDELIJK
                Kredieten k3 = new Kredieten(3,5846,1);             //TIJDELIJK
                kredList.add(k1);                                   //TIJDELIJK
                kredList.add(k2);                                   //TIJDELIJK
                kredList.add(k3);                                   //TIJDELIJK
                int negatief = 0;                                   //TIJDELIJK
                sessie.setAttribute("kredList", kredList);
                sessie.setAttribute("negatief", negatief);
                
                gotoPage("selectKrediet", request, response);
            }
            if (action.equals("delete")){
                
//              CODE OM ONKOST TE DELETEN
                
//              CODE OM UPDATE VAN ARRAYLIST VAN ONKOSTEN OP TE HALEN UIT DATABASE
                //sessie.setAttribute("onkList", onkList);
                
                gotoPage("overzicht", request, response);
                
            }
            
            if (action.equals("overzicht")){
                
//            CODE OM UPDATE VAN ARRAYLIST VAN ONKOSTEN OP TE HALEN UIT DATABASE
                //sessie.setAttribute("onkList", onkList);
                
                gotoPage("overzicht", request, response);
            }
            if (action.equals("uitloggen")){
                sessie.invalidate();
                response.sendRedirect("inloggen.jsp");
            }
        }
        
        /* SELECT KREDIET */
        
        else if(goTo.equals("selectKredietStop"))
        {
            
            String action = request.getParameter("action");
            
            if (action.equals("overzicht")){
                
//            CODE OM UPDATE VAN ARRAYLIST VAN ONKOSTEN OP TE HALEN UIT DATABASE
                //sessie.setAttribute("onkList", onkList);
                
                gotoPage("overzicht", request, response);
            }
            if (action.equals("uitloggen")){
                sessie.invalidate();
                response.sendRedirect("inloggen.jsp");
            }
        }
        
        else if(goTo.equals("selectKrediet")){
//            CODE OM ONKOST DOOR TE STUREN EN KREDIET AAN TE PASSEN
            String krediet = request.getParameter("krediet");
            String status = "doorgestuurd";
            
            System.out.println("krediet : " + krediet + "\n\n");
            System.out.println("status : " + status + "\n\n");
            
//            CODE OM UPDATE VAN ARRAYLIST VAN ONKOSTEN OP TE HALEN UIT DATABASE
            //sessie.setAttribute("onkList", onkList);
                
            gotoPage("overzicht", request, response);
        }
        
        /* OVERZICHT KREDIETEN */
        
        else if(goTo.equals("overzichtKredietStop"))
        {
            String action = request.getParameter("action");
            
            if(action.equals("overzicht"))
            {
//            CODE OM UPDATE VAN ARRAYLIST VAN ONKOSTEN OP TE HALEN UIT DATABASE
                //sessie.setAttribute("onkList", onkList);
                
                gotoPage("overzicht", request, response);
            }
            if (action.equals("uitloggen")){
                sessie.invalidate();
                response.sendRedirect("inloggen.jsp");
            }
        }
        
        else if(goTo.equals("bekijkKrediet"))
        {
//            CODE OM ARRAYLIST VAN ONKOSTEN VAN KREDIET OP TE HALEN UIT DATABASE
            
            krNummer = Integer.parseInt(request.getParameter("krediet"));
            
            gotoPage("bekijkKrediet", request, response);
        }
        
        /* BEKIJK KREDIET */
        
        else if(goTo.equals("bekijkKredietStop"))
        {
            String action = request.getParameter("action");
            
            if(action.equals("overzicht"))
            {
//            CODE OM UPDATE VAN ARRAYLIST VAN ONKOSTEN OP TE HALEN UIT DATABASE
                //sessie.setAttribute("onkList", onkList);
                
                gotoPage("overzicht", request, response);
            }
            if (action.equals("uitloggen")){
                sessie.invalidate();
                response.sendRedirect("inloggen.jsp");
            }
        }
        else if(goTo.equals("infoOnkost"))
        {
            
//            CODE OM ONKOST UIT DATABASE TE HALEN DMV ONKOSTID
            onkostId = Integer.parseInt(request.getParameter("onkostId"));
            
            SimpleDateFormat dateformat = new SimpleDateFormat ("dd/MM/yyyy");
            Date date = new Date();
            try {
                date = dateformat.parse("21/02/2017");
            } catch (ParseException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }

            onkost = new Onkosten(1,"eerste",date,6513,"doorgestuurd");
            sessie.setAttribute("Onkost", onkost);
            
            System.out.println("OnkostId: " + onkostId + "\n\n");
            System.out.println("krNummer: " + krNummer + "\n\n");
            gotoPage("infoOnkost", request, response);
        }
        
        /* INFO ONKOST */
        
        else if(goTo.equals("infoOnkostStop"))
        {

//            CODE OM UPDATE VAN ARRAYLIST VAN ONKOSTEN OP TE HALEN UIT DATABASE
            //sessie.setAttribute("onkList", onkList);
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
