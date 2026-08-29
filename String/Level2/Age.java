package com.gla.Level2;
import java.util.Scanner;
public class Age {
    public String[][] checkAge(int[] a)
    {
        String[][] check=new String[2][10];
        for(int i=0;i<2;i++) {
            for (int j = 0; j < 10; j++) {
                if (i == 0) {
                    check[i][j]=String.valueOf(a[j]);
                }
                else if(i==1) {
                    if (a[j] >= 18) {
                        check[i][j] = "true";
                    } else {
                        check[i][j] = "false";
                    }
                }
            }
        }
        return check;
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        Age obj=new Age();
        int[] age=new int[10];
        System.out.println("Enter ages of 10 Students");
        for(int i=0;i<10;i++)
        {
            age[i]=sc.nextInt();
        }
        String[][] result= obj.checkAge(age);
        System.out.println("Result of whether the 10 students can vote or not is");
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                System.out.print(result[i][j]+" ");
            }
            System.out.println();
        }
    }
}
