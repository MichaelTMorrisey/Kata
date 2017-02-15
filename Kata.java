/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kata;

/**
 *
 * @author Mike Morrisey
 */
public class Kata 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        //try adding characters
        char a, b;
        int sum;
        a = 'A';
        b = 'a';
        sum = a + b;
        System.out.println("A = " + a);
        System.out.println("a = " + b);
        System.out.println("A = " + (int)a);
        System.out.println("a = " + (int)b);
        System.out.println("capital a = " + Character.toUpperCase(b));
        System.out.println("capital a = " + (int)Character.toUpperCase(b));
        System.out.println("b = " + b);
        System.out.println(a + "+" + b + " = " + sum);
        
        
    }//end main()
    
}//end class Kata
