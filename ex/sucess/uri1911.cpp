#include <iostream>
#include <sstream>
#include <map>
using namespace std;

int compare(string s, string t)
{
	int c = 0;

	for (int i = 0; i < s.length(); ++i)
		if (s[i] != t[i])
			c++;

	return c;
}

int main(int argc, char const *argv[])
{
	int N, M, n, m, c;
	map<string, string> chamada;
	string nome, assinatura;

	for (cin >> N; N != 0; cin >> N)
	{
		for (int n = 0; n < N; ++n)	
		{
			cin >> nome >> assinatura;
			chamada[nome] = assinatura;
		}

		for (m = 0, c = 0, cin >> M; m < M; ++m)
		{
			cin >> nome >> assinatura;
			if (compare(chamada[nome], assinatura) > 1)
				c++;
		}

		cout << c << endl;
		chamada.clear();
	}

	return 0;
}
