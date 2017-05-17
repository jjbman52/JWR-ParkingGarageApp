package jwrparkinggarageapp;

import java.io.*;
import java.util.*;

/**
 *
 * @author jordanrehbein
 */
public class GarageAppFileWriter {
    private String filePath;
    private boolean append = false;
    private GarageAppGenericFileFormatter format;

    public GarageAppFileWriter(final String filePath, final GarageAppGenericFileFormatter format) {
        setFilePath(filePath);
        setFormat(format);
    }

    public final void writeToFile(final List<Map<String, String>> list) throws Exception{
        File file = new File(filePath);
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file, append)));
        Map<String,String> map = new HashMap<>();
        map = list.get(0);
        
        out.println("totalHours" + format.getFormat() + map.get("totalHours"));
        out.println("totalFee"+ format.getFormat() + map.get("totalFee"));
        
        out.close();
    }
    
    public final String getFilePath() {
        return filePath;
    }
    
    public final void setFilePath(final String filePath) {
        if(filePath == null){
            throw new InvalidEntryException();
        }else{
            this.filePath = filePath;
        }
    }

    public final GarageAppGenericFileFormatter getFormat() {
        return format;
    }

    public final void setFormat(final GarageAppGenericFileFormatter format) {
        if(format == null){
            throw new InvalidEntryException();
        }else{
            this.format = format;
        }
    }

    @Override
    public final String toString() {
        return "GarageAppFileWriter{" + "filePath=" + filePath + ", append=" + append + ", format=" + format + '}';
    }

    @Override
    public final int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.filePath);
        hash = 79 * hash + Objects.hashCode(this.format);
        return hash;
    }

    @Override
    public final boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final GarageAppFileWriter other = (GarageAppFileWriter) obj;
        if (!Objects.equals(this.filePath, other.filePath)) {
            return false;
        }
        if (!Objects.equals(this.format, other.format)) {
            return false;
        }
        return true;
    }
}
