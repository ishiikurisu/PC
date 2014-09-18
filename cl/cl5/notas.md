# Strings

É a estrutura de dados fundamental. É uma sequência de caracteres, pode ser
implementada como arrays ou listas encadeadas.

+ Problemas comuns
  + Substituição em editores de texto
  + Pesquisa em documentos da internet

Operações comuns: substituir substrings, buscar substrings...

Problemas sugeridos
-------------------

1. Produzir uma lista com as palavras presentes em um documento.
2. Contar a frequência das palavras em um documento.
3. Imprimir as palavras com mais documento.
4. Dado um texto, encontrar a mais longa substring duplicada.

Array de sufixos
----------------

É um array que contém todos os sufixos de uma palavra.

    String banana = "banana";
    ArrayDeSufixos array = new ArrayDeSufixos(banana);
    // array == {"banana", "anana", "nana", "ana", "na", "a"};

# Recomendações

+ Tenha o livro "Programming Pearls".
+ Use mais o HashMap! Ainda não aprendi a usar esta merda, apesar de gostar
muito dela.
+ Aprenda a estrutura de dados "Array de Sufixos".
+ UVA10252
