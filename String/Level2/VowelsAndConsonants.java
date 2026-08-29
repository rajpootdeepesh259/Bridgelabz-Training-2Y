package com.gla.Level2;
import java.util.Scanner;
public class VowelsAndConsonants {
    public int[] countVowelsAndConsonants(String str) {
        int vowels = 0;
        int consonants = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' || str.charAt(i) == 'o' || str.charAt(i) == 'u' || str.charAt(i) == 'A' || str.charAt(i) == 'E' || str.charAt(i) == 'I' || str.charAt(i) == 'O' || str.charAt(i) == 'U') {
                vowels++;
            } else if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z' || str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
                consonants++;
            }
        }
        int[] result = new int[2];
        result[0] = vowels;
        result[1] = consonants;
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        VowelsAndConsonants obj = new VowelsAndConsonants();
        System.out.println("Enter the string");
        String s = sc.nextLine();
        int[] a = obj.countVowelsAndConsonants(s);
        System.out.println("The number of vowels and consonants in the string is");
        System.out.println(a[0] + " " + a[1]);
    }
}