public static class FactorialCounter 
{ 
    public static List<long> GetFactorialRow(List<long> factorialNumbers) 
    { 
        List<long> result = new List<long>(); 
        foreach (long number in factorialNumbers) 
        { 
            try 
            { 
                long factorial = GetFactorial(number); 
                result.Add(factorial); 
            } 
            catch(ArgumentOutOfRangeException ex) 
            { 
                Console.WriteLine(number + ": Out of range. Correct is range is (0, +inf)"); 
            } 
             
        } 
 
        return result; 
    } 
 
    private static long GetFactorial(long factorialNumber) 
    { 
        if (factorialNumber < 0) 
        { 
            throw new ArgumentOutOfRangeException(); 
        } 
 
        if (factorialNumber == 0 || factorialNumber == 1) 
        { 
            return 1; 
        } 
 
        return factorialNumber * GetFactorial(factorialNumber - 1); 
    } 
}
