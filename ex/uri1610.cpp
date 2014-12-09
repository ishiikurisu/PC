#include <iostream>
#include <stdlib.h>
using namespace std;

bool DFS(bool** graph, int limit, bool* relax, int vertex)
{
	bool result = false;

	if (relax[vertex] == true)
		result = true;

	relax[vertex] = true;
	for (int neigh = 0; neigh < limit && result == false; ++neigh)
		if (graph[vertex][neigh] == true && relax[neigh] == false)
			result = DFS(graph, limit, relax, neigh);
		else if (graph[vertex][neigh] == true && relax[neigh] == true)
			result = true;

	return result;
}

main()
{
	int nc;
	int docs, rels;
	int dom, sub;
	bool outlet;
	bool* path;
	bool** ships;

	cin >> nc;
	for (int c = 0; c < nc; c++)
	{
		cin >> docs >> rels;
		path = (bool*) malloc(sizeof(bool)*docs);
		ships = (bool**) malloc(docs*sizeof(bool*));
		for (dom = 0; dom < docs; ++dom)
		{
			ships[dom] = (bool*) malloc(docs*sizeof(bool));
			for (sub = 0; sub < docs; ++sub)
				ships[dom][sub] = false;
		}

		for (int r = 0; r < rels; ++r)
		{
			cin >> dom >> sub;
			ships[dom-1][sub-1] = true;
		}

		outlet = false;
		/* DFS */
		for (dom = 0; dom < docs && outlet == false; ++dom)
		{
			for (sub = 0; sub < docs; ++sub)
				path[sub] = false;
			outlet = DFS(ships, docs, path, dom);
		}

		if (outlet) cout << "SIM";
		else cout << "NAO";
		cout << endl;
	}
}
