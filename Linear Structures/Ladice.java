import java.util.*;
import java.io.*;

class Kattio extends PrintWriter {
    public Kattio(InputStream i) {
    super(new BufferedOutputStream(System.out));
    r = new BufferedReader(new InputStreamReader(i));
    }
    public Kattio(InputStream i, OutputStream o) {
    super(new BufferedOutputStream(o));
    r = new BufferedReader(new InputStreamReader(i));
    }

    public boolean hasMoreTokens() {
    return peekToken() != null;
    }

    public int getInt() {
    return Integer.parseInt(nextToken());
    }

    public double getDouble() { 
    return Double.parseDouble(nextToken());
    }

    public long getLong() {
    return Long.parseLong(nextToken());
    }

    public String getWord() {
    return nextToken();
    }



    private BufferedReader r;
    private String line;
    private StringTokenizer st;
    private String token;

    private String peekToken() {
    if (token == null) 
        try {
        while (st == null || !st.hasMoreTokens()) {
            line = r.readLine();
            if (line == null) return null;
            st = new StringTokenizer(line);
        }
        token = st.nextToken();
        } catch (IOException e) { }
    return token;
    }

    private String nextToken() {
    String ans = peekToken();
    token = null;
    return ans;
    }
}

class UF
{
	int arraySize = 0;
	int [] array;
	int [] rankArray;
	
	public UF(int size)
	{
		array = new int[size];
		rankArray = new int[size];
		for(int i = 0; i < size; i++)
		{
			array[i] = i;
			rankArray[i] = 1;
		}
	}
	
	public boolean isConnected(int a, int b)
	{
		if(find(a) == find(b))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public int find(int a)
	{
		while (!(a == array[a]))
		{
			array[a] = array[array[a]];
			a = array[a];
		}
		return a;
	}
	
	public void join(int a, int b)
	{
		int p = find(a);
        int q = find(b);
        if(rankArray[p] < rankArray[q])
        {
            rankArray[q] += rankArray[p];
			array[p] = q;
        }
		else
		{
			rankArray[p] += rankArray[q];
			array[q] = p;
		}
	}
}

public class Ladice
{
	static int recursed = -1;
	static LinkedList<Integer> markedNums = new LinkedList<Integer>();
	static UF uf;
	public static void main(String[] args)
	{
		boolean completed = false;
		Kattio io = new Kattio(System.in);
		int numOps = io.getInt();
		int size = io.getInt();
		uf = new UF(size+1);
		for(int ii = 0; ii < numOps; ii++)
		{
			int n1 = io.getInt();
			int n2 = io.getInt();
			if(uf.array[n1] == n1)
			{
				uf.array[n1] = n2;
				io.println("LADICA");
				//io.println("If 1");
				completed = true;
			}
			else if(uf.array[n2] == n2)
			{
				uf.array[n2] = n1;
				io.println("LADICA");
				//io.println("If 2");
				completed = true;
			}
			else if(needRecursion(n1,n2))
			{
				recursed = 0;
				Recurse(n1, n2); 
				if(recursed == -1)
				{
					recursed = 0;
					Recurse(n2, n1);
				}
				if(recursed == 1)
				{
					io.println("LADICA");
					//io.println("If 3");
					completed = true;
				}
			}
			if(!completed)
			{
				io.println("SMECE");
				//io.println("If 4");
			}
			//io.println("End If");
			completed = false;
			recursed = -1;
		}
		io.close();
	}
	public static boolean needRecursion(int a, int b)
	{
		return (uf.array[a] != a && uf.array[b] != b);
	}
	public static void Recurse(int a, int b)
	{
		
		if(uf.array[a] != a && !markedNums.contains(a))
		{
			markedNums.push(a);
			Recurse(uf.array[a], b);
		}
		else if (markedNums.contains(a))
		{
			markedNums.clear();
			recursed = -1;
		}
		if(recursed == 0)
		{
			recursed = 1;
			uf.array[a] = b;
		}
		if(!(markedNums.isEmpty()))
		{
			int prevIndex = markedNums.pop();
			uf.array[prevIndex] = a;
		}
		
		
	}
}