# sieve of erasthotenes

implemented in python

``` python
def erasthotenes(n):
    primes = [True]*(n+1)
    primes[0] = primes[1] = False
    for i in xrange(2, int(n**0.5)):
        if primes[i]:
            for j in xrange(2, n / i + 1, 1):
                primes[i*j] = False
    result = []
    for i in xrange(n+1):
        if primes[i]:
            result.append(i)
    return result

```
