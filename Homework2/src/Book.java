// Yubin Lim yl2vv

public class Book {
	//A Book is just a title and an author
	// fields
	private String title; // A string; Never changes
	private String author; // A string; Never changes

	// Constructor for Book Class
	public Book(String title, String author) {
		this.title = title;
		this.author = author;

	}

	//Getters Public methods that return references to the title
	public String getTitle() {
		return this.title;
	}

	//Getters Public methods that return references to the author
	public String getAuthor() {
		return this.author;
	}

	// No setters because once a book exists, its title and author are fixed.

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
			return (this.title == new_book.title) && (this.author == new_book.author); // title and author match
		}
		else {
			return false; // o is not a Book
		}
	}

	//Shows the values of the fields title and author
	public String toString() {
		return this.title + " (by: " + this.author + ")"; // Example: Title , by: Author
	}

	public static void main(String[] args) {
		Book b1 = new Book("Crazy Rich Asians", "Kevin Kwan"); //create a new book
			System.out.println(b1.toString()); // print the toString
			
			System.out.println("\n");
			
		Book b2 = new Book("In Pieces", "Sally Field");
			System.out.println(b2.toString());
			
			System.out.println("\n");
			
		Book b3 = new Book("Crazy Rich Girlfriend", "Kevin Kwan");
			System.out.println(b3.toString());
			
			System.out.println("\n");
			
		Book b4 = new Book("Crazy Rich Girlfriend", "Kevin Kwan");
			System.out.println(b4.toString());

			System.out.println("\n");
			
			System.out.println(b3.equals(b4)); //compare two books to see if they are equal
			System.out.println(b1.equals(b4));


	}

}
