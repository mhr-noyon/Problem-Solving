/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package knapsack;

import java.util.Scanner;

/* @author Noyon */
public class Knapsack {
    static int max(int a, int b){
        return (a>b) ? a:b;
    }
    static int knapSack(int W, int wt[], int profit[], int n){
        int knap[][] = new int[n+1][W+1];
        for(int i = 0;i<=n;i++){
            for(int w=0;w<=W;w++){
                if(i==0 || w==0)knap[i][w] = 0;
                else{
                    try {
                        knap[i][w] = max(knap[i-1][w],knap[i-1][w-wt[i]]+profit[i]);
                    } catch (Exception e) {
                        System.out.println("ind: "+i+" "+w+" "+e.getLocalizedMessage());
                    }
                        
                    
                }
            }
        }
        return knap[n][W];
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter no of items: ");
        int n = in.nextInt();
        System.out.println("Enter size of knapsack: ");
        int W = in.nextInt();
        int[] profit = new int[n+1];
        int[] wt = new int[n+1];
        System.out.println("Enter the profits of items: ");
        for(int i =1;i<=n;i++){
            profit[i] = in.nextInt();
        }
        System.out.println("Enter the weights of items: ");
        for(int i = 1;i<=n;i++){
            wt[i] = in.nextInt();
        }
        System.out.println("Maximum total profit: "+knapSack(W,wt,profit,n));
    }

}
