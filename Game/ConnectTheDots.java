import java.util.Scanner;

public class ConnectTheDots
{
    public static void main(String[] args)
    {
        Scanner io = new Scanner(System.in);
        String curr;
        char [][] cDots;
        boolean first = true, done = false;
        int x = 0;
        int y = 100;
        char maxVal = '.';
        char minVal = '0';
        int connections = -1;
        int startX = 0, startY = 0;
        int hitX = 0, hitY = 0;

        //Case loop
        while(!done)
        {
            curr = io.nextLine();
            cDots = new char[100][curr.length()];
            y = curr.length();
            //Creates the char array for us to work with
            while(!curr.equals(""))
            {
                cDots[x] = curr.toCharArray();
                if(!io.hasNextLine())
                {
                    done = true;
                    break;
                }

                curr = io.nextLine();
                x++;
            }

            //Finds how many times we have to search for a connection
            //And finds our start point
            for(int xx = 0; xx < x; xx++)
            {
                for(int yy = 0; yy < y; yy++)
                {
                    if(cDots[xx][yy] > maxVal)
                    {
                       connections++;
                    }
                    if(cDots[xx][yy] == '0')
                    {
                        startX = xx;
                        startY = yy;
                    }
                }
            }

            //Begins to make connections
            iterationsLoop:
            for(int ii = 0; ii < connections; ii++)
            {
                boolean continueation = true;
                //Searches through the row that the number is sitting in
                for(int yy = 0; yy < y ; yy++)
                {
                    if(minVal + 1 == ':')
                    {
                        minVal = '`';
                    }
                    else if(minVal + 1 == '{')
                    {
                        minVal = '@';
                    }
                    if(cDots[startX][yy] == minVal + 1)
                    {
                        minVal++;
                        hitX = startX;
                        hitY = yy;
                        if((startY > yy))
                        {
                            for(int yyy = hitY+1; yyy < startY; yyy++)
                            { 
                                if(cDots[startX][yyy] == '|')
                                {
                                    cDots[startX][yyy] = '+';
                                    continueation = false;
                                }
                                else if(cDots[hitX][yyy] == '.')
                                {
                                    cDots[startX][yyy] = '-';
                                    continueation = false;
                                }
                            }
                        }
                        else
                        {
                            for(int yyy = startY + 1; yyy < hitY; yyy++)
                            {
                                if(cDots[startX][yyy] == '|')
                                {
                                    cDots[startX][yyy] = '+';
                                    continueation = false;
                                }
                                else if(cDots[hitX][yyy] == '.')
                                {
                                    cDots[startX][yyy] = '-';
                                    continueation = false;
                                }
                            }
                        }
                        startY = hitY;
                        startX = hitX;
                    }
                }
                if(continueation)
                {
                //Please note that the xxx is not meant to be explicit, I just ran out of variable names
                    for(int xx = 0; xx < x; xx++)
                    {
                        if(minVal + 1 == ':')
                        {
                            minVal = '`';
                        }
                        else if(minVal + 1 == '{')
                        {
                            minVal = '@';
                        }
                        if(cDots[xx][startY] == (char)(minVal + 1))
                        {
                            hitX = xx;
                            hitY = startY;
                            minVal++;
                            if((startX > xx))
                            {
                                for(int xxx = hitX+1; xxx < startX; xxx++)
                                {
                                    if(cDots[xxx][hitY] == '-')
                                    {
                                        cDots[xxx][hitY] = '+';
                                    }
                                    else if(cDots[xxx][hitY] == '.')
                                    {
                                        cDots[xxx][hitY] = '|';
                                    }
                                }
                            }
                            else
                            {
                                for(int xxx = startX + 1; xxx < hitX; xxx++)
                                {
                                    if(cDots[xxx][hitY] == '-')
                                    {
                                        cDots[xxx][hitY] = '+';
                                    }
                                    else if(cDots[xxx][hitY] == '.')
                                    {
                                        cDots[xxx][hitY] = '|';
                                    }
                                }
                            }
                        }
                    }
                }
                continueation = true;
                startY = hitY;
                startX = hitX;
            }
            
            //Printing
            for(int xx = 0; xx < x; xx++)
            {
                for(int yy = 0; yy < y; yy++)
                {
                    System.out.print(cDots[xx][yy]);
                }
                System.out.println();
            }
            System.out.println();

            first = true;
            x = 0;
            y = 100;
            maxVal = '.';
            minVal = '0';
            connections = -1;
            startX = 0;
            startY = 0;
            hitX = 0;
            hitY = 0;
            //If there is a line of no text following each line, uncomment the next line.
        }

        io.close();
    }
}