package jwrparkinggarageapp;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 *
 * @author jordanrehbein
 */
public class GarageTotalsToListOfMaps {
    private GarageAppFileReader fileReader;
    private GarageAppFileWriter filewriter;

    public GarageTotalsToListOfMaps(String filePath, GarageAppGenericFileFormatter format) throws IllegalArgumentException{
        fileReader = new GarageAppFileReader(filePath, format);
        filewriter = new GarageAppFileWriter(filePath, format);
    }
    
    public final void getTotalsInListOfMaps(Receipt receipt, List<Map<String,String>> list, Map<String,String> map) throws Exception{
        list = fileReader.readFile();
        
        map = list.get(0);
        
        double hours;
        double fee;
        
        if (!map.isEmpty()){
            hours = Double.parseDouble(map.get("totalHours"));
            fee = Double.parseDouble(map.get("totalFee"));
        }else{
            hours = 0;
            fee = 0;
        }
        
        hours += receipt.getHours();
        fee += receipt.getFee();
        
        map.clear();
        map.put("totalHours", Double.toString(hours));
        map.put("totalFee" , Double.toString(fee));
        
        filewriter.writeToFile(list);
    }

    @Override
    public final String toString() {
        return "GarageTotalsToListOfMaps{" + "fileReader=" + fileReader + ", filewriter=" + filewriter + '}';
    }

    @Override
    public final int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.fileReader);
        hash = 23 * hash + Objects.hashCode(this.filewriter);
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
        final GarageTotalsToListOfMaps other = (GarageTotalsToListOfMaps) obj;
        if (!Objects.equals(this.fileReader, other.fileReader)) {
            return false;
        }
        if (!Objects.equals(this.filewriter, other.filewriter)) {
            return false;
        }
        return true;
    }
}
