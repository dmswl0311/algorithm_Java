import java.io.*;
import java.util.*;

/**
 * 11820	88
 * @author CHO
 * @see https://www.acmicpc.net/problem/2174
 * @category 구현
 */

public class BOJ_2174_로봇시뮬레이션{
	static class Robot {
		int x;
		int y;
		char dir;

		public Robot(int x, int y, char dir) {
			this.x = x;
			this.y = y;
			this.dir = dir;
		}
	}
	static StringTokenizer st;
	static int A, B;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ArrayList<Robot> robots = new ArrayList<>(); // 로봇 정보 담을 리스트
		robots.add(new Robot(0, 0, 'A')); // 0번째 임시값 넣어줌
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			char d = st.nextToken().charAt(0);
			robots.add(new Robot(x, y, d));
		}
		boolean flag = false;
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			char j = st.nextToken().charAt(0);
			int k = Integer.parseInt(st.nextToken());
			if (flag)
				continue;
			Robot cur = robots.get(i);
			outer: for (int r = 0; r < k; r++) {
				if (j == 'L') {
					if (cur.dir == 'W') {
						cur.dir = 'S';
					} else if (cur.dir == 'S') {
						cur.dir = 'E';
					} else if (cur.dir == 'E') {
						cur.dir = 'N';
					} else if (cur.dir == 'N') {
						cur.dir = 'W';
					}
				} else if (j == 'R') {
					if (cur.dir == 'W') {
						cur.dir = 'N';
					} else if (cur.dir == 'N') {
						cur.dir = 'E';
					} else if (cur.dir == 'E') {
						cur.dir = 'S';
					} else if (cur.dir == 'S') {
						cur.dir = 'W';
					}
				} else if (j == 'F') {
					if (cur.dir == 'W') {
						cur.x -= 1;
					} else if (cur.dir == 'N') {
						cur.y += 1;
					} else if (cur.dir == 'E') {
						cur.x += 1;
					} else if (cur.dir == 'S') {
						cur.y -= 1;
					}
					if (!isOkay(cur.x, cur.y)) {
						sb.append("Robot " + i + " crashes into the wall");
						flag = true;
						break;
					}
					for (int l = 0; l < robots.size(); l++) {
						if (l != i) {
							Robot next = robots.get(l);
							if (next.x == cur.x && next.y == cur.y) {
								sb.append("Robot " + i + " crashes into robot " + l);
								flag = true;
								break outer;
							}
						}
					}
				}
			}
		}
		if (!flag)
			sb.append("OK");
		System.out.println(sb);
	}

	private static boolean isOkay(int x, int y) {
		return x >= 1 && x < A + 1 && y >= 1 && y < B + 1;
	}
}