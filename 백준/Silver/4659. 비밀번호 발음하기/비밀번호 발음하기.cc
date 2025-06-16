#include <iostream>
#include <string>
#include <sstream>
using namespace std;
bool checkPass(string str);

int main()
{
    string str;
    string result, result_str;

    while (1)
    {
        getline(cin, str);

        if (str == "end")
        {
            cout << result;
            return 0;
        }

        if (checkPass(str))
        {
            result_str = "<" + str + ">" + " is acceptable. \n";
            result.append(result_str);
        }
        else
        {
            result_str = "<" + str + ">" + " is not acceptable. \n";
            result.append(result_str);
        }
    }
    return 0;
}

bool checkPass(string str)
{
    if (str.find('a') == string::npos && str.find('e') == string::npos && str.find('i') == string::npos && str.find('o') == string::npos && str.find('u') == string::npos)
    {
        return false;
    }

    int Astack = 0; // 모음
    int Bstack = 0; // 자음

    for (int i = 0; i < str.length(); i++)
    {
        if (str.at(i) == 'a' || str.at(i) == 'e' || str.at(i) == 'i' || str.at(i) == 'o' || str.at(i) == 'u')
        {
            Astack++;
            Bstack = 0;
        }
        else
        {
            Bstack++;
            Astack = 0;
        }

        if (Astack == 3 || Bstack == 3)
        {
            return false;
        }
    }

    for (int i = 0; i < str.length() - 1; i++)
    {
        if (str.at(i) == str.at(i + 1))
        {
            if (str.at(i) != 'e' && str.at(i) != 'o')
            {
                return false;
            }
        }
    }

    return true;
}