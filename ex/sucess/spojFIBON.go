package main
import "fmt"

func setup() []uint64 {
    fib := make([]uint64, 101)
    fib[0] = 1
    fib[1] = 1

    for i := 2; i < 101; i++ {
        fib[i] = fib[i-1] + fib[i-2]
    }

    return fib
}

func main() {
    var t int
    var n int

    fib := setup()
    fmt.Scanf("%d\n", &n)
    for i := 0; i < n; i++ {
        fmt.Scanf("%d\n", &t)
        fmt.Printf("%d\n", fib[t-1])
    }
}
