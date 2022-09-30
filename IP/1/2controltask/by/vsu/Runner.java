package by.vsu;

public class Runner {
	/*
	 * Метод для вычисления простого выражения.
	 * Ключевое слово static позволит вызвать метод,
	 * не создавая объект класса Runner
	 * Ключевое слово public позволит вызвать метод
	 * из другого класса
	 */
	public static int fact(int n){
		int res  = 1;
		for(int i = 1; i < n; i++){
			res *= i;
		}
		return res;
	}

	public static double calculateRow(double x, double e) {
		int n = 2;
		double a = -1 * Math.pow(x, 3) / fact(3), b = x;
		double s = a + b;
		int sign = 1;
		while (Math.abs(a - b) > e){
			b = a;
			a = sign * Math.pow(x, 2*n + 1) / fact(2 * n + 1);
			sign *= -1;
			s += a;
			n++;
		}
		return s;
	}

	public static void main(String[] args) {
		double x = Double.parseDouble(args[0]);
		double prec = Double.parseDouble(args[1]);
		System.out.println(calculateRow(x, prec));
		System.out.println(Math.sin(x));
	}
}