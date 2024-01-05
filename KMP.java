/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package kmp;

import java.util.Scanner;

/* @author Noyon */
public class KMP {
    void KMPSearch(String pat, String txt) {
        int M = pat.length();
        int N = txt.length();
        int lps[] = new int[M];
        int j = 0; 
        computeLPSArray(pat, M, lps);
        int i = 0, c= 0; 
        while (i < N) {
            if (pat.charAt(j) == txt.charAt(i)) {
               j++;
               i++;
            }
            if(j==M){
                System.out.println("Found pettern at index: "+ (i-j));
                j = lps[j-1];
                c++;
            }

            else if (i < N && pat.charAt(j) != txt.charAt(i)) {
                if(j!=0) j = lps[j-1];
                else i++;
            }
        }
        if(c==0) System.out.println("Not found!");
        
    }
    void computeLPSArray(String pat, int M, int lps[]){
        int len = 0;
        int i = 1;
        lps[0] = 0;
        while (i < M) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            }
            else 
            {
                if (len != 0)
                    len = lps[len-1];
                else {
                    lps[i] = len;
                    i++;
                }
            }
        }
    }
    public static void main(String[] args) { 
        Scanner in = new Scanner(System.in);
        String txt = "ABABDABACDABABCABAB";
        String pat = "ABABCABAB";
        System.out.print("Enter main string: ");
        txt = in.nextLine();
        System.out.print("Enter pattern string: ");
        pat = in.nextLine();
        System.out.println("Main String: ");
        for(int i = 0;i<txt.length();i++){
            System.out.println((i)+": "+txt.charAt(i));
        }
        System.out.println("Pattern: ");
        for(int i = 0;i<pat.length();i++){
            System.out.println((i)+": "+pat.charAt(i));
        }
        new KMP().KMPSearch(pat, txt);
    }

}