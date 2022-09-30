package by.vsu;

import org.junit.Assert;
import org.junit.Test;

/*
 * Набор тестов. Как правило, для одного метода или класса
 * создаётся отдельный набор тестов, помещаемый в отдельный
 * класс. Имя этого класса может быть произвольным, но
 * желательно, чтобы оно отображало, какой метод или класс
 * будет тестироваться
 */
public class ExpressionTestCase {
	/*
	 * каждый метод, начинающийся с аннотации @Test
	 * представляет собой один тест, в котором, как
	 * правило, представлен один набор тестовых данных
	 */
	@Test
	public void testDividingBiggerNumberBySmaller() {
		Assert.assertEquals(
				2.5, // ожидаемый результат
				Runner.expression(2, 5), // вызов тестируемого методы
				0.0000000001 // для вещественных чисел погрешность сравнения
		);
	}

	@Test
	public void testDividingSmallerNumberByBigger() {
		Assert.assertEquals(
				0.4,
				Runner.expression(5, 2),
				0.0000000001
		);
	}

	@Test
	public void testDividingPositiveNumberByZero() {
		Assert.assertEquals(
				Double.POSITIVE_INFINITY,
				Runner.expression(0, 2),
				0.0000000001
		);
	}

	@Test
	public void testDividingNegativeNumberByZero() {
		Assert.assertEquals(
				Double.NEGATIVE_INFINITY,
				Runner.expression(0, -2),
				0.0000000001
		);
	}
}