import java.io.*;
import java.util.*;

/**
 * 18724   152
 * @author CHO
 * @see https://www.acmicpc.net/problem/1967
 * @category 트리, DFS
 */

public class BOJ_1967_트리의지름 {
   static class Node{
      int vertex;
      Node link;
      int w;
      public Node(int vertex, Node link, int w) {
         super();
         this.vertex = vertex;
         this.link = link;
         this.w = w;
      }
   }
   static StringTokenizer st;
   static boolean[] visited;
   static int r;
   static Node[] list;
   static int v;
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      list=new Node[n+1];
      for (int i = 0; i < n-1; i++) {
         st=new StringTokenizer(br.readLine());
         int a=Integer.parseInt(st.nextToken());
         int b=Integer.parseInt(st.nextToken());
         int w=Integer.parseInt(st.nextToken());
         list[a]=new Node(b, list[a], w);
         list[b]=new Node(a, list[b], w);
      }
      
      r=0;
      int len=0;
      visited=new boolean[n+1];
      dfs(1,len);
      r=0;
      visited=new boolean[n+1];
      dfs(v,len);
      System.out.println(r);
   }
   private static void dfs(int i,int len) {
      visited[i]=true;
      for (Node next=list[i]; next!=null; next=next.link) {
         if(!visited[next.vertex]) {
            dfs(next.vertex, len+next.w);
         }
      }
      if(r<len) {
         r=len;
         v=i;
      }
   }
}