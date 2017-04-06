package jwr.parkinggarageapp;

public class MinNoMaxFeeCalculator implements FeeCalculationStrategy {
    
    @Override
    public double calculateFee(double hours) {
        double fee = 0;
        if(hours <= 2){
            fee = 1.50;
        } else if(hours > 2 || hours <= 24){
            hours -= 2;
            fee += 1.50;
            while(hours > 0){
                hours -= 1;
                fee += .75;
            }
        }
        return fee;
    }
}
