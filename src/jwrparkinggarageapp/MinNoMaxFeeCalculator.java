package jwrparkinggarageapp;

public class MinNoMaxFeeCalculator implements FeeCalculationStrategy {
    private double minFee;

    public MinNoMaxFeeCalculator(final double maxHours, final double minFee, final double maxFee) {
        setMinFee(minFee);
    }
    
    @Override
    public final double calculateFee(final double hours) {
        return minFee;
    }
    
    public double getMinFee() {
        return minFee;
    }

    public final void setMinFee(final double minFee) {
        if(minFee < 0){
            throw new IllegalArgumentException("Input is not valid: The minimum fee cost must be greater than 0");
        }else{
            this.minFee = minFee;
        }
    }
}
