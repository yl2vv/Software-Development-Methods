//Yu Bin Lim (yl2vv)
// Homework 3

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Library {

	private ArrayList<Book> libraryBooks;// An array list that holds all books for the library
	private ArrayList<Person> patrons; //An array list that holds all the people who are patrons of the library
	private String name; // A string that holds the name of the library
	private int numBooks; // An integer keeps track of number of books that are available to be checked out
	private int numPeople; // An integer that keeps the number of patrons to the library
	private String currentDate; // A String that represents the current date
	
	//Constructor that takes in a String for the name of the library
	public Library(String name) {
		this.libraryBooks = new ArrayList<Book>();
		this.patrons = new ArrayList<Person>();
		this.name = name;
		this.numBooks = numBooks;
		this.numPeople = numPeople;
		this.currentDate = currentDate;
	}
	
	//Accessors and Mutators for the fields provided
	public ArrayList<Book> getLibraryBooks() {
		return this.libraryBooks;
	}

	
	public void setLibraryBooks(ArrayList<Book> libraryBooks) {
		this.libraryBooks = libraryBooks;
	}

	
	public ArrayList<Person> getPatrons() {
		return this.patrons;
	}


	public void setPatrons(ArrayList<Person> patrons) {
		this.patrons = patrons;
	}


	public String getName() {
		return this.name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getNumPeople() {
		this.numPeople = this.patrons.size();
		return this.numPeople;
	}


	public String getCurrentDate() {
		return this.currentDate;
	}


	public void setCurrentDate(String currentDate) {
		this.currentDate = currentDate;
	}

	// Accessor for NumBooks // Removes the number of books that are checked out and returns number of books available
	public int getNumBooks() {
		int available = this.libraryBooks.size();
		for (Book book : libraryBooks) {
			if (book.isCheckedOut()) {
				available -= 1;
			}
		}
		numBooks = available;
		return this.numBooks;
	}
	
	//Return copies of book in library
	public int checkNumCopies(String title, String author) {
		int count = 0;
		for (Book book : libraryBooks) {
			if(title.equals(book.getTitle()) && author.equals(book.getAuthor())) {
					count ++;
				}
			}	
		return count;
	}
	
	//Return the number of books in library
	public int totalNumBooks() {
		return libraryBooks.size();
	}
	
	//Checks out a book not currently checked out to a patron 
	public boolean checkOut(Person p, Book b, String dueDate) {
		if (patrons.contains(p)) {
			if (libraryBooks.indexOf(b) != -1 && libraryBooks.get(libraryBooks.indexOf(b)).isCheckedOut() == false) {
			libraryBooks.get(libraryBooks.indexOf(b)).setCheckedOut(true); //Now checked out
			libraryBooks.get(libraryBooks.indexOf(b)).setDueDate(dueDate); // Due date of book
			p.getCheckedOut().add(libraryBooks.get(libraryBooks.indexOf(b))); //person checked it out
			return true;
			}
			else {
				return false;
			}
		}
		return false;
	}
	

	
	
	//Books due on given date
	public ArrayList<Book> booksDueOnDate(String date) {
		ArrayList<Book> booksDueOnDate = new ArrayList<Book>();
		for(int i = 0; i < libraryBooks.size(); i++) {
			if (libraryBooks.get(i).getDueDate() == (date)) {
				booksDueOnDate.add(libraryBooks.get(i));
			}
		}
		return booksDueOnDate;
	}
	
	//Calculate the late fee the person owes
	public double lateFee(Person p) {
		double late_fee = 0;
		for (int i = 0; i < p.getCheckedOut().size(); i ++) {
			String year = p.getCheckedOut().get(i).getDueDate().substring(6, 10); //Due Date
			int year_due = Integer.parseInt(year);
			String month = p.getCheckedOut().get(i).getDueDate().substring(3, 5);
			int month_due = Integer.parseInt(month);
			String day = p.getCheckedOut().get(i).getDueDate().substring(0, 2);
			int day_due = Integer.parseInt(day);
			
			String year_is = this.currentDate.substring(6, 10); //Current Date
			int year_now = Integer.parseInt(year_is);
			String month_is = this.currentDate.substring(3, 5);
			int month_now = Integer.parseInt(month_is);
			String day_is = this.currentDate.substring(0, 2);
			int day_now = Integer.parseInt(day_is);
			
			Calendar book_due = new GregorianCalendar(year_due, month_due, day_due); //In Gregorian Calendar
			Calendar current_date = new GregorianCalendar(year_now, month_now, day_now);
			
			long diff = current_date.getTimeInMillis() - book_due.getTimeInMillis(); // Calculate date differences
			long days = (long)(diff / 8.64E7);
			if (days > 0) {
				late_fee += p.getCheckedOut().get(i).getBookValue() * .01 * days;
			}
			
		}
		double fee_due = (double) Math.round(late_fee * 100) /100;
		return fee_due;
	}

	public static void main(String[] args) {
		

	}

}
