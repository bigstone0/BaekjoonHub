#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <climits>
using namespace std;

int g_N;
vector<int> g_A;
int g_plus = 0;
int g_minus = 0;
int g_multi = 0;
int g_div = 0;
int result_max = INT_MIN;
int result_min = INT_MAX;

void next(int num, int sum);

int main()
{
    string str, buffer;
    char delimeter = ' ';

    getline(cin, str);
    istringstream iss(str);
    getline(iss, buffer, delimeter);
    g_N = stoi(buffer);

    getline(cin, str);
    istringstream iss1(str);
    for (int i = 0; i < g_N; i++)
    {
        getline(iss1, buffer, delimeter);
        g_A.push_back(stoi(buffer));
    }

    getline(cin, str);
    istringstream iss2(str);
    getline(iss2, buffer, delimeter);
    g_plus = stoi(buffer);
    getline(iss2, buffer, delimeter);
    g_minus = stoi(buffer);
    getline(iss2, buffer, delimeter);
    g_multi = stoi(buffer);
    getline(iss2, buffer, delimeter);
    g_div = stoi(buffer);

    next(1, g_A[0]);

    cout << result_max << "\n"
         << result_min;
}

void next(int num, int sum)
{
    if (num == g_N)
    {
        if (sum < result_min)
            result_min = sum;

        if (sum > result_max)
            result_max = sum;
        return;
    }
    else
    {
        if (g_plus > 0)
        {
            g_plus--;
            next(num + 1, sum + g_A[num]);
            g_plus++;
        }
        if (g_minus > 0)
        {
            g_minus--;
            next(num + 1, sum - g_A[num]);
            g_minus++;
        }
        if (g_multi > 0)
        {
            g_multi--;
            next(num + 1, sum * g_A[num]);
            g_multi++;
        }
        if (g_div > 0)
        {
            g_div--;
            next(num + 1, sum / g_A[num]);
            g_div++;
        }
        return;
    }
}