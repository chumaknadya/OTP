public class PiGenerator {
	/**
	 * Returns precision hexadecimal digits of the fractional part of pi.
	 * Returns digits in most significant to least significant order.
	 * 
	 * If precision < 0, return null.
	 * 
	 * @param precision
	 *            The number of digits after the decimal place to retrieve.
	 * @return precision digits of pi in hexadecimal.
	 */
	public static int[] computePiInHex(int precision) {
		if (precision < 0)
			return null;
		int[] res = new int[precision];
		for(int i = 0; i < precision; i++){
			res[i] = piDigit(i+1);
		}
		return res;
	}

	/**
	 * Computes a^b mod m
	 * 
	 * If a < 0, b < 0, or m < 0, return -1.
	 * 
	 * @param a
	 * @param b
	 * @param m
	 * @return a^b mod m
	 */
	public static int powerMod(int a, int b, int m) {
		if (a < 0 || b < 0 || m <= 0) {
			return -1;
		}
		long  res = 1;  // Initialize result
		long base = a % m;
		// Update a if it is more than
		// or equal to mod
		while (b > 0) {
			// If b is odd, add a with result
			if (b % 2 == 1)
				res = (res * base) % m;

			b >>= 1;  // b = b / 2
			base = (base * base) % m;
		}

		return (int)res;

	}

	private static double lg(double x) {
		return Math.log(x) / Math.log(2.0);
	}

	/**
	 * Computes the nth digit of Pi in base-16.
	 * 
	 * If n < 0, return -1.
	 * 
	 * @param n
	 *            The digit of Pi to retrieve in base-16.
	 * @return The nth digit of Pi in base-16.
	 */
	public static int piDigit(int n) {
		if (n < 0)
			return -1;

		n -= 1;
		double x = 4 * piTerm(1, n) - 2 * piTerm(4, n) - piTerm(5, n)
				- piTerm(6, n);
		x = x - Math.floor(x);

		return (int) (x * 16);
	}

	private static double piTerm(int j, int n) {
		// Calculate the left sum
		double s = 0;
		for (int k = 0; k <= n; ++k) {
			int r = 8 * k + j;
			s += powerMod(16, n - k, r) / (double) r;
			s = s - Math.floor(s);
		}

		// Calculate the right sum
		double t = 0;
		int k = n + 1;
		// Keep iterating until t converges (stops changing)
		while (true) {
			int r = 8 * k + j;
			double newt = t + Math.pow(16, n - k) / r;
			if (t == newt) {
				break;
			} else {
				t = newt;
			}
			++k;
		}

		return s + t;
	}
}
