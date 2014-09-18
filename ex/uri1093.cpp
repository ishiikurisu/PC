#include <iostream>
#include <vector>
#include <cstdio>
#include <cmath>
#define NUM_VALUES 4
#define DICE_SIZE (6.0)
using namespace std;

vector<int> vamp;
float result;

/* DATA STRUCTURES */
int tree_size(int life, int damage)
{
  int hits = 0;

  while (life > 0)
  {
    life -= damage;
    hits++;
  }

  return hits;
}

/* MAIN FUNCTIONS */
bool readData()
{
  int cont = NUM_VALUES;
  int value;

  for (int i = 0; i < NUM_VALUES; i++)
  {
    cin >> value;
    vamp.push_back(value);
    if (value == 0) cont--;
  }

  if (cont)
    return true;
  else
    return false;
}

float jsum(int AT, int left) {
  float sum = 0;
  float die = DICE_SIZE;

  for (int i = 1; i < 16; i++) {
    sum += (pow((AT/die)*((die-AT)/die), i))*pow(AT/die, left);
  }

  sum = 2*sum + pow(AT/die, left);

  return sum;
}

void processData()
{
  /*
  int player1life = vamp.at(0);
  int player2life = vamp.at(1);
  int AT = vamp.at(2);
  int DAM = vamp.at(3);
  */
  int left_size = tree_size(vamp.at(1), vamp.at(3));
  int right_size = tree_size(vamp.at(0), vamp.at(3));
  float vic = vamp.at(2) / DICE_SIZE;
  float pow_left = pow(vic, left_size);
  float pow_right = pow(1 - vic, right_size);

  result = 100 * (pow_left / (pow_left + pow_right));

  /*
  int AT = vamp.at(2);
  int left_size = tree_size(vamp.at(1), vamp.at(3));
  result = jsum(AT, left_size) * 100;
  */
}

void writeData()
{
  printf("%.1f\n", result);
  vamp.clear();
}

main()
{
  while(readData())
  {
    processData();
    writeData();
  }
}
