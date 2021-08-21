import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @see http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=1006&sca=20
 * 오목이 될 수 있는 조건**
 * 1. 왼쪽에 있는 좌표값 출력 -> 오목의 체크방향 왼쪽 우선
 * 2. 따로 범위 체크 x -> 배열의 크기 +2씩 
 * 3. 이미 체크한 방향 다시 체크하지 않도록 반대방향 값 확인
 * 
 */
public class Jungol_1733_오목 {
	static int[][] map;
	static StringTokenizer st;
	static StringBuilder sb=new StringBuilder();
	static int dx[]= {-1,1,1,0}; //오목의 체크 방향 왼쪽 우선!
	static int dy[]= {1,1,0,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			map=new int[21][21]; // 범위체크 하지 않기 위해 19+2로 
			
			for (int i = 1; i <= 19; i++) {
				st=new StringTokenizer(br.readLine());
				for (int j = 1; j <= 19; j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			for (int x = 1; x <= 19; x++) {
				for (int y = 1; y <= 19; y++) {
					int currVal=map[x][y];
					if(currVal!=0) {
						for (int d=0; d<4; d++) {
							// 진행방향의 반대쪽이 나와 같은 숫자면, 지금 진행방향은 이미 확인했으므로
							if (currVal==map[x+dx[d]*-1][y+dy[d]*-1]) continue;
							int count=1;
							// 지금 진행방향으로 계속 가봄 **
							while(currVal==map[x+dx[d]*count][y+dy[d]*count]) count++;
							if(count==5) {
								System.out.println(currVal);
								System.out.print(x+" "+y);
								return;
							}
						}
					}
				}
			}
			System.out.println(0);
	}

}
