import java.util.Scanner;

public class BOJ_6550 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		String s="";
		while((s=scan.next())!=null) {
			String t=scan.next();
			
			if (t.contains(s)==true) {
				System.out.println("Yes");
			}else {
				System.out.println("No");
			}
		}

	}
}
