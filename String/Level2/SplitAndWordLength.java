package com.gla.Level2;
import java.util.Scanner;
public class SplitAndWordLength {
    public String[][] splitStringAndLength(String str) {
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

        int[] length = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            length[i] = words[i].length();
        }
        String[][] wordsandlength = new String[2][words.length];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i == 0) {
                    wordsandlength[i][j] = words[j];
                } else if (i == 1) {
                    wordsandlength[i][j] = String.valueOf(length[j]);
                }
            }
        }
        return wordsandlength;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SplitAndWordLength obj = new SplitAndWordLength();
        System.out.println("Enter the text");
        String s = sc.nextLine();
        String[][] s1 = obj.splitStringAndLength(s);
        System.out.println("Word and the length of each word is");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < s1[i].length; j++) {
                System.out.print(s1[i][j] + " ");
            }
            System.out.println();
        }
    }
}
