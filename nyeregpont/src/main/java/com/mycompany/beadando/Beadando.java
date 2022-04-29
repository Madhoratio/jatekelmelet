package com.mycompany.beadando;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author szofisanyi
 */
public class Beadando {

    static boolean Nyeregont(int matrix[][])
    {
        for (int i = 0; i < matrix.length; i++) {
            // Minimum érték megkeresése
            // Minimum érték oszlopindex keresése
            int minRow = matrix[i][0], colIndex = 0;
            for (int j = 1; j < matrix[i].length; j++) {
                if (minRow > matrix[i][j]) {
                    minRow = matrix[i][j];
                    colIndex = j;
                }
            }
      
            // Sor minimális elemének ellenőrzése az oszlop legnagyobb eleme-e
            int k;
            for (k = 0; k < matrix.length; k++) {
                if (minRow < matrix[k][colIndex]) {
                    break;
                }
            }
      
            // Ha a nyeregpont ebben a sorban van akkor kiíratjuk
            if (k == matrix.length) {
               System.out.println("Nyeregpont erteke: " + minRow);
               return true;
            }
        }
      
        // Ha nincs nyeregpont a visszatérésünk hamis
        return false;
    }
    
    static void test1() {
        int matrix[][] = {
            {0,7,1,0},
            {2,5,9,0},
            {8,6,0,1},
        };
        
        System.out.print("== Test #1: ");
        if (Nyeregont(matrix) == false) {
            System.out.println("Nincs nyeregpont.");
        }
    }
    
    static void test2() {
        int matrix[][] = {
            {8,2,1,0},
            {0,1,3,2},
            {6,9,2,0},
        };
        
        System.out.print("== Test #2: ");
        if (Nyeregont(matrix) == false) {
            System.out.println("Nincs nyeregpont.");
        }
    }
    
    static void test3() {
        int matrix[][] = {
            {0,0,0,0},
            {1,1,0,0},
            {2,2,8,8},
        };
        
        System.out.print("== Test #3: ");
        if (Nyeregont(matrix) == false) {
            System.out.println("Nincs nyeregpont.");
        }
    }
    
    static void test4() {
        int matrix[][] = {
            {5,0,1,6},
            {2,8,8,0},
            {9,2,4,6},
        };
        
        System.out.print("== Test #4: ");
        if (Nyeregont(matrix) == false) {
            System.out.println("Nincs nyeregpont.");
        }
    }
    
    static void test5() {
        int matrix[][] = {
            {1,3,3,2},
            {2,9,0,3},
            {4,3,8,8},
        };
        
        System.out.print("== Test #5: ");
        if (Nyeregont(matrix) == false) {
            System.out.println("Nincs nyeregpont.");
        }
    }
        
        
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner sc = new Scanner(new BufferedReader(new FileReader("file.txt")));
        int rows = 3;
        int columns = 4;
        
        int matrix[][] = new int[rows][columns];
        while(sc.hasNextLine()) {
            for (int i = 0; i < matrix.length; i++) {
                String[] row = sc.nextLine().trim().split(",");
                for (int j = 0; j< row.length; j++) {
                    matrix[i][j] = Integer.parseInt(row[j]);
                }
            }
        }
         
        if (Nyeregont(matrix) == false) {
            System.out.println("Nincs nyeregpont.");
        }
        
        System.out.println("========== TEST ==========");
        test1();
        test2();
        test3();
        test4();
        test5();
    }
}
