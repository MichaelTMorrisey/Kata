/*
Here is the code to be placed in main() to test class PokerHand:

        String myHandString, yourHandString;
        PokerHand myHand, yourHand;
        
        //expect 
        myHandString = "9H 8C 9H TH QH";
        yourHandString = "AS TS QS 7S 8C";
        
        myHand = new PokerHand(myHandString);
        yourHand = new PokerHand(yourHandString);
       
        System.out.println(myHand.compareWith(yourHand));
      
 */
package practiceone;

//submitting this so as to save the work i've done so far

import java.util.*;
import java.util.Arrays;
    
public class PokerHand
{      
    //ranking of the hand, to use in comparing
      int[] rank;
      
    
    public enum Result { TIE, WIN, LOSS } 

    //note that the parameter "hand"
    //represents 5 poker cards
    //given as number/suit pairs
    //example "AH 3H 9D 2S 4C"
    
    //numbers can be accessed with "for (int i = 0; i < 14; i+=3)"
    //suits can be accessed with "for (int i = 1; i < 14; i+=3)"
    
    //constructor for a PokerHand 
    PokerHand(String hand)
    {
      
      //rank the hand based on the rules for Texas Hold'em
      //as detailed on Wikipedia.  Ranking is from 1 to 15
      //with a straight flush being the best hand possible.
      setRank(hand);
      

    }//end PokerHand()

    
    //*************************************************************************************************************
    
    //this method accepts a poker hand as a parameter
    //and returns a 4-element integer array counting
    //the totals for each suit.  The array is in
    //the order of [Spades, Diamonds, Hearts, Clubs].
    //For example, if there are four Spades
    //and one Heart, the array returned
    //would be [4, 0, 1, 0]
    public int[] getSuitScore(String hand)
    {
        //declare an int array to return
        int[] result;
        //initialize the result;
        result = new int[]{0,0,0,0};
        
        //iterate over the hand
        //and fill in the score
        for(int i = 1; i < 14; i+=3)
        {
            
            //TESTING
        System.out.println("Now in for loop, i = " + i + " and (hand.charAt(i)) = " + (hand.charAt(i)));
        
            
            switch(hand.charAt(i))
            {
                //if it's a Spade
                case 'S' : result[0]++;
                        break;
                //if it's a Diamond
                case 'D' : result[1]++;
                        break;
                //if it's a Heart
                case 'H' : result[2]++;
                        break;
                //if it's a Club
                case 'C' : result[3]++;
                        break;
                //if none of the above, output error message
                default  : System.out.println("Error in the getSuitScore method.");
                        break;
            }//end switch
        }//end for
        
        //TESTING
        String testString;
        testString = "{";
        int m = 0;
        for (; m < result.length - 1; m++)
        {
            testString += result[m] + " ";
        }//end for
        testString += result[m] + "}";
        System.out.println("result = " + testString);
        //END TESTING
        
        return result;
    }//end getSuitScore()
    
    //******************************************************************************************************************
    
    //this method accepts a poker hand
    //and returns an array of 13 elements
    //counting the occurence of each distinct number.
    //For example, if there is one King, the array returned
    //will have a "1" at index 11
    public int[] getNumScore(String hand)
    {
        //TESTING
        System.out.println("Now starting getNumScore()");
        //declare an int array to return
        //containing one element for each possible number
        //shown on the card, or face card 
        int[] result;
        //initialize it to contain 13 zeros (the initial total count of each denomination)
        result = new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0};
        
