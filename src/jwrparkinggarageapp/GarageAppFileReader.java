package jwrparkinggarageapp;

import java.io.*;
import java.util.*;

/**
 *
 * @author jordanrehbein
 */
public class GarageAppFileReader {
    private String filePath;
    private GarageAppGenericFileFormatter format;

    public GarageAppFileReader(final String filePath, final GarageAppGenericFileFormatter format){
        setFilePath(filePath);
        setFormat(format);
    }
    
    public List<Map<String, String>> readFile() throws Exception{
        File file = new File(filePath);
        List<Map<String, String>> list = new ArrayList<>();
        BufferedReader in = null;
        
	in = new BufferedReader(new FileReader(file));
	String line = in.readLine();
        
        Map<String, String> map = new HashMap<>();
	while(line!=null && line.length()!=0){
            String[] fields = line.split(format.formatLine());
            map.put(fields[0], fields[1]);
            line = in.readLine();
        }
        list.add(map);
        in.close();
        return list;
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
        return "GarageAppFileReader{" + "filePath=" + filePath + ", format=" + format + '}';
    }

    @Override
    public final int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.filePath);
        hash = 37 * hash + Objects.hashCode(this.format);
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
        final GarageAppFileReader other = (GarageAppFileReader) obj;
        if (!Objects.equals(this.filePath, other.filePath)) {
            return false;
        }
        if (!Objects.equals(this.format, other.format)) {
            return false;
        }
        return true;
    }
}
