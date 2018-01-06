#include <stdlib.h>
#include <stdio.h>
#define DECK_SIZE 52

/* DATA STRUCTURES */
typedef struct node {
  int shuffle;
  int* sequence;
  struct node* next;
} node;

node* new_list()
{
  node* list = (node*) malloc(sizeof(node));

  list->sequence = (int*) malloc(sizeof(int)*DECK_SIZE);
  list->next = NULL;
  list->shuffle = 0;

  return list;
}

node* add_list(node* list, node* item)
{
  node* walker = list;

  while (walker->next != NULL) walker = walker->next;
  walker->next = item;

  return list;
}

/* GLOBALS */
int num_tests;
node* head;

/* MAIN FUNCTIONS */
void setup()
{
  head = new_list();
  head->sequence = NULL;
  return;
}

void process()
{
  node* list;
  int i;

  return;
}

void draw()
{
  node* list;
  int i;

  for (list = head->next; list != NULL; list = list->next)
  {
    for (i = 0; i < DECK_SIZE; i++)
    {
      printf("%d\n", list->sequence[i]);
    }
  }
}

int read()
{
  int i, j;
  node* list;

  scanf("%d", &num_tests);
  if (num_tests == 0)
    return num_tests;
  else
  {
    setup();
    /* READ SHUFFLES */
    for (i = 0; i < num_tests; i++)
    {
      list = new_list();
      for (j = 0; j < DECK_SIZE; j++)
      {
        scanf("%d", &list->sequence[j]);
      }
      head = add_list(head, list);
    }

    /* READ SHUFFLE TIME */
    for (list = head->next; list != NULL; list = list->next)
      scanf("%d", &list->shuffle);
  }

  return num_tests;
}

main()
{
  while(read())
  {
    process();
    draw();
  }
}
