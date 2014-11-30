#include <iostream>
#include <math.h>
using namespace std;
const unsigned long LIMIT = (unsigned long) pow(10, 12);

unsigned long to_bin (unsigned long index) {
  unsigned long outlet = 0;
  unsigned int digit = 0;

  while ((index >> digit) > 0)
  {
    if (digit > 0 && outlet == 0)
      outlet = 10;
    else
      outlet *= 10;

    if ((index >> digit) & 0x1)
      ++outlet;
    ++digit;
  }

  if (index % 2 == 0) --outlet;
  return outlet;
}

main()
{
  unsigned long index = 1;
  unsigned long number = to_bin(index);

  cout << "{";
  while (number < LIMIT)
  {
    cout << number << ", ";
    ++index;
    number = to_bin(index);
  }
  cout << index << "}" << endl;
}
