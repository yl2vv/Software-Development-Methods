import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Homework 6 Card Creator
 * 
 * This class defines the thread task that will
 * "come up with" and submit greeting card ideas
 * to the print queue.  We have added the code
 * necessary to read from the file, but it's up to
 * you to handle turning off the printer (keeping
 * track of how many threads are open) and adding
 * the read-in line from the inspiration file to
 * the queue.
 * 
 * @author jh2jf
 *
 */
public class CardCreator implements Runnable {
	
	/**
	 * Print queue to add new card ideas
	 */
	private PrintQueue printQueue;
	
	/**
	 * Inspiration file name
	 */
	private String filename;
	
	public CardCreator(PrintQueue d, String filename) {
		printQueue = d;
		this.filename = filename;
	}
	
	private static int counter; // counter of running threads
	
	/**
	 * Run method that is the main method for the thread
	 */
	@Override
	public void run() {
		   counter ++;
		Scanner s = null;
		try {
			s = new Scanner(new FileReader(filename));
			while (s.hasNextLine()) {
				// TODO: Read the next line from the inspiration file
				String slogan = s.nextLine();
				// TODO: Enqueue the line into the print queue
				printQueue.enqueue(slogan);
				if (s.hasNextLine()) { // if there is another slogan
					Thread.sleep(1000); // sleep for 1 second (i.e. 1000 ms) before submitting the next slogan
				}
			}
		} catch (IOException e) {
			System.out.println("Could not read file");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			if (s != null)
				s.close();
			   counter --;
			// TODO: Turn off the print queue (if applicable)
			if (counter == 0) { // when the last CardCreator thread has finished executing
			printQueue.turnOff(); // turn off the PrintQueue
			}
		}
		
	}

}
