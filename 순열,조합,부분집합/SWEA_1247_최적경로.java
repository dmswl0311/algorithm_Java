import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * @see https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15OZ4qAPICFAYD&categoryId=AV15OZ4qAPICFAYD&categoryType=CODE&problemTitle=1247
 * 순열, 시간을 더 줄일 방법은..? -> 백트래킹?
 */
public class SWEA_1247_최적경로 {
    static int N,M;
    static StringBuilder sb=new StringBuilder();
    static StringTokenizer st;
    static int company[];
    static int home[];
    static int input[][];
    static int pick[];
    static int min;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int T= Integer.parseInt(br.readLine());
        for (int t=1; t<T+1; t++) {
            N=Integer.parseInt(br.readLine());
            input=new int[N][2];
            company=new int[2];
            home=new int[2];
            st=new StringTokenizer(br.readLine());
            company[0]=Integer.parseInt(st.nextToken());
            company[1]=Integer.parseInt(st.nextToken());
            home[0]=Integer.parseInt(st.nextToken());
            home[1]=Integer.parseInt(st.nextToken());
            for (int i = 0; i < N; i++) {
                input[i][0]=Integer.parseInt(st.nextToken()); //x좌표
                input[i][1]=Integer.parseInt(st.nextToken()); //y좌표
            }
            min=Integer.MAX_VALUE;
            pick=new int[N];
            permutation(0,0);
            sb.append("#").append(t).append(" ").append(min).append("\n");
        }
        System.out.println(sb);
    }
    private static void permutation(int cnt, int flag) {    
        if (cnt==N) {
            int dist=0;
            dist+=Math.abs(input[pick[0]][0]-company[0])+Math.abs(input[pick[0]][1]-company[1]);
            int x=input[pick[0]][0];
            int y=input[pick[0]][1];
            for (int i=1; i<N; i++) {
                dist+=Math.abs(x-input[pick[i]][0])+Math.abs(y-input[pick[i]][1]);
                if (dist>min) {
                    return;
                }
                x=input[pick[i]][0];
                y=input[pick[i]][1];
            }
            dist+=Math.abs(x-home[0])+Math.abs(y-home[1]);
            min=min>dist?dist:min;
            return;
        }
        for (int i=0; i<N; i++) {
            if((flag&1<<i)!=0) continue;
            pick[cnt]=i;
            permutation(cnt+1, flag|1<<i);
        }
         
    }
 
}