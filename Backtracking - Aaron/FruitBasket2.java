import java.util.*;
import java.lang.Math;
public class FruitBasket2
{
	static long[] array;
	static long maxWeight;
	public static void main(String[] args)
	{
		Scanner io = new Scanner(System.in);
		int fruits = io.nextInt();
	
		array = new long[fruits];
		boolean[] turnedOn = new boolean[fruits];
		maxWeight = 0;
		for(int ii = 0; ii < fruits; ii++)
		{
			array[ii] = io.nextLong();
			maxWeight += array[ii];
		}
		maxWeight *= Math.pow(2,fruits-1);
		comboArea(turnedOn, 0, 0);
		System.out.println(maxWeight);
	
	}
	public static void comboArea(boolean[] turnedOn, int position, long weight)
	{
		if(position != array.length)
		{
			comboArea(turnedOn, position+1,weight);
			if(weight+array[position] < 200)
			{
				turnedOn[position] = true;
				comboArea(turnedOn, position+1, weight+array[position]);
			}

		}
		else
		{
			maxWeight -= weight;
		}
	}
	
}
