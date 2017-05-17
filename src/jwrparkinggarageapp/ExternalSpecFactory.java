package jwrparkinggarageapp;

import java.io.*;
import java.lang.reflect.Constructor;
import java.util.Properties;

/**
 *
 * @author jordanrehbein
 */
public abstract class ExternalSpecFactory {
    
    public final static FeeCalculationStrategy getFeeCalculatorInstance(){
        FeeCalculationStrategy reader = null;
        File file = new File("src" + File.separatorChar + "config.properties");
        Properties props  = new Properties();
        FileInputStream inFile;
        try {
            inFile = new FileInputStream(file);
            props.load(inFile);
            inFile.close();
            
            String className = props.getProperty("calculator");
            Class clazz = Class.forName(className);
            Constructor constructor = clazz.getConstructor(double.class, double.class, double.class);
            
            String strMaxHours = props.getProperty("max.hours");
            double maxHours = Double.parseDouble(strMaxHours);
            String strMinFee = props.getProperty("min.fee");
            double minFee = Double.parseDouble(strMinFee);
            String strMaxFee = props.getProperty("max.fee");
            double maxFee = Double.parseDouble(strMaxFee);
            
            reader =(FeeCalculationStrategy)constructor.newInstance(maxHours, minFee, maxFee);
            
        } catch(Exception ex){
            System.out.println("ERROR: you must place a copy of the\n "
                    + "config.properties file in the 'c:/temp' directory of "
                    + "your computer's main hard drive.");
        }
        return reader;
    }
}
