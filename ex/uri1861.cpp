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

    /* remove dead people */
    set<string>::iterator it;
    for (it = dead.begin(); it != dead.end(); ++it)
        if (alive.count(*it) != 0)
            alive.erase(*it);

    /* sort killers */
    vector<string> survivors;
    for (it = alive.begin(); it != alive.end(); ++it)
        survivors.push_back(*it);
    sort(survivors.begin(), survivors.end());

    /* show killrate */
    vector<string>::iterator i;
    cout << "HALL OF MURDERERS" << endl;
    for (i = survivors.begin(); i != survivors.end(); ++i)
        cout << *i << " " << killrate[*i] << endl;

    return 0;
}
