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
public class Veci
{
    static int factorial(int n)
    {    
        if (n == 0)  
        {
            return 1;  
        }    
        else  
        {
            return(n * factorial(n-1)); 
        }    
    }  
    
    public static void main(String[] args)
    {
        Kattio sc = new Kattio(System.in, System.out);
        String X = sc.getWord();
        int x = Integer.parseInt(X);
     
        char[] numChar = new char[String.valueOf(x).length()];
        int[] num = new int[String.valueOf(x).length()];

        for(int ii = 0; ii < String.valueOf(x).length(); ii++)
        {
            numChar[ii] = X.charAt(ii);// fill array with given integers
            //System.out.println(numChar[ii]);
            num[ii] = (int)numChar[ii];
         
        }
        Arrays.sort(numChar);
        Arrays.sort(num);

        //change postions
        for(int idek = String.valueOf(x).length() - 1; idek >= 0; idek--)
        {
            //System.out.println(numChar[idek]);
            ////WHY YOU NO WORK
            if(idek > 0)
            {
                //System.out.println("before" + numChar[idek]);
                //System.out.println("before" + numChar[idek - 1]);
                char b = numChar[idek - 1];
                numChar[idek - 1] = numChar[idek];
                numChar[idek] = b;
                ///System.out.println("after" + numChar[idek]);
                //System.out.println("after" + numChar[idek - 1]);
            }
            String output = "";
            for(int wassup = 0; wassup < String.valueOf(x).length(); wassup++)
            {
                output += numChar[wassup];
            }
            //System.out.println(Integer.parseInt(output));
            if(Integer.parseInt(output) > x)
            {
                System.out.println(Integer.parseInt(output));
                System.exit(0);
            }

        }
        System.out.println("0");
    
        
        
        
    }
}