package jwrparkinggarageapp;

import java.util.Objects;

public class ConsoleOutput implements OutputStrategy {
    private final String name = "Console Output";
    private final String id = "consoleOutput1";
    
    @Override
    public final void produceOutput(final String line) throws IllegalArgumentException{
        if(line == null || line.isEmpty() || line.length() < 2){
            throw new IllegalArgumentException("Input is not valid.");
        }else{
            System.out.println(line);
        }
    }

    @Override
    public final String toString() {
        return "name=" + name + ", id=" + id;
    }

    @Override
    public final int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.name);
        hash = 47 * hash + Objects.hashCode(this.id);
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
        final ConsoleOutput other = (ConsoleOutput) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
