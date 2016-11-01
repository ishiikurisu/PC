#include <iostream>

const double PI = 3.14159;
double radius;

bool read_data() {
  bool flag = true;

  std::cin >> radius;
  if (radius == 0) flag = false;

  return flag;
}

void process_data() {
  std::cout << "A: " << PI * radius * radius << '\n';
}

int main() {
  bool flag = true;

  flag = read_data();
  while (flag) {
    process_data();
    flag = read_data();
  }

  return 0;
}
