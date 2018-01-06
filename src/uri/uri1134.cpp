#include <iostream>
using namespace std;

main()
{
	int input;
	int acl = 0, gas = 0, dsl = 0;

	do 
	{
		cin >> input;
		switch (input)
		{
			case 1: acl++; break;
			case 2: gas++; break;
			case 3: dsl++; break;
		}
	} while (input != 4);

	cout << "MUITO OBRIGADO" << endl;
	cout << "Alcool: " << acl << endl;
	cout << "Gasolina: " << gas << endl;
	cout << "Diesel: " << dsl << endl;
}
