using System;
using System.Collections.Generic;
using System.Linq;

public class Program
{
    static void Main(string[] args)
    {
        var words = new List<string> { "apple", "banana", "apricot", "blueberry", "cherry", "date", "fig", "grape" };
        var trie = new Trie();
        foreach (var word in words)
        {
            trie.Insert(word);
        }

        while (true)
        {
            Console.Write("Enter prefix: ");
            var prefix = Console.ReadLine();
            var results = trie.Search(prefix);
            Console.WriteLine("Results: " + string.Join(", ", results));
        }
    }
}