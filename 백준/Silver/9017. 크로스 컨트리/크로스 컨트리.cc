#include <iostream>
#include <sstream>
#include <string>
#include <vector>
#include <algorithm>
using namespace std;

int main()
{
    string str;

    getline(cin, str);
    int gameNum = stoi(str);
    vector<int> t_result;

    for (int i = 0; i < gameNum; i++)
    {
        vector<int> team_number;
        vector<int> team_count(201);
        vector<int> team_result(201);
        vector<int> team_last(201);
        vector<int> V;
        getline(cin, str);
        int personNum = stoi(str);
        string buffer;
        char delimeter = ' ';
        int result = 0;

        getline(cin, str);
        istringstream iss(str);

        while (getline(iss, buffer, delimeter))
        {
            int team = stoi(buffer);
            V.push_back(team);
            team_count[team] += 1;
            auto it = find(team_number.begin(), team_number.end(), team);
            if (it == team_number.end())
                team_number.push_back(team);
        }

        // V.erase(remove(V.begin(), V.end(), 1), V.end());
        for (int j = 0; j < team_number.size(); j++)
        {
            if (team_count[team_number[j]] < 6)
            {
                V.erase(remove(V.begin(), V.end(), team_number[j]), V.end());
            }
        }

        for (int j = 0; j < V.size(); j++)
        {
            if (team_count[V[j]] > 2)
                team_result[V[j]] += j + 1;

            team_count[V[j]]--;

            if (team_count[V[j]] == 1)
                team_last[V[j]] = j + 1;
        }

        for (int j = 0; j < team_number.size(); j++)
        {
            if (team_result[team_number[j]] == 0)
            {
                continue;
            }

            if (result == 0)
            {
                result = team_number[j];
                continue;
            }
            if (team_result[team_number[j]] < team_result[result])
            {
                result = team_number[j];
            }
            else if (team_result[team_number[j]] == team_result[result])
            {
                if (team_last[team_number[j]] < team_last[result])
                {
                    result = team_number[j];
                }
            }
        }

        t_result.push_back(result);
    }

    for (int i = 0; i < t_result.size(); i++)
    {
        cout << t_result[i] << "\n";
    }
}