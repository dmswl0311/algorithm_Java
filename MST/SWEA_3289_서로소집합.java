import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_3289_서로소집합 {
	public static void make() {
		for (int i = 0; i < n+1; i++) {
			parents[i]=i;
		}
	}
	public static int find(int x) {
		if(x==parents[x]) return x;
		return parents[x]=find(parents[x]);
	}
	
	public static void union(int x,int y) {
		int xRoot=find(x);
		int yRoot=find(y);
		if (xRoot!=yRoot) {
			parents[yRoot]=xRoot;
		}
	}

	static int[] parents;
	static StringTokenizer st;
	static StringBuilder sb=new StringBuilder();
	static int n,m;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t < T + 1; t++) {
			sb.append("#").append(t).append(" ");
			st=new StringTokenizer(br.readLine());
			n=Integer.parseInt(st.nextToken());
			m=Integer.parseInt(st.nextToken());
			parents=new int[n+1];
			make();
			for (int i = 0; i < m; i++) {
				st=new StringTokenizer(br.readLine());
				int num=Integer.parseInt(st.nextToken());
				int a=Integer.parseInt(st.nextToken());
				int b=Integer.parseInt(st.nextToken());
				if (num==0) union(a,b);
				else if (num==1) {
					if(find(a)==find(b)) sb.append(1);
					else sb.append(0);
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}