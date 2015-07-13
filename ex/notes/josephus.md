# Josephus

from wolfram's mathworld:

>Given a group of n men arranged in a circle under the edict that
every mth man will be executed going around the circle until
>only one remains, find the position L(n,m) in which you should
stand in order to be the last survivor (Ball and Coxeter 1987).

Strategy
--------

At every round, floor(n/2) of the people are gone. An even number of men
implies that the first person to shoot will have the gun again. We can
apply the previous points at any moment using the number of people left
in the circle.

1. Kill the people until the number of people left are of the form 2^k.
2. The person holding the gun at this time is the survivor.
3. ans = 2*(n - 2^k) + 1 | k = max{k | n > 2^k}
