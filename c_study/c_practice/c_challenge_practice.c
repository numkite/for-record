
#define _CRT_SECURE_NO_WARNINGS

#include <stdio.h>
#include <string.h>


// 10 배열과 포인터
/*

void input_nums(int* lotto_nums); //lotto_nums가 배열이라서 포인터로 받아도 상관없음
void print_nums(int* lotto_nums);

int main() {

	int lotto_nums[6];

	input_nums(lotto_nums);
	print_nums(lotto_nums);

	return 0;
}

void input_nums(int* lotto_nums) {

	for (int i = 0; i < 6; i++) {

		int count;

		do {
			count = 0;

			printf("번호 입력: ");
			scanf("%d", &lotto_nums[i]);

			for (int j = 0; j < i; j++) {
				if (lotto_nums[j] == lotto_nums[i]) {
					printf("같은 번호가 있습니다!\n");
					count = 1;
					break;
				}
			}
		} while (count); //같은 번호가 있다면 count = 1이 되어 do~while루프에서 벗어날 수 없음. 같은 번호가 존재하지 않을 때 루프가 끝남

	}

}


void print_nums(int* lotto_nums) {

	printf("로또 번호: ");

	for (int i = 0; i < 6; i++) {
		printf("%d ", lotto_nums[i]);
	}

}

*/


// 11 문자
/*

int main() {

	char ch;
	int length = 0;
	int max_length = 0;

	while ((ch = getchar()) != EOF) {
		if (ch == '\n') {
			if (length > max_length)
				max_length = length;

			length = 0;
		}
		
		else {
			length++;
		}
	}

	printf("가장 긴 단어의 길이: %d", max_length);

	return 0;
}

*/


// 12 문자열
/*

int main() {

	char str1[30];
	char str2[30];
	char str3[30];

	printf("세 단어 입력: ");
	scanf("%s %s %s", str1, str2, str3);

	if (strcmp(str1, str2) < 0) {
		if (strcmp(str2, str3) < 0)
			printf("%s, %s, %s", str1, str2, str3);
		else {
			if (strcmp(str1, str3) < 0)
				printf("%s, %s, %s", str1, str3, str2);
			else
				printf("%s, %s, %s", str3, str1, str2);
		}
	}
	else {
		if (strcmp(str2, str3) < 0) {
			if (strcmp(str3, str1) < 0)
				printf("%s, %s, %s", str2, str3, str1);
			else
				printf("%s, %s, %s", str2, str1, str3);
		}
		else
			printf("%s, %s, %s", str3, str2, str1);
	}

	return 0;

}

*/


// 13 변수의 영역과 데이터 공유
/*

void input_data(int* pa, int* pb);
void swap_data(void);
void print_data(int a, int b);

int a, b;

int main(void) {

	input_data(&a, &b);
	swap_data();
	print_data(a, b);

	return 0;

}

void input_data(int* pa, int* pb) {

	printf("두 정수 입력: ");
	scanf("%d %d", pa, pb);

}

void swap_data() {

	int temp;
	
	temp = a;
	a = b;
	b = temp;

}

void print_data(a, b) {

	printf("두 정수 출력: %d, %d", a, b);

}

*/


// 14 다차원 배열과 포인터 배열
/*

int main() {

	int arr[5][6] = { 0 };
	int n = 1;
	int total = 0;

	for (int i = 0; i < 4; i++) {
		int sum = 0;
		for (int j = 0; j < 5; j++) {
			arr[i][j] = n;
			n++;
			sum += arr[i][j];
		}
		arr[i][5] = sum;
		total += sum;
	}

	arr[4][5] = total;
	
	for (int j = 0; j < 5; j++) {
		int sum = 0;
		for (int i = 0; i < 4; i++) {
			sum += arr[i][j];
		}
		arr[4][j] = sum;
	}

	for (int i = 0; i < 5; i++) {
		for (int j = 0; j < 6; j++) {
			printf("%5d", arr[i][j]);
		}
		printf("\n");
	}

	return 0;

}

*/


// 15 응용 포인터
/*

#include <stdio.h>
#include <string.h>

void swap(const char* type, void* a, void* b) {
	if (strcmp(type, "int") == 0) {
		int temp = *(int*)a;
		*(int*)a = *(int*)b;
		*(int*)b = temp;
	}
	else if (strcmp(type, "double") == 0) {
		double temp = *(double*)a;
		*(double*)a = *(double*)b;
		*(double*)b = temp;
	}
}

int main() {
	int age1, age2;
	double height1, height2;

	printf("첫 번째 사람의 나이와 키 입력: ");
	scanf("%d %lf", &age1, &height1);
	printf("두 번째 사람의 나이와 키 입력: ");
	scanf("%d %lf", &age2, &height2);

	// 나이와 키를 교환
	swap("int", &age1, &age2);
	swap("double", &height1, &height2);

	printf("첫 번째 사람의 나이와 키: %d, %.1f\n", age1, height1);
	printf("두 번째 사람의 나이와 키: %d, %.1f\n", age2, height2);

	return 0;
}


*/


// 16 메모리 동적 할당
/*

#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

void printPrimes(int n) {
	bool* isPrime = (bool*)malloc((n + 1) * sizeof(bool));
	if (isPrime == NULL) {
		printf("메모리 할당 실패");
		return;
	}

	for (int i = 2; i <= n; i++) {
		isPrime[i] = true; // 모든 수를 우선 소수로 가정
	}

	// 에라토스테네스의 체 알고리즘
	for (int p = 2; p * p <= n; p++) {
		if (isPrime[p] == true) {
			for (int i = p * p; i <= n; i += p) {
				isPrime[i] = false;
			}
		}
	}

	// 소수와 소수가 아닌 숫자 출력
	int count = 0;
	for (int i = 2; i <= n; i++) {
		if (isPrime[i]) {
			printf("%d\t", i);
		}
		else {
			printf("X\t");
		}
		count++;
		if (count == 5) {
			printf("\n");
			count = 0;
		}
	}

	free(isPrime); // 메모리 해제
}

int main() {
	int n;
	printf("양수 입력: ");
	scanf("%d", &n);
	if (n < 2) {
		printf("2 이상의 수를 입력하세요.\n");
		return 0;
	}
	printPrimes(n);
	return 0;
}

*/


