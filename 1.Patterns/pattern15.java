import java.util.Scanner;

public class pattern15 {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int values = 1, spaces = n/2;
        for(int row = 1; row <= n; row++){
            for(int sp = 1; sp <= spaces; sp++){
                System.out.print("\t");
            }
            int num = row <= (n + 1)/2 ? row : n + 1 - row;
            for(int val = 1; val <= values; val++){
                System.out.print(num + "\t");
                if(val <= (values)/2){
                    num++ ;
                }else{
                    num--;
                }
            }
            System.out.println();
            if(row <= n/2){
                values += 2;
                spaces--;
            }else{
                values -=2;
                spaces++;
            }
        }
    }
}
