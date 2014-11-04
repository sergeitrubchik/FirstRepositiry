
import java.util.*;

public class NonlinearEquation {
	
	double a,b; //границы отрезка, на котором ищем решение
	double[] coefficients;//коэффиуиенты полинома
	int n;//степень полинома
	double eps = 1e-8;//точность
	
	public NonlinearEquation(double a, double b, int n, double[] coef){//конструктор
		assert( n > 0);
		this.a = a;
		this.b = b;
		this.n = n;
		coefficients = new double[n+1];
		for( int i = 0; i <= n; i++ ){
			coefficients[i] = coef[i];
		}
	}
	
	public double f(double x){//вычисляем значение нашего полинома в нужной точке
		double res = 0;
    	res+= coefficients[0];    	
    	for(int i = 1; i <= n; i++){   		
    		res+=coefficients[i]*Math.pow(x, i);
    	}
    	return res;
	}
	
	public double getSolution() throws Exception{
		int counter = 0;
		double c;
		c = (a+b)/2;
		while( Math.abs(f(c)) >= eps){
			counter++;
			if(f(a)*f(c) < 0) b = c;
			else a = c;
			c = (a+b)/2;
			if(counter > 1000000) throw new Exception("На данном отрезке уравнение не имеет корней");
		}		
		return c;
	}
	
	public String toString(){
		String str = "  ";
		if( coefficients[n] != 0) str+= coefficients[n]+"*x^"+n+" ";
		
		for( int i = n-1; i > 1; i--){
			if( coefficients[i] > 0) str+= "+"+coefficients[i]+"*x^"+i+" ";
			else if(coefficients[i] < 0) str+= coefficients[i]+"*x^"+i+" ";

		}
		
		if( coefficients[1] > 0) str+= "+"+coefficients[1]+"*x ";
		else if(coefficients[1] < 0) str+= coefficients[1]+"*x " ;
		if( coefficients[0] > 0) str+= "+"+coefficients[0];
		else if(coefficients[0] < 0) str+= coefficients[0];
		str+=" = 0";
		
		return str;
	}
	
}
