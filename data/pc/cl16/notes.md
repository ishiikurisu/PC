    Quanto mais idiota, melhor

# Grafos

Um grafo é um par (V, A) em que V é o conjunto arbitrário e A é um subconjunto
do conjunto de todos os pares de elementos de V. Os elementos de V são chamados
de vértices e os de A são chamados de arestas.

Existem vários variações de grafos: orientados X não orientados; ponderados X
não-ponderados; cíclico X acíclico; simples X multigrafo; desconexo X conexo;

Subconjuntos importantes são os subgrafos, grafos parciais.

Classificação de arestas
------------------------

+ Arestas de retorno (detectam loops)
+ Arestas de árvore (nós fundamentais da árvore mínima)
+ Arestas de avanço
+ Arestas de cruzamento

Implementação
-------------

Podemos criar duas estruturas: uma para implementar os vértices e outra para
guardar as arestas. Podemos usar:

  + Lista de adjacências: listas + listas
    - Ideal para representar grafos esparsos
  + Matriz de adjacências: vetores + matrizes (linhas: origem, colunas: destino)
  + Implementação do Mateus: map<vértice, map<vértice, peso>>

Algoritmos famosos
------------------

+ Busca em largura
+ Algoritmo de Prim para a árvore mínima
+ Algoritmo de Dijskstra para menores caminhos
+ Busca em profundidade
+ Ordenamento topológico

# Travessia de Grafos

Problema: passar por todos os nós.

Algoritmo básico
----------------

1. Enquanto o *conjunto* não for vazio
  1. *Escolha* um item do conjunto
  2. Se o item o desejado, termine
  3. Senão, retire-o do conjunto

O tamanho do conjunto e como é feita a escolha do próximo item do conjunto
interfere na eficiência deste algoritmo.

# Problemas

+ Número de Erdös (uva10044)
+ Dudu faz o serviço (uri1610)
+ uri1081
