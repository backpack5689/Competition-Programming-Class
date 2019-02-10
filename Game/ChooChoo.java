import java.util.Scanner;
import java.util.Arrays;
public class ChooChoo
{
    public static void main(String[] args)
    {
        Scanner io = new Scanner(System.in);
        int capacity = io.nextInt();
        int stations = io.nextInt();   
        String curr;
        boolean possible = true;
        int currCapacity = 0;
        int tmp, tmp2;
        io.nextLine();
        for (int fido = 0; fido < stations; fido++) 
        {
            tmp = io.nextInt();
            currCapacity -= tmp;
            if(currCapacity < 0)
            {
                possible = false;
                break;
            }
            tmp = io.nextInt();
            currCapacity += tmp;
            if(currCapacity > capacity)
            {
                possible = false;
                break;
            }
            tmp = io.nextInt();
            tmp2 = capacity - currCapacity;
            if((tmp2 != 0) && (tmp != 0))
            {
                possible = false;
                break;
            }
            if(tmp2 > 0 && fido == stations)
            {
                possible = false;
                break;
            }

        }
        if((currCapacity != 0 && possible) || (!possible))
        {
            System.out.print("impossible");
        }
        else
        {
            System.out.print("possible");
        }
        io.close();
    }
}