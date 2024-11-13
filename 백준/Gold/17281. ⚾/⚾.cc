#include <iostream>
using namespace std;

int N;
int iNing[51][10];
bool check[10];
int result[10];
int scoreMax;

int NIning()
{
    int ex_score = 0;
    int turn = 1;
    int out = 0;
    int person = 0;
    bool site[4] = {false};
    site[0] = true;

    while (turn <= N)
    {
        if (person == 9)
            person = 1;
        else
            person++;

        int ruta = iNing[turn][result[person]];

        if (ruta == 0)
        {
            out++;
            if (out == 3)
            {
                turn++;
                out = 0;
                site[1] = false;
                site[2] = false;
                site[3] = false;
            }
            continue;
        }
        else if (ruta == 4)
        {
            for (int i = 1; i < 4; i++)
            {
                if (site[i])
                {
                    ex_score++;
                    site[i] = false;
                }
            }
            ex_score++;
            continue;
        }

        if (site[3])
        {
            ex_score++;
            site[3] = false;
        }

        if (site[2])
        {
            if (ruta == 1)
                site[3] = true;
            else
                ex_score++;
            site[2] = false;
        }

        if (site[1])
        {
            if (ruta == 3)
                ex_score++;
            else
                site[ruta + 1] = true;
            site[1] = false;
        }

        site[ruta] = true;
    }

    return ex_score;
}

void permitation(int depth)
{
    if (depth == 10)
    {
        int score = NIning();
        if (score > scoreMax)
        {
            scoreMax = score;
        }
        return;
    }

    for (int i = 2; i <= 9; i++)
    {
        if (!check[i])
        {
            check[i] = true;
            result[depth] = i;
            if (depth == 3)
                permitation(5);
            else
                permitation(depth + 1);
            check[i] = false;
        }
    }
}

int main(void)
{
    cin >> N;
    for (int i = 1; i <= N; i++)
    {
        for (int j = 1; j <= 9; j++)
        {
            cin >> iNing[i][j];
        }
    }
    result[4] = 1;
    check[1] = true;

    permitation(1);

    cout << scoreMax;

    return 0;
}