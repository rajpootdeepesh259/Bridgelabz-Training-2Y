package com.gla.Level1;
import java.util.Scanner;
public class Equal {
    public boolean compareString(String s1,String s2)
    {
        if(s1.length()!=s2.length())
        {
            return false;
        }
        else
        {
            for(int i=0;i<s1.length();i++){
                if(s1.charAt(i)!=s2.charAt(i))
                {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the two strings");
        String str1=sc.next();
        String str2=sc.next();
        Equal cs=new Equal();
        System.out.println(cs.compareString(str1,str2));
    }
}