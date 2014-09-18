#include <iostream>

main()
{
	int count = 0;
	float numb;
	float sum = 0.0;

	for (int i = 0; i < 6; i++)
	{
		std::cin >> numb;
		if (numb > 0)
		{
			sum += numb;
			count++;
		}
	}

	std::cout << count << " valores positivos\n";
	std::cout << sum / count << "\n";
}
