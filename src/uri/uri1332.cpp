#include <iostream>
#include <string>
#include <list>
using namespace std;

int amount;
list<int> results;
list<string> words;

bool readData()
{
  bool flag = true;
  string word;

  cin >> amount;
  if (amount == 0)
    flag = false;
  else for (int i = 0; i < amount; i++)
  {
    cin >> word;
    words.push_back(word);
  }

  return flag;
}

int discover_word(string word)
{
  int length = word.length();
  int result = 0;;

  if (length == 5)
    result = 3;
  else
  {
    string oneS = "one";
    string twoS = "two";
    int one = 0;
    int two = 0;

    for (int l = 0; l < length; l++)
    {
      if (word[l] == oneS[l]) one++;
      if (word[l] == twoS[l]) two++;
    }
    result = (one > two)? 1: 2;
  }

  return result;
}

void processData()
{
  int result;

  for (list<string>::iterator word = words.begin(); word != words.end(); word++)
  {
    result = discover_word(*word);
    results.push_back(result);
  }
}

void writeData()
{
  for (list<int>::iterator result = results.begin(); result != results.end(); result++)
  {
    cout << *result << endl;
  }

  results.clear();
  words.clear();
}

main()
{
  readData();
  processData();
  writeData();
  /*
  while(readData())
  {
    processData();
    writeData();
  }
  */
}
