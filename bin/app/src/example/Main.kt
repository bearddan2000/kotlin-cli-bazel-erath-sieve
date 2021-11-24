package example;

/**
 * You can edit, run, and share this code.
 * play.kotlinlang.org
 */
fun manipulated_seive(N:Int, isprime:BooleanArray, SPF:IntArray)
{
    val prime = mutableListOf<Int>()

    // 0 and 1 are not prime
    isprime[0] = false
    isprime[1] = false

    var i = 2

    // Fill rest of the entries
    while (i<N)
    {
        // If isPrime[i] == True then i is
        // prime number
        if (isprime[i])
        {
            // put i into prime[] vector
            prime.add(i);

            // A prime number is its own smallest
            // prime factor
            SPF[i] = i;
        }

        // Remove all multiples of  i*prime[j] which are
        // not prime by making isPrime[i*prime[j]] = false
        // and put smallest prime factor of i*Prime[j] as prime[j]
        // [for exp :let  i = 5, j = 0, prime[j] = 2 [ i*prime[j] = 10]
        // so smallest prime factor of '10' is '2' that is prime[j] ]
        // this loop run only one time for number which are not prime
        var j = 0

        while (j < prime.count() &&
             i*prime.get(j) < N && prime.get(j) <= SPF[i])
        {
            isprime[i*prime.get(j)] = false

            // put smallest prime factor of i*prime[j]
            SPF[i*prime.get(j)] = prime.get(j)
            j+=1
        }
        i+=1
    }
  print("[OUTPUT] ")
  for(o in prime)
	 print(" $o")
}

fun main() {
  val N: Int = 10
  val isprime = BooleanArray(N) {true}
	val SPF = IntArray(N) {2}
  println("[INPUT] " + N)
	manipulated_seive(N, isprime, SPF)
}
