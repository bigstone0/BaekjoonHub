#include <iostream>
#include <sstream>
#include <string>
#include <vector>

using namespace std;

bool checkBox(vector<vector<int>> map, int x, int y);

int main()
{
    string str, buffer;
    char delimeter = ' ';
    int map_x, map_y, robot_x, robot_y, robot_dir;
    vector<vector<int>> map;
    int result = 0;
    int dir_x[4] = {0, 1, 0, -1};
    int dir_y[4] = {-1, 0, 1, 0};

    getline(cin, str);
    istringstream iss(str);
    getline(iss, buffer, delimeter);
    map_y = stoi(buffer);
    getline(iss, buffer, delimeter);
    map_x = stoi(buffer);

    getline(cin, str);
    istringstream iss1(str);
    getline(iss1, buffer, delimeter);
    robot_y = stoi(buffer);
    getline(iss1, buffer, delimeter);
    robot_x = stoi(buffer);
    getline(iss1, buffer, delimeter);
    robot_dir = stoi(buffer);

    for (int i = 0; i < map_y; i++)
    {
        getline(cin, str);
        istringstream iss2(str);
        vector<int> input;
        for (int j = 0; j < map_x; j++)
        {
            getline(iss2, buffer, delimeter);
            input.push_back(stoi(buffer));
        }
        map.push_back(input);
    }

    while (1)
    {
        bool flag = false;

        if (robot_x < 0 || robot_x >= map[0].size() || robot_y < 0 || robot_y >= map.size() || map[robot_y][robot_x] == 1)
        {
            break;
        }

        if (checkBox(map, robot_x, robot_y))
        {
            map[robot_y][robot_x] = 2;
            result++;
            continue;
        }

        for (int i = 0; i < 4; i++)
        {
            int dirRx = robot_x + dir_x[i];
            int dirRy = robot_y + dir_y[i];
            if (checkBox(map, dirRx, dirRy))
            {
                flag = true;
                break;
            }
        }

        if (flag)
        {
            robot_dir -= 1;
            if (robot_dir == -1)
                robot_dir = 3;

            if (checkBox(map, robot_x + dir_x[robot_dir], robot_y + dir_y[robot_dir]) && map[robot_y + dir_y[robot_dir]][robot_x + dir_x[robot_dir]] == 0)
            {
                robot_x += dir_x[robot_dir];
                robot_y += dir_y[robot_dir];
            }
        }
        else
        {
            if (robot_dir == 0)
                robot_y += 1;
            else if (robot_dir == 1)
                robot_x -= 1;
            else if (robot_dir == 2)
                robot_y -= 1;
            else if (robot_dir == 3)
                robot_x += 1;
        }
    }

    cout << result;
}

bool checkBox(vector<vector<int>> map, int x, int y)
{
    if (x < 0 || x >= map[0].size() || y < 0 || y >= map.size())
        return false;

    if (map[y][x] == 0)
        return true;
    else
        return false;
}