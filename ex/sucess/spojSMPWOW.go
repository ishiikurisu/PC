package main
import "fmt"

func main() {
    var xxx int

    fmt.Scanf("%d\n", &xxx)
    fmt.Printf("W")
    for x := 0; x < xxx; x++ {
        fmt.Printf("o")
    }
    fmt.Print("w\n")
}
