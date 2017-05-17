package jwrparkinggarageapp;

/**
 *
 * @author jordanrehbein
 */
public class AdditionalTimeFeeCalculator extends FeeCalculationDecorator{
    private double min;
    private double max;
    private double additionalFee;
    private double additionalTime;

    public AdditionalTimeFeeCalculator(final FeeCalculationStrategy feeCalcToBeDecorated, double min, double max, final double fee, final double time) throws Exception{
        super(feeCalcToBeDecorated);
        setMin(min);
        setMax(max);
        setAdditionalFee(fee);
        setAdditionalTime(time);
    }
    
    @Override
    public final double calculateFee(final double hours) throws Exception{
        if(hours < 0){
            throw new IllegalArgumentException("Hours are not valid");
        }else{
            double fee = 0;
            double totalHours = hours;
            if(max == 0 || hours > min && hours < max){
                totalHours -= min;
                    while(totalHours > 0){
                    totalHours -= additionalTime;
                    fee += additionalFee;
                }
                return super.calculateFee(hours) + fee;
            }else{
                return super.calculateFee(hours);
            }
        }
    }

    public final double getMin() {
        return min;
    }

    public final void setMin(final double min) {
        if(min < 0){
            throw new IllegalArgumentException("Minimum hours are not valid");
        }else{
            this.min = min;
        }
    }

    public final double getMax() {
        return max;
    }

    public final void setMax(final double max) {
        if(max < 0){
            throw new IllegalArgumentException("Maximum hours are not valid");
        }else{
            this.max = max;
        }
    }

    public final double getAdditionalFee() {
        return additionalFee;
    }

    public final void setAdditionalFee(final double additionalFee) {
        if(additionalFee < 0){
            throw new IllegalArgumentException("additionalFee is not valid");
        }else{
            this.additionalFee = additionalFee;
        }
    }

    public final double getAdditionalTime() {
        return additionalTime;
    }

    public final void setAdditionalTime(final double additionalTime) {
        if(additionalTime < 0){
            throw new IllegalArgumentException("additional hours are not valid");
        }else{
            this.additionalTime = additionalTime;
        }
    }

    @Override
    public final String toString() {
        return "AdditionalTimeFeeCalculator{" + "min=" + min + ", max=" + max + ", additionalFee=" + additionalFee + ", additionalTime=" + additionalTime + '}';
    }

    @Override
    public final int hashCode() {
        int hash = 7;
        hash = 47 * hash + (int) (Double.doubleToLongBits(this.min) ^ (Double.doubleToLongBits(this.min) >>> 32));
        hash = 47 * hash + (int) (Double.doubleToLongBits(this.max) ^ (Double.doubleToLongBits(this.max) >>> 32));
        hash = 47 * hash + (int) (Double.doubleToLongBits(this.additionalFee) ^ (Double.doubleToLongBits(this.additionalFee) >>> 32));
        hash = 47 * hash + (int) (Double.doubleToLongBits(this.additionalTime) ^ (Double.doubleToLongBits(this.additionalTime) >>> 32));
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
        final AdditionalTimeFeeCalculator other = (AdditionalTimeFeeCalculator) obj;
        if (Double.doubleToLongBits(this.min) != Double.doubleToLongBits(other.min)) {
            return false;
        }
        if (Double.doubleToLongBits(this.max) != Double.doubleToLongBits(other.max)) {
            return false;
        }
        if (Double.doubleToLongBits(this.additionalFee) != Double.doubleToLongBits(other.additionalFee)) {
            return false;
        }
        if (Double.doubleToLongBits(this.additionalTime) != Double.doubleToLongBits(other.additionalTime)) {
            return false;
        }
        return true;
    }
}
