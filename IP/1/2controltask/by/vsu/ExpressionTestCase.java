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
				0.4387, // ожидаемый результат
				Runner.calculateRow(0.5, 0.01), // вызов тестируемого методы
				0.01 // для вещественных чисел погрешность сравнения
		);
	}

	@Test
	public void testGetNegativeIntegers() {
		Assert.assertEquals(
				0.5403,
				Runner.calculateRow(1, 0.01),
				0.01
		);
	}

	@Test
	public void testGetMixedNumbers() {
		Assert.assertEquals(
				0.196,
				Runner.calculateRow(0.2, 0.01),
				0.01
		);
	}
}