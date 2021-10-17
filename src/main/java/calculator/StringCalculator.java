
package calculator;

import java.util.ArrayList;

class StringCalculator {
	static int count = 0;


	public int add(String input) throws Exception {
count++;
		ArrayList<Integer> list = new ArrayList<>();
    	//if string is empty it returns 0
    	int sum=0;
       if(input.isEmpty())
    	    return 0;
       else {
    	   if(input.length()==1)
    	      return Integer.parseInt(input);   //if string length is 1 it returns first element converted to integer
    	   else {
    		   String[] nums = StringCalculator.split(input);
    		  
    		   for (String num : nums) {
    			   if(Integer.parseInt(num)<0) {
    				   list.add((Integer.parseInt(num)));
				         // throw new StringCalculatorException("negatives not allowed "+num);
    			   }else if(Integer.parseInt(num)>1000)
    				   num="0";
    	            sum += Integer.parseInt(num);
    	        }
    		   if(list.size()>0)
    			   throw new StringCalculatorException("negative not allowed "+list.toString());
    		   return sum;
    	   }
    	   }
      }
    private static String[] split(String str)
	{     if (str.startsWith("//")) {
        String delimiter = str.substring(2, 3);
        return str.substring(4).split(delimiter);
    }

		String[] nums = str.split(",|\n");
		return nums;
	}

    public int getCallCount() {
		return count;
	}


}