/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boekhoudingappclient;


import SessionBean.GuiBeanRemote;
import javax.ejb.EJB;

/**
 *
 * @author jonas
 */
public class Main 
{
    
    @EJB private static GuiBeanRemote bean;
    
    
    public static void main(String[] args) 
    {
        new GUI(bean);
    }
}