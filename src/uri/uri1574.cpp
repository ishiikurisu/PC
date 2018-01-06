#include <iostream>
#include <vector>
#include <cstdio>
using namespace std;

main()
{
	int num_tests, num_commands;
	string command;
	int position = 0;
	vector<bool> commands;

	cin >> num_tests;
	for (int i = 0; i < num_tests; i++)
	{
		position = 0;

		cin >> num_commands;
		cout << num_commands << endl;
		for (int c = 0; i < num_commands; c++)
		{
			cin >> command;
			fflush(stdout);
			cout << command << endl;
			if (command == "LEFT")
			{ 
				commands.push_back(false);
				position--;
			}
			else if (command == "RIGHT")
			{
				commands.push_back(true);
				position++;
			}
			else
			{
				int input;
				cin >> command >> input;
				position += (commands[input-1])? 1: -1;
			}
		}
		cout << position << endl;
		commands.clear();
	}
}
