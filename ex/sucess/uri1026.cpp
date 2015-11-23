#include <iostream>
using namespace std;

unsigned long setbit(unsigned long b, unsigned long c, unsigned long v) {
	return (v)? (b | (1 << c)) : (b & ~(1 << c));
}

unsigned long getbit(unsigned long b, unsigned long c)
{
	return b & (1 << c);
}

int main(int argc, char const *argv[]) {
	unsigned long x, y, z, i, a, b;

	while (cin >> x >> y)
	{
		z = 0;
		for (i = 0; i < 32; ++i)
		{
			a = getbit(x, i);
			b = getbit(y, i);
			if (!(a && b))
				z = setbit(z, i, a || b);
		}
		cout << z << endl;
	}

	return 0;
}
