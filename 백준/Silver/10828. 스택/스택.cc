#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct Node
{
	int data;
	struct Node* pre;
}Node;

typedef struct Stack
{
	Node* front;
	Node* rear;
	int count;
}Stack;

void initStack(Stack* stack)
{
	stack->front = stack->rear = NULL;
	stack->count = 0;
}

int isEmpty(Stack* stack)
{
	return stack->count == 0;
}

void push(Stack* stack, int data)
{
	Node* newNode = (Node*)malloc(sizeof(Node));
	newNode->data = data;
	newNode->pre = NULL;

	if (isEmpty(stack))
	{
		stack->front = newNode;
	}
	else {
		newNode->pre = stack->rear;
	}
	stack->rear = newNode;
	stack->count++;
}

int pop(Stack* stack) {
	int data;
	Node* ptr;
	if (isEmpty(stack))
	{
		return -1;
	}
	ptr = stack->rear;
	data = ptr->data;
	stack->rear = ptr->pre;
	free(ptr);
	stack->count--;

	return data;
}

int main(void)
{
	int T;
	scanf("%d", &T);
	Stack stack;
	initStack(&stack);
	for (int i = 0; i < T; i++) {
		char ch[10];
		scanf("%s", ch);
		int num;
		if (strcmp(ch,"push")==0)
		{
			scanf("%d", &num);
			push(&stack, num);
		}
		else if (strcmp(ch, "pop") == 0) printf("%d\n", pop(&stack));
		else if (strcmp(ch, "size") == 0) printf("%d\n", stack.count);
		else if (strcmp(ch, "empty") == 0) {
			if (isEmpty(&stack) == 0) printf("%d\n",0);
			else printf("%d\n",1);
		}
		else if (strcmp(ch, "top") == 0) {
			if (isEmpty(&stack) == 1) printf("%d\n", -1);
			else printf("%d\n", stack.rear->data);
		}
	}

	return 0;
}