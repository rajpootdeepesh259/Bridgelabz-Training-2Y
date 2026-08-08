import java.util.Scanner;
class average
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter three numbers");
		int a=sc.nextInt();
		int b=sc.nextInt();
		int c=sc.nextInt();
		int Average=(a+b+c)/3;
		System.out.println("Average is="+Average);
	}
}
