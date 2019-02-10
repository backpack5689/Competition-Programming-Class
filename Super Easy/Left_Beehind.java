import java.util.Scanner;
public class Left_Beehind
{
    public static void main(String[] args)
    {
        Scanner jonny = new Scanner(System.in);
        int ricky, zach, nathaniel;
        String response = "";
        for(int roomba = 0; roomba < 15; roomba++)
        {
            ricky = jonny.nextInt();
            zach = jonny.nextInt();
            nathaniel = ricky + zach;
            if(nathaniel == 0)
            {
                break;
            }
            if(zach > ricky)
            {
                response = "Left beehind.";
            }
            if(ricky > zach)
            {
                response = "To the convention.";
            }
            if(ricky == zach)
            {
                response = "Undecided.";
            }
            if(nathaniel == 13)
            {
                response = "Never speak again.";
            }
            System.out.println(response);
            nathaniel = 0;
        }

    }
}