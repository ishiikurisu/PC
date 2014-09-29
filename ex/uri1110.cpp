#include <iostream>
#include <cstdlib>
#include <vector>
using namespace std;

int* populate_deck(int deck_size)
{
	int* deck = (int*) malloc(sizeof(int)*deck_size);

	for (int i = 0; i < deck_size; ++i)
		deck[i] = i + 1;

	return deck;
}

main()
{
	int deck_size, temp;
	int* deck;
	vector<int> discard;

	cin >> deck_size;
	while (deck_size > 0)
	{
		deck = populate_deck(deck_size);
		while (deck_size > 1)
		{
			discard.push_back(deck[0]);
			temp = deck[1];
			for (int i = 0; i < deck_size - 3; ++i) 
				deck[i] = deck[i+2];
			deck[deck_size-2] = temp;
			deck_size--;
		}

		cout << "Discarded cards:";
		for (vector<int>::iterator it = discard.begin(); it != discard.end(); it++)
			cout << " " << *it;
		cout << endl;
		cout << "Remaining cards: " << deck[0] << endl;
		
		discard.clear();
		cin >> deck_size;
	}
}
