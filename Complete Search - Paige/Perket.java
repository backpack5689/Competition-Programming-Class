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

public class Perket
{
    public static void main(String[] args)
    {
        Kattio sc = new Kattio(System.in, System.out);
        int N = sc.getInt(); // ingredients

        //the total sourness is the product of sourness 
        //amounts of all ingredients, while the total 
        //bitterness is the sum of bitterness amounts 
        //of all ingredients.
   
        LinkedList<Integer> sour = new LinkedList<Integer>();
        LinkedList<Integer> bitter = new LinkedList<Integer>();
        int min1 = 1000000000;
        int min2 = 1000000000;

        for(int i = 0; i < N; i++)
        {
            sour.add(sc.getInt());
            bitter.add(sc.getInt());
        }
        int sourTotal = 1;
        int bitterTotal = 0;
        
        for(int ii = 0; ii < sour.size(); ii++) //both the same size
        {
            sourTotal *= sour.get(ii);
            bitterTotal += bitter.get(ii);

            if(Math.abs(sourTotal - bitterTotal) < min1)
            {
                min1 = Math.abs(sourTotal - bitterTotal);
            }
        }
        sourTotal = 1;
        bitterTotal = 0;
        for(int ii = sour.size(); ii < sour.size(); ii--) //both the same size
        {
            sourTotal *= sour.get(ii);
            bitterTotal += bitter.get(ii);

            if(Math.abs(sourTotal - bitterTotal) < min2)
            {
                min2 = Math.abs(sourTotal - bitterTotal);
            }
        }
        if(min1 < min2)
        {
            System.out.println(min1);
        }
        else
        {
            System.out.println(min2);
        }

        
    }
}