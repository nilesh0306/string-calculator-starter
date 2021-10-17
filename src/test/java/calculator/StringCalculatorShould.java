package calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorShould {
	StringCalculator calculator= new StringCalculator();

    @Test
    void empty_string_should_return_0() throws Exception {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(0, stringCalculator.add(""));
    }

  @Test
    void string_with_single_number_should_return_number_as_int() throws Exception {
        StringCalculator stringCalculator = new StringCalculator();
       assertEquals(1, stringCalculator.add("1"));
  }
  @Test
  public void addTwoNumberIsSumOfNumbers() throws Exception {
      StringCalculator calculator = new StringCalculator();
      assertEquals(3, calculator.add("1,2"));
  }
  @Test
  public void addUnknownAmountOfNumber() throws Exception {
      StringCalculator calculator = new StringCalculator();
      assertEquals(13, calculator.add("1,2,5,3,2"));
 
  }
  @Test
	public void acceptNewlineAsValidDelimiter() throws Exception
	{
		assertEquals(6, calculator.add("1\n2,3"));
	}

  @Test
	public void anyDelimeter() throws Exception
	{
		assertEquals(3, calculator.add("//;\n1;2"));
	}
 
  @Test
  public void NegativeNumber() throws Exception {
      StringCalculator calculator = new StringCalculator();
      try {
          calculator.add("//;\n1;-2;5");
      }catch (StringCalculatorException e) {
          assertEquals("negative not allowed [-2]", e.getMessage());
      }
  }

  @Test 
	public void multipleNegativeNumbers() throws Exception
	{
		try {
			calculator.add("-1,-2,3");
		}
		
		catch(Exception e)
		{
			assertEquals("negative not allowed [-1, -2]", e.getMessage());
		}
	}

  @Test
	public void validateCallCount(){
		assertEquals(calculator.getCallCount(), calculator.count);
	}

  @Test
	public void ignoreNumsGrtThn1000() throws Exception
	{
		assertEquals(2, calculator.add("2,1001"));
	}
  @Test
	public void validateAnyLengthDelimeter() throws Exception
	{
		assertEquals(6, calculator.add("//[***]\n1***2***3"));
	}
 
  @Test
	public void multipleDelimeter() throws Exception	{
		assertEquals(6, calculator.add("//[*][%]\n1*2%3"));
	}
}