#include <iostream>
#include <vector>

main()
{
  int coin;
  int john, mary;
  int plays;

  std::cin >> plays;
  while (plays != 0)
  {
    john = mary = 0;
    for (int i = 0; i < plays; i++)
    {
      std::cin >> coin;
      if (coin) john++;
      else mary++;
    }

    std::cout << "Mary won " << mary << " times and ";
    std::cout << "John won " << john << " times" << std::endl;

    std::cin >> plays;
  }
}
