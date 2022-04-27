package algo;

import java.io.*;
import java.util.*;

/**
 * 11664	76
 * @author CHO
 * @see https://www.acmicpc.net/problem/19236
 * @category DFS, 구현
 * @tip DFS가 return 되었을 때 원래 값으로 돌아가는 방법!
 * 삼성 SW 역량 테스트 기출
 */
public class BOJ_19236_청소년상어 {
	static class Fish {
		int x;
		int y;
		int num;
		int d;
		public Fish(int x, int y, int num, int d) {
			this.x = x;
			this.y = y;
			this.num = num;
			this.d = d;
		}
	}

	static class Shark {
		int x;
		int y;
		int d;
		public Shark(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}

	static StringTokenizer st;
	static int max;
	static int[][] dir = { { 0, 0 }, { -1, 0 }, { -1, -1 }, { 0, -1 }, { 1, -1 }, { 1, 0 }, { 1, 1 }, { 0, 1 },
			{ -1, 1 } };
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] map = new int[4][4]; // 번호 저장
		Fish[] fishList = new Fish[17];
		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				int a = Integer.parseInt(st.nextToken());// 번호
				int b = Integer.parseInt(st.nextToken());// 방향
				fishList[a] = new Fish(i, j, a, b); // 작은순으로 정렬 되어있음
				map[i][j] = a;
			}
		} // 입력 완료
		// 0,0 상어가 먹기
		Shark shark = new Shark(0, 0, fishList[map[0][0]].d);
		int result = map[0][0]; // 먹는 처리
		fishList[map[0][0]] = null; // 상어니까 null처리
		map[0][0] = -1; // -1은 상어, 0은 빈칸
		max=result;
		dfs(map, fishList, result, shark);
		System.out.println(max);
	}

	private static void dfs(int[][] map, Fish[] fishList, int result, Shark shark) {
		// 물고기 움직임
		for (int i = 1; i < fishList.length; i++) {
			Fish fish = fishList[i];
			if(fish==null) continue;
			int cnt=8;
			int d=fish.d;
			while (cnt-->0) {
				int nx = fish.x + dir[d][0];
				int ny = fish.y + dir[d][1];
				if (nx >= 0 && ny >= 0 && nx < 4 && ny < 4 && map[nx][ny] != -1) {
					if (map[nx][ny] == 0) {
						// 빈칸일 때
						fishList[map[fish.x][fish.y]]= new Fish(nx,ny,fish.num,d);//나의 정보 
						fishList[map[nx][ny]]= null;//상대방의 정보
						map[nx][ny]=fish.num; //이동할 위치에 내정보 넣기
						map[fish.x][fish.y]=0;
					} else if (map[nx][ny] >= 1) {
						// 물고기 일 때
						Fish temp=fishList[map[nx][ny]]; //이동할 fish 임시 저장
						fishList[map[fish.x][fish.y]]= new Fish(nx,ny,fish.num,d);//나의 정보 
						fishList[map[nx][ny]]= new Fish(fish.x,fish.y,temp.num,temp.d);//상대방의 정보
						map[nx][ny]=fish.num; //이동할 위치에 내정보 넣기
						map[fish.x][fish.y]=temp.num;
					}
					break;
				}
				d+=1;
				if(d>8) d=1;
			}
		}// 물고기 끝
		// 상어 움직임
		int cnt=4;
		int nx=shark.x;
		int ny=shark.y;
		while(cnt-->0) {
			if(nx<0 || ny<0 || nx>=4 || ny>=4) break;
			else {
				if(map[nx][ny]>=1) {
					// 물고기
					Fish temp=fishList[map[nx][ny]];
					int[][] copy_map=new int[4][4];
					for (int i = 0; i < 4; i++) {
						for (int j = 0; j < 4; j++) {
							copy_map[i][j] = map[i][j];
						}
					}
					Fish[] copy_fishList = new Fish[17];
					for (int i = 1; i < 17; i++) {
						copy_fishList[i] = fishList[i];
					} // 복사완료 -> dfs가 return 되었을 때 원래 값으로 돌아가기 위해
					Shark newShark=new Shark(nx, ny, temp.d);
					copy_map[nx][ny]=-1;
					copy_map[shark.x][shark.y]=0;
					copy_fishList[temp.num]=null;
					dfs(copy_map, copy_fishList, result+temp.num, newShark);
				}
				nx+=dir[shark.d][0];
				ny+=dir[shark.d][1];
			}
		}
		max=max<result?result:max;
		return;
	}
}
