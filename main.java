import java.util.*;

public class main
{
    static void main(String[] args)
    {
        //some variables and object initialization, appEnd will be important to end the app when asked
        int appEnd = 0;
        UserStats player = new UserStats(); //creates object to store data
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to OmenTracker! \nThis simple app can be used to improve and/or track your Omen gameplay\n");
        System.out.println("Please enter your previous or current game utility usage per round: (Enter smoke, blind, then teleport)");

        double smoke = input.nextDouble();
        double blind = input.nextDouble();
        double teleport = input.nextDouble();

        //program will keep running and loop the questions and functions until appEnd = -1,
        while(appEnd != -1)
        {
            player.getUtilityUsage(smoke, blind, teleport);
            System.out.println("Database Updated!");

            System.out.println();
            System.out.println("What would you like to do now?");
            String[] listArray = {"1. Check Omen utility statistics", "2. Evaluate your Omen utility effectiveness", "3. Evaluate gunplay on Omen", "4. End program"};
            for (int i = 0; i < listArray.length; i++) {
                System.out.println(listArray[i]);
            }
            if (input.nextInt() == 2) {
                player.statComparison();
                player.utilitySuggestion();
            } else {
                System.out.println("Im not done with this </3");
                appEnd = -1;
            }
        }
    }
}
