#include <iostream>
#include <vector>
#include <string>
#include <sstream>

using namespace std;

int main()
{
    vector<int> sh;
    vector<int> gender;
    vector<int> number;
    string str;
    int N, person;

    getline(cin, str);
    N = stoi(str);
    sh.push_back(-1);

    getline(cin, str);
    istringstream iss(str);
    string buffer;
    char delimeter = ' ';

    while (getline(iss, buffer, delimeter))
    {
        sh.push_back(stoi(buffer));
    }

    getline(cin, str);
    person = stoi(str);

    for (int i = 0; i < person; i++)
    {
        getline(cin, str);
        istringstream iss1(str);
        int s, nu;

        getline(iss1, buffer, delimeter);
        s = stoi(buffer);
        gender.push_back(s);

        getline(iss1, buffer, delimeter);
        nu = stoi(buffer);
        number.push_back(nu);
    }

    for (int i = 0; i < person; i++)
    {
        int s = gender[i];
        int num = number[i];
        int total_num = number[i];

        if (s == 1)
        {
            while (1)
            {
                if (sh[total_num] == 1)
                {
                    sh[total_num] = 0;
                    total_num += num;
                }
                else if (sh[total_num] == 0)
                {
                    sh[total_num] = 1;
                    total_num += num;
                }

                if (total_num > N)
                    break;
            }
        }
        else if (s == 2)
        {
            int front_num = number[i];
            int back_num = number[i];

            if (sh[front_num] == 0)
                sh[front_num] = 1;
            else
                sh[front_num] = 0;

            while (1)
            {
                front_num -= 1;
                back_num += 1;

                if (front_num == 0 || back_num > N)
                    break;

                if (sh[front_num] == sh[back_num])
                {
                    if (sh[front_num] == 1)
                    {
                        sh[front_num] = 0;
                        sh[back_num] = 0;
                    }
                    else
                    {
                        sh[front_num] = 1;
                        sh[back_num] = 1;
                    }
                }
                else
                    break;
            }
        }
    }

    for (int i = 1; i <= N; i++)
    {
        cout << sh[i];
        if (i % 20 == 0)
            cout << "\n";
        else
            cout << " ";
    }
}