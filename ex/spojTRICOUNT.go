package main
import "fmt"

func tricount(N uint64) uint64 {
    var s uint64
    var i uint64
    var r uint64

    s = 0
    r = 1
    for i = 1; i <= N; i++ {
        s += 1
        
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
