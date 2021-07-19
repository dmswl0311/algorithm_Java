import java.util.Scanner;

public class BOJ_10952 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		while(true) {
			int A=scan.nextInt();
			int B=scan.nextInt();
			if (A==0 & B==0) {
				break;
			}
			System.out.println(A+B);
		}
		scan.close();
	}

}
