#include <cstdlib>
#include <cstdio>
using namespace std;

struct node 
{
	char number;
	node* left;
	node* right;
};
typedef node* btree;

btree create_tree()
{
	return NULL;
}

btree new_tree(char number)
{
	btree root = create_tree();
	
	root->number = number;
	root->left = NULL;
	root->right = NULL;

	return root;
}

btree search(btree root, char* numbers)
{
	btree tree = root;
	int index = 0;
	
	while (tree != NULL || numbers[index] != '\0')
	{
		if (numbers[index] == tree->number)
		{
			tree = tree->right;
			index++;
		}
		else
			tree = tree->left;
	}

	return index;
}

btree add_to_tree(btree root, char* numbers)
{
	int limit = search(root, numbers);
	btree tree = root;
	btree memory;
	int index = 0;

	while (index != limit)
	{
		memory = tree;
		if (numbers[index] == tree->number)
		{
			tree = tree->right;
			index++;
		}
		else
			tree = tree->left;
	}

	tree = memory;
	tree->left = new_tree(numbers[index]);
	tree = tree->left;
	index++;
	while (numbers[index] != '\0')
	{
		tree->right = new_tree(numbers[index]);
		tree = tree->left;
		index++;
	}

	
}

main()
{
	int nc;
	btree phones;
	char phone[200];

	while (true)
	{
		/* READ DATA */
		cin >> nc;
		for (int c = 0; c < nc; c++)
		{
			cin >> phone;
			phones.push_back(phone);
		}

		/* PROCESS DATA */


		/* WRITE DATA */
	}
}
