#include <stdio.h>
#include <stdlib.h>

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

void push(Stack* stack, char data)
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
	char data;
	Node* ptr;
	if (isEmpty(stack))
	{
		printf("Error : Stack is empty!\n");
		return 0;
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


	for (int i = 0; i < T; i++) {
		char str[51];
		scanf("%s", str);
		int flag = 0;

		Stack stack;
		initStack(&stack);

		for (int i = 0; i < sizeof(str); i++) {
			if (str[i] == '\0') break;

			if (str[i] == '(') push(&stack, str[i]);
			else
			{
				if (isEmpty(&stack)) {
					flag = 1;
					break;
				}
				else
				{
					pop(&stack);
				}
			}
		}
		
		if (flag == 1) puts("NO");
		else
		{
			if (!isEmpty(&stack)) puts("NO");
			else puts("YES");
		}
	}

	return 0;
}