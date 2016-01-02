#include <iostream>
using namespace std;
#define rem(A,B) (((A)%(B) != 0)? 1 : 0)

int get_rounds(int ducks)
{
	if (ducks == 1)
		return 0;
    else if (ducks <= 3)
        return 1;
    else
        return ducks/3 +
               rem(ducks, 3) +
			   get_rounds(ducks/3 + rem(ducks, 3));
}

main()
{
    int ducks;

    for (cin >> ducks; ducks > 0; cin >> ducks)
        cout << get_rounds(ducks) << endl;
}
