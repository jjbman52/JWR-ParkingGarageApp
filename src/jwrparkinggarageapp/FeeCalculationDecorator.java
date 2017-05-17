package jwrparkinggarageapp;

/**
 *
 * @author jordanrehbein
 */
public class FeeCalculationDecorator implements FeeCalculationStrategy{
private FeeCalculationStrategy feeCalcToBeDecorated;

    public FeeCalculationDecorator(FeeCalculationStrategy feeCalcToBeDecorated) throws Exception{
        if(feeCalcToBeDecorated == null){
            throw new IllegalArgumentException("feeCalcToBeDecorated is incorrect.");
        }else{
            this.feeCalcToBeDecorated = feeCalcToBeDecorated;
        }
    }

    @Override
    public double calculateFee(double hours) throws Exception{
        if(hours < 0){
            throw new InvalidEntryException();
        }else{
            return feeCalcToBeDecorated.calculateFee(hours);
        }
    }
}
