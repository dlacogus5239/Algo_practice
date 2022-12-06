package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 백준 14938 서강그라운드
public class Main14938 {
	static int N, M, R; // N 지역의 개수, M 수색 범위, R 길의 개수
	static int[][] map; // 간선 가중치 저장
	static int[] item; // n번째 지역(노드)가 가지고 있는 아이템 수
	static final int maxVal = 999_999_999;

	public static void main(String[] args) throws IOException, NumberFormatException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		map = new int[N + 1][N + 1];
		// 플로이드 와샬을 위한 배열 초기화
		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < N + 1; j++) {
				if (i == j) {
					continue;
				}
				map[i][j] = maxVal;
			}
		}

		item = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			item[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			map[from][to] = weight;
			map[to][from] = weight; // 무방향
		}

		// input END

		int result = Integer.MIN_VALUE;

		// 플로이드-와샬
		for (int k = 1; k < N + 1; k++) {
			for (int i = 1; i < N + 1; i++) {
				for (int j = 1; j < N + 1; j++) {
					if (map[i][j] > map[i][k] + map[k][j]) {
						map[i][j] = map[i][k] + map[k][j];
					}
				}
			}
		}
		// 각 노드까지 최솟값 END

		// M(수색 거리) 이하인 거리만 탐색해서, item의 개수 최댓값을 구해준다
		for (int i = 1; i < N + 1; i++) {
			int tmp = 0;
			for (int j = 1; j < N + 1; j++) {
				if (map[i][j] <= M) {
					tmp += item[j];
				}
			}
			result = Math.max(result, tmp);
		}
		System.out.println(result);

	}

}