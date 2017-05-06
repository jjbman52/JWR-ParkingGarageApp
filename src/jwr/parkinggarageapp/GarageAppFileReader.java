package jwr.parkinggarageapp;

import java.io.*;
import java.util.*;

/**
 *
 * @author jordanrehbein
 */
public class GarageAppFileReader {
    private File file;
    private OutputStrategy output;

    public GarageAppFileReader(File file, OutputStrategy output){
        setFile(file);
        setOutput(output);
    }
    
//    public List<Map<String, String>> readFile() throws IOException{
//        List<Map<String, Object>> list = new ArrayList<>();
//        BufferedReader in = null;
//        
//	in = new BufferedReader(new FileReader(file));
//	String line = in.readLine();
//        int key = 0;
//        
//	while(line != null){
//            Map<String, Object> map = new HashMap<>();
//            map.put(Integer.toString(key), line);
//            list.add(map);
//            line = in.readLine();
//            key++;
//        }
//        
//        return list;
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
}
