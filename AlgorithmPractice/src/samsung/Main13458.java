package samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main13458 {
	// 백준 13458 시험 감독
	// 시험장의 개수, 총감독관, 부감독관
	static int N, mainViewer, subViewer;
	// 응시자 수
	static int[] candidate;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		candidate = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			candidate[i] = Integer.parseInt(st.nextToken()) - mainViewer;
		}
		st = new StringTokenizer(br.readLine());
		mainViewer = Integer.parseInt(st.nextToken());
		subViewer = Integer.parseInt(st.nextToken());

		br.close();
		// input END

		long ans = 0L;
		for (int i = 0; i < N; i++) {
			long result = 0L;
			if (candidate[i] <= mainViewer) {
				ans++;
				continue;
			} else {
				ans++;
				candidate[i] -= mainViewer;

				if (candidate[i] % subViewer == 0) {
					ans += candidate[i] / subViewer;
				} else {
					ans += candidate[i] / subViewer + 1;
				}
			}
		}

		System.out.println(ans);
	}

}
