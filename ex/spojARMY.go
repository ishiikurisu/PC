package main
import "fmt"

var NG int
var NM int
var G []int
var M []int

func setup() {
    fmt.Scanf("%d %d", &NG, &NM)
    G = [NG]int
    M = [NM]int

    for i := 0; i < NG; i += 1 {
        fmt.Scanf("%d", &G[i])
    }
    for i := 0; i < NG; i += 1 {
        fmt.Scanf("%d", &M[i])
    }
}

func draw() {
    for i := 0; i < len(G); i+= 1 {
        fmt.Printf("%d\n", G[i])
    }
}

func main() {
    var T int

    fmt.Scanf("%d", &T)
    for t := 0; t < T; t += 1 {
        setup()
        draw()
    }
}
