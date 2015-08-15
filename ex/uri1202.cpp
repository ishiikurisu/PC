#include <stdlib.h>
#include <stdio.h>
#include <math.h>
#include <iostream>
#include <vector>
#include <bitset>
#define LIMIT 10000
using namespace std;

int T;
vector<unsigned long long> fib;

void strrev(char *p)
{
  char *q = p;
  while(q && *q) ++q;
  for(--q; p < q; ++p, --q)
    *p = *p ^ *q,
    *q = *p ^ *q,
    *p = *p ^ *q;
}

void setup()
{
	fib.push_back(0);
	fib.push_back(1);
	fib.push_back(1);

	unsigned long long fn = fib[n-1] + fib[n-2];
	while (fn < 1000)
	{
		fib.push_back(fn);
		fn = fib[n-1] + fib[n-2];
	}

	fib.pop_front();
	cout << fib[fib.size()-1] << endl;
}

void loop()
{
	string inlet;

	cin >> inlet;
	
}


int main(int argc, char const *argv[])
{

	setup();
	while (cin >> T)
	{
		for (int t = 0; t < T; ++t)
			loop();
	}

	return 0;
}
