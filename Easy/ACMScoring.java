import java.util.Scanner;

public class ACMScoring {
    public static void main(String[] args) 
    {
        Scanner io = new Scanner(System.in);

        int [] penalties = new int[26];
        int totalTime = 0;
        char problem;
        int submitTime, problemsCorrect;
        String validity, input;
        String [] tmp = new String[3];

        input = io.nextLine();
        tmp = input.split(" ");
        submitTime = Integer.parseInt(tmp[0]);

        while (submitTime != -1) 
        {
            problem = tmp[1].charAt(0);
            validity = tmp[2];
            if(validity.equals("right") && penalties[problem-65] != -1)
            {
                totalTime += submitTime + penalties[problem-65];
                penalties[problem-65] = -1;
                problemsCorrect++;
            }
            else
            {
                if(validity.equals("wrong") && penalties[problem-65] != -1)
                {
                    penalties[problem-65] += 20;
                }
            }
            input = io.nextLine();
            tmp = input.split(" ");
            submitTime = Integer.parseInt(tmp[0]);
        }

        System.out.println(problemsCorrect + " " + totalTime);
        io.close();
    }
}