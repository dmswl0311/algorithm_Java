import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
/**
 * 15152	512
 * @author CHO
 * @see https://www.acmicpc.net/problem/2239
 * @category 백트래킹
 */
public class Main {
	static int[][] map;
	static ArrayList<int[]> zero;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map=new int[9][9];
		zero=new ArrayList<>(); // 0인 좌표들 저장
		for (int i = 0; i < 9; i++) {
			String str=br.readLine();
			for (int j = 0; j < 9; j++) {
				map[i][j]=str.charAt(j)-'0';
				if(map[i][j]==0) zero.add(new int[] {i,j});
			}
		}// 입력 완료
		
		solve(0);
		
	}

	private static boolean solve(int index) {
		if(index==zero.size()) {
			// 기저 조건 : 0이 다 채워지면 끝남
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
			return true;
		}
		int xy[]=zero.get(index);
		int x=xy[0];
		int y=xy[1];
		for (int i = 1; i <= 9; i++) {
			// 숫자 넣어보기 
			
			// 괜찮으면 다음 index로 
			if(canUse(x,y,i)) {
				map[x][y]=i;
				if(solve(index+1)) {
					return true;
				}
			}
			map[x][y]=0;
		}
		return false;
	}

	private static boolean canUse(int i, int j, int v) {
		// 혹시 행에 같은 값?
		for(int r = 0; r< 9; r++) {
			if(map[r][j]==v) return false;
		}
		
		// 혹시 열에 같은 값?
		for (int c = 0; c <9; c++) {
			if(map[i][c]==v) return false;
		}
		
		// 3*3 사각형 영역에서 같은 값?
		int sr=(i/3)*3;
		int sc=(j/3)*3;
		for (int r = sr; r < sr+3; r++) {
			for (int c = sc; c < sc+3; c++) {
				if(map[r][c]==v) return false;
			}
		}
		
		return true;
	}

}