#include <stdio.h>
#define senha (2002)

main()
{
    int entrada;

    scanf("%d", &entrada);
    while (entrada != senha)
    {
        printf("Senha Invalida\n");
        scanf("%d", &entrada);
    }

    printf("Acesso Permitido\n");
}
