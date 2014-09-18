#include <stdlib.h>
#include <stdio.h>
#include <string.h>

#define bool int
#define true 1
#define false 0

char* process_data(char* word1, char* word2) {
  char* new_word = (char*) malloc(sizeof(char));
  bool flag = false;
  int size = 1;
  int i, j, k;

  new_word[0] = '\0';
  for (i = 0; word1[i] != '\0'; i++) {
    for (j = 0; word2[j] != '\0'; j++) {
      if (word1[i] == word2[j]) {
        flag = false;
        k = 0;
        while (new_word[k] != '\0' && !flag) {
          if (word1[i] == new_word[k]) flag = true;
          k++;
        }
        if (flag == false) {
          size++;
          new_word = (char*) realloc(new_word, sizeof(char)*size);
          new_word[size-2] = word1[i];
          new_word[size-1] = '\0';
          break;
        }
      }
    }
  }

  return new_word;
}

int partition(char* a, int p, int r) {
  int x = a[r];
  int i = p-1;
  int j;
  char temp;

  for (j = p; j < r - 1 ; ++j) {
    if (a[j] <= x) {
      i++;
      temp = a[i];
      a[i] = a[j];
      a[j] = temp;
    }
  }
  temp = a[i+1];
  a[i+1] = a[r];
  a[r] = temp;

  return i + 1;
}

//using MIT's QuickSort
char* sort_string(char* word, int current_index, int last_index) {
  int new_index;

  if (current_index < last_index) {
    new_index = partition(word, current_index, last_index);
    word = sort_string(word, current_index, new_index - 1);
    word = sort_string(word, new_index + 1, last_index);
  }

  return word;
}

int main() {
  char word1[10];
  char word2[10];
  char* new_word;

  while (scanf("%s %s", &word1, &word2) != EOF) {
    new_word = process_data(word1, word2);
    new_word = sort_string(new_word, 0, strlen(new_word)-1);
    printf("%s\n", new_word);
  }

  return 0;
}
