package algoPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main16398 {
	// 백준 16398 행성 연결

	// 크루스칼 O(ElogE) -> 희소 그래프(간선 적을때)
	// 프림 O(ElogV) -> 밀집 그래프 (간선 많을때)

	static int N;
	static int[][] matrix;
	static int[] minEdge;

	public static void main(String[] args) throws IOException, NumberFormatException {
		// input START
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		matrix = new int[N + 1][N + 1];
		minEdge = new int[N + 1];
		StringTokenizer st;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
			minEdge[i] = Integer.MAX_VALUE;
		}
		br.close();
		// input END
		boolean[] isVisited = new boolean[N + 1];

		long result = 0L;
		// 시작점 1로 설정
		minEdge[1] = 0;

		// 가중치가 가장 적은 간선부터 선택해서 트리를 형성해 나간다
		//	
		for (int i = 1; i <= N; i++) {
			int min = Integer.MAX_VALUE;
			int minIdx = 0;
			for (int j = 1; j <= N; j++) {
				if (!isVisited[j] && min > minEdge[j]) {
					min = minEdge[j];
					minIdx = j;
				}
			}

			isVisited[minIdx] = true;
			result += min;
			for (int j = 1; j <= N; j++) {
				if (!isVisited[j] && matrix[minIdx][j] != 0 && minEdge[j] > matrix[minIdx][j]) {
					minEdge[j] = matrix[minIdx][j];
				}
			}

		}

		System.out.println(result);

	}

}
