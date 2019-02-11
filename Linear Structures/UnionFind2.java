import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStream;

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
public class UnionFind2
{
	public static void main(String[] args)
	{
		Kattio io = new Kattio(System.in);
		int size = io.getInt();
		int numOps = io.getInt();
		UF MyUnion = new UF(size);
		for(int ha = 0; ha < numOps; ha++)
		{
			char symbol = io.getWord().charAt(0);
			int n1 = io.getInt();
			int n2 = io.getInt();
			if(symbol == '=')
			{
				MyUnion.join(n1,n2);
			}
			else
			{
				if(MyUnion.find(n1) == MyUnion.find(n2))
				{
					io.println("yes");
				}
				else
				{
					io.println("no");
				}
			}
		}
	io.close();
	}
}

