package main

import "fmt"

func main() {
    var T int
    var N int
    var name string

    fmt.Scanf("%d\n", &T)
    for t := 0; t < T; t++ {
        fmt.Scanf("%d %s\n", &N, &name)
        stuff := calculate(N, name)
        fmt.Printf("%d\n", len(stuff) % 1000000007)
    }
}

func calculate(n int, name string) map[string]bool {
    stuff := make(map[string]bool, 0)
    changes := make(map[int]bool, 0)
    stuff = npali(n, name, stuff, changes)
    return stuff
}

func npali(n int, name string, stuff map[string]bool, changes map[int]bool) map[string]bool {
    limit := len(name) - 1

    if n == 0 {
        return stuff
    }

    for i := 0; i <= limit; i++ {
        newChanges := copyMap(changes)
        newChanges[i] = true
        for c := 'a'; c <= 'z'; c++ {
            _, here := changes[i]
            if (rune(name[i]) != c) && (here == false) {
                newWord := build(name, i, c)
                if pali(newWord) && newWord != name {
                    stuff[newWord] = true
                }
                stuff = npali(n-1, newWord, stuff, newChanges)
            }
        }
    }

    return stuff
}

func build(word string, i int, c rune) string {
    newWord := []rune(word)
    newWord[i] = c
    return string(newWord)
}

func pali(word string) bool {
    fact := true
    half := len(word) / 2
    limit := len(word) - 1

    for i := 0; i < half && fact; i++ {
        if word[i] != word[limit-i] {
            fact = false
        }
    }

    return fact
}

func copyMap(inlet map[int]bool) map[int] bool {
    outlet := make(map[int]bool, 0)

    for key, value := range inlet {
        outlet[key] = value
    }

    return outlet
}
