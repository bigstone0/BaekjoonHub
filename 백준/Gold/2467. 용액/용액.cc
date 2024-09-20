#include <iostream>
#include <cmath>;

using namespace std;

int main() {
	long list[100001];
	int num;
	cin >> num;
	int end = num - 1;
	int start = 0;
	int minX = 1000000000;
	int minY = 1000000000;

	for (int i = 0; i < num; i++) {
		cin >> list[i];
	}

	while (start != end) {
		long result = list[start] + list[end];
		if (abs(result) < abs(minX + minY)) {
			minX = list[start];
			minY = list[end];
		}

		if (result == 0) break;
		else if (result > 0) end--;
		else if (result < 0) start++;
	}

	cout << minX << " " << minY << "\n";
}