import java.util.*;
public class Flexible{
	public static void main(String[] args){
		Kattio io = new Kattio(System.in, System.out);
		int width = io.getInt(), num = io.getInt(), temp;
		boolean[] gaps = new boolean[width];
		int[] partition = new int[num];
		for(int i = 0; i < num; i++){
			temp = io.getInt();
			partition[i] = temp;
			gaps[temp] = true; //This is the space from the left wall to this partition
			gaps[width-temp] = true; //This is the space from the right wall to this partition
		}
		for(int i = 0; i < num; i++){
			for(int j = i+1; j < num; j++){
				temp = Math.abs(partition[i]-partition[j]); //This is the space between partitions
				gaps[temp] = true;
			}
		}
		for(int i = 1; i < width; i++){
			if(gaps[i])
				System.out.print(i+" ");
		}
		System.out.println(width);
	}
}