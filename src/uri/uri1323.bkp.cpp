#include <iostream>
using namespace std;

main()
{
	int side;
	int square;
	int size;
	bool flag;

	cin >> side;
	while (side > 0)
	{
		square = 0;
		size = 1;
		flag = true;

		while (flag == true)
		{
			flag = false;

			for (int x = 0; x < side; ++x)
				for (int y = 0; y < side; ++y)
					if (x + size <= side && y + size <= side)
					{
						++square;
						flag = true;
					}
					else continue;

			++size;
		}

		cout << square << endl;
		cin >> side;
	}
}
