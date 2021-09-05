import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_11651_좌표정렬하기2 {
	static StringTokenizer st;
	static int[][] list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		list=new int[N][2];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int x=Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			list[i]=new int[] {x,y};
		}
		Arrays.sort(list,new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1]==o2[1]) {
					return Integer.compare(o1[0], o2[0]);
				}return Integer.compare(o1[1], o2[1]);
			}
		});
		for (int i = 0; i < N; i++) {
			System.out.println(list[i][0]+" "+list[i][1]);
		}
	}

}
