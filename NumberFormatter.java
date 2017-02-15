/*
 Place the following code in the main method to run this

   double myDouble;
        double myDoubleFormatted;
        
        myDouble = 12345.54521;
        
        System.out.println(myDouble);
        
        myDoubleFormatted = NumberFormatter.formatter(myDouble);
        
        System.out.println(myDoubleFormatted);
 */


package practiceone;

import java.text.DecimalFormat;
import java.math.RoundingMode;
/**
 *
 * @author Michael.T.Morrisey
 */
public class NumberFormatter {
    
    public static double formatter(double n)
    {
        
        //declare a double to return
        double result;
        //declare a new DecimalFormat object
        DecimalFormat myDecimalFormat;
        //declare a String to store the pattern
        String myPattern;
        
        //initialize the pattern with two decimal places, rounding half up
        myPattern = "#.##";
        //initialize the DecimalFormat with the pattern
        myDecimalFormat = new DecimalFormat(myPattern);
        //set the rounding mode 
        myDecimalFormat.setRoundingMode(RoundingMode.HALF_UP);
        
        result = Double.parseDouble(myDecimalFormat.format(n));
        
        
        //return the result
        return result;
        
    }//end formatter()
    
}//end class NumberFormatter
