
package Controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import SessionBean.Kredieten;
import SessionBean.Onkosten;
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
import SessionBean.StatelessBeanLocal;
import java.util.Collections;

/**
 *
 * @author jonas & Simon
 */
@WebServlet(urlPatterns = {"/Controller"})
public class Controller extends HttpServlet 
{
    
    @EJB private StatelessBeanLocal stateless;
    
    /* globale variabelen */
    int pNummer;
    int bNummer;
    int werkType;
    int krNummer;
    int onkostId;
    int first = 1;
    double onkostenBedrag;
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
        bNummer = stateless.getBNumer(pNummer);
        
        /* INLOGGEN */
        System.out.println(" goto (processRequest): " + goTo + "\n\n");
        if( goTo == null )
        {
            sessie.setAttribute("werkType", werkType);
            sessie.setAttribute("pNummer", pNummer);
            sessie.setAttribute("onkList", onkList);
            
            gotoPage("overzicht", request, response);
        }
        
        else if(goTo.equals("uitloggen"))
        {
            sessie.invalidate();
            response.sendRedirect("inloggen.jsp");
        }
        
        else if (goTo.equals("overzicht"))
        {
            onkList = stateless.getOnkosten(pNummer);
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
            onkostId = stateless.getOnkostId();
            sessie.setAttribute("onkostId", onkostId+1);
            
            System.out.println("onkostId : " + onkostId);
            
            gotoPage("nieuweOnkosten", request, response);
        }
       
        else if(goTo.equals("bekijkOnkost"))
        {
            System.out.println("onkost list voor : " + onkList);
            onkostId = Integer.parseInt(request.getParameter("onkostId"));
            System.out.println("onkost id : " + onkostId);
            onkost = stateless.getOnkostById(onkostId);
            sessie.setAttribute("Onkost", onkost);
            
            gotoPage("bekijkOnkost", request, response);
        }        
        
