# Backtracking

Estratégia para lidar com problemas, como State Space Problems. Esta estratégia
é genérica, ou seja, é a mesma independentemente do problema, o que facilita um
pouco a solução. Em geral, o problema busca o caminho percorrido até a solução.

Ela é uma estratégia de força bruta, mas é boa para se usar se o tamanho do
conjunto de dados for pequeno. Para problemas maiores, podemos podar um pouco
a árvore de possibilidades.

É um método sistemático para iterar por todos os possíveis estados em um espaço
de busca. O algoritmo segue uma solução genérica em profundidade.

Uma solução que aplica puramente o algoritmo de backtracking pode não ser muito
bom, pois a árvore com todas as possibilidades pode ser muito grande. Outra
eurística que pode contribuir no algoritmo de backtracking são dividir-e-
conquistar.

Etapas
------

1. Identificar uma representação para o estado.
  + Considerar o estado inicial.
  + Considerar o estado final ou criar uma condição de parada.
2. Propor regras para derivação dos próximos estados.

Problemas sugeridos
-------------------
+ uva780
+ uva10255
