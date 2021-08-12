import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 순열 visited -> flag로 바꿔서 풀어봄
 * 논리연산자 이용
 */
public class SWEA_6808_규영인영이의카드게임 {
	static StringBuilder sb=new StringBuilder();
	static StringTokenizer st;
	static int kyu[];
	static int in[];
	static int card[];
	static int kwin,iwin;
	static int resultw,resultl;
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t < T + 1; t++) {
			kyu=new int[9];
			in=new int[9];
			card=new int[9];
			st=new StringTokenizer(br.readLine());
			for (int i=0; i<9; i++) {
				kyu[i]=Integer.parseInt(st.nextToken());
			} // 규영 카드 입력
			int cnt=0;
			int flag=0;
			for (int i=1; i<=18; i++) {
				flag=0;
				for(int x:kyu) {
					if (i==x) {
						flag=1;
						break;
					}
				}
				if (flag==0) {
					in[cnt]=i;
					cnt++;
				}
			}
		
			kwin=0;
			iwin=0;
			resultw=0;
			resultl=0;
			permutation(0,0);
			
			sb.append("#").append(t).append(" ").append(resultw).append(" ").append(resultl).append("\n");
		}
		System.out.println(sb);
	}
	private static void permutation(int ct,int flag) {
		if (ct==9) {
			for (int i=0; i<9; i++) {
				if(kyu[i]>card[i]) kwin+=kyu[i]+card[i];
				else iwin+=kyu[i]+card[i];
			}
			if(kwin>iwin) resultw++;
			else resultl++;
			kwin=0;
			iwin=0;
			return;
		}
		for (int i=0; i<9; i++) {
			if((flag&1<<i)!=0) continue;
			card[ct]=in[i];
			permutation(ct+1,(flag|1<<i));
		}
	}
	
}
