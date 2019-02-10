import java.util.Scanner;

public class ArmyStrength {
    public static void main(String[] args) 
    {
        Scanner io = new Scanner(System.in);
        int n = io.nextInt();
        int gSize, mSize, gMax = -1, mMax = -1, tmp;
        
        
        for (int fido = 0; fido < n; fido++) 
        {
            gMax = -1; 
            mMax = -1;
            gSize = io.nextInt();
            mSize = io.nextInt();
            for (int i = 0; i < gSize; i++) 
            {
                tmp = io.nextInt();
                if(tmp > gMax)
                {
                    gMax = tmp;
                }
            }
            for (int i = 0; i < mSize; i++) 
            {   
                tmp = io.nextInt();
                if(tmp > mMax)
                {
                    mMax = tmp;
                }
            }

            if(gMax >= mMax)
            {
                System.out.println("Godzilla");
            }
            else
            {
                System.out.println("MechaGodzilla");
            }
        }

        io.close();
    }
}