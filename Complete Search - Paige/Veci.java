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

public class Veci {
    static Kattio sc = new Kattio(System.in);
    static LinkedList<Integer> perms;
    static int length;
    static int x;

    static void permutation(String prefix, String str) 
    {
        int N = str.length();
        if (N == 0 && prefix.length() == length) 
        {
            int permutation = Integer.parseInt(prefix);
            if (permutation > x)
            {
                perms.add(permutation);
            }
        }
        else 
        {
            for (int i = 0; i < N; i++)
            {
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, N)); 
                //add i value as prefix and take out from string and repeat
                
            }
        }
    }

    public static void main(String[] args) 
    {
        perms = new LinkedList<Integer>();
        String X = sc.getWord();
        length = X.length();
        x = Integer.parseInt(X);
        permutation("", X);

        if(perms.isEmpty())
        {
          System.out.println(0);
        } 
        else
        {
            int min = 1000000;
            for(int i = 0; i < perms.size(); i++)
            {
                if(perms.get(i) < min)
                {
                    min = perms.get(i);
                }
            }
            if(min == 1000000)
            {
                System.out.println(0);
            }
            else
            {
                System.out.println(min);
            }
            
        } 
    }

}