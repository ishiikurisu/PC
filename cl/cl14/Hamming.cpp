#include <iostream>
#include <stdio.h>
#include <stdlib.h>
#include <math.h>
using namespace std;

int N, H;

bool hamming(int* v)
{
	int dist = 0;

	for (int c = 0; c < N; c++)
	{
		if (v[c] == 1) ++dist;
	}

	if (dist == H) return true;
	else return false;
}

/*
char* toBin(int number)
{
	char* bit = (char*) malloc(sizeof(char)*N);
	int partial = number;

	for (int n = N - 1; n >= 0; ++n)
	{

	}
}
*/



main()
{
	int nc, a;
	char* bit;
	int *v;

	cin >> nc;
	for (int c = 0; c < nc; c++)
	{
		cin >> N >> H;

		v =(int*) malloc ( N*sizeof(int));

		for(int i = 0; i<N; i++){
			v[i]=0;
		}

		for(int i =0; i<pow(2,N); i++){
			a=0;
			v[a]++;
			while(v[a]==2){
				v[a]=0;
				a++;
				v[a]++;

			}
			if(hamming(v)){
				for(int b=N-1; b>=0; b--){

					printf("%d",v[b]);
				}
				cout << endl;


			}

		}

		if (nc -1 != c) cout << endl;
	}



}
