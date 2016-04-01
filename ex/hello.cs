using System;

namespace hello
{
    public class hello
    {
        /// <summary>
        ///   The main entry point for the application
        /// </summary>
        [STAThread]
        public static void Main(string[] args)
        {
            var inlet = Console.ReadLine();
            Console.WriteLine(string.Format("hello {0}", inlet));
        }
    }
}
