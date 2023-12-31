package newjavaprograms.cleancodefunction;

import java.util.Arrays;

/**
 * This class Generates prime numbers up to a user specified
 * maximum. The algorithm used is the Sieve of Eratosthenes.
 * <p>
 * Eratosthenes of Cyrene, b. c. 276 BC, Cyrene, Libya --
 * d. c. 194, Alexandria. The first man to calculate the
 * circumference of the Earth. Also known for working on
 * calendars with leap years and ran the library at Alexandria.
 * <p>
 * The algorithm is quite simple. Given an array of integers
 * starting at 2. Cross out all multiples of 2. Find the next
 * uncrossed integer, and cross out all of its multiples.
 * Repeat untilyou have passed the square root of the maximum
 * value.
 *
 * @author Alphonse
 * @version 13 Feb 2002 atp
 */

public class GeneratePrimes
{
    /**
     * @param maxValue is the generation limit.
     */
    public static int[] generatePrimes(int maxValue)
    {
        if (maxValue >= 2) // the only valid case
        {
            // declarations
            int s = maxValue + 1; // size of array
            boolean[] f = new boolean[s];

            // initialize array to true.
            initializeArrayToTrue(s, f);
            // get rid of known non-primes
            f[0] = f[1] = false;
            // sieve
            sieve(s, f);
            // how many primes are there?
            int count = 0;
            count = getPrimeCount(s, f, count);
            int[] primes = extractPrimes(s, f, count);
            return primes; // return the primes
        }
        else // maxValue < 2
            return new int[0]; // return null array if bad input.
    }

    private static int[] extractPrimes(int s, boolean[] f, int count) {
        int j;
        int i;
        int[] primes = new int[count];
        // move the primes into the result
        for (i = 0, j = 0; i < s; i++)
        {
            if (f[i]) // if prime
                primes[j++] = i;
        }
        return primes;
    }

    private static int getPrimeCount(int s, boolean[] f, int count) {
        int i;
        for (i = 0; i < s; i++)
        {
            if (f[i])
                count++; // bump count.
        }
        return count;
    }

    private static void sieve(int s, boolean[] f) {
        int i;
        int j;
        for (i = 2; i < Math.sqrt(s) + 1; i++)
        {
            if (f[i]) // if i is uncrossed, cross its multiples.
            {
                for (j = 2 * i; j < s; j += i)
                    f[j] = false; // multiple is not prime
            }
        }
    }

    private static void initializeArrayToTrue(int s, boolean[] f) {
        int i;
        for (i = 0; i < s; i++)
            f[i] = true;
    }

    public static void main(String[] args) {
        int[] primes = generatePrimes(100);
        System.out.println(Arrays.toString(primes));

    }
}