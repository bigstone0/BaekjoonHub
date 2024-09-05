#include <iostream>
using namespace std;

int AIndex, BIndex, ALen, BLen;
int reIndex = 0;
int A[100];
int B[100];
int result[100];
bool check[100];

bool search(int num) {
	for (int i = BIndex; i < BLen; i++) {
		if (B[i] == num) {
			BIndex = i + 1;
			return true;
		}
	}

	return false;
}

void go() {
	int max = 0;
	int temp = AIndex;
	for (int i = AIndex; i < ALen; i++) {
		if (A[i] > max && !check[i]) {
			max = A[i];
			temp = i + 1;
		}
	}

	if (max == 0) return;

	check[temp - 1] = true;
	if (search(max)) {
		AIndex = temp;
		result[reIndex++] = max;
	}

	if (AIndex == ALen) return;

	go();
}

int main(void) {
	cin >> ALen;
	AIndex = 0;

	for (int i = 0; i < ALen; i++) {
		cin >> A[i];
	}
	
	cin >> BLen;
	BIndex = 0;
	for (int i = 0; i < BLen; i++) {
		cin >> B[i];
	}

	go();

	cout << reIndex << "\n";
	for (int i = 0; i < reIndex; i++) {
		cout << result[i] << " ";
	}
}
