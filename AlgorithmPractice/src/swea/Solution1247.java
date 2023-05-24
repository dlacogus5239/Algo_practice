package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1247 {
	// SWEA 1247 최적 경로
	static int N;

	static class Node {
		int x;
		int y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static boolean[] isVisited;
	static int min;
	static Node[] customers;
	static Node house;
	static Node company;

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			min = Integer.MAX_VALUE;
			N = Integer.parseInt(br.readLine());
			isVisited = new boolean[N];
			StringTokenizer st = new StringTokenizer(br.readLine());

			// 회사, 집 정보 입력
			company = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			house = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			customers = new Node[N];

			// 고객 정보 입력
			for (int i = 0; i < N; i++) {
				customers[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}

			// input END

			// dfs 로 백트래킹으로 구현
			for (int i = 0; i < N; i++) {
				int initDist = Distance(company.x, company.y, customers[i].x, customers[i].y);
				isVisited[i] = true;
				dfs(1, initDist, i);
				isVisited[i] = false;
			}
			sb.append("#" + t + " ").append(min).append("\n");
		}
		System.out.println(sb.toString());
	}

	// 조합 구하는것과 같이 하고, 거리만 넘겨주면 될거같은데...
	// 고객방문횟수, 현재까지 거리
	public static void dfs(int cnt, int dst, int pre) {
		// 모든 고객 방문
		if (cnt == N) {
			// 마지막 집 까지 가는 거리 계산
			min = Math.min(min, dst + Distance(customers[pre].x, customers[pre].y, house.x, house.y));
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!isVisited[i]) {
				isVisited[i] = true;
				dfs(cnt + 1, dst + Distance(customers[pre].x, customers[pre].y, customers[i].x, customers[i].y), i);
				isVisited[i] = false;
			}
		}
	}

	// 거리 계산
	public static int Distance(int x1, int y1, int x2, int y2) {
		return Math.abs(x1 - x2) + Math.abs(y1 - y2);
	}

}
