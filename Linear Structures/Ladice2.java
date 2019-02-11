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
	boolean [] marked;
	
	public UF(int size)
	{
		array = new int[size];
		marked = new boolean[size];
		for(int i = 0; i < size; i++)
		{
			array[i] = i;
			marked[i] = false;
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
		if(array[a] == a)
		{
			return a;
		}
		else
		{
			return array[a] = find(array[a]);
		}
	}
	
	public void join(int a, int b)
	{
		array[find(a)] = find(b);
	}
}

public class Ladice2
{
	public static void main(String[] args)
	{
		Kattio io = new Kattio(System.in);
		int numOps = io.getInt();
		int size = io.getInt();
		UF uf = new UF(size+1);
		for(int ii = 0; ii < numOps; ii++)
		{
			int n1 = io.getInt();
			int n2 = io.getInt();
			if(!uf.marked[n1])
			{
				uf.marked[n1] = true;
				uf.join(n1, n2);
				io.println("LADICA");
			}
			else if(!uf.marked[n2])
			{
				uf.marked[n2] = true;
				uf.join(n2,n1);
				io.println("LADICA");
			}
			else if(!uf.marked[uf.find(n1)])
			{
				uf.marked[uf.find(n1)] = true;
				uf.join(n1,n2);
				io.println("LADICA");
			}
			else if(!uf.marked[uf.find(n2)])
			{
				uf.marked[uf.find(n2)] = true;
				uf.join(n2, n1);
				io.println("LADICA");
			}
			else
			{
				io.println("SMECE");
			}
		}
		io.close();
	}
}