// 17 사용자 정의 자료형
/*
#include <stdio.h>

#define STUDENT_COUNT 5

typedef struct {
	int id;
	char name[50]; // 학생 이름
	int scores[3]; // 국어, 영어, 수학 점수
	int total;
	float average;
	char grade;
} Student;

void calculateScores(Student* s) {
	s->total = s->scores[0] + s->scores[1] + s->scores[2];
	s->average = s->total / 3.0;

	if (s->average >= 90) {
		s->grade = 'A';
	}
	else if (s->average >= 80) {
		s->grade = 'B';
	}
	else if (s->average >= 70) {
		s->grade = 'C';
	}
	else {
		s->grade = 'F';
	}
}

void sortStudents(Student students[]) {
	for (int i = 0; i < STUDENT_COUNT - 1; i++) {
		for (int j = i + 1; j < STUDENT_COUNT; j++) {
			if (students[i].total < students[j].total) {
				Student temp = students[i];
				students[i] = students[j];
				students[j] = temp;
			}
		}
	}
}

void printStudents(const Student students[], const char* title) {
	printf("\n# %s\n", title);
	for (int i = 0; i < STUDENT_COUNT; i++) {
		printf("%d %s %d %d %d %d %.1f %c\n",
			students[i].id,
			students[i].name,
			students[i].scores[0], students[i].scores[1], students[i].scores[2],
			students[i].total,
			students[i].average,
			students[i].grade);
	}
}

int main() {
	Student students[STUDENT_COUNT];

	// 각 학생 정보 입력
	for (int i = 0; i < STUDENT_COUNT; i++) {
		printf("학번: ");
		scanf("%d", &students[i].id);
		printf("이름: ");
		scanf("%s", students[i].name); // 문자열 입력
		printf("국어, 영어, 수학 점수: ");
		scanf("%d %d %d", &students[i].scores[0], &students[i].scores[1], &students[i].scores[2]);
		calculateScores(&students[i]);
	}

	printStudents(students, "정렬 전 데이터");
	sortStudents(students);
	printStudents(students, "정렬 후 데이터");

	return 0;
}

*/


// 18 파일 입출력
/*
#include <stdio.h>
#include <string.h>
#include <stdbool.h>

#define MAX_WORD_LENGTH 20
#define MAX_REGISTERED_WORDS 10

int main() {
	char registeredWords[MAX_REGISTERED_WORDS][MAX_WORD_LENGTH + 1]; // 등록 단어 저장 배열
	int registeredCount = 0;
	char word[MAX_WORD_LENGTH + 1];

	// a.txt에서 등록 단어 읽기
	FILE* fileA = fopen("a.txt", "r");
	if (!fileA) {
		perror("a.txt 파일을 열 수 없습니다.");
		return 1;
	}
	while (fgets(word, MAX_WORD_LENGTH + 1, fileA) != NULL && registeredCount < MAX_REGISTERED_WORDS) {
		word[strcspn(word, "\n")] = '\0';  // 개행 문자 제거
		strcpy(registeredWords[registeredCount++], word);
	}
	fclose(fileA);

	// b.txt를 열어서 등록되지 않은 단어 찾기
	FILE* fileB = fopen("b.txt", "r");
	FILE* fileC = fopen("c.txt", "w");
	if (!fileB || !fileC) {
		perror("b.txt 또는 c.txt 파일을 열 수 없습니다.");
		return 1;
	}

	while (fgets(word, MAX_WORD_LENGTH + 1, fileB) != NULL) {
		word[strcspn(word, "\n")] = '\0';  // 개행 문자 제거
		bool isRegistered = false;

		for (int i = 0; i < registeredCount; i++) {
			if (strcmp(registeredWords[i], word) == 0) {
				isRegistered = true;
				break;
			}
		}

		if (!isRegistered) {
			fprintf(fileC, "%s\n", word);
		}
	}

	fclose(fileB);
	fclose(fileC);

	printf("처리가 완료되었습니다.\n");
	return 0;
}

*/


// 19 전처리와 분할 컴파일
/*

#include <stdio.h>

// 사칙연산 매크로 정의
#define ADD(x, y) ((x) + (y))
#define SUBTRACT(x, y) ((x) - (y))
#define MULTIPLY(x, y) ((x) * (y))
#define DIVIDE(x, y) ((x) / (y))

void calculateExpression() {
	char operator;
	int num1, num2, result;

	printf("수식 입력(종료 Ctrl + Z): ");
	while (scanf("%d %c %d", &num1, &operator, &num2) == 3) {
		switch (operator) {
		case '+':
			result = ADD(num1, num2);
			break;
		case '-':
			result = SUBTRACT(num1, num2);
			break;
		case '*':
			result = MULTIPLY(num1, num2);
			break;
		case '/':
			if (num2 != 0) {
				result = DIVIDE(num1, num2);
			}
			else {
				printf("0으로 나눌 수 없습니다.\n");
				continue;
			}
			break;
		default:
			printf("지원되지 않는 연산자입니다.\n");
			continue;
		}
		printf("%d %c %d = %d\n", num1, operator, num2, result);
		printf("수식 입력(종료 Ctrl + Z): ");
	}
}

int main() {
	calculateExpression();
	return 0;
}


*/

















