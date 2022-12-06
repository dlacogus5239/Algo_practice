package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main16398 {
	static int N;

	// 인접행렬이라 PRIM 알고리즘 선택
	public static void main(String[] args) throws IOException, NumberFormatException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		int[][] adjMatrix = new int[N + 1][N + 1]; // 인접행렬
		int[] minEdge = new int[N + 1]; // 타 정점에서 자신으로의 간선비용 중 최소비용
		boolean[] visited = new boolean[N + 1]; // 신장트리에 선택된 여부

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				adjMatrix[i][j] = Integer.parseInt(st.nextToken());
			}
			minEdge[i] = Integer.MAX_VALUE;
		} // input END
		long result = 0;
		// 최소 비용(결과) --> 비용이 최대 1억이라 총 비용이 21억 초과할거 같아서 long 으로 설정

		minEdge[1] = 0; // 시작지점을 1로 설정
		for (int e = 1; e <= N; e++) { // 모든 행성 연결
			int min = Integer.MAX_VALUE;
			int minVertex = 0;
			for (int i = 1; i <= N; i++) {
				if (!visited[i] && min > minEdge[i]) {
					min = minEdge[i];
					minVertex = i;
				} // 가장 비용이 적은 행성 선택, 비용 최신화
			}

			visited[minVertex] = true; // 방문체크
			result += min; // 총 비용 더해줌
			for (int i = 1; i <= N; i++) {
				if (!visited[i] && adjMatrix[minVertex][i] != 0 && minEdge[i] > adjMatrix[minVertex][i]) {
					minEdge[i] = adjMatrix[minVertex][i];
				}
			}
		}
		System.out.println(result);
	}

}