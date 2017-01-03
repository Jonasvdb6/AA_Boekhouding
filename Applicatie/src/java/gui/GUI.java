/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
//import SessionBean.localStateless;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author simon
 */
public class GUI extends JFrame implements ActionListener{

//    private localStateless onkost;
    private JTextField kredietnr;
    private JButton zoekKnop;
    private JLabel labelInvoer;
    private JLabel labelUitvoer;
    private JPanel panelInvoer;
    private JPanel panelKnoppen;
    private JPanel panelUitvoer;
    
    public GUI(){
        
//        this.onkost = onkost;
        
        Container c = super.getContentPane();
        c.setLayout(new BoxLayout(c,BoxLayout.Y_AXIS));
        panelInvoer = new JPanel();
        panelKnoppen = new JPanel();
        panelUitvoer = new JPanel();
        panelInvoer.setLayout(new GridLayout(1,2));
        panelKnoppen.setLayout(new FlowLayout());
        panelUitvoer.setLayout(new GridLayout(1,1));
        
        kredietnr = new JTextField();
        zoekKnop = new JButton("Bekijk");
        labelInvoer = new JLabel("Geef kredietnr");
        labelUitvoer = new JLabel("eziu");
        
        panelInvoer.add(labelInvoer);
        panelInvoer.add(kredietnr);
        panelKnoppen.add(zoekKnop);
        panelUitvoer.add(labelUitvoer);
        c.add(panelInvoer);
        c.add(panelKnoppen);
        c.add(panelUitvoer);
        zoekKnop.addActionListener(this);
        
        setVisible(true); 
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300,50);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        int KredietId = 0;
        try {
            KredietId = Integer.parseInt(this.getKrediet());
        }
        catch (NumberFormatException x){
            //this.setOutput("Verkeerde invoer!");
            return;
        }
        // CODE OM DATA UIT DATABASE TE HALEN
        System.out.println("Krediet: " + KredietId + "\n\n");   
    }
    
    public String getKrediet(){
        return kredietnr.getText();
    }
}
