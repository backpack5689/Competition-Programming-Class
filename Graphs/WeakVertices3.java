import java.util.*;
//import javafx.util.Pair;
import java.util.LinkedList;
//edge list
class Pair<U, V>
{
    public final U first;
    public final V second;

    public Pair(U first, V second)
    {
        this.first = first;
        this.second = second;
    }
    public String toString()
    {
        return "(" + first + "," + second + ")";
    }
	public boolean Equals(Pair U)
	{
		if((this.first == U.first||this.first == U.second )&&(this.second == U.first || this.second == U.second))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
public class WeakVertices3
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); 

        while(N != -1)
        {
            int triangle = 0;
            LinkedList<Pair<Integer, Integer>> list = new LinkedList<Pair<Integer, Integer>>();

            for(int ii = 0; ii < N; ii++)
            {
                for(int jj = 0; jj < N; jj++)
                {
                    int temp = sc.nextInt();
                    if(temp == 1)
                    {
                        Pair<Integer, Integer> pair = new Pair<>(ii, jj);
                        if(!list.contains(pair))
                        {
                            list.add(pair);
							//System.out.println(pair.toString());
                        }
                      
                    }
                }
            }
            for(int i = 0; i < N; i++)
            {
    
                for(int j = 0; j < N; j++)
                {
                    for(int k = 0; k < N; k++)
                    {
          
                        Pair<Integer, Integer> compare1 = new Pair<>(i, j);
                        Pair<Integer, Integer> compare2 = new Pair<>(j, k);
                        Pair<Integer, Integer> compare3 = new Pair<>(k, i);
						Pair<Integer, Integer> compare4 = new Pair<>(j, i);
                        Pair<Integer, Integer> compare5 = new Pair<>(k, j);
                        Pair<Integer, Integer> compare6 = new Pair<>(i, k);
                        //System.out.println(compare3.toString());
                        //System.out.println("I'm about to hit the if statement");
						//System.out.println(list.contains(compare1));
						//System.out.println(list.contains(compare4));
                        if((list.contains(compare1)||list.contains(compare4)) && (list.contains(compare2)||list.contains(compare5)) 
							&& (list.contains(compare3)||list.contains(compare6)))
                        {
                            //System.out.println("I hit the If statement");
							triangle++;
                        }
                        
                        
                    }
                }
                if(triangle < 1)
                {
                    System.out.print(i + " ");
                }

                triangle = 0; //reset for next line
            }
            System.out.println();
            N = sc.nextInt();
         
            
            
        }

    }
}