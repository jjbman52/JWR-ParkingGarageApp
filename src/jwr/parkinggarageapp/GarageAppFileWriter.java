package jwr.parkinggarageapp;

import java.io.*;
import java.util.*;

/**
 *
 * @author jordanrehbein
 */
public class GarageAppFileWriter {
    private File file;
    private OutputStrategy output;
    private boolean append;

    public GarageAppFileWriter(File file, OutputStrategy output, boolean append) {
        setFile(file);
        setOutput(output);
        setAppend(append);
    }
    
//    public void fileWrite(List<Map<String, String>> data) throws IOException{
//        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file, append)));
//        
//        for (String record : data){
//            out.println(object);
//        }
//        out.close();
//        output.produceOutput("Data was written to " + file.getAbsolutePath());
//    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public OutputStrategy getOutput() {
        return output;
    }

    public void setOutput(OutputStrategy output) {
        this.output = output;
    }

    public boolean isAppend() {
        return append;
    }

    public void setAppend(boolean append) {
        this.append = append;
    }
}
