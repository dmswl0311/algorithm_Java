package collections;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

//class xy implements Comparable<xy>{
//	int x;
//	int y;
//	public xy(int x, int y) {
//		super();
//		this.x = x;
//		this.y = y;
//	}
//	@Override
//	public int compareTo(xy o) {
//		if(this.x==o.x) {
//			return Integer.compare(this.y, o.y);
//			
//		}
//		return Integer.compare(this.x, o.x);
//	}
//	
//}

public class BOJ_11650_좌표정렬하기 {
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		ArrayList<int[]> s=new ArrayList<int[]>();
		for (int n=0; n<N; n++) {
			int arr[]=new int[2];
			st = new StringTokenizer(br.readLine());
			arr[0]=Integer.parseInt(st.nextToken());
			arr[1]=Integer.parseInt(st.nextToken());
			s.add(arr);
		}
		Collections.sort(s,new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0]==o2[0]) {
					return Integer.compare(o1[1], o2[1]);
				}
				return Integer.compare(o1[0], o2[0]);
			}
		});
		for (int i=0; i<s.size(); i++) {
			System.out.println(s.get(i)[0]+" "+s.get(i)[1]);
		}
	}
	
	
}
