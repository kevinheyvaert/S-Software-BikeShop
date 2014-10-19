package be.uantwerpen.SS.client.view;

public class View {
	
public static void main(String args[]) {
		
		long StartTime , EndTime, TotalTime;
		double pi = 4;
		int [] anArray = new int[1000000];
		
		//start time
		StartTime = System.nanoTime();
		
		System.out.println("Starting program SingleThread : ");
		
		System.out.println("Calculating pi...");
		boolean plus = false;
		for (double i = 3; i < 1000000000; i += 2) {
			if (plus) {
				pi += 4.0 / i;
			} else {
				pi -= 4.0 / i;
			}
			plus = !plus;
		}
		
		System.out.println("Pi = " +pi);
		
}

}
