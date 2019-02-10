import java.util.Scanner;

public class Bela
{
    public static void main(String[] args)
    {
        Scanner io = new Scanner(System.in);
        int n = io.nextInt() * 4;
        char dom = io.nextLine().charAt(1);
        int tot = 0;
        String curr;
        for (int fido = 0; fido < n; fido++) 
        {
            curr = io.next();
            switch(curr.charAt(0))
            {
                case'A':
                    tot += 11;
                    break;
                case'K':
                    tot += 4;
                    break;
                case'Q':
                    tot += 3;
                    break;
                case'T':
                    tot += 10;
                    break;
                case'9':
                    if(curr.charAt(1) == dom)
                    {
                        tot += 14;
                    }
                    break;
                case'J':
                    if(curr.charAt(1) == dom)
                    {
                        tot += 20;
                    }
                    else
                    {
                        tot += 2;
                    }
                    break;
            }
        }
        System.out.print(tot);
        io.close();
    }
}