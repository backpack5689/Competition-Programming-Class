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
class FW 
{
    static long[] ft; 
	public FW(int n) 
	{ 
		ft = new long[n+1]; 
	} 
	public static long rsq(int b) 
	{ // returns RSQ(1, b)
		long sum = 0; 
		for (; b != 0; b -= (b & (-b)))
		{	
			sum += ft[b];
		}
		return sum; 
	}
	public static long rsq(int a, int b) 
	{ 
		return rsq(b) - (a == 1 ? 0 : rsq(a - 1)); 
	}

	public static void adjust(int k, long v) 
	{ // note: n = ft.size() - 1
		for (; k < (long)ft.length; k += (k & (-k))) 
		{
			ft[k] += v; 
		}
	}
	public static void adjust(int k) 
	{
		long v;
		if(rsq(k,k) == 0)
		{
			v = 1;
		}
		else
		{
			v = -1;
		}
		for(; k < ft.length; k += (k & (-k)))
		{
			ft[k] += v;
		}
	}
}

public class FenwickTree2
{
	public static void main(String[] args)
	{
		Kattio io = new Kattio(System.in);
		int size = io.getInt();
		FW ft = new FW(size);
		int ops = io.getInt();
		for(int ii = 0; ii < ops; ii++)
		{
			char op = io.getWord().charAt(0);
			if(op == '+')
			{
				ft.adjust(io.getInt()+1, io.getLong());
			}
			else
			{
				io.println(ft.rsq(io.getInt()));
			}
			//add 1 to k when doing adjust
		}
		io.close();
	}
}