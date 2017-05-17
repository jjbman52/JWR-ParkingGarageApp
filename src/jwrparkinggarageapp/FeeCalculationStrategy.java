package jwrparkinggarageapp;

public interface FeeCalculationStrategy {
    public abstract double calculateFee(double hours) throws Exception;
}
