package softeer;

import java.util.*;
import java.io.*;
import java.lang.StringBuilder;

public class Main3 {
	// 성적 평가 
	static int N;

	static class Participant {
		int idx;
		int score;
		int grade;

		public Participant(int idx, int score) {
			this.idx = idx;
			this.score = score;
		}

		public String toString() {
			return "[ idx : " + this.idx + ", score : " + this.score + ", grade : " + this.grade + "]";
		}

	}

	static ArrayList<Participant>[] contest;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		// 대회는 3번인데 마지막 토탈 저장하기 위해서 하나 추가
		contest = new ArrayList[4];

		// list Init
		for (int i = 0; i < 4; i++) {
			contest[i] = new ArrayList<>();
		}

		// 4번쨰 최종점수 저장하기 위한 Participant 처음에 넣어주기
		for (int i = 0; i < N; i++) {
			contest[3].add(new Participant(i, 0));
		}

		// input Start
		StringTokenizer st;
		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int curScore = Integer.parseInt(st.nextToken());
				// 대회마다 참가자 점수
				contest[i].add(new Participant(j, curScore));
				// 최종점수
				contest[3].get(j).score += curScore;
			}
		}
		// input End

		// 내림차순 정렬 후 cnt에 따라서 grade(등수 저장)
		for (int i = 0; i < 4; i++) {
			contest[i].sort((o1, o2) -> o2.score - o1.score);

			// 대회마다 등수 저장
			int cnt = 1;
			int curGrade = 1;
			contest[i].get(0).grade = curGrade;
			for (int j = 1; j < N; j++) {
				if (contest[i].get(j - 1).score == contest[i].get(j).score) {
					contest[i].get(j).grade = curGrade;
					cnt++;
				} else {
					curGrade += cnt;
					contest[i].get(j).grade = curGrade;
					cnt = 1;
				}
			}
			// //확인용
			// System.out.println("========");
			// for(int j = 0; j < N; j++){
			// System.out.println(contest[i].get(j).toString());
			// }
			// System.out.println("========");

			// 다시 idx순으로 정렬렬
			contest[i].sort((o1, o2) -> o1.idx - o2.idx);

			for (int j = 0; j < N; j++) {
				sb.append(contest[i].get(j).grade + " ");
			}
			sb.append("\n");
		}

		System.out.println(sb.toString());

	}
}