        //iterate over the hand and update scorecard
        for (int i = 0; i < 14; i+=3)
        {
                //TESTING
                System.out.println("Now in for loop, i = " + i + " and (hand.charAt(i)) = " + (hand.charAt(i)));
        
        
          //if the card has a number value
          if (Character.isDigit(hand.charAt(i)))
          {   //keep track of it at an index two less than its number value
            //i.e. if the card is a 2, increment the scorecard at index 0
              //TESTING
//              int myTestInt;
  //            myTestInt = Character.getNumericValue(hand.charAt(i));
    //          System.out.println("myTestInt = " + myTestInt);
    //          System.out.println("hand.charAt(i) = " + hand.charAt(i));
      //        
      //        myTestInt -= 2;
        //      System.out.println("myTestInt = " + myTestInt);
 //             System.out.println("((hand.charAt(i))-2) = " + (((int)hand.charAt(i))-2) );
   //           System.out.println("incrementing result[" + (hand.charAt(i)) + "]");
            result[Character.getNumericValue(hand.charAt(i))-2]++;
          //or if the card is not a number
          }//end if
          else 
              switch (hand.charAt(i))
              {
                  //if it's a ten
                  case 'T' : result[8]++;
                        break;
                  //or if it's a Jack
                  case 'J' : result[9]++;
                        break;
                  //or if it's a Queen
                  case 'Q' : result[10]++;
                        break;
                  //or if it's a King
                  case 'K' : result[11]++;
                        break;
                  //or if it's a Ace
                  case 'A' : result[12]++;
                        break;
                  //if none of the above, print an error message
                  default : System.out.println("Error at the switch in the getNumScore method.");    
                        break;
              }//end switch

          //TESTING
        String testString;
        testString = "{";
        int m = 0;
        for (; m < result.length - 1; m++)
        {
            testString += result[m] + " ";
        }//end for
        testString += result[m] + "}";
        System.out.println("result = " + testString);
        //END TESTING
        
          
        }//end for

        //TESTING
        System.out.println("Now ending getNumScore()");
        
        //TESTING
        String testString;
        testString = "{";
        int m = 0;
        for (; m < result.length - 1; m++)
        {
            testString += result[m] + " ";
        }//end for
        testString += result[m] + "}";
        System.out.println("result = " + testString);
        //END TESTING
        
