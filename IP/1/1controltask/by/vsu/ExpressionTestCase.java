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
	public void testGetPositiveIntegers() {
		Assert.assertEquals(
				-8, // ожидаемый результат
				Runner.expression(1, 2, 3), // вызов тестируемого методы
				0.0000000001 // для вещественных чисел погрешность сравнения
		);
	}

	@Test
	public void testGetNegativeIntegers() {
		Assert.assertEquals(
				-8,
				Runner.expression(-1, -2, -3),
				0.0000000001
		);
	}

	@Test
	public void testGetMixedNumbers() {
		Assert.assertEquals(
				16,
				Runner.expression(1, 2, -3),
				0.0000000001
		);
	}
}