
package AutomataFinito;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.*;

public class FiniteAutomata extends JFrame{
    public static final int ancho = 375;
    public static final int largo = 150;
    private JTextField cadena;
    private JTextField result = new JTextField(20);
    private JLabel x;
    
    public FiniteAutomata(){
        setSize(ancho,largo);
        setTitle("Automata");
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(3,0));
        setLocationRelativeTo(null);
        contenido();
        setVisible(true);
        
    }
    
    public void contenido() {
        
        // Input
        
        JPanel r = new JPanel();
        r.setLayout(new FlowLayout(FlowLayout.CENTER));
        x = new JLabel("Cadena: ");
        cadena = new JTextField(25);
        r.add(x);
        r.add(cadena);
        add(r);
        
        //Estado
        JPanel q = new JPanel();
        q.setLayout(new FlowLayout(FlowLayout.CENTER));
        result.setEditable(false);
        x = new JLabel("Estado: ");
        q.add(x);
        q.add(result);
        add(q);
        
        
        //
        JPanel j = new JPanel();
        j.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton p = new JButton("Procesar");
        j.add(p);
        add(j);
        p.addActionListener(new Listen());
        cadena.addActionListener(new Listen());
    }
    
    private class Listen implements ActionListener{
        public void actionPerformed(ActionEvent e){
            int num=0;
            String estado ="Y";
            
            boolean noValido = false;
            
            String c = cadena.getText();
            
            for (int i = 0; i < c.length(); i++) {
                if(!(c.charAt(i)=='1' || c.charAt(i)=='0'))
                    noValido= true;
            }
            
            if(!noValido){
                for (int i = 0; i < c.length() ; i++) {
                    if(c.contains("111"))
                        estado ="N";
                }
            }
            
            if(noValido)
                result.setText("Cadena No valida");
            else if(estado.equalsIgnoreCase("y"))
                result.setText("Aceptacion");
            else
                result.setText("No aceptacion");
        }
    }
    public static void main(String[] args) {
        new FiniteAutomata();
    }
}
