import java.util.*;
public class CanonicalCoins
{
	public static int [] coins;
	public static int numInts;
	public static int greedyAlgorithm(int target)
	{
		int curr = 0;
		for(int ii = 0; ii < numInts; ii++)
		{
			if (target - coins[ii] > 0)
			{
				int numCoinofType = target / coins[ii];
				target -= coins[ii] * numCoinofType;
				curr++;
			}
			if(target == 0)
			{
				break;
			}
		}
		return curr;
	}
	
	public static void optimizedAlgorithm(int upperLimit, int[] totalingArray)
	{
		for(int target = 0; target < upperLimit; target++)
		{
			for(int coin = 0; coin < numInts; coin++)
			{
				if(coins[coin] <= target)
				{
					totalingArray[target] = Math.min(totalingArray[target - coins[coin]]+1, totalingArray[target]);
				}
				else
				{
					break;
				}
			}
		}
	}
	
	public static void main(String [] args)
	{
		Scanner io = new Scanner(System.in);
		numInts = io.nextInt();
		coins = new int[numInts];
		for(int i = 0; i < numInts; i++)
		{
			coins[i] = io.nextInt();
		}
		int upperLimit = coins[numInts - 1] + coins[numInts - 2];		
		
		int [] optimizedNumbers = new int[upperLimit];
		Arrays.fill(optimizedNumbers, 999999);
		optimizedNumbers[0] = 0;
		optimizedAlgorithm(upperLimit, optimizedNumbers);
		
		boolean isCononical = true;
		for(int ii = 0; ii < upperLimit; ii++)
		{
			if(greedyAlgorithm(ii) <= optimizedNumbers[ii])
			{
				System.out.println(Integer.toString(greedyAlgorithm(ii)) + " " + Integer.toString(optimizedNumbers[ii]));
				isCononical = false;
				break;
			}
		}

		if(isCononical)
		{
			System.out.println("canonical");
		}
		else
		{
			System.out.println("non-canonical");
		}
	}
}