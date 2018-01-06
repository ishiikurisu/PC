#include <iostream>
#include <vector>
#define min(A,B) ((A)<(B))? (A) : (B)
using namespace std;

int n, m, outlet;

int distance(string x, string y) {
  int c = 0;
  for (int i = 0; i < m; ++i)
    (x[i] != y[i])? c++ : NULL;
  return c;
}

void setup() {
  vector<string> stuff;
  vector<string>::iterator it;
  string box;
  outlet = 0;
  
  cin >> box;
  stuff.push_back(box);
  for (int i = 1; i < n; ++i) {
    int current = m;
    cin >> box;
    for (it = stuff.begin(); it != stuff.end(); ++it) {
      current = min(current, distance(box, *it));
    }
    stuff.push_back(box);
    outlet += current;
  }
}

void draw() {
  static int h = 0;
    
  cout << "Instancia " << ++h << endl;
  cout << outlet << endl;
  cout << endl;
}

int main() {
  for (cin >> n >> m; n; cin >> n >> m) {
    setup();
    draw();
  }
  return 0;
}