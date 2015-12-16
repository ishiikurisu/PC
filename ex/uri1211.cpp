#include <iostream>
#include <stdlib.h>
#include <map>
using namespace std;

int walk(string phone, map<char, map> tree, int index)
{
	if (index == phone.length())
		return 0;

	char digit = phone.at(index);
	int result = 0;

	if (tree.count(digit) > 0) {
		result = walk(phone, tree.[digit], index+1) + 1;
	}
	else {
		tree[digit] = map<char, map>();
		result = walk(phone, tree.[digit], index+1);
	}

	return result;
}

int main(int argc, char const *argv[]) {
	int n, economy;
	string phone;
	map<char, map> phones;

	while (cin >> n)
	{
		economy = 0;

		for (size_t i = 0; i < n; i++) {
			cin >> phone;
			economy += walk(phone, phones, 0);
		}

		cout << economy << endl;
		phones.clear();
	}

	return 0;
}
