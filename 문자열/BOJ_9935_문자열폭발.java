import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 92104	392
 * @author CHO
 * @see https://www.acmicpc.net/problem/9935, https://hsin.hr/coci/archive/2013_2014/ -> CONTEST #5
 * @category 문자열, 자료구조-스택
 * replace -> 메모리 초과
 * 단순 for문 비교 -> 시간 초과
 * deque, queue 두개 사용 -> 메모리 초과
 */
public class BOJ_9935_문자열폭발 {

	static StringTokenizer st;
	static StringBuilder sb=new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String bomb= br.readLine();// 입력 완료

		ArrayList<Character> list=new ArrayList<>();
		
		int i=0;
		while(true) {
			if(i==str.length()) break;
			list.add(str.charAt(i));
			// 방금 list에 넣은 문자가 bomb의 마지막 문자와 같을 경우 
			if(list.get(list.size()-1)==bomb.charAt(bomb.length()-1)) {
				boolean flag=true;
				int index=list.size()-1;
				for (int j = bomb.length()-2; j >=0; j--) {
					index-=1;
					// 만약 index가 0보다 크다면 
					if(index>=0) {
						if(list.get(index)==bomb.charAt(j)) {
							continue;
						}else {
							flag=false;
							break;
						}
					}else flag=false;
				}
				if(flag) {
					// 폭발 가능하므로 삭제
					index=list.size()-1;
					for (int j = 0; j < bomb.length(); j++) {
						list.remove(index--);
					}
				}
			}
			i++;
		}
		// 출력
		if(list.size()==0) sb.append("FRULA");
		else {
			for (int j = 0; j < list.size(); j++) {
				sb.append(list.get(j));
			}
		}
		System.out.println(sb);
	}
}
