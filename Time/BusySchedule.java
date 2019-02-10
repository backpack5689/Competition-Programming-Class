import java.util.*;
import java.io.*;
import java.math.*;

public class BusySchedule
{
    public static void main(String[] args)
    {
        Scanner io = new Scanner(System.in);
        int n = io.nextInt();
        int [] array = new int[200];
        Arrays.fill(array, 999999999);
        int curr;
        String tmp;
        String [] tmp2 = new String [5];
        String tmp3;
        String meep;
        int tmp4;
        int min;
        int hour;
        io.nextLine();
        boolean hit = false;
        //Case loop
        while(n != 0)
        {
            for(int i = 0; i < n; i++)
            {
                tmp = io.nextLine();
                tmp2 = tmp.split(" |:");
                curr = Integer.parseInt(tmp2[0]) * 60;
                curr += Integer.parseInt(tmp2[1]);
                if(tmp2[2].equals("p.m."))
                {
                    curr += (12 * 60);
                }
                //System.out.println(curr);
                if(curr / 60 == 12|| (curr - 720)/60 == 12)
                {
                    curr -= 60 * 12;
                }
                array[i] = curr;
            }
            
            
            Arrays.sort(array);

            for(int i = 0; i < n; i++)
            {
                curr = array[i];
                if(curr < 60)
                {
                    meep = "a.m.";
                    hit = true;
                }
                else if(curr >= 720 && curr < 780)
                {
                    meep = "p.m.";
                    hit = true;
                }
                else if(curr >= 12*60 + 60)
                {
                    meep = "p.m.";
                    curr = curr - (12 * 60);
                }
                else
                {
                    meep = "a.m.";
                }
                min = curr % 60;
                hour = (curr - min)/60; 
                if(hour == 0 || hit)
                {
                    hour = 12;
                }
                hit = false;
                System.out.printf("%d:%02d %s\n", hour, min, meep);
            }
            Arrays.fill(array, 999999999);
            System.out.println();
            n = io.nextInt();
            io.nextLine();

        }
        io.close();
    }
}