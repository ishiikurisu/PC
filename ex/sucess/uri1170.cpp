#include <iostream>
#include <vector>
using namespace std;

vector<float> supplies;
vector<int> day_count;
int days;

void readData()
{
  cin >> days;

  for (int i = 0; i < days; i++)
  {
    float supply;
    cin >> supply;
    supplies.push_back(supply);
  }
}

int count(float supply)
{
  int day = 0;

  while (supply > 1)
  {
    supply /= 2;
    day++;
  }

  return day;
}

void processData()
{
  for (int i = 0; i < days; i++)
    day_count.push_back(count(supplies.at(i)));
}

void writeData()
{
  for (int i = 0; i < days; i++)
    cout << day_count.at(i) << " dias" << endl;
}

main()
{
  readData();
  processData();
  writeData();
}
