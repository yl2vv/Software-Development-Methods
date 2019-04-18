// Yubin Lim yl2vv
// Homework 3

public class Book {
	//A Book is just a title and an author
	// fields
	private String title; // A string; Never changes
	private String author; // A string; Never changes
	private String dueDate; // A string; Given in the format "DD MM YYYY"
	private boolean checkedOut; // A boolean; true if book is checked out
	private int bookId; // An int; holds id for a certain book
	private double bookValue; // A double; current value of the book
	

	// Constructor for Book Class
	public Book(String title, String author, int bookId, double bookValue) {
		this.title = title;
		this.author = author;
		this.bookId = bookId;
		this.bookValue = bookValue;
		this.checkedOut = checkedOut;
		

	}

	//Getters Public methods that return references to the title
	public String getTitle() {
		return this.title;
	}

	//Getters Public methods that return references to the author
	public String getAuthor() {
		return this.author;
	}

	// No setters for title and authors because once a book exists, its title and author are fixed.

	//accessors and mutators for each of the new fields except for a mutator for bookId
	public String getDueDate() {
		return this.dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public boolean isCheckedOut() { // "is", not "get" for boolean accessors
		return checkedOut;
	}

	public void setCheckedOut(boolean checkedOut) {
		this.checkedOut = checkedOut;
	}

	public int getBookId() {
		return this.bookId;
	}

	public double getBookValue() {
		return bookValue;
	}

	public void setBookValue(double bookValue) {
		this.bookValue = bookValue;
	}

	/*
	Return true if the Book object passed to equals() with title and author strings match
	(are equal to) the title and author strings of the current Book object; otherwise, return false. 
	 */
	public boolean equals(Object o) {
		if (o == null) {
			return false; // o is null
		}
		if( o instanceof Book) {
			Book new_book = (Book) o; // cast o to a Book
			return (this.bookId == new_book.bookId); // the id of the book match
		}
		else {
			return false; // o is not a Book
		}
	}

	//Shows the values of the fields title and author
	public String toString() {
		return ("#" + this.bookId + " \"" + this.title + "\"" + " (by: " + this.author + ") Checked Out?" + this.checkedOut + "; Due Date: " + String.valueOf(this.dueDate) + "]" + " {Book Value: " + this.bookValue + "}"); 
	}

	public static void main(String[] args) {
		
	}

}
