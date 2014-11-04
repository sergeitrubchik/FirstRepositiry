
import java.util.Scanner;


public class Test {
	public static void main(String[] args){
		//можно просить пользовател€ вводить коэффициенты
		/*Scanner in = new Scanner(System.in);
		System.out.println("¬ведите степень полинома:");
		int n = in.nextInt();
		double[] coef = new double[n+1];
		System.out.println("¬ведите коэффициенты полинома(a_i - коэффициент при x в степени i):");
		for(int i = 0; i <= n; i++ ){
			System.out.print("a_"+i+" = ");
			coef[i] = in.nextDouble();
		}*/
		
		//дл€ примера рассмотрим уравнение x^3-3*x^2+3 = 0
		double coef[] = {3,0,-3,1};
		int n = 3;
		
		double a = Double.valueOf(args[0]);
		double b = Double.valueOf(args[1]);
		
		NonlinearEquation equation = new NonlinearEquation(a, b, n, coef);
		
		System.out.print("Solution of equation"+equation.toString()+" on ["+a+", "+b+"]: ");
		try{
			System.out.println(equation.getSolution());
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
}
