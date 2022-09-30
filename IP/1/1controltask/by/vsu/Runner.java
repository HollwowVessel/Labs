package by.vsu;

public class Runner {
	/*
	 * Метод для вычисления простого выражения.
	 * Ключевое слово static позволит вызвать метод,
	 * не создавая объект класса Runner
	 * Ключевое слово public позволит вызвать метод
	 * из другого класса
	 */
	public static double expression(double a, double b, double c) {
		return b*b - 4 * a * c;
	}

	public static void main(String[] args) {
		double a = Double.parseDouble(args[0]);
		double b = Double.parseDouble(args[1]);
		double c = Double.parseDouble(args[2]);
		System.out.println(expression(a, b, c));
	}
}