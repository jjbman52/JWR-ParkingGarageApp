package jwrparkinggarageapp;

import edu.wctc.jwr.date.DateUtilities;
import java.time.LocalDateTime;
import java.util.*;

public class ParkingGarage {
    private String companyName;
    private String companyId;
    private int ticketId = 0;
    private DataAccessStrategy dataAccessStrategy;
    private DataEntryStrategy dataEntryStrategy;
    private FeeCalculationStrategy feeCalc;
    private AutomatedCheckInTerminal autoCheckIn;
    private AutomatedCheckOutTerminal autoCheckOut;
    private GarageTotalReceipt totalReceipt;
    private OutputStrategy customerReceiptOutput;
    private OutputStrategy companyReceiptOutput;
    private OutputStrategy onScreenDisplayOutput;
    private DateUtilities dateUtil;
    private List<Map<String,String>> list;
    private Map<String,String> map;
    private String filePath;
    private  GarageAppGenericFileFormatter format;
    

    public ParkingGarage(final String companyName, final String companyId, final FeeCalculationStrategy feeCalc, final DataEntryStrategy dataEntryStrategy, final DataAccessStrategy dataAccessStrategy, final OutputStrategy customerReceiptOutput, final OutputStrategy companyReceiptOutput, final OutputStrategy onScreenDisplayOutput, final DateUtilities dateUtil, final List<Map<String,String>> list, final Map<String,String> map, final String filePath, final GarageAppGenericFileFormatter format) throws Exception{
        setCompanyName(companyName);
        this.companyId = companyId;
        setDataEntryStrategy(dataEntryStrategy);
        setDataAccessStrategy(dataAccessStrategy);
        setFeeCalc(feeCalc);
        totalReceipt = new GarageTotalReceipt(feeCalc, dataAccessStrategy, dateUtil);
        setCustomerReceiptOutput(customerReceiptOutput);
        setCompanyReceiptOutput(companyReceiptOutput);
        setOnScreenDisplayOutput(onScreenDisplayOutput);
        setDateUtil(dateUtil);
        setMap(map);
        setList(list);
        setFilePath(filePath);
        setFormat(format);
    }
    
    public final void checkVehicleIn(final LocalDateTime dateTime) throws Exception{
        setTicketId(ticketId);
        autoCheckIn = new AutomatedCheckInTerminal(companyName, Integer.toString(ticketId), dateTime, dataEntryStrategy, customerReceiptOutput, onScreenDisplayOutput, dateUtil);
    }
    
    public final void checkVehicleOut(final String ticketId)  throws Exception{
        autoCheckOut = new AutomatedCheckOutTerminal(ticketId, feeCalc, dataAccessStrategy, customerReceiptOutput, onScreenDisplayOutput, dateUtil, list, map, filePath, format);
        
        totalReceipt.addTicket(ticketId);
        companyReceiptOutput.produceOutput(totalReceipt.getTotalReceipt());
    }

    public final String getCompanyName() {
        return companyName;
    }

    public final void setCompanyName(final String companyName) throws IllegalArgumentException{
        if(companyName == null || companyName.isEmpty() || companyName.length() < 2){
            throw new IllegalArgumentException("Input is not valid.");
        }else{
            this.companyName = companyName;
        }
    }

    public final int getTicketId() {
        return ticketId;
    }

    public final void setTicketId(final int ticketId) throws IllegalArgumentException{
        if(ticketId < 0){
            throw new IllegalArgumentException("Input is not valid: Ticket Id must be greater than 0");
        }else{
            this.ticketId = ticketId + 1;
        }
    }

    public final FeeCalculationStrategy getFeeCalc() {
        return feeCalc;
    }

    public final void setFeeCalc(final FeeCalculationStrategy feeCalc) throws IllegalArgumentException{
        if(feeCalc == null){
            throw new IllegalArgumentException("Fee Calculator was not found.");
        }else{
            this.feeCalc = feeCalc;
        }
    }

