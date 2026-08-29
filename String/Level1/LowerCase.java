package com.gla.Level1;
import java.util.Scanner;
public class LowerCase {
    public String toLowerCase(String str)
    {
        String s="";
        for(int i=0;i<str.length();i++)
        {
            char ch=str.charAt(i);
            if(ch>='A'&&ch<='Z') {
                ch = (char) (ch + 32);
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
        LowerCase obj=new LowerCase();
        System.out.println("Enter the string in uppercase");
        String s=sc.nextLine();
        String s1=obj.toLowerCase(s);
        String s2=s.toLowerCase();
        boolean result=obj.compareString(s1,s2);
        System.out.println("Converted to Lowercase using user defined method = "+s1);
        System.out.println("Converted to Lowercase using in built method = "+s2);
        System.out.println("Comparing the two strings to see if they are equal (true=Yes,false=No)");
        System.out.println(result);
    }
}