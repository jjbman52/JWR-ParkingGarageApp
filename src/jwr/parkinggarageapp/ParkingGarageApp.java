package jwr.parkinggarageapp;

public class ParkingGarageApp {
    private String companyName;
    private DataAccessStrategy dataAccessStrategy;
    private FeeCalculationStrategy feeCalc;
    private AutomatedCheckInTerminal autoCheckIn;
    private AutomatedCheckOutTerminal autoCheckOut;

    public ParkingGarageApp(String companyName, FeeCalculationStrategy feeCalc, DataAccessStrategy dataAccessStrategy) {
        setCompanyName(companyName);
        setDataAccessStrategy(dataAccessStrategy);
        setFeeCalc(feeCalc);
    }
    
    public void checkVehicleIn(double hours){
        autoCheckIn = new AutomatedCheckInTerminal(companyName, hours);
    }
    
    public void checkVehicleOut(String ticketId){
        autoCheckOut = new AutomatedCheckOutTerminal(ticketId, feeCalc, dataAccessStrategy);
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public FeeCalculationStrategy getFeeCalc() {
        return feeCalc;
    }

    public void setFeeCalc(FeeCalculationStrategy feeCalc) {
        this.feeCalc = feeCalc;
    }

    public DataAccessStrategy getDataAccessStrategy() {
        return dataAccessStrategy;
    }

    public void setDataAccessStrategy(DataAccessStrategy dataAccessStrategy) {
        this.dataAccessStrategy = dataAccessStrategy;
    }
}