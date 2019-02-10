import java.util.Scanner;

public class Chess
{
    public static void main(String[] args)
    {
        Scanner io = new Scanner(System.in);
        int n = io.nextInt();
        io.nextLine();
        int startX, endX;
        char tstartX, tendX;
        int startY, endY;
        int count = 0;
        boolean completed = false;
        for(int fido = 0; fido < n; fido++)
        {
            //Starting and ending variables
            tstartX = io.next().charAt(0);
            startY = io.nextInt();
            tendX = io.next().charAt(0);
            endY = io.nextInt();
            startX = SwitchA(tstartX);
            endX = SwitchA(tendX);
            
            //If it's on an opposite colored square...
            if((((startX+startY) %2 == 0) && !((endX+endY) %2 == 0) || ((endX+endY) %2 ==0) && !((startX+startY) %2 == 0)))
            {
                System.out.print("Impossible\n");
                continue;
            }
            else
            {
                //If they are equal to each other, we won't have to do anything...
                if((startX == endX)&&(startY == endY) )
                {
                    startX = SwitchB(startX);
                    System.out.printf("%d %c %d\n",count, startX, startY);
                    continue;
                }
                else
                {
                    //At this point, we need to find the diagonals, because if one is on the line, we have our answer.
                    count++;
                    final int M1 = 1;
                    final int M2 = -1;
                    //To find our intercept using y = mx + b, our intercept will always be y+-x
                    int startB1 = startY - startX;
                    int startB2 = startY + startX;
                    int checkX = 0, checkY = 0, tmp;
                    for(int x = 1; x <= 8; x++)
                    {
                        tmp = M1 * x + startB1;
                        if((tmp == endY && x == endX) && tmp < 9 && tmp > 0)
                        {
                            startX = SwitchB(startX);
                            endX = SwitchB(endX);
                            System.out.printf("%d %c %d %c %d\n", count, startX, startY, endX, endY);
                            completed = true;
                            continue;
                        }
                        tmp = M2 * x + startB2;
                        if((tmp == endY) && (x == endX) && tmp < 9 && tmp > 0 )
                        {
                            startX = SwitchB(startX);
                            endX = SwitchB(endX);
                            System.out.printf("%d %c %d %c %d\n", count, startX, startY, endX, endY);
                            completed = true;
                            continue;
                        }
                    }
                    if(!completed)
                    {
                        count++;
                        int endB1 = endY - endX;
                        int endB2 = endY + endX;
                        for(int x = 1; x <= 8; x++)
                        {
                            tmp = M1 * x + endB1;
                            if((tmp == M1 * x + startB1 || tmp == M2 * x + startB2) && tmp < 9 && tmp > 0 )
                            {
                                startX = SwitchB(startX);
                                endX = SwitchB(endX);
                                x = SwitchB(x);
                                System.out.printf("%d %c %d %c %d %c %d\n", count, startX, startY, x, tmp, endX, endY);
                                completed = true;
                                continue;
                            }
                            tmp = M2 * x + endB2;
                            if((tmp == M2 * x + startB2 || tmp == M1 * x + startB1) && tmp < 9 && tmp > 0)
                            {
                                
                                startX = SwitchB(startX);
                                endX = SwitchB(endX);
                                x = SwitchB(x);
                                System.out.printf("%d %c %d %c %d %c %d\n", count, startX, startY, x, tmp, endX, endY);
                                completed = true;
                                continue;
                            }
                        }
                        if(!completed)
                        {
                            System.out.print("Impossible\n");
                        }
                    }
                }
            }
            count = 0;
            completed = false;
        }
    }
    public static int SwitchA(char x)
    {
        switch(x)
        {
            case 'A':
                return 1;
            case 'B':
                return 2;
            case 'C':
                return 3;
            case 'D':
                return 4;
            case 'E':
                return 5;
            case 'F':
                return 6;
            case 'G':
                return 7;
            case 'H':
                return 8;
            default:
                return 0;
        }
    }
    public static char SwitchB(int x)
    {
        switch(x)
        {
            case 1:
                return 'A';
            case 2:
                return 'B';
            case 3:
                return 'C';
            case 4:
                return 'D';
            case 5:
                return 'E';
            case 6:
                return 'F';
            case 7:
                return 'G';
            case 8:
                return 'H';
            default:
                return 0;
        }
    }
}