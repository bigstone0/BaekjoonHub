#include <iostream>
#include <cstring>
#include <cmath>
using namespace std;
int main(void) {
	int result;
	int N;
	cin >> N;

	if (N == 1) {
		int tasteA, tasteB;
		cin >> tasteA;
		cin >> tasteB;
		cout << abs(tasteA - tasteB);
	}
	else {
		int tasteA[11];
		int tasteB[11];
		for (int i = 0; i < N; i++) {
			cin >> tasteA[i];
			cin >> tasteB[i];
		}

		for (int i = 1; i < pow(2, N) ; i++) {
			int aSum = 1;
			int bSum = 0;

			for (int j = 0; j < 10; j++) {
				if ((i & (1 << j)) > 0) {
					aSum *= tasteA[j];
					bSum += tasteB[j];
				}
			}

			if (i == 1) result = abs(aSum - bSum);
			else {
				if (abs(aSum - bSum) < result) result = abs(aSum - bSum);
			}
		}
		cout << result;
	}
}