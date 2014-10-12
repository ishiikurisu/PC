#include <iostream>

main()
{
  int r;
  while (std::cin >> r)
  {
    if (r == 0) std::cout << "vai ter copa!";
    else std::cout << "vai ter duas!";
    std::cout << std::endl;
  }
}
