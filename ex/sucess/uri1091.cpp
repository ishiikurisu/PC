#include <iostream>
using namespace std;

main()
{
	int nc;
	int div[2];
	int pt[2];
	

	cin >> nc;
	while (nc > 0) 
	{
		cin >> div[0] >> div[1];
		for (int i = 0; i < nc; ++i)
		{
			cin >> pt[0] >> pt[1];
			
			if (pt[0] == div[0] || pt[1] == div[1])
				cout << "divisa";
			else
			{
				if (pt[1] < div[1]) cout << "S";
				else cout << "N";
				if (pt[0] < div[0]) cout << "O";
				else cout << "E";
			}
			cout << endl;
		}
		cin >> nc;
	}
}
