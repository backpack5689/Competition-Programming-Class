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
public class FenwickTree
{
    public static class Fenwick 
    {
        long[] ft; //vector
        public Fenwick(int x)
        {
            ft = new long[x + 1];
        }
        long rsq(int b) // range sum query (1, b)
        {
            b--;
            if(b == -1)
            {
                return 0;
            }
            long sum = ft[0];
            while(b > 0)
            {
                sum += ft[b];
                b -= (b & (-b));
            }
            return sum;
        }
        void adjust(int k, long v)
        {
               // (i & (-i)) == LSOne(i) 
            if(k == 0)
            {
                ft[0]+=v;
            }
            else
            {
                while(k <= ft.length)
                {
                    ft[k]+=v;  
                    k += (k & (-k)); 
                }
            }
                
            
        }
    }
    public static void main(String[] args) throws IOException
    {
        
        Kattio sc = new Kattio(System.in, System.out);

        int N = sc.getInt(); // array length
        int Q = sc.getInt(); // operation num

        char C;
        int fido;

        Fenwick tree = new Fenwick(N);

        for(int ii = 0; ii < Q; ii++)
        {
            C = sc.getWord().charAt(0);
            fido = sc.getInt();

            if(C == '+')
            {
                long fido2 = sc.getLong();//(int)input.charAt(4);
                tree.adjust(fido, fido2);
                //System.out.println("I adjusted successfully");
            }
            else
            {
                sc.println(tree.rsq(fido));
            }
        }
        sc.close();
    }

   
    
}