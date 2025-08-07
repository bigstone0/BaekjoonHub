#include <iostream>
#include <vector>
#include <string>
#include <sstream>

using namespace std;

int main()
{
    vector<int> clas;
    int main_tea, sub_tea;
    long long result = 0;

    string str, buffer;
    char delimeter = ' ';

    getline(cin, str);
    int class_num = stoi(str);

    getline(cin, str);
    istringstream iss(str);
    while (getline(iss, buffer, delimeter))
    {
        clas.push_back(stoi(buffer));
    }

    getline(cin, str);
    istringstream iss1(str);
    getline(iss1, buffer, delimeter);
    main_tea = stoi(buffer);
    getline(iss1, buffer, delimeter);
    sub_tea = stoi(buffer);

    for (int i = 0; i < class_num; i++)
    {
        clas[i] -= main_tea;
        result++;

        if (clas[i] <= 0)
            continue;

        result += clas[i] / sub_tea;
        if (clas[i] % sub_tea != 0)
            result++;
    }

    cout << result;
}