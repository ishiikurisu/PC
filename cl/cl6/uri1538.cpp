#include <iostream>

bool read_data() {
  
}

int main() {
  bool flag;

  flag = read_data();
  while (flag) {
    process_data();
    flag = read_data();
  }

  return 0;
}
