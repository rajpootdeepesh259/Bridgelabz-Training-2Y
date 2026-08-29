package com.gla.Level1;
import java.util.Scanner;
public class UpperCase {
    public String toUppercase(String str)
    {
        String s="";
        for(int i=0;i<str.length();i++)
        {
            char ch=str.charAt(i);
            if(ch>='a'&&ch<='z') {
                ch = (char) (ch - 32);
            }
            s+=ch;
        }
        return s;
    }
    public boolean compareString(String str1,String str2)
    {
        if(str1.length()!=str2.length())
        {
            return false;
        }
        for(int i=0;i<str1.length();i++)
        {
            if(str1.charAt(i)!=str2.charAt(i))
            {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        UpperCase obj=new UpperCase();
        System.out.println("Enter the string in lowercase");
        String s=sc.nextLine();
        String s1=obj.toUppercase(s);
        String s2=s.toUpperCase();
        boolean result=obj.compareString(s1,s2);
        System.out.println("Converted to Uppercase using user defined method = "+s1);
        System.out.println("Converted to Uppercase using in built method = "+s2);
        System.out.println("Comparing the two strings to see if they are equal (true=Yes,false=No)");
        System.out.println(result);
    }
}