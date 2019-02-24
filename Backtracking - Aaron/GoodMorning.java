import java.util.*;
import java.lang.Math;
public class GoodMorning
{
	static int[][] possNums = {{0}, //0
						{1,2,3,4,5,6,7,8,9,0}, //1
						{2,3,5,6,8,9,0}, //2
						{3,6,9}, //3
						{4,5,6,7,8,9,0}, //4
						{5,6,8,9,0}, //5
						{6,9,0}, //6
						{7,8,9,0}, //7
						{8,9,0}, //8
						{9,0}, //9
						{1,2,3,4,5,6,7,8,9,0}}; //Beginning Choice
	static int digits;
	public static int getValue(int targetNum)
	{
		int finalNum = 0;
		int place,tmp,currPlaceValue;
		int lastNum = 0;
		int reps = digits;
		int targetNum2 = targetNum;  
		for(int ii = 0; ii<reps; ii++)
		{

			place = (int)Math.pow(10,digits);
			//System.out.println("Place "+place);
			digits = digits - 1;
			tmp = targetNum % place;
			currPlaceValue = (targetNum - tmp)/place;
			targetNum2 = targetNum2 - tmp;
			if(finalNum == 0)
			{
				for(int index = 0; index < 10; index++)
				{
					if(possNums[10][index] == currPlaceValue)
					{
						lastNum = possNums[10][index];
						finalNum = lastNum * place;
						break;
					}
				}
			}
			else
			{
				int min = 999;
				int[] a = possNums[lastNum];
				for(int index = 0; index < a.length; index++)
				{
					if(a[index] == ((targetNum%place)/(place/10)))
					{
						lastNum = a[index];
						break;
					}
					if(Math.abs((a[index]*place)-targetNum) > Math.abs((min * place)-targetNum))
					{
						min = a[index];
						lastNum = a[index];
					}
				}
				
				finalNum = (lastNum * place) + finalNum;
			}
		}
		return finalNum;
	}

	public static void main(String[] args)
	{
		Scanner io = new Scanner(System.in);
		int repetitions = io.nextInt();
		io.nextLine();
		for(int r = 0; r < repetitions; r++)
		{
			String myNumS = io.nextLine();
			//System.out.println(myNumS);
			if(myNumS.equals(""))
			{
				System.out.println("I went through "+ r + " times."); 
				break;
			}
			digits = myNumS.length()-1;
			int myNum = Integer.parseInt(myNumS);
			int returnValue= getValue(myNum);
			System.out.println(returnValue);
		}
		io.close();
	}
}