package by.vsu;

public class Runner {
	/*
	 * Метод для вычисления простого выражения.
	 * Ключевое слово static позволит вызвать метод,
	 * не создавая объект класса Runner
	 * Ключевое слово public позволит вызвать метод
	 * из другого класса
	 */
	public static double expression(int a, double b) {
		return b / a;
	}

	public static void main(String[] args) {
		int a = Integer.parseInt(args[0]);
		double b = Double.parseDouble(args[1]);
		System.out.println(expression(a, b));
	}
}