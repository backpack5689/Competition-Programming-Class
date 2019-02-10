import java.util.*;
import java.io.*;
import java.math.*;

public class BitbyBit2
{
    static int number = 0;
    static int question = 0;
    public static void main(String[] args)
    {
        Scanner io = new Scanner(System.in);
        int n = io.nextInt();

        String input;
        
        while(n != 0)
        {
             io.nextLine();
            //Takes input and manipulates 2 ints
            for(int i = 0; i<n; i++)
            {
                input = io.next();
                switch(input.charAt(0))
                {
                    case 'C':
                    case 'c':
                        clear(io.nextInt());
                        break;
                    case 'S':
                    case 's':
                        set(io.nextInt());
                        break;
                    case 'O':
                    case 'o':
                        or(io.nextInt(), io.nextInt());
                        break;
                    case 'A':
                    case 'a':
                        and(io.nextInt(), io.nextInt());
                        break;
                    default:
                        System.out.println("HEY! YOU MAKE NO SENSE! YOU DONT EXIST! HEAD TO BROOKLYN AND GET YOURSELF SOME FOOD SO THAT YOU CAN DROWN YOUR DEPRESSION FROM NOT EXISTING IN FOOD!");
                        break;
                }
                io.nextLine();
            }
            for(int i = 31; i>=0; i--)
            {
                if((question &(1<<i))>>i==0)
                {
                    System.out.print("?");
                }
                else if((number &(1<<i))>>i==0)
                {
                    //I have never wanted to shoot my computer more than right now due to this assignment
                    System.out.print("0");
                }
                else if(Math.abs((number &(1<<i))>>i)==1)
                {
                    System.out.print("1");
                }
                else
                {
                    int yeet = (number &(1<<i))>>i;
                    System.out.print(yeet);
                }
            }
            System.out.println();
            n = io.nextInt();
            number = 0;
            question = 0;
        }
    }
    public static void reset(int i)
    {
        //System.out.println("Reset at "+ i);
        question &= ~(1<<i);
    }
    public static void clear(int i)
    {
       number &= ~(1<<i);
       //System.out.println("Put a 0 in " + i);
       question |= (1<<i);
    }
    public static void set(int i)
    {
        number |= (1<<i);
        //System.out.println("Put a 1 in " + i);
        question |= (1<<i);
    }
    public static void or(int i, int j)
    {
        int num1 = (number &(1<<i))>>>i;
        int num2 = (number &(1<<j))>>>j;
        int known1 = (question &(1<<i))>>>i;
        int known2 = (question &(1<<j))>>>j;
        //System.out.println(num1 + " " + num2);
        if((num1 == 1 && known1 == 1)||(num2 == 1 && known2 == 1))
        {
            set(i);
        }
        else if((known1 == 1 && known2 == 1))
        {
            clear(i);
        }
        else
        {
            clear(i);
            reset(i);
        }
    }
    public static void and(int i, int j)
    {
        int ii = (number &(1<<i))>>>i;
        int jj = (number &(1<<j))>>>j;
        int iit = Math.abs((question &(1<<i))>>>i);
        int jjt = Math.abs((question &(1<<j))>>>j);
        if((ii == 0 && iit != 0)||(jj == 0 && jjt != 0))
        {
            clear(i);
        }
        if((ii == 1 && jj == 1))
        {
            set(i);
        }

        if(ii == 1 && jjt == 0)
        {
            clear(i);
            reset(i);
        }
    }
}