#include <stdlib.h>
#include <stdio.h>

/*****************
AUXILIAR FUNCTIONS
*****************/

int strlen(char* str)
{
	int i = 0;
	while (str[i] != '\0') ++i;
	return i;
}

char** split(char* str, char spch)
{
	char** out;
	char* word;
	int i, j, k;
	
	i = 0;
	j = 0;
	k = 1;
	out = (char**) malloc(sizeof(char*));
	
	for (i = 0; i < strlen(str); i++)
	{
		j = 1;
		word = (char*) malloc(sizeof(char));
		word[j - 1] = str[i];
		
		i++;
		while (str[i] != spch && str[i] != '\0')
		{
			j++;
			word = (char*) realloc(word, sizeof(char) * j);
			word[j - 1] = str[i];
			i++;
		}
		word[j - 1] = '\0';
		out[k - 1] = word;
		k++;
		
		out = (char**) realloc(out, sizeof(char*) * k);
		word = NULL;
	}
	out[k - 1] = NULL;
	
	return out;
}

int* count(char* inlet);
{
	int[2] outlet;
	
	/* WRITE STUFF */
	
	return outlet;	
}

/*************
MAIN FUNCTIONS
*************/
	
char* read()
{
	char* out = (char*) malloc(sizeof(char));
	int len = 1;
	
	scanf("%c", &out[len-1]);
	while (out[len-1] != '\n' && out[len-1] != '\0')
	{
		len = len + 1;
		out = (char*) realloc(out, len * sizeof(char));
		scanf("%c", &out[len-1]);
	}
	out[len-1] = '\0';
	
	return out;
}

char* process(char* inlet)
{
	char** midlet = split(inlet, '=');
	char* outlet = NULL;
	int[2][2] index;
	int i;
	
	/* TRANSLATE DATA */
	for (i = 0; i < 2; ++i)
		index[i] = count(midlet[i]);
	
	/* PROCESS */
	if (index[0][0] == index[1][0])
    {
        if (index[0][1] != index[1][1])
            outlet = "IMPOSSIBLE";
        else
            outlet = "IDENTITY";    
    } 
    else 
    {
		i = (index[1][1] - index[0][1]) / (index[0][0] - index[1][0]);
        outlet = (char*) malloc(10 * sizeof(char));
		sprintf(&outlet, "%d", i);
	}
	
	return outlet;
}

void write(char* out)
{
	printf("%s\n", out);
}

int main()
{
	int T, t;
	char* inlet;
	char* outlet;
	
	scanf("%d\n", &T);
	for (t = 0; t < T; ++t)
	{
		inlet = read();
		outlet = process(inlet);
		write(outlet);
	}
	
	return 0;
}