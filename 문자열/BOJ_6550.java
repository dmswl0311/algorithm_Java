import java.util.Scanner;

public class BOJ_6550 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		
		while(scan.hasNext()) {
			String[] str=scan.nextLine().split(" ");
			String s=str[0];
			String t=str[1];
			String result="Yes";
			
			if (t.contains(s)==true) {
				System.out.println("Yes");
			}else {
				outer: for(int i=0; i<s.length(); i++) {
					for (int j=0; j<t.length(); j++) {
						if (s.charAt(i)==t.charAt(j)) {
							t=(String) t.subSequence(j+1, t.length());
							break;
						}
						if (j==t.length()-1) {
							result="No";
							break outer;
						}
					}
				}
			System.out.println(result);
			}
		}
	}
}
