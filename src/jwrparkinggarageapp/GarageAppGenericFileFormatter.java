package jwrparkinggarageapp;

import java.util.Objects;

/**
 *
 * @author jordanrehbein
 */
public class GarageAppGenericFileFormatter {
    private String format;
    
    public GarageAppGenericFileFormatter(final String format) throws IllegalArgumentException{
        setFormat(format);
    }
    
    public final String formatLine(){
        return format;
    }

    public final String getFormat() {
        return format;
    }

    public final void setFormat(final String format) throws IllegalArgumentException{
        if(format == null){
            throw new InvalidEntryException();
        }else{
            this.format = format;
        }
    }

    @Override
    public final String toString() {
        return "GarageAppGenericFileFormatter{" + "format=" + format + '}';
    }

    @Override
    public final int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.format);
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
        final GarageAppGenericFileFormatter other = (GarageAppGenericFileFormatter) obj;
        if (!Objects.equals(this.format, other.format)) {
            return false;
        }
        return true;
    }
}
