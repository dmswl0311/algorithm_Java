import java.util.Arrays;
import java.util.Scanner;

public class BOJ_11720 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int sum=0;
		int t=scan.nextInt();
		String[] numArray=scan.next().split("");
		for (int i=0; i<t; i++) {
			sum+=Integer.parseInt(numArray[i]);
		}
		System.out.println(sum);
	}
}