    public final DataAccessStrategy getDataAccessStrategy() {
        return dataAccessStrategy;
    }

    public final void setDataAccessStrategy(final DataAccessStrategy dataAccessStrategy) throws IllegalArgumentException{
        if(dataAccessStrategy == null){
            throw new IllegalArgumentException("Data Access Strategy was not found.");
        }else{
            this.dataAccessStrategy = dataAccessStrategy;
        }
    }

    public final DataEntryStrategy getDataEntryStrategy() {
        return dataEntryStrategy;
    }

    public final void setDataEntryStrategy(final DataEntryStrategy dataEntryStrategy) throws IllegalArgumentException{
        if(dataEntryStrategy == null){
            throw new IllegalArgumentException("Data Access Strategy was not found.");
        }else{
            this.dataEntryStrategy = dataEntryStrategy;
        }
    }

    public final OutputStrategy getCustomerReceiptOutput() {
        return customerReceiptOutput;
    }

    public final void setCustomerReceiptOutput(final OutputStrategy customerReceiptOutput) throws IllegalArgumentException{
        if(customerReceiptOutput == null){
            throw new IllegalArgumentException("Receipt Output was not found.");
        }else{
            this.customerReceiptOutput = customerReceiptOutput;
        }
    }

    public final OutputStrategy getCompanyReceiptOutput() {
        return companyReceiptOutput;
    }

    public final void setCompanyReceiptOutput(final OutputStrategy companyReceiptOutput) throws IllegalArgumentException{
        if(companyReceiptOutput == null){
            throw new IllegalArgumentException("Receipt Output was not found.");
        }else{
            this.companyReceiptOutput = companyReceiptOutput;
        }
    }

    public final OutputStrategy getOnScreenDisplayOutput() {
        return onScreenDisplayOutput;
    }

    public final void setOnScreenDisplayOutput(final OutputStrategy onScreenDisplayOutput) throws IllegalArgumentException{
        if(onScreenDisplayOutput == null){
            throw new IllegalArgumentException("GUI Output was not found.");
        }else{
            this.onScreenDisplayOutput = onScreenDisplayOutput;
        }
    }

    public final DateUtilities getDateUtil() {
        return dateUtil;
    }

    public final void setDateUtil(final DateUtilities dateUtil) throws IllegalArgumentException{
        if(dateUtil == null ){
            throw new IllegalArgumentException("DateUtilities was not found.");
        }else{
            this.dateUtil = dateUtil;
        }
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) throws IllegalArgumentException{
        if(map == null){
            throw new IllegalArgumentException("Map was not found.");
        }else{
            this.map = map;
        }
    }

    public final List<Map<String, String>> getList() {
        return list;
    }

    public final void setList(final List<Map<String, String>> list) throws IllegalArgumentException{
        if(list == null){
            throw new IllegalArgumentException("List of Maps was not found.");
        }else{
            this.list = list;
        }
    }

    public final String getFilePath() {
        return filePath;
    }

    public final void setFilePath(final String filePath) throws IllegalArgumentException{
        if(filePath == null){
            throw new IllegalArgumentException("GUI Output was not found.");
        }else{
            this.filePath = filePath;
        }
    }

    public final GarageAppGenericFileFormatter getFormat() {
        return format;
    }

    public final void setFormat(final GarageAppGenericFileFormatter format) throws IllegalArgumentException{
        if(format == null){
            throw new IllegalArgumentException("GarageAppGenericFileFormatter was not found.");
        }else{
            this.format = format;
        }
    }

    @Override
    public final String toString() {
        return "companyName = " + companyName + " companyID = " + companyId;
    }

    @Override
    public final int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.companyName);
        hash = 23 * hash + Objects.hashCode(this.companyId);
        return hash;
    }

    @Override
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ParkingGarage other = (ParkingGarage) obj;
        if (!Objects.equals(this.companyName, other.companyName)) {
            return false;
        }
        if (!Objects.equals(this.companyId, other.companyId)) {
            return false;
        }
        return true;
    }
}