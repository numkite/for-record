
#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <string.h>


// 02 상수와 데이터 출력
/*
#include <stdio.h>

int main() {
	printf("Student Number : %d\n", 32165);
	printf("Name : %s\n", "홍길동");
	printf("GPA : %c\n", 'A');
	
	return 0;

}

*/


// 03-1 변수
/*

#include <stdio.h>

int main() {
	int a = 0;

	a = a + 1;
	a = a + 2;
	a = a + 3;
	printf("a : %d", a);

	return 0;

}

*/


// 03-2 데이터 입력
/*

#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>


int main() {

	char fruit[20];
	int cnt;

	printf("좋아하는 과일: ");
	scanf("%s", fruit);
	printf("몇 개: ");
	scanf("%d", &cnt);
	printf("%s를 %d개 드립니다.", fruit, cnt);

	return 0;

}

*/

/*

int main() {

	char ch;

	printf("문자 입력: ");
	scanf_s("%c", &ch);

	printf("%c문자의 아스키 코드값은 %d입니다.", ch, ch);

	return 0;

}

*/


// 04 연산자
/*

int main() {

	int seats = 70;
	int audience = 65;
	double rate;

	rate = audience / (double)seats * 100;

	printf("입장률: %.1f", rate);

	return 0;

}

*/

/*

int main() {

	int hour, min, sec;
	double time = 3.76;

	hour = (int)time;
	time = time - hour;
	time = 60 * time;
	min = (int)time;
	time = time - min;
	sec = 60 * time;

	printf("3.76시간은 %d시간 %d분 %d초입니다.", hour, min, sec);

	return 0;

}

*/


// 05 선택문
/*

int main() {

	double height = 179.5;
	double weight = 75.0;

	if (height >= 187.5 && weight < 80) {
		printf("ok\n");
	}
	else {
		printf("cancel\n");
	}

	return 0;
}

*/

/*

int main() {

	int age = 25, chest = 95;
	char size;

	if (age < 20) {
		if (chest >= 95)
			size = 'L';
		else if (chest >= 85)
			size = 'M';
		else
			size = 'S';
	}

	else {
		if (chest >= 100)
			size = 'L';
		else if (chest >= 90)
			size = 'M';
		else
			size = 'S';
	}

	printf("사이즈는 %c입니다.\n", size);

	return 0;

}

*/


// 06 반복문
/*

int main() {
	int size = 5; 

	for (int i = 0; i < size; i++) { 
		for (int j = 0; j < size; j++) { 
			if (i == j || i + j == size - 1) { 
				printf("*"); 
			}
			else {
				printf(" "); 
			}
		}
		printf("\n"); 
	}
	return 0;
}

*/


// 07 함수
/*

double centi_to_meter(int height);

int main() {

	double res;

	res = centi_to_meter(187);
	printf("%.2lfm \n", res);

	return 0;
}

double centi_to_meter(int height) {

	double meter;
	meter = height * 0.01;

	return meter;

}

*/

/*

void sum(int n);

int main() {

	sum(10);
	sum(100);

	return 0;

}

void sum(int n) {

	int total = 0;

	for (int i = 1; i <= n; i++) {
		total += i;
	}

	printf("%d\n", total);
}

*/


// 08 배열
/*

int main() {

	int A[3] = { 1, 2, 3 };
	int B[10];
	int i;

	for (i = 0; i < length(B), i++) {

	}
}

*/

/*

int main() {

	char str1[80], str2[80];
	char temp[80];

	printf("두 문자열 이력 : ");
	scanf("%s %s", str1, str2);
	printf("바꾸기 전: %s, %s\n", str1, str2);
	
	strcpy(temp, str1);
	strcpy(str1, str2);
	strcpy(str2, temp);
	printf("바꾼 후: %s, %s\n", str1, str2);

	return 0;

}

*/


// 09 포인터
/*

void swap(double* pa, double* pb);
void line_up(double* maxp, double* midp, double* minp);

int main() {

	double max, mid, min;

	printf("실수값 3개 입력: ");
	scanf("%lf%lf%lf", &max, &mid, &min);
	line_up(&max, &mid, &min);
	printf("정렬된 값 출력: %.1lf, %.1lf, %.1lf\n", max, mid, min);

	return 0;

}

void swap(double* pa, double* pb) {

	double temp;

	temp = *pa;
	*pa = *pb;
	*pb = temp;
}

void line_up(double* maxp, double* midp, double* minp) {


	if (*midp > *maxp) {
		if (*minp > *maxp) {
			if (*midp > *minp) {
				swap(maxp, minp);
				swap(maxp, midp);
			}
			else
				swap(maxp, minp);
		}
		else
			swap(maxp, midp);
	}
	else if (*minp > *maxp) {
		if (*maxp > *midp) {
			swap(maxp, midp);
			swap(maxp, minp);
		}
	}

	return 0;

}

*/



























