package jwrparkinggarageapp;

public class MinMaxFeeCalculator implements FeeCalculationStrategy {
    private double max;
    private double minFee;
    private double maxFee;

    public MinMaxFeeCalculator(final double maxHours, final double minFee, final double maxFee) {
        setMax(maxHours);
        setMinFee(minFee);
        setMaxFee(maxFee);
    }
            
    @Override
    public final double calculateFee(final double hours) {
        double fee = 0;
        if(hours > max){
            fee = maxFee;
        } else{
            fee = minFee;
        }
        return fee;
    }

    public final double getMax() {
        return max;
    }

    public final void setMax(final double max) throws IllegalArgumentException{
        if(max <= 0){
            throw new IllegalArgumentException("Input is not valid: The maximum hours charged must be greater than 0");
        }else{
            this.max = max;
        }
    }

    public final double getMinFee() {
        return minFee;
    }

    public final void setMinFee(final double minFee) throws IllegalArgumentException{
        if(minFee < 0){
            throw new IllegalArgumentException("Input is not valid: The minimum fee cost must be greater than 0");
        }else{
            this.minFee = minFee;
        }
    }
    
    public final double getMaxFee() {
        return maxFee;
    }

    public final void setMaxFee(final double maxFee) throws IllegalArgumentException{
        if(maxFee <= 0){
            throw new IllegalArgumentException("Input is not valid: The minimum fee cost must be greater than 0");
        }else{
            this.maxFee = maxFee;
        }
    }
}