        /* NIEUWE ONKOST + BEKIJK ONKOST*/
        else if (goTo.equals("save"))
        {
            /* Data uit form halen */
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date datum = new Date();
            try 
            {
                datum = formatter.parse(request.getParameter("datum")); 
            }
            catch (ParseException ex)
            {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
            double onkostenBedrag = Double.parseDouble(request.getParameter("bedrag"));
            String omschrijving = request.getParameter("omschrijving");
            String status = "In aanmaak";

            /* Data afprinten */
            System.out.println("datum : " + datum + "\n\n");
            System.out.println("onkostenBedrag : " + onkostenBedrag + "\n\n");
            System.out.println("omschrijving : " + omschrijving + "\n\n");
            
            stateless.setOnkost(onkostId, omschrijving, datum, onkostenBedrag, status);

            onkList = stateless.getOnkosten(pNummer);
            sessie.setAttribute("onkList", onkList);

            gotoPage("overzicht", request, response);
        }
        
        else if (goTo.equals("saveNew"))
        {
            /* Data uit form halen */
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date datum = new Date();
            try 
            {
                datum = formatter.parse(request.getParameter("datum")); 
            }
            catch (ParseException ex)
            {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
            double onkostenBedrag = Double.parseDouble(request.getParameter("bedrag"));
            String omschrijving = request.getParameter("omschrijving");
            String status = "In aanmaak";

            /* Data afprinten */
            System.out.println("datum : " + datum + "\n\n");
            System.out.println("onkostenBedrag : " + onkostenBedrag + "\n\n");
            System.out.println("omschrijving : " + omschrijving + "\n\n");
            System.out.println("onkostId : " + onkostId+1 + "\n\n");
            
            stateless.maakNewOnkost(onkostId+1, omschrijving, datum, onkostenBedrag, status, pNummer, 0);

            onkList = stateless.getOnkosten(pNummer);
            sessie.setAttribute("onkList", onkList);
            
            if (goTo.equals("saveNew"))
            {
                gotoPage("overzicht", request, response);
            }
        }
        
        else if (goTo.equals("send"))
        {
            /* Data uit form halen */
            SimpleDateFormat dateformat = new SimpleDateFormat ("dd/MM/yyyy");
            Date date = new Date();
            try 
            {
                date = dateformat.parse(request.getParameter("datum"));
            }
            catch (ParseException ex) 
            {
                System.out.println("EXCEPTION");
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
            onkostenBedrag = Double.parseDouble(request.getParameter("bedrag"));
            String omschrijving = request.getParameter("omschrijving");

            /* Data afprinten */
            System.out.println("OnkostId : " + onkostId);
            System.out.println("datum : " + date);
            System.out.println("onkostenBedrag : " + onkostenBedrag);
            System.out.println("omschrijving : " + omschrijving);

            //Zowel eigen kredieten al die van de baas worden opgehaald
            kredList = stateless.getKredietenEigenEnBaas(pNummer, bNummer);

            List<Integer> indexToRemove = new ArrayList<Integer>();
            for(int i=0; i<kredList.size(); i++)
            {
                if(kredList.get(i).getKrType() == 1)
                {
                    if( (kredList.get(i).getKrSaldo() - onkostenBedrag) < 0 )
                    {
                        indexToRemove.add(i);
                    }
                }
                else
                {
                    krNummer = kredList.get(i).getKrNummer();
                    if( (kredList.get(i).getKrSaldo() - onkostenBedrag) < 0 )
                    {
                        stateless.setNegatief(krNummer, 1);
                    }
                    else
                    {
                        stateless.setNegatief(krNummer, 0);
                    }
                }
            }

            //Om ervoor te zorgen dat de jusite elementen verwijderd worden
            Collections.sort(indexToRemove, Collections.reverseOrder());
            for(int i=0; i<indexToRemove.size(); i++)
            {
                kredList.remove((int)indexToRemove.get(i));
            }

            sessie.setAttribute("kredList", kredList);

            gotoPage("selectKrediet", request, response);
        }
        
        else if (goTo.equals("sendNew"))
        {
            /* Save new */
            /* Data uit form halen */
            if (first == 1)
            {
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                Date datum = new Date();
                try 
                {
                    datum = formatter.parse(request.getParameter("datum")); 
                }
                catch (ParseException ex)
                {
                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
                onkostenBedrag = Double.parseDouble(request.getParameter("bedrag"));
                String omschrijving = request.getParameter("omschrijving");
                String status = "In aanmaak";

                /* Data afprinten */
                System.out.println("datum : " + datum + "\n\n");
                System.out.println("onkostenBedrag : " + onkostenBedrag + "\n\n");
                System.out.println("omschrijving : " + omschrijving + "\n\n");
                System.out.println("onkostId : " + onkostId+1 + "\n\n");

                stateless.maakNewOnkost(onkostId+1, omschrijving, datum, onkostenBedrag, status, pNummer, 0);

                onkList = stateless.getOnkosten(pNummer);
                sessie.setAttribute("onkList", onkList);
                
                onkostId += 1;
                
                first = 0;
            }
            
            /* Send new */
            //Zowel eigen kredieten al die van de baas worden opgehaald
            kredList = stateless.getKredietenEigenEnBaas(pNummer, bNummer);

            List<Integer> indexToRemove = new ArrayList<Integer>();
            for(int i=0; i<kredList.size(); i++)
            {
                if(kredList.get(i).getKrType() == 1)
                {
                    if( (kredList.get(i).getKrSaldo() - onkostenBedrag) < 0 )
                    {
                        indexToRemove.add(i);
                    }
                }
                else
                {
                    krNummer = kredList.get(i).getKrNummer();
                    if( (kredList.get(i).getKrSaldo() - onkostenBedrag) < 0 )
                    {
                        stateless.setNegatief(krNummer, 1);
                    }
                    else
                    {
                        stateless.setNegatief(krNummer, 0);
                    }
                }
            }

            //Om ervoor te zorgen dat de jusite elementen verwijderd worden
            Collections.sort(indexToRemove, Collections.reverseOrder());
            for(int i=0; i<indexToRemove.size(); i++)
            {
                kredList.remove((int)indexToRemove.get(i));
            }

            sessie.setAttribute("kredList", kredList);

            gotoPage("selectKrediet", request, response);
        }
        
        else if (goTo.equals("delete"))
        {
            stateless.deleteOnkost(onkostId);

            onkList = stateless.getOnkosten(pNummer);
            sessie.setAttribute("onkList", onkList);

            gotoPage("overzicht", request, response);
        }
        
        else if(goTo.equals("selectKrediet"))
        {
            first = 1;
            
            int krediet = Integer.parseInt(request.getParameter("krediet"));
            double saldo = stateless.getKredietById(krediet).getKrSaldo() - onkostenBedrag;
            stateless.setKredietSaldo(krediet, saldo);
            
            stateless.setOnkostStatus(onkostId, "Doorgestuurd");
            stateless.setOnkostKrediet(onkostId, krediet);
            
            System.out.println("onkostId : " + onkostId + "\n\n");
            System.out.println("krediet saldo: " + stateless.getKredietById(krediet).getKrSaldo() + "\n\n");
            System.out.println("krediet : " + krediet + "\n\n");
            System.out.println("onkostenBedrag : " + onkostenBedrag + "\n\n");
            
            onkList = stateless.getOnkosten(pNummer);
            sessie.setAttribute("onkList", onkList);
                
            gotoPage("overzicht", request, response);
        }
        
         else if(goTo.equals("overzichtKrediet"))
        {            
            kredList = stateless.getKredietenAll();
            double totaalKrediet=0;
            for(int i=0; i<kredList.size(); i++)
            {
                totaalKrediet += kredList.get(i).getKrSaldo();
            }
            
            sessie.setAttribute("kredList", kredList);
            sessie.setAttribute("totaalKrediet", totaalKrediet);
            
            gotoPage("overzichtKrediet", request, response);
        }
        
        else if(goTo.equals("bekijkKrediet"))
        {
            krNummer = Integer.parseInt(request.getParameter("krediet"));
            System.out.println("krNummer : " + krNummer);
            
            onkList = stateless.getOnkostenKrediet(krNummer);
            sessie.setAttribute("onkList", onkList);
            
            gotoPage("bekijkKrediet", request, response);
        }
        
        else if(goTo.equals("infoKrediet"))
        {
            onkostId = Integer.parseInt(request.getParameter("onkostId"));
            System.out.println("onkostId : " + onkostId);
            
            krNummer = stateless.getKrNummerVanOnkost(onkostId);
            System.out.println("krNummer : " + krNummer);
            
            Kredieten k = stateless.getKredietById(krNummer);
            
            onkList = stateless.getOnkostenKrediet(krNummer);
            sessie.setAttribute("onkList", onkList);
            sessie.setAttribute("Krediet", k);
            
            gotoPage("infoKrediet", request, response);
        }

        else if(goTo.equals("infoOnkost"))
        {
            onkostId = Integer.parseInt(request.getParameter("onkostId"));
            
            SimpleDateFormat dateformat = new SimpleDateFormat ("dd/MM/yyyy");
            Date date = new Date();
            try
            {
                date = dateformat.parse("21/02/2017");
            }
            catch (ParseException ex) 
            {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }

            onkost = stateless.getOnkostById(onkostId);
            sessie.setAttribute("Onkost", onkost);
            
            System.out.println("OnkostId: " + onkostId + "\n\n");
            System.out.println("krNummer: " + krNummer + "\n\n");
            gotoPage("infoOnkost", request, response);
        }
        
        /* INFO ONKOST */        
        else if(goTo.equals("goedkeurenOnkost"))
        {            
            onkList = stateless.getOnkostenManager(pNummer);
            sessie.setAttribute("onkList", onkList);
            
            gotoPage("goedkeurenOnkost", request, response);
        }
        
        /* GOEDKEUREN ONKOST */
        else if (goTo.equals("goedkeuren"))
        {
            onkostId = Integer.parseInt(request.getParameter("onkostId"));
            stateless.setOnkostStatus(onkostId, "Betaald");
            
            onkList = stateless.getOnkostenManager(pNummer);
            sessie.setAttribute("onkList", onkList);
            
            gotoPage("goedkeurenOnkost", request, response);
        }
        else if (goTo.equals("afkeuren"))
        {
            onkostId = Integer.parseInt(request.getParameter("onkostId"));
            stateless.setOnkostStatus(onkostId, "Afgekeurd");
            
            onkList = stateless.getOnkostenManager(pNummer);
            sessie.setAttribute("onkList", onkList);
            
            gotoPage("goedkeurenOnkost", request, response);
        }
        
        else if (goTo.equals("terugOverzichtOnkost"))
        {
            gotoPage("bekijkKrediet", request, response);
        }
        
        else if (goTo.equals("terugOverzichtKrediet"))
        {
            gotoPage("overzichtKrediet", request, response);
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
    
    public String getServletInfo() 
    {
        return "Short description";
    }
}