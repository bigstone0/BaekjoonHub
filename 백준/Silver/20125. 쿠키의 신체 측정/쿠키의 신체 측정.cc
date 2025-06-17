#include <iostream>
#include <string>
#include <vector>

using namespace std;

int leftArm(vector<vector<string>> v, int x, int y);
int rightArm(vector<vector<string>> v, int x, int y);
int bottom(vector<vector<string>> v, int x, int y);

int main()
{
    string str;
    getline(cin, str);
    int N = stoi(str);
    vector<vector<string>> v;
    bool flag = true;
    int x, y;

    for (int i = 0; i < N; i++)
    {
        vector<string> v1;
        getline(cin, str);
        for (size_t j = 0; j < str.length(); j++)
        {
            string char_str = str.substr(j, 1);
            v1.push_back(char_str);

            if (flag && char_str == "*")
            {
                x = j;
                y = i + 1;
                flag = false;
            }
        }
        v.push_back(v1);
    }

    cout << y + 1 << " " << x + 1 << endl;
    cout << leftArm(v, x - 1, y) << " " << rightArm(v, x + 1, y);

    int next = bottom(v, x, y + 1);
    y += next;

    cout << " " << next << " " << bottom(v, x - 1, y + 1) << " " << bottom(v, x + 1, y + 1);
}

int leftArm(vector<vector<string>> v, int x, int y)
{
    int xx = x;
    int yy = y;
    int count = 0;

    while (1)
    {
        if (xx == -1 || xx == v[0].size() || v[yy][xx] == "_")
            break;
        else
        {
            count++;
            xx += -1;
        }
    }

    return count;
}

int rightArm(vector<vector<string>> v, int x, int y)
{
    int xx = x;
    int yy = y;
    int count = 0;

    while (1)
    {
        if (xx == -1 || xx == v[0].size() || v[yy][xx] == "_")
            break;
        else
        {
            count++;
            xx += 1;
        }
    }

    return count;
}

int bottom(vector<vector<string>> v, int x, int y)
{
    int xx = x;
    int yy = y;
    int count = 0;

    while (1)
    {
        if (yy == -1 || yy == v.size() || v[yy][xx] == "_")
            break;
        else
        {
            count++;
            yy += 1;
        }
    }
    return count;
}