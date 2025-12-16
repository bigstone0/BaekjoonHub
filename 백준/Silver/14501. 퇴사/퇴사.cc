#include <iostream>
#include <vector>
#include <sstream>
#include <string>
using namespace std;

vector<int> g_T;
vector<int> g_P;
vector<int> g_dy;
int g_N;
int result = 0;

int next(int num);

int main()
{
    int N;
    string str, buffer;
    char delimeter = ' ';

    getline(cin, str);
    istringstream iss(str);
    getline(iss, buffer, delimeter);
    g_N = stoi(buffer);

    for (int i = 0; i < g_N; i++)
    {
        getline(cin, str);
        istringstream iss(str);
        getline(iss, buffer, delimeter);
        g_T.push_back(stoi(buffer));
        getline(iss, buffer, delimeter);
        g_P.push_back(stoi(buffer));
        g_dy.push_back(0);
    }

    for (int i = 0; i < g_N; i++)
    {
        int one = next(i);
        if (one > result)
            result = one;
    }

    cout << result;
}

int next(int num)
{
    int next_num = num + g_T[num] - 1;

    if (g_dy[num] != 0)
    {
        return g_dy[num];
    }
    else
    {
        if (next_num + 1 == g_N)
            return g_P[num];

        for (int i = next_num + 1; i < g_N; i++)
        {
            int next_sum = next(i) + g_P[num];
            if (next_sum > g_dy[num])
                g_dy[num] = next_sum;
        }
        return g_dy[num];
    }
}