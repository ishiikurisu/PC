#include "stdlib.h"
#include "stdio.h"
#include "string.h"

char *original;
char *password;

/* DATA STRUCTURES  */
char* string_new()
{
    char *s = malloc(sizeof(char));
    s[0] = '\0';
    return s;
}


char* ctos(char ch)
{
    char* out = (char*) malloc(sizeof(char) * 2);
    out[0] = ch;
    out[1] = '\0';
    return out;
}

char* cat(char *to_hold, char* to_add)
{
    int l1 = strlen(to_hold);
    int l2 = strlen(to_add);
    int len = l1 + l2;
    char* new_str = malloc(sizeof(char) * (len + 1));

    memcpy(new_str, to_hold, l1);
    memcpy(new_str + l1, to_add, l2);

    new_str[len] = '\0';
    return new_str;
}

/* PROBLEM PROCEDURES */

char* read_password()
{
    char* box = string_new();
    char* temp = NULL;
    char it;

    scanf("%c", &it);
    while (it != '\n')
    {
        temp = cat(box, ctos(it));
        free(box);
        box = temp;
        scanf("%c", &it);
    }

    return box;
}

char* allocate_original()
{
    original = (char*) malloc(sizeof(char) * (1 + strlen(password)));
    memcpy(original, password, strlen(password) + 1);
    return original;
}

/* MAIN PROCEDURES */
void operation_1(long i, long j, long k)
{
    printf("%c\n", (!memcmp(password+i, password+k, j - i))? 'Y' : 'N');
}

void operation_2(long i, long j, long k)
{
    memcpy(password+i, original+k, j - i);
}

void operation_3(long i, long j)
{
    long n;

    for (n = i-1; n < j; ++n)
    {
        if ((password[n] >= 'a') && (password[n] <= 'z')) {
            if (password[n] == 'z') password[n] = 'a';
            else password[n]++;
        }
    }
}


int main(int argc, char const *argv[])
{
    long M, m, c, i, j, k;

    password = read_password();
    allocate_original();

    while (scanf("%ld", &M) > 0)
    {
        for (m = 0; m < M; ++m)
        {
            scanf("%ld", &c);
            switch (c) {
                case 1:
                    scanf("%ld %ld %ld", &i, &j, &k);
                    operation_1(i, j, k);
                break;

                case 2:
                    scanf("%ld %ld %ld", &i, &j, &k);
                    operation_2(i, j, k);
                break;

                case 3:
                    scanf("%ld %ld", &i, &j);
                    operation_3(i, j);
                break;
            }
            printf("%s\n", password);
        }
    }

    return 0;
}
