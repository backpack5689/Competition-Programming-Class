import java.util.Scanner;

public class Mosquito
{
    public static void main(String[] args)
    {
        Scanner io = new Scanner(System.in);
        int mos,pup,lar, egg, rlar,rpup,nweeks,mostmp;
        while(io.hasNext())
        {
            mos = io.nextInt();
            pup = io.nextInt();
            lar = io.nextInt();
            egg = io.nextInt();
            rlar = io.nextInt();
            rpup = io.nextInt();
            nweeks = io.nextInt();
            for(int i = 0; i < nweeks; i++)
            {
                mostmp = mos;
                mos = (int)Math.floor(pup / rpup);
                pup = (int)Math.floor(lar / rlar);
                lar = mostmp * egg;
            }
            System.out.println(mos);
        }
        io.close();
    }
}