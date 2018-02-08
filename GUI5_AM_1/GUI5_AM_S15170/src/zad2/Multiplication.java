package zad2;

import java.math.BigDecimal;

public class Multiplication extends Operators{
	String res="";
	double num1=0;
	double num2=0;
	
	Multiplication(){};
	
		@Override
		String getResult(String number1, String number2){
			BigDecimal result=new BigDecimal("0");
			BigDecimal bd1=new BigDecimal(number1);
			BigDecimal bd2=new BigDecimal(number2);
			result=bd1.multiply(bd2);
			this.res=result+"";
			return this.res;
		
	}
		@Override
		public String toString(){
			return this.res;
		}

}
