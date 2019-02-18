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
public class DartScoreTest
{
    public static void main(String[] args)
    {
        //Runs through every possible number
        for (int N = 1; N <= 180; N++)
        {
            Kattio sc = new Kattio(System.in, System.out);
            //int N = sc.getInt(); //total score

            int[] score = new int[]{0, 0, 0};
            int[] placement = new int[]{0, 0, 0};
            boolean completed = false;

            //first score and postition
            for(int i = 1; i <= 20; i++) //score
            {
                for(int j = 1; j <= 3; j++) //postition
                {
                    if(i * j == N)
                    {
                        score[0] = i;
                        placement[0] = j;
                        completed = true;
                        break;
                    }

                    //second score and position
                    for(int k = 1; k <= 20; k++) //score
                    {
                        for(int l = 1; l <= 3; l++) //postition
                        {
                            //do stuff
                            if(k * l + i * j == N)
                            {
                                score[0] = i;
                                placement[0] = j;
                                score[1] = k;
                                placement[1] = l;
                                completed = true;
                                break;
                            }
                            
                            //third score and position
                            for(int m = 1; m <= 20; m++) //score
                            {
                                for(int n = 1; n <= 3; n++) //postition
                                {
                                    //do stuff
                                    if(m * n + k * l + i * j == N)
                                    {
                                        score[0] = i;
                                        placement[0] = j;
                                        score[1] = k;
                                        placement[1] = l;
                                        score[2] = m;
                                        placement[2] = n;
                                        completed = true;
                                        break;
                                    

                                    }
                                

                                }
                            if(completed){break;}
                            }
                        if(completed){break;}
                        }
                    if(completed){break;}
                    }
                if(completed){break;}
                } 
            if(completed){break;}
            }
            if(!completed || placement[0] == 0)
            {
                System.out.println("impossible");
            }
            else
            {
                for(int ii = 0; ii < 3; ii++)
                {
                    if(score[ii] == 0)
                    {
                        break;
                    }
                    if(placement[ii] == 1)
                    {
                        System.out.println("single " + score[ii]);
                    }
                    else if(placement[ii] == 2)
                    {
                        System.out.println("double " + score[ii]);
                    }
                    else
                    {
                    System.out.println("triple " + score[ii]);
                    }
                }
            }
        System.out.println("***");
        }
    }
}
