import java.util.Scanner;

public class BattleSimulation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String monAttack = scan.nextLine();
        int monAttackLength = monAttack.length();
        for(int i = 0; i < monAttackLength; i++)
        {
            if(!(i+2 > monAttackLength-1 || i+1 > monAttackLength-1) && (monAttack.charAt(i) != monAttack.charAt(i+1) && monAttack.charAt(i+1) != monAttack.charAt(i+2) && monAttack.charAt(i+2) != monAttack.charAt(i)) )
            {
                System.out.print("C");
                if(i != monAttackLength)
                {
                    i += 2;
                }
            }
            else
            {
                switch (monAttack.charAt(i))
                {
                    case 'R':
                        System.out.print("S");
                        break;
                    case 'B':
                        System.out.print("K"); 
                        break;
                    case 'L':
                        System.out.print("H");
                        break;
                }
            }         
        }
        scan.close();
    }
}