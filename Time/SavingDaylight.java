import java.util.*;
import java.io.*;
import java.math.*;

public class SavingDaylight
{
    public static void main(String[] args)
    {
        Scanner io = new Scanner(System.in);
        String month, day, year, tmp;
        String[] tmp2 = new String[2];
        int sHour, sMin, eHour, eMin, tHour, tMin;

        //Case loop
        while(io.hasNext())
        {
            month = io.next();
            day = io.next();
            year = io.next();
            tmp = io.next();
            tmp2 = tmp.split(":");
            sHour = Integer.parseInt(tmp2[0]);
            sMin = Integer.parseInt(tmp2[1]);
            tmp = io.next();
            tmp2 = tmp.split(":");
            eHour = Integer.parseInt(tmp2[0]);
            eMin = Integer.parseInt(tmp2[1]);
            if(eMin - sMin < 0)
            {
                eMin += 60;
                eHour -= 1;
            }
            tMin = eMin - sMin;
            tHour = eHour - sHour;
            System.out.printf("%s %s %s %d hours %d minutes\n",month,day,year,tHour,tMin);
            //If there is a line of no text following each line, uncomment the next line.
            //io.nextLine();
        }
        io.close();
    }
}