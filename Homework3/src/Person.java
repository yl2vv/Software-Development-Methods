//Yubin Lim yl2vv

import java.util.ArrayList;

public class Person {
	//A Person has a name and a list of books they remember reading, but both of those can change. 
	//To keep people straight, they also have a numerical ID.

	//fields
	private String name; // A String containing the Person's name in whatever form they provided it
	private int libraryCardNum; // An integer containing the Person's unique ID.
	private ArrayList<Book> checkedOut; // An ArrayList<Book> of books the Person has checked out
	private String address; // A string containing address for person

	//Constructor for Person Class
	public Person(String name, String address, int libraryCardNum) {
		this.name = name;
		this.address = address;
		this.libraryCardNum = libraryCardNum;		
		this.checkedOut = new ArrayList<Book>();

	}



	//Getters Public methods that return references to the name
	public String getName() {
		return this.name;
	}



	//Setter for name field
	public void setName(String name) {
		this.name = name;
	}


	//Getter that returns address
	public String getAddress() {
		return this.address;
	}


	//Setter for address field
	public void setAddress(String address) {
		this.address = address;
	}



	//Getters Public methods that returns the value of the id field 
	public int getLibraryCardNum() {
		return this.libraryCardNum;
	}



	//id cannot change, therefore no Setter



	//Getters Public methods that return references to the ArrayList checkedOut
	public ArrayList<Book> getCheckedOut() {
		return checkedOut;
	}
	
	// the read field will be changed by other methods, so no setter



	//Add the Book b to the list of the current object's read books if and only if it was not already in that list
	public boolean addBook(Book b) { 
		if (!checkedOut.contains(b)) {
			checkedOut.add(b);
			return true;
		}
		else {
			return false;
		}
	}



	// Return true if the current object has read the Book b
	public boolean hasRead(Book b) {
		if (checkedOut.contains(b) == true) {
			return true;
		}
		else
			return false;
	}

	//Return true if the Book was removed or false if it was not there
	public boolean forgetBook(Book b) {
		if (checkedOut.contains(b) == true) {
			checkedOut.remove(b);
			return true;
		}
		else
			return false;
	}

	//Return the number of Books the current object has read
	public int numBooksRead() {
		return checkedOut.size();
	}

	//return true if the current Person object's id value is equal to the id value of the Person object passed to equals(). Otherwise, return false.
	public boolean equals(Object o) {
		if (o == null) {
			return false; // o is null
		}
		if( o instanceof Person) {
			Person id2 = (Person) o; // cast o to a Book
			return (this.libraryCardNum == id2.libraryCardNum); // id match
		}
		else {
			return false; // o is not a Person
		}
	}

	//shows the values of the fields name, id and read
	public String toString() {
		return "Name: " + this.name + " , Address: " + this.address + " , id: " + this.libraryCardNum + " , Checked Out: " + this.checkedOut;
	}

	// Return an ArrayList<Book> of the books that both Person a and Person b have read
	public static ArrayList<Book> commonBooks(Person a, Person b) {
		ArrayList<Book> commonBooks = new ArrayList<Book>();

		for (Book ele : a.checkedOut) {
			if (b.hasRead(ele)) {
				commonBooks.add(ele);
			}
		}
		return commonBooks;
	}

	//Returns a measure of how similar the reading preferences of two readers are as a number between 0 and 1
	public static double similarity(Person a, Person b) {
		double a_read = a.numBooksRead(); // number of books a read
		double b_read = b.numBooksRead(); // number of books b read
		if (a_read == 0 || b_read == 0) { // if either reader has not read any books, the result is 0.0
			return 0.0;
		}
		else { // the number of commonBooks divided by smaller of the number of books read
			ArrayList<Book> commonBooks = new ArrayList<Book>();
			commonBooks = commonBooks(a,b); // the common number of books read
			double common = commonBooks.size();

			if (a_read >= b_read) {
				return common / b_read;
			}
			else {
				return common / a_read;
			}
		}
	}


	public static void main(String[] args) {

	}

}
