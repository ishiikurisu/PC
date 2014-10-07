#include <cstdlib>
#include <iostream>
#include <string>
using namespace std;

/* DATA STRUCTURE DEFINITION */
struct node
{
	char number;
	node* left;
	node* right;
};
typedef node* btree;

btree create_tree()
{
	return (btree) malloc(sizeof(node));
}

btree new_tree(char number)
{
	btree root = create_tree();

	root->number = number;
	root->left = NULL;
	root->right = NULL;

	return root;
}

btree add_to_left(btree root, char letter)
{
	if (root->left == NULL)
		root->left = new_tree(letter);

	return root->left;
}
btree add_to_right(btree root, char letter)
{
	if (root->right == NULL)
		root->right = new_tree(letter);

		return root->right;
}

/* DATA STRUCTURE MANIPULATION */
btree populate_tree(string phone)
{
	btree root = new_tree(phone.at(0));
	btree tree = root;
	int limit = phone.length();
	int index = 1;


	while (index < limit)
	{
		tree = add_to_right(tree, phone.at(index));
		index++;
	}

	return root;
}

btree add_to_tree(btree book, string phone)
{
	int limit = phone.length();
	int index = 0;
	char c = phone.at(index);
	btree page = book;

	while (index < limit)
	{
		c = phone.at(index);
		if (page->right == NULL)
		{
			page = add_to_right(page, c);
		}
		else
		{
			if (page->right->number == c)
				page = add_to_right(page, c);
			else while (page->number != c)
				page = add_to_left(page, c);
		}
		index++;

	}

	return book;
}

int walk_and_count(btree root, int size)
{
	cout << root->number << " < ";
	int left = 0, right = 0;

	if (root->left != NULL)
		left = walk_and_count(root->left, size);
	if (root->right != NULL)
		right = walk_and_count(root->right, size);

	cout << " > ";
	return left + right;
}
int size_of_tree(btree root)
{
	return walk_and_count(root, 0);
}

/* MAIN FUNCTIONS */
main()
{
	int nc, c, expensive, affordable;
	btree phone_book;
	string phone;

	while (cin >> nc)
	{
		phone_book = NULL;
		expensive = 0;
		for (c = 0; c < nc; c++)
		{
			cin >> phone;
			expensive += phone.length();
			if (phone_book == NULL)
				phone_book = populate_tree(phone);
			else
				phone_book = add_to_tree(phone_book, phone);
		}
		affordable = size_of_tree(phone_book);

		cout << (expensive - affordable) << endl;
	}
}
