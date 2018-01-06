# KMP Algorithm

```
algorithm kmp_search:
    input:
        an array of characters, S (the text to be searched)
        an array of characters, W (the word sought)
    output:
        an integer (the zero-based position in S at which W is found)

    define variables:
        an integer, m ← 0 (the beginning of the current match in S)
        an integer, i ← 0 (the position of the current character in W)
        an array of integers, T (the table, computed elsewhere)

    while m + i < length(S) do
        if W[i] = S[m + i] then
            if i = length(W) - 1 then
                return m
            let i ← i + 1
        else
            if T[i] > -1 then
                let m ← m + i - T[i], i ← T[i]
            else
                let i ← 0, m ← m + 1

    (if we reach here, we have searched all of S unsuccessfully)
    return the length of S
```

See this [video](https://www.youtube.com/watch?v=2ogqPWJSftE) on YouTube!

# Rabin-Karp Algorithm

```
function RabinKarp(string s[1..n], string pattern[1..m])
    hpattern := hash(pattern[1..m]);  hs := hash(s[1..m])
    for i from 1 to n-m+1
        if hs = hpattern
            if s[i..i+m-1] = pattern[1..m]
                return i
        hs := hash(s[i+1..i+m])
    return not found
```

# Z Algorithm

``` C++
int L = 0, R = 0;
for (int i = 1; i < n; i++) {
  if (i > R) {
    L = R = i;
    while (R < n && s[R-L] == s[R]) R++;
    z[i] = R-L; R--;
  } else {
    int k = i-L;
    if (z[k] < R-i+1) z[i] = z[k];
    else {
      L = i;
      while (R < n && s[R-L] == s[R]) R++;
      z[i] = R-L; R--;
    }
  }
}
```
