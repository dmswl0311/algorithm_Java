import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * 11552	80
 * @author CHO
 * @see https://www.acmicpc.net/problem/12904
 * @category 문자열
 * 백트래킹으로 S->T 유추했지만, 시간초과
 * T->S로 유추하면 경우의 수가 한번에 하나씩밖에 없기 때문에 T->S로 유추해야 함.
 * 배열을 직접 reverse하지 않고, rev 변수를 이용해서 reverse 구현
 */
public class BOJ_12904_A와B {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		String T = br.readLine(); //입력 완료

		ArrayList<Character> list=new ArrayList<>();
		for (int i = 0; i < T.length(); i++) {
			list.add(T.charAt(i));
		}// list에 T 문자 담기
		boolean rev=false; // 문자열 반대 여부 
		
		/*T로부터 S를 유추한다.
		 rev가 정방향 기준, 마지막 문자가 A일 때 이전에 실행한 연산은 1번
		 마지막 문자가 B일 때 이전에 실행한 연산은 2번 -> rev가 반대로 바뀌어야 함
		*/
		while(true) {
			if(list.size()==S.length()) break;
			if(!rev) {
				if(list.get(list.size()-1)=='A') {
					list.remove(list.size()-1);
				}else if(list.get(list.size()-1)=='B'){
					list.remove(list.size()-1);
					rev=true;
				}
			}else {
				if(list.get(0)=='A') {
					list.remove(0);
				}else if(list.get(0)=='B'){
					list.remove(0);
					rev=false;
				}
			}
		}
		
		// 반대여부에 따라 for문 다르게
		boolean dflag=true;
		if(!rev) {
			for (int i = 0; i < list.size(); i++) {
				if(list.get(i)==S.charAt(i)) continue;
				else {
					dflag=false;
					break;
				}
			}
		}else {
			int idx=0;
			for (int i = list.size()-1; i >=0; i--) {
				if(list.get(i)==S.charAt(idx)) {
					idx++;
					continue;
				}
				else {
					dflag=false;
					break;
				}
			}
		}
		if(dflag) {
			System.out.println(1);
		}else System.out.println(0);
	}
}
