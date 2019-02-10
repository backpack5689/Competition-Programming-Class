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
public class UnionFind
{
    private int[] parents;
	//This following tells you how many nodes are connected to the array
	private int[] rankArray;
    UnionFind(int n)
    {
        parents = new int[n + 1];
		rankArray = new int[n+1];
        for(int i = 0; i < n; i++)
        {
            parents[i] = i;
			rankArray[i] = 1;
        }
    }

    int find(int a)
    {
        //This compresses your search tree (making it only 1 root), and does what it normally does
		while(!(a == array[a]))
		{
			array[a] = array[array[a]];
			a = array[a];
		}
        return a;
    }

    void union(int a , int b)
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

    boolean connected(int a, int b)
    {
        return find(a) == find(b);
    }
    
    public static void main(String[] args)
    {
        Kattio sc = new Kattio(System.in);

        int N = sc.getInt();
        int Q = sc.getInt();

        UnionFind uf = new UnionFind(N);
     
      
        for(int ii = 0; ii < Q; ii++)
        {
            char C = sc.getWord().charAt(0);
            //sc.println(C);
            int a = sc.getInt();
            //sc.println(a);
            int b = sc.getInt();
            //sc.println(b);
			

            if(C == '?')
            {
                if(uf.connected(a, b))
                {
                    sc.println("yes");
                }
                else
                {
                    sc.println("no");
                }  
            }
            else
            {
                uf.union(a, b);
            }
          

        }
        sc.close();
    }
}