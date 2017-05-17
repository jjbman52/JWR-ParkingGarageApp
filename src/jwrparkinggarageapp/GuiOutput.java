package jwrparkinggarageapp;

import java.util.Objects;
import javax.swing.JOptionPane;

public class GuiOutput implements OutputStrategy{
    private final String name = "Gui Output";
    private final String id = "guiOutput1";
    
    @Override
    public final void produceOutput(final String line) throws IllegalArgumentException{
        if(line == null || line.isEmpty() || line.length() < 2){
            throw new IllegalArgumentException("Input is not valid.");
        }else{
            JOptionPane.showMessageDialog(null,line);
        }
    }

    @Override
    public final String toString() {
        return "name=" + name + ", id=" + id;
    }

    @Override
    public final int hashCode() {
        int hash = 5;
        hash = 13 * hash + Objects.hashCode(this.name);
        hash = 13 * hash + Objects.hashCode(this.id);
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
        final GuiOutput other = (GuiOutput) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
