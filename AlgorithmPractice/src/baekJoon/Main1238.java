package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// Dijkstra 
public class Main1238 {
	static class Vertex implements Comparable<Vertex> {
		int no; // 끝점
		int weight; // 비용

		public Vertex(int no, int weight) {
			super();
			this.no = no;
			this.weight = weight;
		}

		@Override
		public int compareTo(Vertex o) {
			// TODO Auto-generated method stub
			return this.weight - o.weight;
		}

	}

	static int[] distance, reverseDistance;
	static ArrayList<ArrayList<Vertex>> map, reverseMap;
	static int X, N, M;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // N명의 학생
		M = Integer.parseInt(st.nextToken()); // M개의 단방향 도로
		X = Integer.parseInt(st.nextToken()); // X번 마을
		distance = new int[N + 1]; // 각 학생별 가는 비용
		reverseDistance = new int[N + 1]; // 각 학생별 오는 비용
		map = new ArrayList<ArrayList<Vertex>>(); // 가는 정보를 입력
		reverseMap = new ArrayList<ArrayList<Vertex>>(); // 오는 정보를 입력
		for (int i = 0; i <= N; i++) {
			map.add(new ArrayList<>());
			reverseMap.add(new ArrayList<>());
		} // 초기화 수행

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			map.get(from).add(new Vertex(to, weight)); // 그대로 저장 from ~ to
			reverseMap.get(to).add(new Vertex(from, weight)); // 반대로 저장 to ~ from
		} // input END

		distance = Dijstra(map);
		reverseDistance = Dijstra(reverseMap);

		int result = 0; // 결과

		for (int i = 1; i <= N; i++) {
			result = Math.max(result, distance[i] + reverseDistance[i]);
		}
		System.out.println(result);

	}

	// 다익스트라 수행
	public static int[] Dijstra(ArrayList<ArrayList<Vertex>> list) {
		PriorityQueue<Vertex> pq = new PriorityQueue<>();
		pq.offer(new Vertex(X, 0));

		boolean[] isVisited = new boolean[N + 1];
		int[] tmpDist = new int[N + 1];
		Arrays.fill(tmpDist, Integer.MAX_VALUE);
		tmpDist[X] = 0;

		while (!pq.isEmpty()) {
			Vertex cur = pq.poll();
			int curVertex = cur.no;

			if (!isVisited[curVertex]) {
				isVisited[curVertex] = true;

				for (int i = 0; i < list.get(curVertex).size(); i++) {
					Vertex v = list.get(curVertex).get(i);
					if (!isVisited[v.no] && tmpDist[v.no] > tmpDist[curVertex] + v.weight) {
						tmpDist[v.no] = tmpDist[curVertex] + v.weight;
						pq.offer(new Vertex(v.no, tmpDist[v.no]));
					}
				}
			}
		}

		return tmpDist;
	}

}