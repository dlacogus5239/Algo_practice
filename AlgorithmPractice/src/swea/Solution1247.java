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

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			Node company = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			Node house = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			
			
		}
	}

}
