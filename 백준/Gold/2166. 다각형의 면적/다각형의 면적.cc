#include <iostream>
#include <cmath>
#include <iomanip>

using namespace std;

int num;
long long list[10000][2];
long double result = 0;
int main(void) {
	cin >> num;
	for (int i = 0; i < num; i++) {
		cin >> list[i][0];
		cin >> list[i][1];
	}

	for (int i = 1; i < num - 1; i++) {
		result += (list[0][0] * list[i][1] + list[i][0] * list[i + 1][1] +
			list[i + 1][0] * list[0][1] - list[i][0] * list[0][1] - list[i + 1][0] * list[i][1]
			- list[0][0] * list[i + 1][1]) * 0.5;
	}

	cout << fixed << setprecision(1) << abs(result) << "\n";
}