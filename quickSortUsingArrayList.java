package quickSort;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class quickSortUsingArrayList {

    public static void main(String[] args) {
        try {
            File file = new File("quick.txt");
            Scanner scan = new Scanner(file);
            int numStudents = scan.nextInt();
                
            // Read the first line to get the number of students
            ArrayList<Integer> rollNumbers = new ArrayList<>(numStudents);
            ArrayList<String> names = new ArrayList<>(numStudents);

                for(int i=0;i<numStudents;i++){
                    int roll = scan.nextInt();
                    String name = scan.nextLine();
                    rollNumbers.add(roll);
                    names.add(name);
                }
           

            System.out.println("Unsorted Student List:");
            printStudentList(rollNumbers, names);
            System.out.println("\n");
            quickSort(rollNumbers, names, 0, rollNumbers.size() - 1);

            System.out.println("\nSorted Student List:");
            printStudentList(rollNumbers, names);

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    private static void quickSort(ArrayList<Integer> rollNumbers, ArrayList<String> names, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(rollNumbers, names, low, high);
            
            System.out.println("Pivot: " + rollNumbers.get(partitionIndex) + " at index " + partitionIndex);
            System.out.println("After Partitioning: ");
            printStudentList(rollNumbers, names);

            quickSort(rollNumbers, names, low, partitionIndex - 1);
            quickSort(rollNumbers, names, partitionIndex + 1, high);
        }
    }

    private static int partition(ArrayList<Integer> rollNumbers, ArrayList<String> names, int low, int high) {
        int pivot = rollNumbers.get(high);
        int i = low - 1;
            //pivot ind +++++  pivot
        for (int j = low; j < high; j++) {
            if (rollNumbers.get(j) > pivot) {
                i++;
                // Swap roll numbers
                int tempRoll = rollNumbers.get(i);
                rollNumbers.set(i, rollNumbers.get(j));
                rollNumbers.set(j, tempRoll);
                     
                // Swap names
                String tempName = names.get(i);
                names.set(i, names.get(j));
                names.set(j, tempName);
            }
        }
        i++;
        // Swap the pivot element
        int tempRoll = rollNumbers.get(i);
        rollNumbers.set(i, rollNumbers.get(high));
        rollNumbers.set(high, tempRoll);

        String tempName = names.get(i);
        names.set(i, names.get(high));
        names.set(high, tempName);

        return i;
    }

    private static void printStudentList(ArrayList<Integer> rollNumbers, ArrayList<String> names) {
        for (int i = 0; i < rollNumbers.size(); i++) {
            System.out.println("Roll: " + rollNumbers.get(i) + "\tName: " + names.get(i));
        }
    }
}