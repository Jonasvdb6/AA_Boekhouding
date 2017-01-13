/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boekhoudingappclient;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
//import SessionBean.localStateless;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import SessionBean.*;
import java.awt.List;

/**
 *
 * @author jonas
 */
public class GUI extends JFrame implements ActionListener
{

    private JTextField kredietnr;
    private JButton zoekKnop;
    private JLabel labelInvoer;
    private JPanel panelInvoer;
    private JPanel panelKnoppen;
    private final GuiBeanRemote bean;
    
    public GUI(GuiBeanRemote bean)
    {
        
        this.bean = bean;
        
        Container c = super.getContentPane();
        c.setLayout(new BoxLayout(c,BoxLayout.Y_AXIS));
        panelInvoer = new JPanel();
        panelKnoppen = new JPanel();
        panelInvoer.setLayout(new GridLayout(1,2));
        panelKnoppen.setLayout(new FlowLayout());
        
        kredietnr = new JTextField();
        zoekKnop = new JButton("Bekijk");
        labelInvoer = new JLabel("Geef kredietnr");
        
        panelInvoer.add(labelInvoer);
        panelInvoer.add(kredietnr);
        panelKnoppen.add(zoekKnop);
        c.add(panelInvoer);
        c.add(panelKnoppen);
        kredietnr.addActionListener(this);
        zoekKnop.addActionListener(this);
        
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth();
        int height = (int) screenSize.getHeight();
        int vensterBreedte = width/6;
        int vensterHoogte = height/9;
        
        setSize(vensterBreedte,vensterHoogte);
        setLocation(width/2-vensterBreedte/2,height/2-vensterHoogte/2);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        int KredietId = 0;
        try 
        {
            KredietId = Integer.parseInt(this.getKrediet());
        }
        catch (NumberFormatException x)
        {
            System.out.println("Verkeerde invoer!\nGeef een geldig kredietnummer op.");
            return;
        }
        int maxKredietId = bean.getMaxKredietId();
        if (KredietId <= 0 || KredietId > maxKredietId)
        {
            System.out.println("Dit krediet bestaat niet, geef een geldig kredietnummer op.");
            return;
        }
        else
        {
            String s = bean.getKrediet(KredietId);
            System.out.println("\n" + s);
        }
    }
    
    public String getKrediet()
    {
        return kredietnr.getText();
    }
}