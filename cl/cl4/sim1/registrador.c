#include <stdio.h>

#define bool int
#define true 1
#define false 0

typedef struct no {
  int bit;
  bool torneira;
  struct no* prox;
} no;

typedef struct fila {
  no* head;
  no* tail;
} fila;

no* nova_lista()
{
  no* lista = (no*) malloc(sizeof(no));

  lista->bit = lista->torneira = false;
  lista->prox = false;

  return lista;
}

no* add_lista()
{

}

no* entrada()
{


}

int main()
{
  
}
