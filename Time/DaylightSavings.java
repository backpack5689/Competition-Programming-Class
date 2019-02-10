import java.util.*;
import java.io.*;
import java.math.*;

public class DaylightSavings
{
    public static void main(String[] args)
    {
        Scanner io = new Scanner(System.in);
        int n = io.nextInt();
        char direction;
        int change, currHours, currMin;
        for (int fido = 0; fido < n; fido++) 
        {
            direction = io.next().charAt(0);
            change = io.nextInt();
            currHours = io.nextInt();
            currMin = io.nextInt();
            if(direction == 'F')
            {
                if(change >= 120)
                {
                    currHours += 2;
                    change -= 120;
                }
                else if(change >= 60)
                {
                    currHours += 1;
                    change -= 60;
                }
                currMin += change;
                if(currMin >= 60)
                {
                    currHours += 1;
                    currMin -= 60;
                }
                if(currHours >= 24)
                {
                    currHours -= 24;
                }
                if(currHours < 0)
                {
                    currHours += 24;
                }
            }
            else
            {
                if(change >= 120)
                {
                    currHours -= 2;
                    change -= 120;
                }
                else if(change >= 60)
                {
                    currHours -= 1;
                    change -= 60;
                }
                currMin -= change;
                if(currMin < 0)
                {
                    currHours -= 1;
                    currMin += 60;
                }
                if(currHours >= 24)
                {
                    currHours -= 24;
                }
                if(currHours < 0)
                {
                    currHours += 24;
                }
            }
            System.out.println(currHours + " " + currMin);
        }

        io.close();
    }
}