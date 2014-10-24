#include <iostream>
#include <iomanip>
#include <vector>
using namespace std;

vector<float> costs;
float md;
int qtd;

bool read()
{
	float temp;
	qtd = 0;
	md = 0.0;

	cin >> qtd;
	if (qtd == 0) return false;

	costs.clear();
	for (int i = 0; i < qtd; ++i)
	{
		cin >> temp;
		costs.push_back(temp);
		md += temp;
	}
	md = md / qtd;

	return true;
}

main()
{
	float diff;
	float temp;

	cout << fixed << setprecision(2);

	while (read())
	{
		diff = 0.0;
		for (int i = 0; i < qtd; ++i)
		{
			temp = md - costs.at(i);
			if (temp > 0)
				diff += temp;
			else
				diff -= temp;
		}
		cout << "$" << (diff/2) << endl;
	}
}
