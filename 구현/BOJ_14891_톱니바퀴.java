import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 11660	84
 * @author CHO
 * @see https://www.acmicpc.net/problem/14891
 * @category 구현
 * 문제 잘 이해하기 -> 한턴에 한번씩만 톱니바퀴 회전함
 */
public class BOJ_14891_톱니바퀴 {
	static class state{
		int start;
		int dir;
		
		public state(int start, int dir) {
			super();
			this.start = start;
			this.dir = dir;
		}
		
	}
	static StringTokenizer st;
	static StringBuilder sb=new StringBuilder();
	static int list[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int result=0;
		list=new int[5][8];
		for (int i = 1; i < 5; i++) {
			String str=br.readLine();
			for (int j = 0; j < 8; j++) {
				list[i][j]=str.charAt(j)-'0';
			}
		}
		// 입력 받음과 동시에 처리
		int K= Integer.parseInt(br.readLine());
		for (int i = 0; i < K; i++) {
			st=new StringTokenizer(br.readLine());
			int start=Integer.parseInt(st.nextToken());
			int dir=Integer.parseInt(st.nextToken());
			int ori=start;
			int ori_dir=dir;
			
			// 회전할 리스트와, 방향이 들어가는 arraylist
			ArrayList<state> state_list=new ArrayList<>();
			state_list.add(new state(ori, ori_dir));
			
			// 오른쪽으로 확인
			int flag=1;
			while(true) {
				if(start+flag<5) {
					if(list[start][2]==list[start+flag][6]) break;
					state_list.add(new state(start+flag, dir*-1));
					start=start+flag;
					dir*=-1;
				}else break;
			}
			// 왼쪽으로 확인
			start=ori;
			dir=ori_dir;
			flag*=-1;
			while(true) {
				if(start+flag>0) {
					if(list[start][6]==list[start+flag][2]) break;
					state_list.add(new state(start+flag, dir*-1));
					start=start+flag;
					dir*=-1;
				}else break;
			}
			
			// 회전 처리
			for (int j = 0; j < state_list.size(); j++) {
				state curr=state_list.get(j);
				if(curr.dir==1) dir1(curr.start);
				else dir2(curr.start);
			}
		
//				System.out.println("회전 결과 확인 "+Arrays.deepToString(list));
		} 
		for (int r = 1; r < 5; r++) {
			if(list[r][0]==1) {
				result+=Math.pow(2, r-1);
			}
		}
		System.out.println(result);

	}
	
	private static void dir1(int start) {
		// 시계방향 회전
		int swap=list[start][7];
		for (int i = 6; i >= 0; i--) {
			list[start][i+1]=list[start][i];
		}
		list[start][0]=swap;
		
	}
	private static void dir2(int start) {
		// 반시계방향 회전
		int swap=list[start][0];
		for (int i = 1; i < 8; i++) {
			list[start][i-1]=list[start][i];
		}
		list[start][7]=swap;
	}

}
