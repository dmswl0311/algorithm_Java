package algo;

import java.io.*;
import java.util.*;
import java.util.Map.*;

/**
 * 81096	868
 * @author CHO
 * @see https://www.acmicpc.net/problem/13414
 * @category 정렬
 * @tip map value로 정렬
 */
public class BOJ_13414_수강신청 {
	
	static StringTokenizer st;
	static StringBuilder sb=new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st=new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		Map<String,Integer> map=new HashMap<String, Integer>();
		for (int l = 1; l < L+1; l++) {
			String input=br.readLine();
			map.put(input, l);
		}
		List<Entry<String, Integer>> entry=new ArrayList<Map.Entry<String,Integer>>(map.entrySet());
		Collections.sort(entry,new Comparator<Entry<String, Integer>>() {

			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				return o1.getValue()-o2.getValue();
			}
		});
		int cnt=0;
		for(Entry<String, Integer> e:entry) {
			if(cnt==K) break;
			sb.append(e.getKey()+"\n");
			cnt++;
		}
		System.out.println(sb);
		
		
	}
}
