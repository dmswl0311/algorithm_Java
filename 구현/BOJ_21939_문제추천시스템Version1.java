package algo;

import java.io.*;
import java.util.*;

public class BOJ_21939_문제추천시스템Version1 {
	static class Pro implements Comparable<Pro>{
		int num;
		int level;

		public Pro(int num, int level) {
			this.num = num;
			this.level = level;
		}

		@Override
		public int compareTo(Pro o) {
			if(this.level==o.level) {
				return Integer.compare(this.num, o.num);
			}
			return  Integer.compare(this.level, o.level);
		}

		
	}

	static StringTokenizer st;
	static StringBuilder sb=new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Map<Integer,Integer> map=new HashMap<Integer, Integer>();
		Map<Integer,Integer> em=new HashMap<Integer, Integer>();
		PriorityQueue<Pro> max=new PriorityQueue<>();
		PriorityQueue<Pro> min=new PriorityQueue<>(Collections.reverseOrder());
		
		for (int n = 0; n < N; n++) {
			st=new StringTokenizer(br.readLine());
			int P = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			max.add(new Pro(P, L));
			min.add(new Pro(P, L));
		}
		int M = Integer.parseInt(br.readLine());
		
		for (int m = 0; m < M; m++) {
			st=new StringTokenizer(br.readLine());
			String con = st.nextToken();
			if(con.equals("add")) {
				int P = Integer.parseInt(st.nextToken());
				int L = Integer.parseInt(st.nextToken());
				max.add(new Pro(P, L));
				min.add(new Pro(P, L));
			}else if(con.equals("recommend")) {
				int x = Integer.parseInt(st.nextToken());
				if(x==1) {
					while(!min.isEmpty()) {
						Pro rc=min.poll();
						if(em.containsKey(rc.num)) {
							em.remove(rc.num);
							continue;
						}
						if(map.containsKey(rc.num)){
							continue;
						}else {
							sb.append(rc.num+"\n");
							map.put(rc.num, 1);
							break;
						}
					}
				}else if(x==-1) {
					while(!max.isEmpty()) {
						Pro rc=max.poll();
						if(em.containsKey(rc.num)) {
							em.remove(rc.num);
							continue;
						}
						if(map.containsKey(rc.num) || em.containsKey(rc.num)){
							continue;
						}else {
							sb.append(rc.num+"\n");
							map.put(rc.num, 1);
							break;
						}
					}
				}
			}else if(con.equals("solved")) {
				int P = Integer.parseInt(st.nextToken());
				em.put(P, 1);
			}
		}
		System.out.println(sb);
	}
}
