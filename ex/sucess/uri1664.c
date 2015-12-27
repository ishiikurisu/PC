#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#define BULLSHIT ("BULLSHIT")
#define BULL 8

int talk, blah, shit;

void pass() {
    return;
}

int gcd(int a, int b) {
    return (b == 0)? a : gcd(b, a % b);
}

void evaluate(char ch) {
    static int si = 0;

    if (ch == BULLSHIT[si]) {
        si++;
        if (si == BULL) {
            si = 0;
            blah = -1;
            shit++;
        }
    }
    else if ((ch >= 'a' && ch <= 'z') ||
             (ch >= 'A' && ch <= 'Z'))
        si = 0;
    else
        talk += blah, si = 0, blah = 0;
}

int main(int argc, char const *argv[]) {
    char ch;
    int g;

    talk = blah = shit = 0;
    while (scanf("%c", &ch) > 0)
        evaluate(ch);

    g = (talk < shit)? gcd(talk, shit) : gcd(shit, talk);
    if (g == 0)
        printf("1 / 1\n");
    else
        printf("%d / %d\n", talk / g, shit / g);

    return 0;
}
