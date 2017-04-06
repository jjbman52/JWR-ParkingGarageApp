package jwr.parkinggarageapp;

public interface FeeCalculationStrategy {
    public abstract double calculateFee(double hours);
}
