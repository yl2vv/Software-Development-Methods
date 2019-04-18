//Yubin Lim yl2vv

import java.util.ArrayList;

public class Person {
	//A Person has a name and a list of books they remember reading, but both of those can change. 
	//To keep people straight, they also have a numerical ID.

	//fields
	private String name; // A String containing the Person's name in whatever form they provided it
	private int id; // An integer containing the Person's unique ID.
	private ArrayList<Book> read; // An ArrayList<Book> of books the Person has read

	//Constructor for Person Class
	public Person(String name, int id) {
		this.name = name;
		this.id = id;		
		this.read = new ArrayList<Book>();
		
	}



	//Getters Public methods that return references to the name
	public String getName() {
		return this.name;
	}



	//Setter for name field
	public void setName(String name) {
		this.name = name;
	}



	//Getters Public methods that returns the value of the id field 
	public int getId() {
		return this.id;
	}



	//id cannot change, therefore no Setter



	//Getters Public methods that return references to the ArrayList read
	public ArrayList<Book> getRead() {
		return this.read;
	}

	// the read field will be changed by other methods, so no setter



	//Add the Book b to the list of the current object's read books if and only if it was not already in that list
	public boolean addBook(Book b) { 
		if (!read.contains(b)) {
			read.add(b);
			return true;
		}
		else {
			return false;
		}
	}

	// Return true if the current object has read the Book b
	public boolean hasRead(Book b) {
		if (read.contains(b) == true) {
			return true;
		}
		else
			return false;
	}

	//Return true if the Book was removed or false if it was not there
	public boolean forgetBook(Book b) {
		if (read.contains(b) == true) {
			read.remove(b);
			return true;
		}
		else
			return false;
	}

	//Return the number of Books the current object has read
	public int numBooksRead() {
		return read.size();
	}

	//return true if the current Person object's id value is equal to the id value of the Person object passed to equals(). Otherwise, return false.
	public boolean equals(Object o) {
		if (o == null) {
			return false; // o is null
		}
		if( o instanceof Person) {
			Person id2 = (Person) o; // cast o to a Book
			return (this.id == id2.id); // id match
		}
		else {
			return false; // o is not a Person
		}
	}

	//shows the values of the fields name, id and read
	public String toString() {
		return "Name: " + this.name + " , id: " + this.id + " , read: " + this.read;
	}

	// Return an ArrayList<Book> of the books that both Person a and Person b have read
	public static ArrayList<Book> commonBooks(Person a, Person b) {
		ArrayList<Book> commonBooks = new ArrayList<Book>();

		for (Book ele : a.read) {
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
		
		Person p1 = new Person("Yu", 239874); // add new person
		Person p2 = new Person("James", 487502);
		Person p3 = new Person("Yubin", 238472);
		
		Book b1 = new Book("Crazy Rich Asians", "Kevin Kwan"); // new book
		Book b2 = new Book("In Pieces", "Sally Field");
		Book b3 = new Book("Crazy Rich Girlfriend", "Kevin Kwan");
		Book b4 = new Book("1984", "George Orwell");
		
		p1.addBook(b1); // add a specific book to person read
		p1.addBook(b2);
		p1.addBook(b3);
		p1.addBook(b4);
		p2.addBook(b1);
		p2.addBook(b3);
		p3.addBook(b2);
		p3.addBook(b3);
		p3.addBook(b4);
		
		System.out.println(p1.hasRead(b1)); // check if book is in person read
		System.out.println(p2.hasRead(b2));
		
		System.out.println("\n");
		
		System.out.println(p2.forgetBook(b4)); // if person has book in read remove it
		System.out.println(p2.forgetBook(b1));
		System.out.println(p2.forgetBook(b3));
		System.out.println(p3.forgetBook(b3));
		
		System.out.println("\n");
		
		System.out.println(p1.numBooksRead()); // how many books are read
		System.out.println(p2.numBooksRead());
		System.out.println(p3.numBooksRead());
		
		System.out.println("\n");
		
		System.out.println(p1.equals(p3)); // check if id is equal
		System.out.println(p1.equals(p2));
		
		System.out.println("\n");
		
		System.out.println(p1.toString()); // print name, id, and read array list
		System.out.println(p2.toString());
		
		System.out.println("\n");
		
		System.out.println(commonBooks(p1,p3)); // print array list of common books in read
		System.out.println(commonBooks(p2, p3));
		
		System.out.println("\n");
		
		System.out.println(similarity(p1,p2)); // print measure of how similar the reading preferences of two people is
		System.out.println(similarity(p1,p3));
		
	
		
		


	}

}
