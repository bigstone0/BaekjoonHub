#include <iostream>
#include <vector>
#include <sstream>
#include <string>
using namespace std;

int main()
{
    vector<vector<int>> A;
    vector<vector<bool>> check;
    vector<int> d;
    vector<int> s;
    int N, M;
    int dx[] = {0, -1, -1, -1, 0, 1, 1, 1};
    int dy[] = {-1, -1, 0, 1, 1, 1, 0, -1};
    string str, buffer;
    char delimeter = ' ';

    getline(cin, str);
    istringstream iss(str);
    getline(iss, buffer, delimeter);
    N = stoi(buffer);
    getline(iss, buffer, delimeter);
    M = stoi(buffer);

    for (int i = 0; i < N; i++)
    {
        getline(cin, str);
        istringstream iss(str);
        vector<int> v;
        vector<bool> boolV;
        for (int j = 0; j < N; j++)
        {
            getline(iss, buffer, delimeter);
            v.push_back(stoi(buffer));
            boolV.push_back(false);
        }
        A.push_back(v);
        check.push_back(boolV);
    }

    for (int i = 0; i < M; i++)
    {
        getline(cin, str);
        istringstream iss(str);
        getline(iss, buffer, delimeter);
        d.push_back(stoi(buffer));
        getline(iss, buffer, delimeter);
        s.push_back(stoi(buffer));
    }

    vector<int> x;
    vector<int> y;

    x.push_back(N - 1);
    y.push_back(0);
    x.push_back(N - 1);
    y.push_back(1);
    x.push_back(N - 2);
    y.push_back(0);
    x.push_back(N - 2);
    y.push_back(1);

    for (int i = 0; i < M; i++)
    {
        // 1 구름 이동
        for (int j = 0; j < s[i]; j++)
        {
            for (int k = 0; k < x.size(); k++)
            {
                x[k] += dx[d[i] - 1];
                if (x[k] == -1)
                    x[k] = N - 1;
                else if (x[k] == N)
                    x[k] = 0;

                y[k] += dy[d[i] - 1];
                if (y[k] == -1)
                    y[k] = N - 1;
                else if (y[k] == N)
                    y[k] = 0;
            }
        }

        // 2 물의 양 1 증가
        for (int j = 0; j < x.size(); j++)
        {
            A[x[j]][y[j]] += 1;
            check[x[j]][y[j]] = true;
        }

        // 4 물복사버그
        for (int j = 0; j < x.size(); j++)
        {
            for (int k = 1; k < 8; k += 2)
            {
                if (x[j] + dx[k] >= 0 && x[j] + dx[k] < N && y[j] + dy[k] >= 0 && y[j] + dy[k] < N)
                {
                    if (A[x[j] + dx[k]][y[j] + dy[k]] > 0)
                        A[x[j]][y[j]] += 1;
                }
            }
        }

        // 3 구름 소멸
        x.clear();
        y.clear();

        for (int j = 0; j < N; j++)
        {
            for (int k = 0; k < N; k++)
            {
                if (check[j][k])
                    check[j][k] = false;
                else
                {
                    if (A[j][k] >= 2)
                    {
                        x.push_back(j);
                        y.push_back(k);
                        A[j][k] -= 2;
                    }
                }
            }
        }
    }

    int result = 0;
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < N; j++)
        {
            result += A[i][j];
        }
    }

    cout << result;

    return 0;
}