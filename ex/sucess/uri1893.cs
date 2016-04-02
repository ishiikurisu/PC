using System;

class URI
{
    public static void Main(string[] args)
    {
        var numbers = Console.ReadLine().Split(' ');
        var first = int.Parse(numbers[0]);
        var last = int.Parse(numbers[1]);
        var result = "nova";

        if (last >= 0 && last <= 2) {
            result = "nova";
        }
        else if (last >= 3 && last <= 96) {
            result = (first > last)? "minguante" : "crescente";
        }
        else {
            result = "cheia";
        }

        Console.WriteLine(result);
    }
}
