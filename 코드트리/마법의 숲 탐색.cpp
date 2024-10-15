// https://www.codetree.ai/training-field/frequent-problems/problems/magical-forest-exploration/description?page=1&pageSize=5

#include <iostream>
#include <cmath>
#include <queue>

using namespace std;

int R, C, K, start, dir, result;
int dx[] = { 0,1,0,-1 };
int dy[] = { -1,0,1,0 };
int map[100][100];
int centerX, centerY;
bool ex[100][100];
int sum = 0;
int cnt = 0;

bool check(int x, int y, int d);
int search(int x, int y);

int main() {
	cin >> R >> C >> K;
	for (int o = 1; o <= K; o++) {
		cin >> start >> dir;
		centerX = start - 1;
		centerY = 1;
		bool flag = false;

		// 남쪽 이동
		do {
			flag = false;

			if (check(centerX, centerY, 0)) { // 남쪽
				flag = true;
				centerY += 1;
			}
			if (!flag) {
				if (check(centerX, centerY, -1)) { // 서쪽
					flag = true;
					centerX -= 1;
					centerY += 1;
					dir -= 1;
					if (dir == -1) dir = 3;
				}
			}
			if (!flag) {
				if (check(centerX, centerY, 1)) { // 동쪽
					flag = true;
					centerX += 1;
					centerY += 1;
					dir += 1;
					if (dir == 4) dir = 0;
				}
			}
		} while (flag);

		if (centerY < 4) {
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					map[i][j] = 0;
					ex[i][j] = false;
				}
			}
			continue;
		}

		map[centerY][centerX] = o;
		for (int i = 0; i < 4; i++) map[centerY + dy[i]][centerX + dx[i]] = o;
		ex[centerY + dy[dir]][centerX + dx[dir]] = true;

		sum += search(centerX, centerY) - 2;
		cnt += 1;
		
	}

	cout << sum << "\n";
}

bool check(int x, int y, int d) {
	if (d == 1) { // 오른쪽 아래 체크
		if ((x + 1 == C - 1) || (y + 1 == R + 2)) return false; // 열, 행 오버플로우 체크

		int xx = x + 1;
		int yy = y;

		for (int i = 0; i < 4; i++) {
			if (map[yy + dy[i]][xx + dx[i]] != 0) return false;
		}

		yy = yy + 1;
		for (int i = 0; i < 4; i++) {
			if (map[yy + dy[i]][xx + dx[i]] != 0) return false;
		}

		return true;
	}
	else if (d == -1) { // 왼쪽 아래 체크
		if ((x - 1 == 0) || (y + 1 == R + 2)) return false; // 열 언더플로우 , 행 오버플로우 체크

		int xx = x - 1;
		int yy = y;

		for (int i = 0; i < 4; i++) {
			if (map[yy + dy[i]][xx + dx[i]] != 0) return false;
		}

		yy = yy + 1;
		for (int i = 0; i < 4; i++) {
			if (map[yy + dy[i]][xx + dx[i]] != 0) return false;
		}

		return true;
	}
	else if (d == 0) { // 아래 체크
		if (y + 1 == R + 2) return false; // 행 오버플로우 체크
		int xx = x;
		int yy = y + 1;
		
		for (int i = 0; i < 4; i++) {
			if (map[yy + dy[i]][xx + dx[i]] != 0) return false;
		}
		
		return true;
	}
}

int search(int x, int y) {
	int result = 0;

	queue<int> q;
	bool check[100][100] = {};
	
	q.push(x);
	q.push(y);
	check[y][x] = true;

	while (!q.empty()) {
		int xx = q.front();
		q.pop();
		int yy = q.front();
		q.pop();

		if (result < yy) result = yy;

		if (ex[yy][xx]) {
			for (int i = 0; i < 4; i++) {
				int xxx = xx + dx[i];
				int yyy = yy + dy[i];

				if (xxx < 0 || yyy < 0 || check[yyy][xxx]) continue;

				if (map[yyy][xxx] != 0) {
					check[yyy][xxx] = true;
					q.push(xxx);
					q.push(yyy);
				}
			}
		}
		else {
			for (int i = 0; i < 4; i++) {
				int xxx = xx + dx[i];
				int yyy = yy + dy[i];

				if (xxx < 0 || yyy < 0 || check[yyy][xxx]) continue;

				if (map[yyy][xxx] == map[yy][xx]) {
					check[yyy][xxx] = true;
					q.push(xxx);
					q.push(yyy);
				}
			}
		}
	}

	return result;
}