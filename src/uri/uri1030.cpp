#include <iostream>
#include <cstdlib>
using namespace std;

/* GLOBAL PARAMETERS */
int people, step, result;

/* DATA STRUCTURES */
typedef struct node {
  int info;
  struct node* next;
} node;

node* new_list(int info)
{
  node* list = (node*) malloc(sizeof(node));

  list->info = info;
  list->next = list;

  return list;
}

node* add_to_list(node* circle, int info)
{
  node* new_item = new_list(info);
  node* list = circle;

  while (list->next != circle) list = list->next;
  new_item->next = circle;
  list->next = new_item;

  return circle;
}

void write_list(node* list)
{
  node* item = list;

  do
  {
    cout << item->info << " ";
    item = item->next;
  }
  while (item != list);

  cout << endl;
}

node* remove_from_list(node* list, int info)
{
  node *current, *previous;
  current = previous = list;

  while (current->info != info)
  {
    previous = current;
    current = current->next;
  }

  previous->next = current->next;
  free(current);

  write_list(previous->next);
  return previous->next;
}

node* forward_remove_from_list(node* list, int moves)
{
  node* current = list, *previous;

  for (int m = 0; m < moves; ++m)
  {
    previous = current;
    current = current->next;
  }

  previous->next = current->next;
  free(current);
  return current->next;
}

/* AUXILIARY FUNCTIONS */
typedef node* CircularList;
void alert() {cout << "ASDF" << endl;}

CircularList populate_list(int howMany)
{
  CircularList list = new_list(1);

  for (int i = 2; i <= howMany; ++i)
  {
    //write_list(list);
    list = add_to_list(list, i);
  }

  return list;
}

int kill_em_all(CircularList people)
{
  CircularList man = people;
  //int i = step;

  while (man != man->next)
  {
    //i += step - 1;
    man = forward_remove_from_list(man, step - 1);
  }

  return man->info;
}

/* MAIN FUNCTIONS */
void read()
{
  cin >> people >> step;
}

void process()
{
  CircularList men = populate_list(people);
  //write_list(men);
  result = kill_em_all(men);
}

void write(int number_case)
{
  cout << "Case " << number_case << ": " << result << endl;
}

main()
{
  int number_cases, c;

  cin >> number_cases;
  for (c = 1; c <= number_cases; c++)
  {
    read();
    process();
    write(c);
  }
}
