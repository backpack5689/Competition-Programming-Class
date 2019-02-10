import java.util.Scanner;

public class Statistics {
    public static void main(String[] args) {
        Scanner io = new Scanner(System.in);
        int counter = 1;
        while(io.hasNext())
        {
            int i = io.nextInt();
            int min = 1000001;
            int max = -1000001;
            int tmp;
            for(int j = 0; j < i; j++)
            {
                tmp = io.nextInt();
                if(tmp > max)
                {
                    max = tmp;
                }
                if(tmp < min)
                {
                    min = tmp;
                }
            }
            int range = max - min;
            System.out.println("Case " + counter + ": " + min + " " + max + " " + range); 
            counter++;
        }
        io.close();
    }
}