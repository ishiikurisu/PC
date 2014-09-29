#include <iostream>
using namespace std;

main()
{
  string sentence;
  int index = 0;
  int change_case = 97 - 65;
  bool occur;

  while (getline(cin, sentence))
  {
    index = 0;
    occur = true;
    while (sentence[index] != '\0')
    {
      if ((sentence[index] >= 65 && sentence[index] <= 91) ||
        (sentence[index] >= 97 && sentence[index] <= 122))
      {
        if (occur && sentence[index] > 91) sentence[index] -= change_case;
        else if (!occur && sentence[index] <= 91) sentence[index] += change_case;
        occur = !occur;
      }
      index++;
    }

    cout << sentence << endl;
  }

}
