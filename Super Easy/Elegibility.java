import java.util.Scanner;
public class Elegibility
{
    static String name;
    static String elegibility = "";
    public static void main(String[] args)
    {
        Scanner io = new Scanner(System.in);
        int numinputs = io.nextInt();
        int year, month, day, course;
        String tmp;
        String [] tmparray = new String[3];
        for(int i = 0; i < numinputs; i++)
        {
            name = io.next();
            tmp = io.next();
            tmparray = tmp.split("/");
            if(Integer.parseInt(tmparray[0]) >= 2010)
            {
                elegibility = "eligible";
            }
            tmp = io.next();
            tmparray = tmp.split("/");
            if(Integer.parseInt(tmparray[0]) >= 1991 && elegibility == "")
            {
                elegibility = "eligible";
            }
            course = io.nextInt();
            if(course >= 41 && elegibility == "")
            {
                elegibility = "ineligible";
            }
            if(elegibility == "")
            {
                elegibility = "coach petitions";
            }
            System.out.println(name + " " + elegibility);
            elegibility = "";
        }
    }
}