        return result;
    }//end getNumScore()
    
    






    //**************************************************************************************
    //************************************************************************************
    
    
    
    
    
    
    
    
    
    //this method accepts a poker hand as a parameter and 
    //returns an int array, with the first
    //element being the hand's rating, from 1-9, with a straight
    //flush being the best at Rank 1, to the lowest rank
    //of 9 for just a high card.  The rest of the int[] array
    //returned by this method is comprised of the cards in order to be compared
    //for that rank.  Further information about interpreting this int[] array
    //can be found in the compareWith method
    public void setRank(String hand)
    {
        //TESTING
        System.out.println("Now starting setRank()");
        
        //scoreboards to keep track of how many of each number and suit we have
        int[] suitScore;
        int[] numScore;
        //flags to determine whether hand is a straight or a flush
        boolean straight, flush;
        //int array to determine two of kind, 3 of kind, 4 of kind
        int[] duplicates;
        
        //initilize dupScore as 3 zeros, represending pairs, triples, and 4 of a kind
        duplicates = new int[]{0, 0, 0};
        
        //initialize rank as an array of 6 ints.
        //The first element is the hand's rank,
        //for use in quick comparison.
        //In case this quick comparison results in a tie,
        //the next 5 elements of the array represent info for tie breaking,
        //according to the peculiarities of their rank.  
        rank = new int[6];
        
        //TESTING
        System.out.println("Now calling getSuitScore()");
        
        //scoreboard int[] array to track # of each suit
        //in order of Spades, Hearts, Diamonds, Clubs
        suitScore = getSuitScore(hand);
        
        
        //TESTING
        System.out.println("Now calling getNumScore()");
        
        
        //scoreboard int[] array to keep track of totals for each card number 
        //in the order 2, 3, ...9, T, J, Q, K, A
        numScore = getNumScore(hand);
        
        
        //TESTING
        System.out.println("Now calling getDupScore()");
        
        //get int[] duplicates based on numScore
        getDupScore(duplicates, numScore);
        
        
        //TESTING
        System.out.println("Now calling getStraight()");
        
        //check if cards are a straight or flush
        straight = getStraight(numScore);
        
        
        //TESTING
        System.out.println("Now calling getFlush()");

        flush = getFlush(suitScore);
        

        //TESTING
        System.out.println("Now calling getSortedKickers()");
        
        //sort the cards for use in more detailed comparisons
        //should a tie result in using just the rank
        getSortedKickers(numScore);
        
        
        
        /*
        Notes on comparisons in case of a tie,
        with instructions tailored for each rank:
        rank 1:
            //in case of tie, compare all 5 as kickers
            //in order from highest to lowest
            //(CASE 1)
        rank 2:
            //in case of tie, compare number of 4 of a kind, 
            //then high kicker/high card
            (CASE 2)
        rank 3:
            //in case of tie, compare number of 3 of a kind,
            //then number of pair
            (CASE 3)
        rank 4:
            //in case of tie, compare all 5 as kickers
            //in order from highest to lowest
            (CASE 1)
        rank 5:
            //in case of tie, compare all 5 as kickers
            //in order from highest to lowest
            (CASE 1)
        rank 6:
            //in case of tie, compare number of 3 of a kind,
            //then the two kickers in order from highest
            (CASE 4 (or same as 3?)
        rank 7:
            //in case of tie, compare number of highest pair
            //then number of lower pair
            //then kicker
            (CASE 5)
        rank 8:
            //in case of tie, compare number of pair
            //then the three kickers in order from highest
            (CASE 6)
        rank 9:
            //compare all 5 as kickers
            //in order from highest to lowest
            (CASE 1)
        */
        
        
        
        
        //TESTING
        System.out.println("Now determining ranking...");
        
        //determine rank
        
        //straight flush is rank 1
        if (straight && flush)
        {
            rank[0] = 1;
            //cards are already arranged from high to low to facilitate comparison
            //by high card, but we need to account for the case where Ace might 
            //be played low in a straight
            if (rank[1] == 12 && rank[2] == 3)
            {
                rank[1] = 3; 
                rank[2] = 2;
                rank[3] = 1;
                rank[4] = 0;
                rank[5] = -1;
            }//end if
        }//end rank 1  
            
        
        //four of a kind is rank 2
        else if (duplicates[2]==1)
        {
            rank[0] = 2;
            int r;
            
            for(int i = 0; i < 13; i++)
            {
                
        //TESTING
        System.out.println("Now calling stepping through numScore at i = " + i);
        
                if (numScore[i] == 4)
                    rank[1] = i;
                if (numScore[i] == 1)
                    rank[2] = i;
            }   
        }//end rank 2
        
        
        //full house is rank 3
        else if (duplicates[0] == 1 && duplicates[1] == 1)
        {
            rank[0] = 3;
            
            
            
            //step through the numScore array and identify
            //the three of a kind and all kickers
            //and fill the rank array appropriately
            for(int i=0; i< 13; i++)
            {
                
                        
        //TESTING
        System.out.println("Now calling stepping through numScore at i = " + i);
        
                if (numScore[i] == 3)
                    rank[1] = i;
                else if (numScore[i] == 2)
                {
                    rank[2] = i;
                    rank[3] = i;
                }//end if
                
            }//end for
        }//end rank 3
        
        
        //flush is rank 4
        else if (flush)
            rank[0] = 4;
            //in case of tie, cards are already arranged for comparison by high card
        
        
        //straight is rank 5
        else if (straight)
        {
            rank[0] = 5;
            //cards are already arranged from high to low to facilitate comparison
            //by high card, but we need to account for the case where Ace might 
            //be played low in a straight
            if (rank[1] == 12 && rank[2] == 3)
            {
                rank[1] = 3; 
                rank[2] = 2;
                rank[3] = 1;
                rank[4] = 0;
                rank[5] = -1;
            }
        }//end rank 5
        
        
        //three of a kind is rank 6
        else if (duplicates[1] == 1)
        {
            rank[0] = 6;
            
            //declare an int array to temporarily store
            //the values of two kickers
            int[] temp;
            //declare an int to use as an index to the temp array
            int j;
            
            //initialize the index to zero
            j=0;
            //initialize temp as a two-element array
            temp = new int[2];
            
            //step through the numScore array and identify
            //the three of a kind and both kickers
            //and fill the rank array appropriately
            for(int i=0; i< 13; i++)
            {
                
                        
        //TESTING
        System.out.println("Now calling stepping through numScore at i = " + i);
                
                
                if (numScore[i] == 3)
                    rank[1] = i;
                else if (numScore[i] == 1)
                {
                    temp[j] = i;
                    j++;
                }//end if
            }//end for
            //the two kickers have been found, now they need 
            //to be sorted and saved
            Arrays.sort(temp);
            rank[2] = temp[1];
            rank[3] = temp[0];
        }//end rank 6
        
        
        //two pair is rank 7
        else if (duplicates[0] == 2)
        {
            rank[0] = 7;
        
            //in case of tie, compare number of highest pair
            //then number of lower pair
            //then kicker
            //declare an int array to temporarily store
            //the values of two pairs
            int[] temp;
            //declare an int to use as an index to the temp array
            int j;
            
            //initialize the index to zero
            j=0;
            //initialize temp as a two-element array
            temp = new int[2];
            
            //step through the numScore array and identify
            //the three of a kind and both kickers
            //and fill the rank array appropriately
            for(int i=0; i< 13; i++)
            {
                
                        
        //TESTING
        System.out.println("Now calling stepping through numScore at i = " + i);
        
                if (numScore[i] == 1)
                    //if there's just one, it's the kicker
                    rank[3] = i;
                else if (numScore[i] == 2)
                {
                    temp[j] = i;
                    j++;
                }//end if
            }//end for
            //the two pairs have been found, now they need 
            //to be sorted and saved
            Arrays.sort(temp);//sorts in ascending order, so reverse
            rank[1] = temp[1];
            rank[2] = temp[0];
            
        }//end rank 7
            
        
        //one pair is rank 8
        else if (duplicates[0] == 1)
        {
            rank[0] = 8;
            
            //declare an int array to temporarily store
            //the values of three kickers
            int[] temp;
            //declare an int to use as an index to the temp array
            int j;
            
            //initialize the index to zero
            j=0;
            //initialize temp as a three-element array
            temp = new int[3];
            
            //step through the numScore array and identify
            //the pair and all 3 kickers
            //and fill the rank array appropriately
            for(int i=0; i< 13; i++)
            {
                
                        
        //TESTING
        System.out.println("Now calling stepping through numScore at i = " + i);
        
                if (numScore[i] == 2)
                    rank[1] = i;
                else if (numScore[i] == 1)
                {
                    temp[j] = i;
                    j++;
                }//end if
            }//end for
            //the three kickers have been found, now they need 
            //to be sorted and saved
            Arrays.sort(temp);
            rank[2] = temp[2];
            rank[3] = temp[1];
            rank[4] = temp[0];
            
        }//end rank 8
        else 
            rank[0] = 9;
            //in case of a tie, cards are already arranged in order to be 
            //judged by high card
        
        //the rank array is now properly filled. 
          
        //TESTING
        System.out.println("Now ending setRank()");
          
    }//end setRank()
    
    
    
    
    
    
    
    
    
    //**************************************************************************
    //****************************************************************************
    
    
    
    
    
    
    
    
    
    
    
    
    //a method to sort the cards in order
    //and place in the first parameter array
    //at indices 1-5
    //in descending order, Ace to 2
    public void getSortedKickers(int[] numScore)
    {
        
        //TESTING
        System.out.println("Now starting getSortedKickers()");
        
            //in case of tie, compare all 5 as kickers
            //in order from highest to lowest
            
            //an index for iterating through the rank array
            int k = 1;
            
            //step through the whole numScore array
            for (int i = 12; i >= 0; i--)
            {
                
                        
        //TESTING
        System.out.println("Now calling stepping through numScore at i = " + i);
        
        
                if (numScore[i] > 0)
                {
                    //a temporary int for storing the # of each number
                    //so we can decrement the temporary variable,
                    //storing that many of that # as individual
                    //cards in the rank array
                    int j = numScore[i];
                    while (j>0)
                    {
                        rank[k] = i;
                        j--;
                        k++;
                    }//end while
                }//end if
            }//end for
            
            //TESTING
        System.out.println("Now ending getSortedKickers()");
        
    }//end getSortedKickers
    
    
    //**********************************************************************************************************
    
    //this method accpepts an int array as a parameter
    //that is 13 elements long, representing info about
    //a poker hand, and returns an array representing 
    //info about any pairs, three of a kind, or four of a kind
    //in that poker hand.  This info is returned in the form
    //of a 3-element int array
    
    public void getDupScore(int[] dupScore, int[] numScore)
    {
        //TESTING
        System.out.println("Now starting getDupScore()");
        
        
        //initilize dupScore as 3 zeros, represending pairs, triples, and 4 of a kind
        
        
        //set dupscore according to the numScore array
        for (int i = 0; i < 13; i++)
        {
            
                    
        //TESTING
        System.out.println("Now calling stepping through numScore at i = " + i);
        
            //note- the numScore array is a 13-element array
            //representing how many of each number we have
            //so look for 2s, 3s, and 4s
            
            //first skip ahead to the next num that's not 0 or 1
            while (i<13 && (numScore[i]== 0 || numScore[i] == 1))
            {
                i++;
                System.out.println("Now incrementing i to " + i);
            }//end while
            //if i is now 13, exit the loop; there are no duplicates
            
             System.out.println("i =" + i);
            
            
            if (i == 13)
            {
                System.out.println("Exiting loop, no more duplicates");
                break;
            }//end if
            //if the num is a 2, increment the first element in dupScore
            switch (numScore[i])
            {
                case 2 : dupScore[0]++;
                        break;
                case 3 : dupScore[1]++;
                        break;
                case 4 : dupScore[2]++;
                        break;
                default: System.out.println("Error in the dupScore method.");
                        break;
            }//end switch
        }//end for
        
        //TESTING
        System.out.println("Now ending getDupScore()");
        
        
        //TESTING
        String testString;
        testString = "{";
        int m = 0;
        for (; m < dupScore.length - 1; m++)
        {
            testString += dupScore[m] + " ";
        }//end for
        testString += dupScore[m] + "}";
        System.out.println("dupScore = " + testString);
        //END TESTING
        
        
    }//end getDupScore
    //**************************************************************************
    
    //this method accepts a numScore and returns a boolean stating if there is a straight
    public boolean getStraight(int[] numScore)
    {
        //TESTING
        System.out.println("Now starting getStraight()");
        
        //declare a boolean to return
        boolean isStraight;
        //an int to use as a counter when iterating over the array
        int i;
        
        //initialize the result to false
        isStraight = false;
        //initialize the counter to zero
        i = 0;
        
        //set the result based on whether all the cards are consecutive.
        //Note: also give positive result for consecutive 2-5 with an Ace
        
        //skip ahead to the first available card
        //as long as it's not too close to the end
        //(we need at least 5 spots consecutive
        //so the first one can't start after index spot 8)
        while(numScore[i] == 0 && i < 9)
            i++;
        //only cutinue if i is less than 9
        if (i <9)
            //if this and the next three consecutive numScore elements are not 1, break
            if (numScore[i] == 1)
                if (numScore[i+1] == 1)
                    if (numScore[i+2] == 1)
                        if (numScore[i+3] == 1)
                            //now either we need the next consecutive element to be a 1, or
                            //we need to have the special case of 2,3,4,5,A
                            if ((numScore[i+4] == 1) || (i==0 && numScore[12] == 1)) 
                                isStraight = true;

        //TESTING
        System.out.println("Now ending getStraight()");
        
        
        //return result
        return isStraight;
    }//end getStraight()
    //**************************************************************************************
    
    //this method accepts a suitScore and returns a boolean stating if there is a flush
    public boolean getFlush(int[] suitScore)
    {
        //TESTING
        System.out.println("Now starting getFlush()");
        
        //declare a boolean to return
        boolean isFlush;
        //initialize to false
        isFlush = false;
        
        //set isFlush based on suitScore
        for (int i = 0; i < 4; i++)
            if (suitScore[i] == 5)
                isFlush = true;
        
        //TESTING
        System.out.println("Now ending getFlush()");
        
        
        return isFlush;
    }//end suitScore()
    //***************************************************************************
    
    
    //this method allows comparison between two poker hands
    public Result compareWith(PokerHand hand) 
    {        
        //TESTING
        System.out.println("Now starting compareWith()");
        System.out.println(rank[0] + ".compareWith(" + hand.rank[0] + ")");
        
        
        if (rank[0] < hand.rank[0])
            return Result.WIN;
        if (rank[0] > hand.rank[0])
            return Result.LOSS;
        
        
        
        System.out.println("About to start switch, rank = " + rank[0]);
        
        //TESTING
        String testString;
        testString = "{";
        int m = 1;
        for (; m < 5; m++)
        {
            testString += rank[m] + " ";
        }//end for
        testString += rank[m] + "}";
        System.out.println("myHand = " + testString);
        //END TESTING
        System.out.println("compared to");
        //TESTING
        String testString2;
        testString2 = "{";
        int n = 1;
        for (; n < 5; n++)
        {
            testString2 += hand.rank[n] + " ";
        }//end for
        testString2 += hand.rank[n] + "}";
        System.out.println("yourHand = " + testString2);
        //END TESTING
        
        //if there's a tie, settle it differently for each rank    
        switch (rank[0])
        {
            
            //rank 1:
            //in case of tie, compare all 5 as kickers
            //in order from highest to lowest
            case 1: 
                
            //rank 4:
            //in case of tie, compare all 5 as kickers
            //in order from highest to lowest    
            case 4: 
                
                
            //rank 5:
            //in case of tie, compare all 5 as kickers
            //in order from highest to lowest
            case 5: 
                    
                
            //rank 9:
            //compare all 5 as kickers
            //in order from highest to lowest
            case 9:
                
                for (int i = 1; i < 6; i++)
                {
                    if (rank[i] > hand.rank[i])
                        return Result.WIN;
                    else if (rank[i] < hand.rank[i])
                        return Result.LOSS;
                }//end for
                return Result.TIE;
                //end Case 1
            
            //rank 2:
            //in case of tie, compare number of 4 of a kind, 
            //then kicker,
            //then declare tie
            case 2: 
            
            //rank 3:
            //in case of tie, compare number of 3 of a kind,
            //then number of pair,
            //then declare tie
            case 3: 
                for (int i = 1; i < 3; i++)
                {
                    if (rank[i] > hand.rank[i])
                        return Result.WIN;
                    else if (rank[i] < hand.rank[i])
                        return Result.LOSS;
                }//end for
                return Result.TIE; 
                    
            //rank 6:
            //in case of tie, compare number of 3 of a kind,
            //then the first kicker
            //then the second kicker
            //then declare tie
            case 6: 
                
            //rank 7:
            //in case of tie, compare number of highest pair
            //then number of lower pair
            //then kicker
            case 7: 
                for (int i = 1; i < 4; i++)
                {
                    if (rank[i] > hand.rank[i])
                        return Result.WIN;
                    else if (rank[i] < hand.rank[i])
                        return Result.LOSS;
                }//end for
                return Result.TIE;
                    
            //rank 8:
            //in case of tie, compare number of pair
            //then the three kickers in order from highest
            case 8:
                for (int i = 1; i < 5; i++)
                {
                    if (rank[i] > hand.rank[i])
                        return Result.WIN;
                    else if (rank[i] < hand.rank[i])
                        return Result.LOSS;
                }//end for
                return Result.TIE;
            
            default : return Result.TIE;
            }//end switch
    }//end compareWith()
    
}//end class PokerHand
