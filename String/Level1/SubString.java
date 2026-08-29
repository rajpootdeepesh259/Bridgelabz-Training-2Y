package com.gla.Level1;
import java.util.Scanner;
public class SubString {
    public String ByCHARAT(String str,int start,int end)
    {
        String s="";
        for(int i=start;i<end;i++)
        {
            s=s+str.charAt(i);
        }
        return s;
    }
    public String BYSUBSTRING(String str,int start,int end)
    {
        String s=str.substring(start,end);
        return s;
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        SubString sub=new SubString();
        System.out.println("Enter the string, start of substring and end of substring");
        String str=sc.next();
        int start=sc.nextInt();
        int end=sc.nextInt();
        String str1=sub.ByCHARAT(str,start,end);
        String str2=sub.BYSUBSTRING(str,start,end);
        if(str1.equals(str2))
        {
            System.out.println("Both Methods give the same substring");
            System.out.println(str1+" "+str2);
        }
        else{
            System.out.println("Both Methods do not give the same substring");
        }
    }
}
