package com.gla.Level2;
import java.util.Scanner;
public class SplitLargestAndSmallest {
    public int[] smallestAndLargest(String str)
    {
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

        int[] length=new int[words.length];
        for (int i = 0; i < words.length; i++)
        {
            length[i]=words[i].length();
        }
        int max=length[0];
        int min=length[0];
        for(int i =1;i<length.length;i++)
        {
            if(length[i]>max)
            {
                max=length[i];
            }
            if(length[i]<min)
            {
                min=length[i];
            }
        }
        int[] result=new int[2];
        result[0]=max;
        result[1]=min;
        return result;
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        SplitLargestAndSmallest obj=new SplitLargestAndSmallest();
        System.out.println("Enter the string");
        String s=sc.nextLine();
        int[] l= obj.smallestAndLargest(s);
        System.out.println("The largest Length and the smallest length of the string is");
        System.out.println(l[0]+" "+l[1]);
    }
}