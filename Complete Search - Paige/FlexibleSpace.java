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
public class FlexibleSpace
{
    public static void main(String[] args)
    {
        Kattio sc = new Kattio(System.in, System.out);
        int W = sc.getInt(); //width
        int P = sc.getInt(); //partions

        LinkedList<Integer> list = new LinkedList<Integer>();
        LinkedList<Integer> previous = new LinkedList<Integer>();
        list.add(W);
        int oldX = 0;
        for(int ii = 0; ii < P; ii++)
        {
            int x = sc.getInt();
            if(!list.contains(x))
            {
                list.add(x);
            }
            if(!list.contains(W-x))
            {
                list.add(W-x);
            }
            if(!list.contains(x-oldX))
            {
                list.add(x - oldX);
            }
            for(int jj = 0; jj < previous.size(); jj++)
            {
                if(!list.contains(x - jj))
                {
                    list.add(x - jj);
                }
            }
            previous.add(x);
            oldX = x;
        }
        Object[] output = list.toArray();
        Arrays.sort(output);

        for(int fido = 0; fido < output.length; fido++)
        {
            System.out.print(output[fido] + " ");
        }

        
        
        
    }
}