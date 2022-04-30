package 구현;

import java.io.*;
import java.util.*;

/**
 * 21776	192
 * @author CHO
 * @see https://www.acmicpc.net/status?user_id=whdmswlek&problem_id=19237&from_mine=1
 * @category 구현
 * @tip 문제 잘 읽기, 배열 어떤걸로 쓸지 정하기, 배열이라고 무조건 2중포문 돌지 않기
 */
public class BOJ_19237_어른상어2 {
	static class Shark {
		int x;
		int y;
		int d;
		List<ArrayList<Integer>> order;

		public Shark(int x, int y, int d, List<ArrayList<Integer>> order) {
			this.x = x;
			this.y = y;
			this.d = d;
			this.order = order;
		}

		public Shark(int d, List<ArrayList<Integer>> order) {
			this.d = d;
			this.order = order;
		}

	}

	static StringTokenizer st;
	static int N, M, k;
	static int[][] dir = { { 0, 0 }, { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());// 상어 갯수
		k = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][N];
		Shark[] sharkList = new Shark[M + 1];
		int[][] time = new int[N][N];
		int[][] smell = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] != 0) {
					List<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
					sharkList[map[i][j]] = new Shark(i, j, 0, list);
					smell[i][j] = map[i][j];
					time[i][j] = k;
				}
			}
		}
		// 방향
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < M + 1; i++) {
			int d = Integer.parseInt(st.nextToken());
			sharkList[i].d = d;
		}
		// 우선순위
		for (int i = 1; i < M + 1; i++) {
			Shark shark = sharkList[i];
			List<ArrayList<Integer>> list = shark.order;
			for (int j = 0; j <= 4; j++) {
				list.add(new ArrayList<Integer>());
			}
			for (int j = 1; j < 4 + 1; j++) {
				st = new StringTokenizer(br.readLine());
				list.get(j).add(0);
				for (int h = 0; h < 4; h++) {
					list.get(j).add(Integer.parseInt(st.nextToken()));
				}
			}
		} // 입력 완료
		int cnt = move(map, sharkList, smell, time);
		System.out.println(cnt);
	}

	private static int move(int[][] map, Shark[] sharkList, int[][] smell, int[][] time) {
		int countTime = 0;
		while (true) {
			if (M == 1)
				break;
			if (countTime >=1000) {
				countTime = -1;
				break;
			}
			int[][] copy_map = new int[N][N];
			int[][] copy_smell = new int[N][N];
			for (int i = 1; i < sharkList.length; i++) {
				if (sharkList[i] == null)
					continue;
				Shark shark = sharkList[i];
				int x = shark.x;
				int y = shark.y;
				boolean flag=false;

				// 우선순위
				ArrayList<Integer> list = shark.order.get(shark.d);
				for (int v = 1; v < list.size(); v++) {
					int ni = x + dir[list.get(v)][0];
					int nj = y + dir[list.get(v)][1];
					if (ni >= 0 && nj >= 0 && ni < N && nj < N) {
						if (smell[ni][nj] == 0) {
							if (copy_map[ni][nj] == 0) {
								copy_map[ni][nj] = i;
								copy_smell[ni][nj] = i;
								sharkList[i].d = list.get(v);
								sharkList[i].x = ni;
								sharkList[i].y = nj;
							} else {
								sharkList[i] = null;
								M--;
							}
							flag=true;
							break;
						}
						
					}
				}
				if(!flag) {
					// 내 냄새와 같은 곳 찾기
					for (int v = 1; v < list.size(); v++) {
						int ni = x + dir[list.get(v)][0];
						int nj = y + dir[list.get(v)][1];
						if (ni >= 0 && nj >= 0 && ni < N && nj < N) {
							if (smell[ni][nj] == i) {
								if (copy_map[ni][nj] == 0) {
									copy_map[ni][nj] = i;
									copy_smell[ni][nj] = i;
									sharkList[i].d = list.get(v);
									sharkList[i].x = ni;
									sharkList[i].y = nj;
								} else {
									sharkList[i] = null;
									M--;
								}
								break;
							}
							
						}
					}
				}
			}
			// 상어 위치 map에 넣어주기
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = copy_map[i][j];
				}
			}

			// 냄새 pq에 더한거 smell에 넣어주기, 원래 smell은 time-1
			// 냄새에서 1을 뺐는데 0 이하면 없애주기

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (smell[i][j] > 0) {
						time[i][j] -= 1;
						if (time[i][j] <= 0) {
							smell[i][j] = 0;
							time[i][j] = 0;
						}
					}
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (copy_smell[i][j] != 0) {
						smell[i][j] = copy_smell[i][j];
						time[i][j] = k;
					}
				}
			}

			
			countTime++;
		}
		// 없애기
		return countTime;
	}

}