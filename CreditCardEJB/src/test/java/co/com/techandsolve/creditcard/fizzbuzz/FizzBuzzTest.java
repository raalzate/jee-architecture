package co.com.techandsolve.creditcard.fizzbuzz;

import org.junit.Assert;
import org.junit.Test;

public class FizzBuzzTest {
	
	@Test
	public void whenIsendOneShouldReturnFizz(){
		//arrange
		Fizz fizz = new Fizz();
		//act
		String result = fizz.get(1);
		//assert
		Assert.assertEquals("Fizz", result);
	}
	
	@Test
	public void whenIsendTwoShouldReturnFizz(){
		//arrange
		Fizz fizz = new Fizz();
		//act
		String result = fizz.get(2);
		//assert
		Assert.assertEquals("Fizz", result);
	}
	
	@Test
	public void whenIsendThreeShouldReturnBuzz(){
		//arrange
		Fizz fizz = new Fizz();
		//act
		String result = fizz.get(3);
		//assert
		Assert.assertEquals("Buzz", result);
	}
	
	
	@Test
	public void whenIsendFourShouldReturnFizz(){
		//arrange
		Fizz fizz = new Fizz();
		//act
		String result = fizz.get(4);
		//assert
		Assert.assertEquals("Fizz", result);
	}
	
	@Test
	public void whenIsendFiveShouldReturnFizz(){
		//arrange
		Fizz fizz = new Fizz();
		//act
		String result = fizz.get(5);
		//assert
		Assert.assertEquals("Fizz", result);
	}

	@Test
	public void whenIsendSixShouldReturnBuzz(){
		//arrange
		Fizz fizz = new Fizz();
		//act
		String result = fizz.get(6);
		//assert
		Assert.assertEquals("Buzz", result);
	}
	
		
	@Test
	public void whenIsendSevenShouldReturnFizz(){
		//arrange
		Fizz fizz = new Fizz();
		//act
		String result = fizz.get(7);
		//assert
		Assert.assertEquals("Fizz", result);
	}
	
	
	@Test
	public void whenIsendEightShouldReturnFizz(){
		//arrange
		Fizz fizz = new Fizz();
		//act
		String result = fizz.get(8);
		//assert
		Assert.assertEquals("Fizz", result);
	}
	
	@Test
	public void whenIsendNineShouldReturnBuzz(){
		//arrange
		Fizz fizz = new Fizz();
		//act
		String result = fizz.get(9);
		//assert
		Assert.assertEquals("Buzz", result);
	}
}
