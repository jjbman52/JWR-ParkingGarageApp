package jwr.parkinggarageapp;

import java.io.File;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

public class DataClearingForFileEntryStorage {
    private File file;
    
    public DataClearingForFileEntryStorage(String fileName){
        file = new File(fileName);
    }
    
    public final void clearDataFromFile(){
        try (PrintWriter writer = new PrintWriter(file)){
            writer.println("");
            writer.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
