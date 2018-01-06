#include <stdlib.h>
#include <iostream>
#include <vector>
#include <set>
#include <map>
#include <algorithm>
using namespace std;

int main(int argc, char const *argv[]) {
    map<string, int> killrate;
    set<string> alive;
    set<string> dead;
    string killer, killed;

    /* read events */
    while (cin >> killer >> killed)
    {
        if (killrate.count(killer) == 0)
            killrate[killer] = 0;
        killrate[killer]++;
        dead.insert(killed);
        alive.insert(killer);
    }

    /* sort killers */
    vector<string> survivors;
    set<string>::iterator it;
    for (it = alive.begin(); it != alive.end(); ++it)
        if (dead.count(*it) == 0)
            survivors.push_back(*it);
    sort(survivors.begin(), survivors.end());

    /* show killrate */
    vector<string>::iterator i;
    cout << "HALL OF MURDERERS" << endl;
    for (i = survivors.begin(); i != survivors.end(); ++i)
        cout << *i << " " << killrate[*i] << endl;

    return 0;
}
