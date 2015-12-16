#include <iostream>
#include <stdlib.h>
#include <map>
using namespace std;

int walk(string phone, map<char, void*> *tree, int index)
{
	if (index == phone.length())
		return 0;

	char digit = phone.at(index);
	int result = 0;
	void *ptr;

	if (tree->count(digit) > 0) {
		ptr = (*tree)[digit];
		result = walk(phone, (map<char, void*>*) ptr, index+1) + 1;
	}
	else {
		(*tree)[digit] = new map<char, void*>();
		ptr = (*tree)[digit];
		result = walk(phone, (map<char, void*>*) ptr, index+1);
	}

	return result;
}

int main(int argc, char const *argv[]) {
	int n, economy;
	string phone;
	void *phones;

	while (cin >> n)
	{
		economy = 0;
		phones = new map<char, void*>();

		for (size_t i = 0; i < n; i++) {
			cin >> phone;
			economy += walk(phone, (map<char, void*>*) phones, 0);
		}

		cout << economy << endl;
		free(phones);
	}

	return 0;
}
