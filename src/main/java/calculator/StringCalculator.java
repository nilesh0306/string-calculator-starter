
package calculator;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
	{   if(str.startsWith("//["))
		return splitMulCustomDelWithAnyLength(str);
    	if (str.startsWith("//")) {
        String delimiter = str.substring(2, 3);
        return str.substring(4).split(delimiter);
    }

		String[] nums = str.split(",|\n");
		return nums;
	}

    private static String[] splitMulCustomDelWithAnyLength(String str) {
		Matcher m = Pattern.compile("//(\\[.+\\])+\n(.*)").matcher(str);
		m.matches();
		String del = m.group(1);
		String delimeters = new String();
		
		int l = del.length(),last =0;
		for(int i =0; i<l ; i++) {
			if(del.charAt(i) == ']' && i != l-1) {	
				delimeters += del.substring(last,i);
				delimeters += "]|";
				last = i+1;
			}
			else if(i == l-1)
				delimeters += del.substring(last,i) + "]";
		}
		String nums = m.group(2);
		
		return nums.split(delimeters); 
	}
	
	public int getCallCount() {
		return count;
	}
    

}