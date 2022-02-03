import java.io.*;
import java.util.*;
import java.util.Map.*;

/**
 * 11668	84
 * @author CHO
 * @see https://www.acmicpc.net/problem/1339
 * @category 그리디
 * !자리수의 합 계산, Map value로 정렬
 */
public class BOJ_1339_단어수학 {
	
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] match=new int[26];
		HashMap<Character, Integer> map=new HashMap<>();
		String[] list=new String[N];
		for (int i = 0; i < N; i++) {
			String str=br.readLine();
			list[i]=str;
			for (int j = str.length()-1; j >=0; j--) {
				char cur=str.charAt(j);
				if(map.containsKey(cur)) {
					int v=map.get(cur);
					map.put(cur, v+(int) Math.pow(10, str.length()-1-j));
				}else {
					map.put(cur, (int) Math.pow(10, str.length()-1-j));
				}
			}
		}// 자리수 합 계산
		
		// Map 내림차순 정렬
		List<Entry<Character, Integer>> list_entries = new ArrayList<Entry<Character, Integer>>(map.entrySet());

		Collections.sort(list_entries, new Comparator<Entry<Character, Integer>>() {
			public int compare(Entry<Character, Integer> o1, Entry<Character, Integer> o2) {
				return o2.getValue().compareTo(o1.getValue());
			}
		});
		
		// 숫자 지정
		int d=9;
		for(Entry<Character, Integer> entry : list_entries) {
			match[entry.getKey()-65]=d;
			d--;
		}
		
		// 계산
		int result=0;
		for (int i = 0; i < list.length; i++) {
			String cur=list[i];
			int a=cur.length()-1;
			for (int j = 0; j < cur.length(); j++) {
				result+=(match[cur.charAt(j)-65])*Math.pow(10, a);
				a--;
			}
		}
		
		System.out.println(result);

	}
}
