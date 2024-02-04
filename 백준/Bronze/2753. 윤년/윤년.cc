#include <stdio.h>

int main() {
	int year, i;
	scanf("%d",&year);
	i = (((year % 4==0) && (year % 100!=0)) || (year % 400==0));
	printf("%d\n", i);
}