import java.util.*;

public class Sort_of_Sorting
{
	public static void main(String[] args)
	{
		Scanner io = new Scanner(System.in);
		String[] inputs;
		int n = io.nextInt();
		io.nextLine();
		int count = 0;
		String swapping;
		boolean swaps = true;
		while(n != 0)
		{
			inputs = new String[n];
			//Puts inputs into a string to sort
			for(int i = 0; i < n; i++)
			{
				inputs[i] = io.nextLine();
			}
			
			//Sorts the array
			while(swaps != false)
			{
				swaps = false;
				for(int i = 0; i < n; i++)
				{
					if(i+1 == n)
					{
						break;
					}
				
					if(inputs[i].charAt(0) > inputs[i+1].charAt(0) || 
						(inputs[i].charAt(0) == inputs[i+1].charAt(0) && inputs[i].charAt(1) > inputs[i+1].charAt(1)))
					{
						swapping = inputs[i];
						inputs[i] = inputs[i+1];
						inputs[i+1] = swapping;
						swaps = true;
					}
				}
			}	
			swaps = true;
			//Prints the array
			for(int i = 0; i < n; i++)
			{
				System.out.println(inputs[i]);
			}
			System.out.println();
			//Checks the next number (n)
			n = io.nextInt();
			io.nextLine();
			
		
		}
	}
}