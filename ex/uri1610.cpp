#include <iostream>
#include <stdlib.h>
using namespace std;

main()
{
	int nc;
	bool* path;
	int dom, sub;
	int doc, fil;
	int docs, rels;
	bool outlet;

	cin >> nc;
	for (int c = 0; c < nc; c++)
	{
		cin >> docs >> rels;
		bool ships[docs][docs];

		for (int r = 0; r < rels; ++r)
		{
			cin >> dom >> sub;
			ships[dom-1][sub-1] = true;
		}

		outlet = false;
		for (doc = 0; doc < docs && !outlet; ++doc)
		{
			path = (bool*) malloc(sizeof(bool)*docs);
			for (fil = 0; fil < docs; ++fil)
				if (ships[doc][fil])
					path[fil] = true;
			for (int i = 0; i < docs; ++i)
				if (path[i] && i != doc)
				{
					dom = i;
					for (sub = 0; sub < docs; ++sub)
						if (ships[dom][sub] && !path[sub])
							path[sub] = true;
				}
			if (path[doc]) outlet = path[doc];
			free(path);
		}

		if (outlet) cout << "SIM";
		else cout << "NAO";
		cout << endl;
	}
}
