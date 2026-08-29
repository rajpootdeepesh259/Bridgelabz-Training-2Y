package com.gla.Level2;
import java.util.Scanner;
public class Split {
    public String[] splitString(String str) {
        int wordcount = 1;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                wordcount++;
            }
        }
        int[] spaces = new int[wordcount - 1];
        int index = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                spaces[index++] = i;
            }
        }
        String[] words = new String[wordcount];
        int start = 0;
        for (int i = 0; i < wordcount - 1; i++) {
            words[i] = str.substring(start, spaces[i]);
            start = spaces[i] + 1;
        }
        int l = str.length();
        words[wordcount - 1] = str.substring(start, l);
        return words;
    }

    public boolean compareArrays(String[] str1, String[] str2) {
        if (str1.length != str2.length) {
            return false;
        }
        for (int i = 0; i < str1.length; i++) {
            if (!str1[i].equals(str2[i])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Split obj = new Split();
        System.out.println("Enter the text");
        String text = sc.nextLine();
        String[] s1 = obj.splitString(text);
        String[] s2 = text.split(" ");
        System.out.println("Words of the text using user defined mathod");
        for (int i = 0; i < s1.length; i++) {
            System.out.print(s1[i] + " ,");
        }
        System.out.println("\nWords of the text using in built mathod");
        for (int i = 0; i < s2.length; i++) {
            System.out.print(s2[i] + " ,");
        }
        boolean result = obj.compareArrays(s1, s2);
        System.out.println("\nComparing the two to see if they are equal (true=Yes,false=No) = " + result);
    }
}