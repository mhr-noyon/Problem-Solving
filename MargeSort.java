/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package margesort;

import java.util.Scanner;

public class MargeSort {
    static void merge(int[] arr,int l, int mid, int r){
        int lsize = mid - l + 1;
        int rsize = r - mid;
        int[] left = new int[lsize];
        int[] right = new int[rsize];
        for(int i=0,j=l;i<lsize;i++,j++){
            left[i] = arr[j];
        }
        for(int i=0,j=mid+1;i<rsize;i++,j++){
            right[i] = arr[j];
        }
        int i = 0, j = 0, k=l;
        while(i!=lsize && j!=rsize){
            if(left[i]<right[j]){
                arr[k] = left[i];
                i++;
            }
            else{
                arr[k] = right[j];
                j++;
            }
            k++;
        }
        while(i!=lsize){
            arr[k] = left[i];
            i++;
            k++;
        }
        while(j!=rsize){
            arr[k] = right[j];
            k++;
            j++;
        }
    }
    static void mergeSort(int[] arr,int l,int r){
        if(l==r) return;
        int mid = (l+r)/2;
        System.out.print("First part-> ");
        for(int i=l;i<=mid;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.print(", ");
        System.out.print("Second part-> ");
        for(int i=mid+1;i<=r;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println("");
        mergeSort(arr,l,mid);        
        mergeSort(arr,mid+1,r);
        merge(arr,l,mid,r);
    }
//    static void merge2arr(int[] left, int[] right, int[] arr, int n, int m){
//        int i = 0, j=0, k =0;
//        while(i!=n && j!=m){
//            if(left[i]<right[j]){
//                arr[k] = left[i];
//                i++;
//            }
//            else{
//                arr[k] = right[j];
//                j++;
//            }
//            k++;
//        }
//        while(i!=n){
//            arr[k] = left[i];
//            i++;
//            k++;
//        }
//        while(j!=m){
//            arr[k] = right[j];
//            k++;
//            j++;
//        }
//    }
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in = new Scanner(System.in);
        System.out.print("Array Size: ");
        int n = in.nextInt();
        int[] arr= new int[n];
        System.out.print("Array: ");
        for(int i=0;i<n;i++){
            arr[i] = in.nextInt();
        }
        mergeSort(arr,0,n-1);
        System.out.print("Sorted array -> ");
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println("\n");
        
        
        //merge two array:
//        System.out.print("First array size: ");
//        int n2 = in.nextInt();
//        int[] arr1= new int[n2];
//        System.out.print("Array: ");
//        for(int i=0;i<n2;i++){
//            arr1[i] = in.nextInt();
//        }
//        System.out.print("Second array size: ");
//        int m2 = in.nextInt();
//        int[] arr2 = new int[m2];
//        System.out.print("Array: ");
//        for(int i=0;i<m2;i++){
//            arr2[i] = in.nextInt();
//        }
//        int[] mergeArr= new int[n2+m2];
//        merge2arr(arr1, arr2, mergeArr,n2,m2);
//        System.out.print("Merged array -> ");
//        for(int i=0;i<m2+n2;i++){
//            System.out.print(mergeArr[i]+" ");
//        }
//        System.out.println("\n");
        
    }
    
}
