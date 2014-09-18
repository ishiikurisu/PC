#include <iostream>

int numbers[2];
int result;

bool read_data() {
  bool flag = true;

  numbers[0] = numbers[1] = 0;
  std::cin >> numbers[0];
  if (numbers[0] == 0) return false;
  std::cin >> numbers[1];

  if (numbers[0] == 0 || numbers[1] == 0)
    flag = false;

  return flag;
}

void process_data() {
  result = numbers[1] + numbers[0];
}

void write_data() {
  std::cout << "X = " << result << '\n';
}

int main() {
  bool flag = true;

  flag = read_data();
  while (flag) {
    process_data();
    write_data();
    flag = read_data();
  }

  return 0;
}
