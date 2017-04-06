package jwr.parkinggarageapp;

public class MinMaxFeeCalculator implements FeeCalculationStrategy {

    @Override
    public double calculateFee(double hours) {
        double fee = 0;
        if(hours <= 3){
            fee = 2;
        } else if(hours > 3 || hours <= 18.5){
            hours -= 3;
            fee += 2;
            while(hours > 0){
                hours -= 1;
                fee += .5;
            }
        }
        return fee;
    }
}
