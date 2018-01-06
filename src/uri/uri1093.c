#include <stdlib.h>
#include <stdio.h>

float result;
int vamp[4]; // 0 = EV1; 1 = EV2; 2 = AT; 3 = D

/* TREE OPERATIONS */
typedef struct node {
  int* track;
  struct node* left;
  struct node* right;
} node;

node* new_tree(int* track) {
  node* tree = (node*) malloc(sizeof(tree));

  tree->track = track;
  tree->left = NULL;
  tree->right = NULL;

  return tree;
}

node* add_to_tree(node* root, int* track) {
  node* leaf = new_tree(track);
  node* tree = root;

  while (tree->right != NULL && tree->left != NULL)
  {
    if (tree->track[0] > track[0])
      tree = tree->left;
    else
      tree = tree->right;
  }

  if (tree->track[0] > track[0])
    tree->left = leaf;
  else
    tree->right = leaf;

  return root;
}

int contain_node(node* tree, int* trace, int flag)
{
  if (!flag || tree == NULL)
    return flag;

  if (tree->track[0] == trace[0] && tree->track[1] == trace[1])
    flag = 0;

  flag = contain_node(tree->left, trace, flag);
  flag = contain_node(tree->right, trace, flag);
}

/* DATA STRUCTUTURE ANALISYS */
node* populate(node* tree, node* root)
{
  int* left_track = (int*) malloc(sizeof(int)*4);
  int* right_track = (int*) malloc(sizeof(int)*4);

  // printf("%d %d < ", tree->track[0], tree->track[1]);
  left_track[0] = tree->track[0] + tree->track[2];
  left_track[1] = tree->track[1] - tree->track[2];
  right_track[0] = tree->track[0] - tree->track[2];
  right_track[1] = tree->track[1] + tree->track[2];
  left_track[2] = tree->track[2]; left_track[3] = tree->track[3];
  right_track[2] = tree->track[2]; right_track[3] = tree->track[3];

  if (!contain_node(root, left_track, 1) && left_track[1] > 0)
    tree->left = new_tree(left_track);
  if (!contain_node(root, right_track, 1) && right_track[0] > 0)
    tree->right = new_tree(right_track);

  if (tree->left != NULL)
    tree = populate(tree->left, root);
  if (tree->right != NULL)
    tree = populate(tree->right, root);

  // printf(" > ");
  return tree;
}

void walk_on_tree(node* tree, int* total, int* vics)
{
  // stop condition
  if (tree == NULL)
    return;

  // check if there is victory condition is met
  if (tree->right == NULL && tree->left == NULL)
  {
    (*total)++;
    if (tree->track[1] <= 0)
      (*vics)++;
  }

  // walk towards anything
  walk_on_tree(tree->left, total, vics);
  walk_on_tree(tree->right, total, vics);

  return;
}

/* MAIN OPERATIONS */
int readData()
{
  int i;
  int flag = 4;
  result = 0.0;

  for (i = 0; i < 4; i++)
  {
    scanf("%d", &vamp[i]);
    if (vamp[i] == 0) flag--;
  }

  return flag;
}

void processData()
{
  int total = 0, vics = total;
  node* tree = new_tree(vamp);

  tree = populate(tree, tree);
  walk_on_tree(tree, &total, &vics);
  result = ((100.0*vics*vamp[2])/(total*6.0));
}

void writeData()
{
  printf("%.1f\n", result);
}

/* i'm using a backtracking strategy */
main()
{
  while(readData())
  {
    processData();
    writeData();
  }
}

/* left directions =>   */
