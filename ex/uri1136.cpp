#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

main()
{
	int N, B;
	vector<int> bs;
	vector<int> aa;
	int bl;

	cin >> N >> B;
	while (N != 0 && B != 0)
	{
		for (int b = 0; b < B; ++b)
		{
			cin >> bl;
			bs.push_back(bl);
		}
		for (int a = 0; a < B; ++a)
			for (int b = a; b < B; ++b)
				aa.push_back(abs(a-b));
		qsort(aa);
		

		bs.clear();
		cin >> N >> B;
	}
}
