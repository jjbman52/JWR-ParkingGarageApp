package jwr.parkinggarageapp;

public class ConsoleOutput implements OutputStrategy {
    
    @Override
    public final void produceOutput(final String line){
        if(line == null || line.isEmpty() || line.length() < 2){
            throw new IllegalArgumentException("Input is not valid.");
        }else{
            System.out.println(line);
        }
    }
}
