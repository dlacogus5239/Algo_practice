package baekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2110 {
	static int N; // 집의 개수
	static int C; // 공유기의 개수
	static int[] house; // 집 위치 정보
	// 이분탐색?
	/*
	 * 집 간의 (최소거리 ~ 최대거리)를 탐색하면서, 해당 거리마다 공유기 설치 할 경우를 계산 공유기의 개수가 일치 할 경우 정답..? -->
	 * 제가 이해한 방법은 이렇습니다.
	 * 
	 * 이때 계산한 공유기의 개수가 많을 경우와 적을 경우에 따라 이분탐색으로 진행..?
	 */

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		house = new int[N];
		for (int i = 0; i < N; i++) {
			house[i] = Integer.parseInt(br.readLine());
		}
		// input END

		// 이분 탐색을 위한 정렬
		Arrays.sort(house);

		int min_distance = 1; // 거리 최솟값
		int max_distance = house[N - 1] - house[0] + 1; // 마지막 집에서 첫번째 집 => 거리 최댓값

		int result = 0; // 결과

		while (min_distance < max_distance) {
			// System.out.println("탐색 범위 : " + min_distance + " ~ " + max_distance);
			int pivot = (min_distance + max_distance) / 2;
			int tmpWIFI = 0;
			// 중간 거리 값으로 공유기 개수를 를 계산
			tmpWIFI = CalcWIFI(pivot);

			// System.out.println("Pivot : " + pivot);
			// System.out.println("지금 현재 거리의 공유기 개수 : " + tmpWIFI);
			// 계산한 공유기 개수가 많을 경우 --> 거리를 늘려 줘야 한다
			if (tmpWIFI >= C) {
				min_distance = pivot + 1;
			}
			// 계산한 공유기 개수가 적을 경우 --> 거리를 줄여 줘야 한다
			else if (tmpWIFI < C) {
				max_distance = pivot;
			}

		}
		// Upper Bound 사용 
		// min_distacne --> (low)탐색 값을 초과하는 첫 번재 값을 가리킴
		System.out.println(min_distance - 1);
	}

	public static int CalcWIFI(int distance) {
		int count = 1; // 공유기의 개수
		// 처음 집 설치

		int preHouse = house[0]; // 그 전의 집을 나타낼 변수

		for (int i = 0; i < house.length; i++) {
			if (house[i] - preHouse >= distance) { // 최소 거리 이상일 경우 설치를 해준다
				count++;
				preHouse = house[i];
			}
		}

		return count;
	}

}