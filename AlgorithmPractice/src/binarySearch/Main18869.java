package binarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main18869 {
	// https://da9dac.tistory.com/311
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		int[] sorted, input = new int[N];
		int[][] zips = new int[M][N];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				input[j] = Integer.parseInt(st.nextToken());
			}
			sorted = Arrays.stream(input).distinct().sorted().toArray();
//			System.out.println(Arrays.toString(sorted));
			for (int j = 0; j < N; j++) {
				// 좌표 압축
				zips[i][j] = Arrays.binarySearch(sorted, input[j]); // 중복되는거 같은 좌표? 같은 순서로 맞춰주기 위해서 ..
			}
		}

		int answer = 0;
		for (int i = 0; i < M; i++) {
//			System.out.println(Arrays.toString(zips[i]));
			for (int j = i + 1; j < M; j++) {
				if (Arrays.equals(zips[i], zips[j])) {
					answer++;
				}
			}
		}

		System.out.println(answer);

	}

}
