package main
import "fmt"

func tricount(N uint64) uint64 {
    var s uint64
    var i uint64

    s = N*N
    for i = 1; i < N; i++ {
        s += i * (N-i)
    }

    return s
}

func main() {
    var T uint64
    var N uint64
    var t uint64

    fmt.Scanf("%d\n", &T)
    for t = 0; t < T; t++ {
        fmt.Scanf("%d\n", &N)
        fmt.Printf("%d\n", tricount(N))
    }
}
