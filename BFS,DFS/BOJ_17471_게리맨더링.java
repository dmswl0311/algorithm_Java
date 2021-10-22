import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 13316	128
 * @author Administrator
 * @see https://www.acmicpc.net/problem/17471
 * @category BFS,그래프
 */

public class BOJ_17471_게리맨더링 {
	static class Node{
		int vertex;
		Node link;
		
		public Node(int vertex, Node link) {
			super();
			this.vertex = vertex;
			this.link = link;
		}
		
	}
	static StringTokenizer st;
	static int N;
	static Node[] nodeList;
	static int[] pick;
	static ArrayList<Integer> not;
	static Queue<Integer> q;
	static boolean visited[];
	static int min;
	static int[] population;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		population=new int[N+1];
		st=new StringTokenizer(br.readLine());
		for (int i = 1; i < N+1; i++) {
			population[i]=Integer.parseInt(st.nextToken());
		}
		
		nodeList=new Node[N+1];
		for (int i = 1; i < N+1; i++) {
			st=new StringTokenizer(br.readLine());
			int n=Integer.parseInt(st.nextToken());
			for (int j = 0; j < n; j++) {
				int v=Integer.parseInt(st.nextToken());
				nodeList[i]=new Node(v, nodeList[i]);
				nodeList[v]=new Node(i, nodeList[v]);
			}
		}// 입력 완료
		
		// 모든 경우의 수 구해서 연결되어있는지 확인 -> 연결되어 있다면 인구수 차이 구함
		min=Integer.MAX_VALUE;
		for (int i = 1; i <= N/2; i++) {
			pick=new int[i]; //뽑힌거
			not=new ArrayList<Integer>(); //안뽑힌거
			combination(0,1,i);
		}
		if(min==Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(min);

	}
	private static void combination(int cnt, int start, int R) {
		if(cnt==R) {
			if(bfs()) {
				// 인구 수 구하기
				int pickCnt=0;
				int notCnt=0;
				for (int i = 0; i < pick.length; i++) {
					pickCnt+=population[pick[i]];
				}
				for (int i = 0; i < not.size(); i++) {
					notCnt+=population[not.get(i)];
				}
				int cal=Math.abs(pickCnt-notCnt);
				min=min>cal?cal:min;
			}
			not.clear();
			return;
		}
		for (int i = start; i < N+1; i++) {
			pick[cnt]=i;
			combination(cnt+1, i+1, R);
		}
		
	}
	private static boolean bfs() {
		q=new LinkedList<Integer>();
		visited=new boolean[N+1];
		
		q.add(pick[0]);
		visited[pick[0]]=true;
		while(!q.isEmpty()) {
			int curr=q.poll();
			
			for (Node next=nodeList[curr]; next!=null; next=next.link) {
				if(!visited[next.vertex]&&Arrays.binarySearch(pick, next.vertex)>=0) {
					q.add(next.vertex);
					visited[next.vertex]=true;
				}
			}
		}
		boolean flag=true;
		for (int i = 0; i < pick.length; i++) {
			if(!visited[pick[i]]) {
				flag=false;
				break;
			}
		}
		if(!flag) return false;

		// 안뽑은것도 bfs
		// 안뽑은 숫자 구하기
		for (int i = 1; i < N+1; i++) {
			flag=true;
			for (int j = 0; j < pick.length; j++) {
				if(i==pick[j]) {
					flag=false;
					break;
				}
			}
			if(flag) {
				not.add(i);
			}
		}
		
		q=new LinkedList<Integer>();
		visited=new boolean[N+1];
		q.add(not.get(0));
		visited[not.get(0)]=true;
		
		while(!q.isEmpty()) {
			int curr=q.poll();
			
			for (Node next=nodeList[curr]; next!=null; next=next.link) {
				if(!visited[next.vertex]&&not.contains(next.vertex)) {
					q.add(next.vertex);
					visited[next.vertex]=true;
				}
			}
		}
		flag=true;
		for (int i = 0; i < not.size(); i++) {
			if(!visited[not.get(i)]) {
				flag=false;
				break;
			}
		}
		if(!flag) return false;
		return true;
	}

}