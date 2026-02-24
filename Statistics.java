import java.util.*;

public class Statistics {
    //this is going to the standard that the user's stats are held to
    //a lot of arrays so i dont have to write a billion lines
    final double smokeExpect = 2.0;
    final double blindExpect = 0.6;
    final double teleportExpect = 0.4;
    final double[] stats = {smokeExpect, blindExpect, teleportExpect};
    final double gunExpect = 1.0;
}

class UserStats extends Statistics
{
    //creates arrays that stores user data
    //no need to override anything
    double[] statParse = new double[3];
    boolean[] comparisonCheck = new boolean[3];
    double[] gunplayStats = new double[3];

        public void getUtilityUsage(double s, double b, double t)
        {
        //simply going to be what the user inputs as their util usage
           statParse[0] = s;
           statParse[1] = b;
           statParse[2] = t;
        }

        public void statComparison()
        {
            //intended to give values to the boolean statements depending on whatever the user stats are
            //return nothing since it is only to give the booleans a value, utilize them in a later method
            for(int c = 0; c < statParse.length; c++)
            {
                if(statParse[c] >= stats[c])
                {
                    comparisonCheck[c] = true;
                } else
                {
                    comparisonCheck[c] = false;
                }
            }
        }

        public void utilitySuggestion()
        {
            //loops to check the contents of the boolean array for stat comparisons
            //produces strings that depend on the trues and falses
            HashMap<Integer, String> statResponse = new HashMap<>();
            statResponse.put(0, "Improve your smoke usage to better zone off the map for your team.");
            statResponse.put(1, "Use your blind more to displace enemies and set up successful fights for your teammates.");
            statResponse.put(2, "Get more positional value by using your teleports to quickly set yourself up in stronger angles.");

            for(int r = 0; r < statParse.length; r++)
            {
                if(comparisonCheck[r] == false)
                {
                    System.out.println(statResponse.get(r));
                }
            }
            if(comparisonCheck[0] == true && comparisonCheck[1] == true && comparisonCheck[2] == true)
            {
                System.out.println("Your usage is good! Perhaps focus on improving the impact of the utility instead.");
            }
        }
    }
