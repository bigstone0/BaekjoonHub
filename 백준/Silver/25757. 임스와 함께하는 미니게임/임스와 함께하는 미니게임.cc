#include <iostream>
#include <string>
#include <sstream>
#include <vector>
#include <set>

using namespace std;

int main()
{
    string strN, buffer;
    int N;
    vector<string> V;

    getline(cin, strN);
    istringstream ss(strN);

    while (getline(ss, buffer, ' '))
    {
        V.push_back(buffer);
    }

    N = stoi(V[0]);

    set<string> Set;

    for (int i = 0; i < N; i++)
    {
        string getStr;
        getline(cin, getStr);
        Set.insert(getStr);
    }

    if (V[1] == "Y")
    {
        cout << Set.size();
    }
    else if (V[1] == "F")
    {
        cout << Set.size() / 2;
    }
    else if (V[1] == "O")
    {
        cout << Set.size() / 3;
    }
}