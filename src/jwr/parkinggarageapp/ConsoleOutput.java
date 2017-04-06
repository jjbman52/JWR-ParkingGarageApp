package jwr.parkinggarageapp;

public class ConsoleOutput implements OutputStrategy {
    
    @Override
    public final void produceOutput(String line){
        if(line == null || line.isEmpty() || line.length() < 2){
            throw new IllegalArgumentException("Input is not valid.");
        }else{
            System.out.println(line);
        }
    }
}
