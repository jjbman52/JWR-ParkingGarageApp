package jwr.parkinggarageapp;

import javax.swing.JOptionPane;

public class GuiOutput implements OutputStrategy{

    @Override
    public final void produceOutput(final String line) {
        if(line == null || line.isEmpty() || line.length() < 2){
            throw new IllegalArgumentException("Input is not valid.");
        }else{
            JOptionPane.showMessageDialog(null,line);
        }
    }
    
}
