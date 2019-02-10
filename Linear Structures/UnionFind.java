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
    UnionFind(int n)
    {
        parents = new int[n + 1];

        for(int i = 0; i < n; i++)
        {
            parents[i] = i;
        }
    }

    int find(int a)
    {
        return parents[a];
    }

    void union(int a , int b)
    {
        int p = find(a);
        int q = find(b);
        if(p != q)
        {
            parents[p] = q;
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