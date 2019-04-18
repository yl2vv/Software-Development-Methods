/**
 * Homework 6 PrintQueue
 * 
 * Implement the class below as specified in the
 * homework 6 document.
 * 
 * @author yl2vv
 *
 */
 
 // Don't forget to include the appropriate import statements
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.*;
 
 
public class PrintQueue {
	
	private Queue<String> queue;      // the print queue (called "queue")
	private Lock documentChangeLock;  // a ReentrantLock lock
	private Condition hasPrintTask, dequeued;   // a condition object
	private boolean isOn;             // boolean variable describing if the queue is on or off
	
	
	
	//TODO:  Finish the rest of this class. 
	
	/**
	 * Constructor PrintQueue
	 */
	public PrintQueue() {
		queue = new LinkedList<String>();
		documentChangeLock = new ReentrantLock();
		hasPrintTask = documentChangeLock.newCondition();
		dequeued = documentChangeLock.newCondition();
		isOn = true;
		
	}
	
	/**
	 * Remove the head element off the queue (if there is something in the queue) and return it
	 * @return : the String that will be printed
	 */
	public String dequeue(){
		documentChangeLock.lock(); // ensure that two CardCreators do not attempt to modify the queue at the same time
		try {
			while (queue.isEmpty()) { // if queue is empty then don't print
				hasPrintTask.await();
			}
			return queue.remove(); // call remove to the queue if there is something in the queue
		}
		catch (InterruptedException e){ // exception if thread is interrupted (locks will help this)
			System.out.println("Interrupted");
		}
		finally {
			dequeued.signalAll(); // wake up all awaiting threads
			documentChangeLock.unlock(); // unlock thread
		}
		return null;
	}
	
	/**
	 * Add the greeting given by the String parameter onto the end of the print queue
	 * @param greeting : greeting slogan to add to queue
	 */
	public void enqueue(String greeting) {
		documentChangeLock.lock(); // ensure that two CardCreators do not attempt to add to the queue at the same time
		try {
			queue.add(greeting); // add greeting to queue
			hasPrintTask.signalAll(); // wake up all awaiting threads
		}
		finally {
			documentChangeLock.unlock();
		}
	}
	
	/**
	 * Turn off the print queue (i.e. set a boolean field denoting that the PrintQueue is no longer accepting jobs)
	 */
	public void turnOff() {
		documentChangeLock.lock();
		try {
			while (!queue.isEmpty()) { 
				dequeued.await();
			}
			isOn = false; // Make sure the queue isn’t in the middle of being modified before turning off the print queue
			hasPrintTask.signalAll();
		}
		catch (InterruptedException e){
			System.out.println("Interrupted");
		}
		finally {
			documentChangeLock.unlock();
		}
	}
	
	/**
	 * Returns the state (value) of isOn.
	 * @return : true if the PrintQueue is still accepting jobs, false if it has been “turned off.”
	 */
	public boolean isOn() {
		if (isOn) {
			return true;
		}
		else return false;
	}
}
