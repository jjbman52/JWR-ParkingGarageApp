package jwr.parkinggarageapp;

public class MinMaxFeeCalculator implements FeeCalculationStrategy {
    private double min;
    private double max;
    private double minFee;
    private double additionalTime;
    private double additionalFee;

    public MinMaxFeeCalculator(double minHours, double maxHours, double minFee, double additionalTime, double additionalFee) {
        setMin(min);
        setMax(max);
        setMinFee(minFee);
        setAdditionalTime(additionalTime);
        setAdditionalFee(additionalFee);
    }
            
    @Override
    public final double calculateFee(double hours) {
        double totalHours = 0;
        double fee = 0;
        if(hours <= min){
            fee = minFee;
        } else if(hours > min || hours <= max){
            totalHours -= min;
            fee += minFee;
            while(totalHours > 0){
                totalHours -= additionalTime;
                fee += additionalFee;
            }
        }
        return fee;
    }

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        if(min < 0){
            throw new IllegalArgumentException("Input is not valid: The minimum hours charged must be greater than 0");
        }else{
            this.min = min;
        }
    }

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        if(max < 0){
            throw new IllegalArgumentException("Input is not valid: The maximum hours charged must be greater than 0");
        }else{
            this.max = max;
        }
    }

    public double getMinFee() {
        return minFee;
    }

    public void setMinFee(double minFee) {
        if(minFee < 0){
            throw new IllegalArgumentException("Input is not valid: The minimum fee cost must be greater than 0");
        }else{
            this.minFee = minFee;
        }
    }

    public double getAdditionalTime() {
        return additionalTime;
    }

    public void setAdditionalTime(double additionalTime) {
        if(additionalTime < 0){
            throw new IllegalArgumentException("Input is not valid: The additional hours amount must be greater than 0");
        }else{
            this.additionalTime = additionalTime;
        }
    }

    public double getAdditionalFee() {
        return additionalFee;
    }

    public void setAdditionalFee(double additionalFee) {
        if(additionalFee < 0){
            throw new IllegalArgumentException("Input is not valid: The additional fee amount must be greater than 0");
        }else{
            this.additionalFee = additionalFee;
        }
    }
}
