
package coinKnapsack;

import java.util.Scanner;

public class coinKnapsack {
    static final int  C=3;
    static int coins[] = {0, 1, 5, 10};
    
//    static void printKnap(int knap[][], int Tk){
//        System.out.println("Printing: ");
//        for(int i = 0;i<=C;i++){
//            for(int j = 0;j<=Tk;j++){
//                System.out.print(knap[i][j]+" ");
//            }
//            System.out.print("\n");
//        }
//    }
    static int knapsack(int amount){
        int knap[][] = new int[C+1][amount+1];
        for(int c = 0;c<=C;c++){
            for(int tk = 0;tk<=amount;tk++){
                if(tk==0) knap[c][tk]=1;
                else if(coins[c]==0) knap[c][tk] = 0;
                else if(coins[c]>tk) knap[c][tk]= knap[c-1][tk];
                else{
                    try {
                        knap[c][tk] = knap[c-1][tk] + knap[c][tk-coins[c]];                        
                    } catch (Exception e) {
                        System.out.println("ind: "+c+" "+tk+" "+e.getLocalizedMessage());
                    }
                }
                //printKnap(knap, amount);
            }
        }
        return knap[C][amount];
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter amount: ");
        int amount = in.nextInt();
        System.out.println("Total possible ways to pay the amount: "+knapsack(amount));
    }
}
