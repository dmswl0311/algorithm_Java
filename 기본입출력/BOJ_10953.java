import java.util.Arrays;
import java.util.Scanner;

public class BOJ_10953 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int t=scan.nextInt();
		for (int i = 0; i<t; i++) {
			// next()와 nextline()의 차이점!!
			String str=scan.next();
			String[] str2=str.split(",");
			System.out.println(Integer.parseInt(str2[0])+Integer.parseInt(str2[1]));
		}
		scan.close();
	}

}
