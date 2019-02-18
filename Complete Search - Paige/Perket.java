import java.util.*;
import java.io.*;
import java.math.BigInteger;

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

//--------------------------------------
// Systematically generate combinations.
//--------------------------------------


class CombinationGenerator {

  private int[] a;
  private int n;
  private int r;
  private BigInteger numLeft;
  private BigInteger total;

  //------------
  // Constructor
  //------------

  public CombinationGenerator (int n, int r) {
    if (r > n) {
      throw new IllegalArgumentException ();
    }
    if (n < 1) {
      throw new IllegalArgumentException ();
    }
    this.n = n;
    this.r = r;
    a = new int[r];
    BigInteger nFact = getFactorial (n);
    BigInteger rFact = getFactorial (r);
    BigInteger nminusrFact = getFactorial (n - r);
    total = nFact.divide (rFact.multiply (nminusrFact));
    reset ();
  }

  //------
  // Reset
  //------

  public void reset () {
    for (int i = 0; i < a.length; i++) {
      a[i] = i;
    }
    numLeft = new BigInteger (total.toString ());
  }

  //------------------------------------------------
  // Return number of combinations not yet generated
  //------------------------------------------------

  public BigInteger getNumLeft () {
    return numLeft;
  }

  //-----------------------------
  // Are there more combinations?
  //-----------------------------

  public boolean hasMore () {
    return numLeft.compareTo (BigInteger.ZERO) == 1;
  }

  //------------------------------------
  // Return total number of combinations
  //------------------------------------

  public BigInteger getTotal () {
    return total;
  }

  //------------------
  // Compute factorial
  //------------------

  private static BigInteger getFactorial (int n) {
    BigInteger fact = BigInteger.ONE;
    for (int i = n; i > 1; i--) {
      fact = fact.multiply (new BigInteger (Integer.toString (i)));
    }
    return fact;
  }

  //--------------------------------------------------------
  // Generate next combination (algorithm from Rosen p. 286)
  //--------------------------------------------------------

  public int[] getNext () {

    if (numLeft.equals (total)) {
      numLeft = numLeft.subtract (BigInteger.ONE);
      return a;
    }

    int i = r - 1;
    while (a[i] == n - r + i) {
      i--;
    }
    a[i] = a[i] + 1;
    for (int j = i + 1; j < r; j++) {
      a[j] = a[i] + j - i;
    }

    numLeft = numLeft.subtract (BigInteger.ONE);
    return a;

  }
}


public class Perket
{
    static LinkedList<Integer> totals;
    static LinkedList<Integer> combos;
    static java.util.List<java.util.Map.Entry<Integer,Integer>> pairList;

    static void doAThing(int length)
    {
        //IDK WTF IM DOING
        CombinationGenerator x = new CombinationGenerator(pairList.size(), length);
        while(x.hasMore())
        {
            combos.add(x.getNext());
        }
        
        for(int i = 0; i < pairList.size(); i++)
        {
            int sourTotal = 1;
            int bitterTotal = 0;

            for(int n = 0; n < length; n++)
            {
                CombinationGenerator x = new CombinationGenerator(parList.size(), length);
                sourTotal = sourTotal * combo[n][0];
                bitterTotal = bitterTotal + combo[n][1];
            }
            totals.add(Math.abs(sourTotal - bitterTotal));
        }
    }
    public static void main(String[] args)
    {
        Kattio sc = new Kattio(System.in, System.out);
        pairList = new java.util.ArrayList<>();
        int lines = sc.getInt();

        for(int i = 0; i < lines; i++)
        {
            int sour = sc.getInt();
            int bitter = sc.getInt();

            java.util.Map.Entry<Integer,Integer> pair = new java.util.AbstractMap.SimpleEntry<>(sour, bitter);
            pairList.add(pair);
            totals.add(Math.abs(sour - bitter));
        }

        for(int j = 1; j < lines; j++)
        {
            doAThing(j + 1);
        }
        //print min
    }
}