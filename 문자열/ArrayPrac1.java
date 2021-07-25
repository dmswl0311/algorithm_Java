import java.util.Scanner;

public class ArrayPrac1 {
	
	/*
	 * 문자열에서 원하는 숫자의 개수 구하기
	 * ex) 입력 : 12345461141456554885
	 * 문자열에서 숫자 하나씩 떼기 -> 문자열.charAt(index) -> char를 int로 -'0'
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		
		String list=scan.next();
		int num=scan.nextInt();
		int cnt=0;
		
		for (int i=0; i<list.length(); i++) {
			if((list.charAt(i)-'0')==num) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}

}
