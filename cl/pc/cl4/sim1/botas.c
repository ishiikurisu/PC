#include <stdio.h>

typedef struct no {
  int tamanho;
  char pe;
  struct no* prox;
} no;

/*
typedef struct pares {
  no* sap_1;
  no* sap_2;
  struct pares* prox;
} pares;
*/

no* nova_lista()
{
  no* lista = (no*) malloc(sizeof(no));

  lista->tamanho = 0;
  lista->pe = 0;
  lista->prox = NULL;

  return lista;
}

no* add_lista(int tamanho, char pe, no* lista)
{
  no* item = nova_lista();
  no* walker = lista;


  item->tamanho = tamanho;
  item->pe = pe;
  while (walker->prox != NULL)
    walker = walker->prox;
  walker->prox = item;

  return lista;
}

int entrada() {
  no* lista = nova_lista();
  int no_saps;
  int tamanho;
  char pe;
  int i;

  scanf("%d", &no_saps);
  if (no_saps == 0) return NULL;

  for (i = 0; i < no_saps; ++i) {
    scanf("%d %c", &tamanho, &pe);
    lista = add_lista(tamanho, pe, lista);
  }

  return lista;
}

void processamento(no* sapatos) {
  no* sapato = sapatos;
  no* sapato_atual;
  int no_sapatos = 0;

  for (sapato = sapatos->prox; sapato->prox != NULL; sapato = sapato->prox) {
    //printf("# %d %c\n", sapato->tamanho, sapato->pe);
    for (sapato_atual = sapato->prox; sapato_atual != NULL; sapato_atual = sapato_atual->prox) {
      //printf("  + %d %c\n", sapato_atual->tamanho, sapato_atual->pe);
      if (sapato->tamanho == sapato_atual->tamanho && sapato->pe != sapato_atual->pe)
        no_sapatos++;
    }
  }

  printf("%d\n", no_sapatos);
  fflush(stdout);
}

int main()
{
  no* sapatos = entrada();

  while (sapatos != NULL) {
    processamento(sapatos);
    sapatos = entrada();
  }

  return 0;
}
