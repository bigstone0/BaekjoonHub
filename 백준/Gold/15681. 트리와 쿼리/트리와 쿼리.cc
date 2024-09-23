#include <stdio.h>
#include <iostream>
#include <cmath>
#include <vector>

using namespace std;

int course(int node);

int N, R, Q;
vector<int> v[100001];
bool visit[100001] = { false, };
int num[100001];

int main() {
	ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
	std::cin >> N >> R >> Q;
	for (int i = 0; i < N - 1; i++) {
		int A, B;
		std::cin >> A >> B;
		v[A].push_back(B);
		v[B].push_back(A);
	}

	visit[R] = true;
	num[R] = course(R);

	for (int i = 0; i < Q; i++) {
		int root;
		std::cin >> root;

		std::cout << num[root] << '\n';
	}
}

int course(int node) {
	int size = v[node].size();
	int result = 1;
	if (size == 0) {
		num[node] = result;
		return result;
	}

	for (int i = 0; i < size; i++) {
		if (!visit[v[node][i]]) {
			visit[v[node][i]] = true;
			result += course(v[node][i]);
		}
	}
	num[node] = result;

	return result;
}