package Problem;
import java.util.Scanner;

/* @author Noyon */
public class Problem1 {
    static Scanner in  = new Scanner(System.in);
    static int item, capacity, secThreshold;
    
    static void knapsack(int[] w,int[] val, int[] security){
        int dpW[][] = new int[item+1][capacity+1];        
        int dpS[][] = new int[item+1][capacity+1];

        for(int i=0;i<=item;i++){
            for(int j=0;j<=capacity;j++){
                if(i==0|| j==0) {
                        dpW[i][j]= 0;
                        dpS[i][j]=0;
                }
                else if(j<w[j]){
                    dpW[i][j] = dpW[i-1][j];
                    dpS[i][j]= dpS[i-1][j];
                }
                else if(val[j]+dpW[i][w[j]-j]>dpW[i-1][j] && security[j]+dpS[i][w[j]-j]<=secThreshold){
                    dpW[i][j] = val[j]+dpW[i][w[j]-j];
                    dpS[i][j]= security[j]+dpS[i][w[j]-j];
                }
                else{
                    dpW[i][j] = dpW[i-1][j];
                    dpS[i][j]= dpS[i-1][j];                    
                }
            }
        }
        System.out.println("Max : "+dpW[item][capacity]);
    }
    public static void main(String[] args) {
        System.out.println("Enter number of items: ");
        item = in.nextInt();
        System.out.println("Enter capacity: ");
        capacity = in.nextInt();
        System.out.println("Enter security Threshold: ");
        secThreshold = in.nextInt();
        int w[] = new int[item+1];       
        int val[] = new int[item+1];        
        int security[] = new int[item+1];
        System.out.print("Enter weights of items: ");
        for(int i=1;i<=item;i++){
            w[i] = in.nextInt();
        }
        System.out.print("Enter values of items: ");
        for(int i=1;i<=item;i++){
            val[i] = in.nextInt();
        }
         System.out.print("Enter security level of items: ");
        for(int i=1;i<=item;i++){
            security[i] = in.nextInt();
        }
        knapsack(w,val,security);
    }

}
