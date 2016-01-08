package main
import "fmt"

func inter() bool {
    var msg string
    var n1 uint32
    var n2 uint32
    var n3 uint32
    var re uint32
    var i uint32
    var cc byte

    n1 = 0
    n2 = 0
    n3 = 0
    n, _ := fmt.Scanf("%32s", &msg)
    if n == 0 {
        return false
    }

    /* setting n1 */
    for i = 0; i < 32; i++ {
        if msg[i] == '0' {
            n1 += (1 << (32-i-1))
        }
    }

    /* setting n2 */
    fmt.Scanf("%16s", &msg)
    for i = 0; i < 16; i++ {
        if msg[i] == '0' {
            n2 += (1 << (16-i-1))
        }
    }

    /* setting n3 */
    for i = 0; i < n2; i++ {
        fmt.Scanf("%c", &cc)
        if cc == '0' {
            n3 += 1 << i
        }
    }

    /* calculating response */
    re = n3 % n1
    for i = 32; re << i == 0 && i >= 0 ; i-- {

    }
    for ; i >= 0 ; i-- {
        if (re << i) & 0x1 == 0x1  {
            fmt.Printf("%d", 0)
        } else {
            fmt.Printf("%d", 1)
        }
    }

    return true
}

func main() {
    flag := true

    for ; flag ; {
        flag = inter()
    }
}
