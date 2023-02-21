public class Test {
	public static void main(String[] args) {
		System.out.println('2'+'3'); 		//101
		System.out.println("2"+"3"); 		//23	 
		System.out.println('A'+5);   		//70
		System.out.println((char)('A'+32));     //a : casting	
		System.out.println('2'-48+'3'-48); 	//char -> int
		System.out.println(Integer.parseInt("2") + Integer.parseInt("3")); //char -> int	 		
		// System.out.println(("25."/"6")); 
		System.out.println(Double.parseDouble("25.") / Double.parseDouble("6"));
		System.out.println(Double.parseDouble("25.") / Integer.parseInt("6"));
		System.out.println(String.format("%.2f", Double.parseDouble("25.") / Integer.parseInt("6")));
	}
}                                                 