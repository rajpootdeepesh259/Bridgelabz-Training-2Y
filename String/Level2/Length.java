package com.gla.Level2;
import java.util.Scanner;
public class Length {
    public int stringLength(String str)
    {
        int count=0;
        char[] ch=str.toCharArray();
        for(int i=0;i<ch.length;i++)
        {
            count++;
        }
        return count;
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        Length obj=new Length();
        System.out.println("Enter the string");
        String s=sc.nextLine();
        int l1=obj.stringLength(s);
        int l2=s.length();
        System.out.println("The length of string using user defined method = "+l1);
        System.out.println("The length of string in built method = "+l2);
    }
}
