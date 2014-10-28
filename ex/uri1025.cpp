#include <iostream>
#include <algorithm>
#include <vector>
#include <cstdlib>
using namespace std;

/* DATA STRUCTURES */
typedef struct node {
  int info;
  int position;
  struct node* left;
  struct node* right;
} node;

node* new_tree(int info, int position)
{
  node* tree = (node*) malloc(sizeof(node));

  tree->info = info;
  tree->position = position;
  tree->right = NULL;
  tree->left = NULL;
}

node* find_leaf(node* tree, int number)
{
  if (tree->info < number && tree->left != NULL)
    tree = find_leaf(tree->left, number);
  else if (tree->info > number && tree->right != NULL)
    tree = find_leaf(tree->right, number);

  return tree;
}

node* add_to_tree(node* root, int info, int position)
{
  node* leaf = new_tree(info, position);
  node* tree = root;

  tree = find_leaf(tree, info);

  if (tree->info < info) tree->left = leaf;
  else tree->right = leaf;

  return root;
}

int search(node* root, int number)
{
  node* tree = root;
  int result = -1;

  while (tree != NULL && result < 0)
  {
    if (tree->info == number) result = tree->position;
    else if (tree->info > number) tree = tree->left;
    else tree = tree->right;
  }

  return result;
}
/* MAIN FUNCTIONS */
int number_marbles, number_queries;
vector<int> /*marbles,*/ queries;
node* mtree;

bool read()
{
  int index, input;

  cin >> number_marbles >> number_queries;
  if (number_marbles == 0 || number_queries == 0) return false;

  cin >> input;
  mtree = new_tree(input, 0);
  for (index = 1; index < number_marbles; index++)
  {
    // cin >> input; marbles.push_back(input);
    cin >> input;
    add_to_tree(mtree, input, index);
  }
  for (index = 0; index < number_queries; index++)
  { cin >> input; queries.push_back(input); }

  return true;
}

void write()
{
  vector<int>::iterator it;
  int index;

  for (it = queries.begin(); it != queries.end(); it++)
  {
    index = search(mtree, *it);

    if (index < 0) cout << *it << " NOT FOUND" << endl;
    else cout << *it << " FOUND AT " << index + 1 << endl;
  }

  queries.clear();
}

main()
{
  while (read()) write();
}
