#include <stdlib.h>
#include <iostream>
#include <vector>
#define NUMBER_CARDS 52
using namespace std;

int N;
int card;
bool winner;
vector<string> players;
vector<bool> active;
vector<int> cards;

void setup()
{
	string player;

	for (int n = 0; n < N; n++)
	{
		cin >> player;
		players.push_back(player);
		active.push_back(true);
	}

	for (int c = 0; c < NUMBER_CARDS; c++)
	{
		cin >> card;
		cards.push_back(card);
	}

	winner = false;
	card = 0;
}

void loop()
{
	int i = 0;

	for (i = 0; i < N; ++i)
	{
		if ()
	}

	card++;
}

void clean()
{
	active.clear();
	players.clear();
	cards.clear();
}

int main(int argc, char const *argv[])
{
	cin >> N;
	while (N > 0)
	{
		setup();
		while (!winner && card < NUMBER_CARDS)
			loop();

		/* write results */
		clean();
		cin >> N;
	}

	return 0;
}
