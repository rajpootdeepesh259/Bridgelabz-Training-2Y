import java.util.Scanner;
class parameter
{
	public static void main(String args[])
	{
		Scanner sc =new Scanner(System.in);
		System.out.println("enter length");
		int l=sc.nextInt();
		System.out.println("enter bredth");
		int b=sc.nextInt();
		int parameter=2*(l+b);
		System.out.println("Parameter is:-"+parameter);
	}
}
