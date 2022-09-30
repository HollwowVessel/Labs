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
	public static double pow(double x, double n){
		double res = x;
		for(int i = 0; i < n; i++){
			res *= x;
		}
		return res;
	}

	public static double calculateRow(double x, double prec) {

		double res = 0;
		for(int i = 0; i < prec; i++){
			res += pow(x, i) / fact(i);
		}
		return res;
	}

	public static void main(String[] args) {
		double x = Double.parseDouble(args[0]);
		double prec = Double.parseDouble(args[1]);
		System.out.println(calculateRow(x, prec));
		System.out.println(pow(2.71, x));
	}
}