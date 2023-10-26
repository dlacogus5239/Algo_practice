package codeTree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main2 {
	static class Rabbit {
		int id;
		// 이동할 거리
		int d;
		int r, c;
		int jump;
		int score;

		public Rabbit(int id, int d, int r, int c, int jump, int score) {
			super();
			this.id = id;
			this.d = d;
			this.r = r;
			this.c = c;
			this.jump = jump;
			this.score = score;
		}

		@Override
		public String toString() {
			return "Rabbit [id=" + id + ", d=" + d + ", r=" + r + ", c=" + c + ", jump=" + jump + ", score=" + score
					+ "]";
		}

	}

	// 좌표 값의 우선순위 구하기 위함
	static class Point implements Comparable<Point> {
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public int compareTo(Point o) {
			if (this.r + this.c != o.r + o.c) {
				return -(this.r + this.c - o.r - o.c);
			}
			if (this.r != o.r) {
				return o.r - this.r;
			}
			return o.c - this.c;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + "]";
		}
		

	}

	// 맵 크기
	static int N, M;
	// 맵
	static int[][] map;
	// 턴 횟수, 점수
	static int K, S;
	// 변경하는 이동거리
	static int L;
	// 변경할 토끼
	static int cPid;
	// 명령 개수
	static int Q;

	// 토끼 마리수
	static int P;

	static PriorityQueue<Rabbit> pq;

	// K번의 턴동안 선택된 토끼인지?
	static boolean[] isChoosen;

	// 이동
	// 상하좌우
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		Q = Integer.parseInt(br.readLine());

		pq = new PriorityQueue<>(new Comparator<Rabbit>() {
			@Override
			public int compare(Rabbit o1, Rabbit o2) {
				if (o1.jump != o2.jump) {
					return o1.jump - o2.jump;
				}
				if (o1.r + o1.c != o2.r + o2.c) {
					return ((o1.r + o1.c) - (o2.r + o2.c));
				}
				if (o1.r != o2.r) {
					return o1.r - o2.r;
				}
				if (o1.c != o2.c) {
					return o1.c - o2.c;
				}
				return o1.id - o2.id;
			}
		});
		int OPERATION = -1;
		// 명령 진행
		for (int q = 0; q < Q; q++) {
			st = new StringTokenizer(br.readLine());
			// 가장 첫번째 줄은 어떤 명령어 인지
			// 100 : 경주 시작 준비
			// 200 : 경주 진행
			// 300 : 이동거리 변경
			// 400 : 최고의 토끼 선정(끝)
			OPERATION = Integer.parseInt(st.nextToken());
			switch (OPERATION) {
			// 경주 준비
			case 100:
				N = Integer.parseInt(st.nextToken());
				M = Integer.parseInt(st.nextToken());
				map = new int[N][M];
				P = Integer.parseInt(st.nextToken());
				for (int i = 0; i < P; i++) {
					int pid = Integer.parseInt(st.nextToken());
					int d = Integer.parseInt(st.nextToken());
					// id, 이동 거리, 시작 좌표(1, 1), 점프 횟수
					pq.offer(new Rabbit(pid, d, 1, 1, 0, 0));
				}

//				System.out.println(pq.toString());
				break;
			case 200:
				K = Integer.parseInt(st.nextToken());
				S = Integer.parseInt(st.nextToken());
				Race();
				break;
			case 300:
				cPid = Integer.parseInt(st.nextToken());
				L = Integer.parseInt(st.nextToken());
				ChangeDistance();
				break;
			case 400:
				System.out.println(Score());
				break;
			}
		}

	}

	public static Rabbit UpRabbit(Rabbit cur) {
		Rabbit upRabbit_res = cur;
		int dis = cur.d;

		dis %= 2 * (N - 1);
		if (dis >= upRabbit_res.r - 1) {
			dis -= (upRabbit_res.r - 1);
			upRabbit_res.r = 1;
		} else {
			upRabbit_res.r -= dis;
			dis = 0;
		}

		if (dis >= N - upRabbit_res.r) {
			dis -= (N - upRabbit_res.r);
			upRabbit_res.r = N;
		} else {
			upRabbit_res.r += dis;
			dis = 0;
		}

		upRabbit_res.r -= dis;

		return upRabbit_res;
	}

	public static Rabbit DownRabbit(Rabbit cur) {
		Rabbit downRabbit_res = cur;
		int dis = cur.d;

		dis %= 2 * (N - 1);

		if (dis >= N - downRabbit_res.r) {
			dis -= (N - downRabbit_res.r);
			downRabbit_res.r = N;
		} else {
			downRabbit_res.r += dis;
			dis = 0;
		}

		if (dis >= downRabbit_res.r - 1) {
			dis -= (downRabbit_res.r - 1);
			downRabbit_res.r = 1;
		} else {
			downRabbit_res.r -= dis;
			dis = 0;
		}

		downRabbit_res.r += dis;

		return downRabbit_res;
	}

	public static Rabbit RightRabbit(Rabbit cur) {
		Rabbit rightRabbit_res = cur;
		int dis = cur.d;
		dis %= 2 * (M - 1);

		if (dis >= M - rightRabbit_res.c) {
			dis -= (M - rightRabbit_res.c);
			rightRabbit_res.c = M;
		} else {
			rightRabbit_res.c += dis;
			dis = 0;
		}

		if (dis >= rightRabbit_res.c - 1) {
			dis -= (rightRabbit_res.c - 1);
			rightRabbit_res.c = 1;
		} else {
			rightRabbit_res.c -= dis;
			dis = 0;
		}

		rightRabbit_res.c += dis;

		return rightRabbit_res;
	}

	public static Rabbit LeftRabbit(Rabbit cur) {
		Rabbit leftRabbit_res = cur;
		int dis = cur.d;

		dis %= 2 * (M - 1);

		if (dis >= leftRabbit_res.c - 1) {
			dis -= (leftRabbit_res.c - 1);
			leftRabbit_res.c = 1;
		} else {
			leftRabbit_res.c -= dis;
			dis = 0;
		}

		if (dis >= M - leftRabbit_res.c) {
			dis -= (M - leftRabbit_res.c);
			leftRabbit_res.c = M;

		} else {
			leftRabbit_res.c -= dis;
		}

		return leftRabbit_res;
	}

	// 경주 진행
	public static void Race() {
		// 뽑혔던 토끼인지 알아보기 위해서
		isChoosen = new boolean[2001];
		PriorityQueue<Point> p_pq = new PriorityQueue<>();
		// K번 만큼 진행
		// S만큼 점수 더해줌
		for (int k = 0; k < K; k++) {
			System.out.println(pq.toString());
			System.out.println(k);
			// 우선 순위 높은 토끼 꺼냄
			Rabbit cur = pq.poll();
			Rabbit nextRabbit;
			// 상
			nextRabbit = UpRabbit(cur);
			p_pq.offer(new Point(nextRabbit.r, nextRabbit.c));
			// 하
			nextRabbit = DownRabbit(cur);
			p_pq.offer(new Point(nextRabbit.r, nextRabbit.c));
			// 좌
			nextRabbit = LeftRabbit(cur);
			p_pq.offer(new Point(nextRabbit.r, nextRabbit.c));
			// 우
			nextRabbit = RightRabbit(cur);
			p_pq.offer(new Point(nextRabbit.r, nextRabbit.c));

			System.out.println(p_pq.toString());
			// 정해진 우선순위가 가장 높은 곳으로 이동
			Point nextP = p_pq.poll();
			cur.r = nextP.r;
			cur.c = nextP.c;
			// 점프 카운트 증가
			cur.jump += 1;
			// 이동했기 때문에 방문처리
			isChoosen[cur.id] = true;

			// 나머지 토끼 점수 더해줌
			pq.forEach((r) -> {
				if (r.id != cur.id) {
					r.score += cur.r + cur.c;
				}
			});

			pq.offer(cur);
		}
		// K번 턴 END
		// 우선순위 가장 높은 애( 점프할 친구와 반대)
		PriorityQueue<Rabbit> score_pq = new PriorityQueue<>(new Comparator<Rabbit>() {
			@Override
			public int compare(Rabbit o1, Rabbit o2) {
				if (o1.r + o1.c != o2.r + o2.c) {
					return -((o1.r + o1.c) - (o2.r + o2.c));
				}
				if (o1.r != o2.r) {
					return -(o1.r - o2.r);
				}
				if (o1.c != o2.c) {
					return -(o1.c - o2.c);
				}
				return -(o1.id - o2.id);
			}
		});
		// 옮겨줌
		while (!pq.isEmpty()) {
			Rabbit tmp = pq.poll();
			score_pq.offer(tmp);
		}
		// 선택됐었던 토끼 중 가장 우선순위 높은거 선택됐었는지
		boolean flag = false;
		while (!score_pq.isEmpty()) {
			Rabbit cur = score_pq.poll();

			if (isChoosen[cur.id] && !flag) {
				cur.score += S;
				flag = true;
			}
			pq.offer(cur);
		}

	}

	// 이동거리 변경
	public static void ChangeDistance() {
		pq.forEach((r) -> {
			if (cPid == r.id) {
				r.d *= L;
			}
		});
	}

	// 점수 계산
	public static int Score() {
		int result = Integer.MIN_VALUE;

		while (!pq.isEmpty()) {
			Rabbit cur = pq.poll();
			result = Math.max(result, cur.score);
		}

		return result;
	}

}
