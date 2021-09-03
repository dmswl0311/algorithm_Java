package MST;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Kruskal
 * MST
 * @author CHO
 *
 */
public class MSTKruskalTest {
	
	// 간선 ===========================================
	static class Edge implements Comparable<Edge>{
		int start,end,weight;

		public Edge(int start, int end, int weight) {
			super();
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
		
		// 오름차순 정렬을 하기 위함
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
		
	}

	// 서로소 집합 ===========================================
	
	// 모든 원소를 자신을 대표자로 만듦 
	
	private static void make() {
		parents=new int[V];
		for (int i = 0; i <V; i++) {
			parents[i]=i;
		}
	}
	
	// x가 속한 집합의 대표자 찾기
	private static int find(int x) {
		// 자신이 곧 대표자
		if(x==parents[x]) return x;
		// pass compression, 자신이 속한 집합의 대표자를 자신의 부모로 만든다
		return parents[x]=find(parents[x]);
	}
	
	// boolean은 union 성공/실패 여부
	private static boolean union(int x,int y) {
		int xRoot=parents[x];
		int yRoot=parents[y];
		// 이미 같은 union
		if (xRoot==yRoot) return false;
		// 편의상 오른쪽에 붙여줌 
		// 여기서 rank 관리코드 적을 수도..
		parents[yRoot]=xRoot;
		return true;
	}
	
	static int[] parents; // 부모원소를 관리 (트리처럼)
	static StringTokenizer st;
	static int V,E;
	static Edge[] edgeList;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st=new StringTokenizer(br.readLine());
		V=Integer.parseInt(st.nextToken());
		E=Integer.parseInt(st.nextToken());
		
		// 간선리스트 작성
		edgeList=new Edge[E];
		for (int i = 0; i < E; i++) {
			st=new StringTokenizer(br.readLine());
			int start=Integer.parseInt(st.nextToken());
			int end=Integer.parseInt(st.nextToken());
			int weight=Integer.parseInt(st.nextToken());
			edgeList[i]=new Edge(start,end,weight);
		}
		
		// 오름차순 정렬
		Arrays.sort(edgeList);
		
		make(); // 모든 정점을 각각의 집합으로 만들고 출발
		
		int cnt=0,result=0;;
		// 간선 하나씩 시도하며 트리를 만들어감
		for(Edge edge : edgeList) {
			if(union(edge.start,edge.end)) {
				cnt++;
				result+=edge.weight;
				if (cnt==V-1) break;
			}
		}
		
		System.out.println(cnt+" "+result);
	}
}