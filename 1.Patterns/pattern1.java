import java.util.Scanner;

public class pattern1{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);

        //input n
        int n = scn.nextInt();

        int stars = 1;

        for(int row = 1; row <= n; row++){
            for(int st = 1; st <= stars; st++){
                System.out.print("*" + "\t");
            }
            stars++;
            System.out.println();
        }
    }
}