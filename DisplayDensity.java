import java.util.*;
public class DisplayDensity
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();

        for(int i = 0; i < N; i++)
        {
            String input = sc.nextLine(); // entire string
            //System.out.println(input);
            String[] inputArray = input.split(" "); // array of words
            //System.out.println(inputArray.length);
            int max = 0;
            for(int j = 1; j <= input.length(); j++) // widths
            {
                int count = 0;
                int row = 0;
                boolean possible = false;
                for(int k = 0; k < inputArray.length; k++)
                {
                    if((inputArray[k].length()) + count < j)
                    {
                        count+=inputArray[k].length();
                        possible = true;
                    }
                    else
                    {
                        if(possible)
                        {
                            row++;
                            count = 0;
                        }
                        else
                        {
                            break;
                        }
        
                    }
                }
                int temp = j + 2 * row;
                if(temp > max)
                {
                    max = temp;
                }
            }
            System.out.println(max);
            max = 0;
        }
    }

}