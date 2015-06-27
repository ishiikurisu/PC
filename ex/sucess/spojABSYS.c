#include <stdlib.h>
#include <stdio.h>

typedef struct NODE {
    char* info;
    struct NODE* next;
} LIST;

LIST* data;

int strlen(char* s)
{
    int i = 0;
    while (s[i] != '\0') ++i;
    return i;
}

char* concatenate(char* str, char to_add)
{
    int i = 0;
    int length = strlen(str);
    char* out = (char*) malloc(sizeof(char) * (length + 2));

    for (i = 0; i < length; ++i)
        out[i] = str[i];

    out[i] = to_add;
    out[i+1] = '\0';
    return out;
}

LIST* new_list()
{
    LIST* list = (LIST*) malloc(sizeof(LIST));

    list->info = NULL;
    list->next = NULL;

    return list;
}

LIST* tail(LIST* head)
{
    LIST* list = head;

    while (list->next != NULL)
        list = list->next;

    return list;
}

LIST* add_to_list(LIST* head, char* to_add)
{
    LIST* list = tail(head);

    list->next = new_list();
    list = list->next;
    list->info = to_add;

    return head;
}

LIST* split(char* str, char to_div)
{
    LIST* result = new_list();
    char* section = "";
    char* to_add = '\0';
    int length = strlen(str);
    int i = 0;

    for (i = 0; i < length; ++i)
    {
        section = "";
        while (str[i] != to_div && i < length)
            section = concatenate(section, str[i]),
            i++;

        result = add_to_list(result, section);
    }

    return result;
}

char* read_line()
{
    char* output = "";
    char to_add;

    scanf("%c", &to_add);
    while (to_add != '\n' && to_add != '\0')
    {
        output = concatenate(output, to_add);
        scanf("%c", &to_add);
    }

    return output;
}

int is_number(char c)
{
    if ((c >= '0') && (c <= '9'))
        return 1;
    else
        return 0;
}
int is_letter(char c)
{
    if ((c >= 'a') && (c <= 'z'))
        return 1;
    else
        return 0;
}

int is_valid(char* str)
{
    int result = 1;
    int limit = strlen(str);
    int i = 0;

    for (i = 0; i < limit && result; ++i)
        if (!is_letter(str[i]) && !is_number(str[i]))
            result = 0;

    return result;
}

char* process(char* input)
{
    char* output = input;
    int limit = strlen(input);
    int i = 0;

    for (i = 0; i < limit; ++i)
    {
        if (is_letter(input[i])) {
            output = NULL;
            break;
        }
    }

    return output;
}

void setup()
{
    char* input = NULL;
    LIST* walk = NULL;
    LIST* line = NULL;

    input = read_line();
    line = split(input, ' ');
    data = new_list();

    walk = line->next;
    while (walk != NULL)
    {
        if (is_valid(walk->info))
            data = add_to_list(data, process(walk->info));

        walk = walk->next;
    }
}

void loop()
{
    LIST* walk = data->next;
    char *a, *b, *c;
    int x, y, z;

    a = walk->info;
    walk = walk->next;
    b = walk->info;
    walk = walk->next;
    c = walk->info;

    if (a == NULL) {
        sscanf(b, "%d", &y);
        sscanf(c, "%d", &z);
        x = z - y;
    }
    else if (b == NULL) {
        sscanf(a, "%d", &x);
        sscanf(c, "%d", &z);
        y = z - x;
    }
    else {
        sscanf(a, "%d", &x);
        sscanf(b, "%d", &y);
        z = x + y;
    }

    printf("%d + %d = %d\n", x, y, z);
}

int main(int argc, char** argv)
{
    int T, t;

    scanf("%d\n", &T);
    for (t = 0; t < T; ++t)
    {
        if (t != 0)
            getchar();
        setup();
        loop();
    }

    return 0;
}
