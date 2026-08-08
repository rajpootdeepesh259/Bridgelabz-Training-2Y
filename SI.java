import java.util.Scanner;
class SI
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("principle is=");
		int p=sc.nextInt();
		System.out.println("rate is=");
		int r=sc.nextInt();
		System.out.println("time is=");
		int t=sc.nextInt();
		int Si=p*r*t;
		System.out.println("Simple interest is="+Si);
	}
}

		