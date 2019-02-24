import java.util.*;
import java.lang.Math;
public class PageLayout
{
	static int totalArea = 0;
	static Article[] array;
	static int maxArea;
	public static void main(String[] args)
	{
		Scanner io = new Scanner(System.in);
		int repetitions = io.nextInt();
		while(repetitions != 0)
		{
			array = new Article[repetitions];
			maxArea = 0;
			boolean[] turnedOn = new boolean[repetitions];
			for(int ii = 0; ii < repetitions; ii++)
			{
				int[] wh = {io.nextInt(), io.nextInt()};
				int[] tlp = {io.nextInt(), io.nextInt()};
				array[ii] = new Article(wh,tlp);
			}
			comboArea(turnedOn, 0);
			System.out.println(maxArea);
			repetitions = io.nextInt();
		}
	}
	public static void comboArea(boolean[] turnedOn, int position)
	{
		if(position != array.length)
		{
			boolean overlap = false;
			for(int ii = 0; ii < position; ii++)
			{
				if(turnedOn[ii] && array[ii].doesOverlap(array[position]))
				{
					//System.out.println("I set overlap to true!");
					overlap = true;
					break;
				}
			}
			if(!overlap)
			{
				turnedOn[position] = true;
				comboArea(turnedOn, position+1);
			}
			turnedOn[position] = false;
			comboArea(turnedOn, position+1);
		}
		else
		{
			int tmp = 0;
			//System.out.println("***");
			for(int ii = 0; ii < turnedOn.length; ii++)
			{
				if(turnedOn[ii])
				{
					tmp += array[ii].area;
				}
			}
			if(tmp > maxArea)
			{
				//System.out.println("I reassigned maxArea");
				maxArea = tmp;
			}
		}
	}
	
}
class Article
{
	int[] trp,tlp,brp,blp;
	int area;
	//These two variables are to help when assigning values in my coordinate arrays
	int x = 0;
	int y = 1;
	public Article(int[] wh, int[] itlp)
	{
		this.tlp = itlp;
		this.trp = new int[]{wh[x]+tlp[x],tlp[y]};
		this.blp = new int[]{tlp[x],wh[y]+tlp[y]};
		this.brp = new int[]{trp[x],blp[y]};
		area = wh[0] * wh[1];
	}
	public boolean doesOverlap(Article B)
	{
		//System.out.println(Arrays.toString(this.tlp));
		//System.out.println(Arrays.toString(B.tlp));
		if(B.tlp[x] >= this.brp[x] || B.brp[x] <= this.tlp[x] || B.tlp[y] >= this.brp[y] || B.brp[y] <= this.tlp[y])
		{
			return false;
		}
		return true;
	}
}