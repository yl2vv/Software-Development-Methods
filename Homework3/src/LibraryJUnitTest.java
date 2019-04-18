import static org.junit.Assert.*;

import org.junit.Test;

public class LibraryJUnitTest {

	@Test
	public void testCheckNumCopies1() {
		// set up
		Library l1 = new Library("Stone");
		
		Book b1 = new Book("Crazy Rich Asians", "Kevin Kwan", 345821, 8.99);
		Book b2 = new Book("Crazy Rich Asians", "Kevin Kwan", 123021, 6.00);
		Book b3 = new Book("Crazy Rich Asians", "Kevin Kwan", 734568, 8.50);
		Book b4 = new Book("Crazy Rich Asians", "Kevin Kwan", 298734, 7.99);
		Book b5 = new Book("In Pieces", "Sally Field", 534821, 8.99);
		Book b6 = new Book("Crazy Rich Girlfriend", "Kevin Kwan", 834975, 10.00);
		Book b7 = new Book("1984", "George Orwell", 384523, 8.50);
		Book b8 = new Book("Animal Farm", "George Orwell", 932841, 7.99);

		l1.getLibraryBooks().add(b1);
		l1.getLibraryBooks().add(b2);
		l1.getLibraryBooks().add(b3);
		l1.getLibraryBooks().add(b4);
		l1.getLibraryBooks().add(b5);
		l1.getLibraryBooks().add(b6);
		l1.getLibraryBooks().add(b7);
		l1.getLibraryBooks().add(b8);
		
		//test
		assertEquals(l1.checkNumCopies("Crazy Rich Asians", "Kevin Kwan"), 4);
		
	}
	
	@Test
	public void testCheckNumCopies2() {
		// set up
		Library l1 = new Library("Stone");
		
		Book b1 = new Book("Crazy Rich Asians", "Kevin Kwan", 345821, 8.99);
		Book b2 = new Book("Crazy Rich Asians", "Kevin Kwan", 123021, 6.00);
		Book b3 = new Book("Crazy Rich Asians", "Kevin Kwan", 734568, 8.50);
		Book b4 = new Book("Crazy Rich Asians", "Kevin Kwan", 298734, 7.99);
		Book b5 = new Book("In Pieces", "Sally Field", 534821, 8.99);
		Book b6 = new Book("Crazy Rich Girlfriend", "Kevin Kwan", 834975, 10.00);
		Book b7 = new Book("1984", "George Orwell", 384523, 8.50);
		Book b8 = new Book("Animal Farm", "George Orwell", 932841, 7.99);

		l1.getLibraryBooks().add(b1);
		l1.getLibraryBooks().add(b2);
		l1.getLibraryBooks().add(b3);
		l1.getLibraryBooks().add(b4);
		l1.getLibraryBooks().add(b5);
		l1.getLibraryBooks().add(b6);
		l1.getLibraryBooks().add(b7);
		l1.getLibraryBooks().add(b8);

		//test
		assertFalse(l1.checkNumCopies("Animal Farm", "George Orwell") == 2);
		
	}


	@Test
	public void testCheckOut1() {
		// set up
		Library l1 = new Library("Rice");
		
		Person p1 = new Person("Yu", "123 Grace St", 239874);
		Person p2 = new Person("James", "19 Emmet St", 487502);
		Person p3 = new Person("Yubin", "246 Ralph Ave", 283971);
		
		Book b1 = new Book("Crazy Rich Asians", "Kevin Kwan", 345821, 8.99);
		Book b2 = new Book("Crazy Rich Asians", "Kevin Kwan", 123021, 6.00);
		Book b3 = new Book("Crazy Rich Asians", "Kevin Kwan", 734568, 8.50);
		Book b4 = new Book("Crazy Rich Asians", "Kevin Kwan", 298734, 7.99);
		Book b5 = new Book("In Pieces", "Sally Field", 534821, 8.99);
		Book b6 = new Book("Crazy Rich Girlfriend", "Kevin Kwan", 834975, 10.00);
		Book b7 = new Book("1984", "George Orwell", 384523, 8.50);
		Book b8 = new Book("Animal Farm", "George Orwell", 932841, 7.99);
		
		l1.getPatrons().add(p1);
		l1.getPatrons().add(p2);
		l1.getPatrons().add(p3);

		l1.getLibraryBooks().add(b1);
		l1.getLibraryBooks().add(b2);
		l1.getLibraryBooks().add(b3);
		l1.getLibraryBooks().add(b4);
		l1.getLibraryBooks().add(b5);
		l1.getLibraryBooks().add(b6);
		l1.getLibraryBooks().add(b7);
		l1.getLibraryBooks().add(b8);
		
		//test
		assertTrue(l1.checkOut(p1, b1, "21 10 2018"));
	}
	
	@Test
	public void testCheckOut2() {
		// set up
		Library l1 = new Library("Rice");
		
		Person p1 = new Person("Yu", "123 Grace St", 239874);
		Person p2 = new Person("James", "19 Emmet St", 487502);
		Person p3 = new Person("Yubin", "246 Ralph Ave", 283971);
		
		Book b1 = new Book("Crazy Rich Asians", "Kevin Kwan", 345821, 8.99);
		Book b2 = new Book("Crazy Rich Asians", "Kevin Kwan", 123021, 6.00);
		Book b3 = new Book("Crazy Rich Asians", "Kevin Kwan", 734568, 8.50);
		Book b4 = new Book("Crazy Rich Asians", "Kevin Kwan", 298734, 7.99);
		Book b5 = new Book("In Pieces", "Sally Field", 534821, 8.99);
		Book b6 = new Book("Crazy Rich Girlfriend", "Kevin Kwan", 834975, 10.00);
		Book b7 = new Book("1984", "George Orwell", 384523, 8.50);
		Book b8 = new Book("Animal Farm", "George Orwell", 932841, 7.99);
		
		l1.getPatrons().add(p1);
		l1.getPatrons().add(p2);
		l1.getPatrons().add(p3);

		l1.getLibraryBooks().add(b1);
		l1.getLibraryBooks().add(b2);
		l1.getLibraryBooks().add(b3);
		l1.getLibraryBooks().add(b4);
		l1.getLibraryBooks().add(b5);
		l1.getLibraryBooks().add(b6);
		l1.getLibraryBooks().add(b7);
		l1.getLibraryBooks().add(b8);
		
		//test
		assertFalse(l1.checkOut(p1, b1, "21 10 2018") == false);
	}
	
	@Test
	public void testBooksDueOnDate1() {
		//set up
		Library l1 = new Library("Ohill");
		
		Book b1 = new Book("Crazy Rich Asians", "Kevin Kwan", 345821, 8.99);
		Book b2 = new Book("Crazy Rich Asians", "Kevin Kwan", 123021, 6.00);
		Book b3 = new Book("Crazy Rich Asians", "Kevin Kwan", 734568, 8.50);
		Book b4 = new Book("Crazy Rich Asians", "Kevin Kwan", 298734, 7.99);
		Book b5 = new Book("In Pieces", "Sally Field", 534821, 8.99);
		Book b6 = new Book("Crazy Rich Girlfriend", "Kevin Kwan", 834975, 10.00);
		Book b7 = new Book("1984", "George Orwell", 384523, 8.50);
		Book b8 = new Book("Animal Farm", "George Orwell", 932841, 7.99);

		l1.getLibraryBooks().add(b1);
		l1.getLibraryBooks().add(b2);
		l1.getLibraryBooks().add(b3);
		l1.getLibraryBooks().add(b4);
		l1.getLibraryBooks().add(b5);
		l1.getLibraryBooks().add(b6);
		l1.getLibraryBooks().add(b7);
		l1.getLibraryBooks().add(b8);
			
		b1.setDueDate("03 10 2018");
		b2.setDueDate("29 09 2018");
		b3.setDueDate("01 10 2018");
		b4.setDueDate("03 10 2018");
		b5.setDueDate("05 10 2018");
		b6.setDueDate("10 10 2018");
		b7.setDueDate("30 09 2018");
		b8.setDueDate("04 10 2018");
		
		//test
		assertEquals(1, l1.booksDueOnDate("01 10 2018").size());
	}
	
	@Test
	public void testBooksDueOnDate2() {
		//set up
		Library l1 = new Library("Ohill");
		
		Book b1 = new Book("Crazy Rich Asians", "Kevin Kwan", 345821, 8.99);
		Book b2 = new Book("Crazy Rich Asians", "Kevin Kwan", 123021, 6.00);
		Book b3 = new Book("Crazy Rich Asians", "Kevin Kwan", 734568, 8.50);
		Book b4 = new Book("Crazy Rich Asians", "Kevin Kwan", 298734, 7.99);
		Book b5 = new Book("In Pieces", "Sally Field", 534821, 8.99);
		Book b6 = new Book("Crazy Rich Girlfriend", "Kevin Kwan", 834975, 10.00);
		Book b7 = new Book("1984", "George Orwell", 384523, 8.50);
		Book b8 = new Book("Animal Farm", "George Orwell", 932841, 7.99);

		l1.getLibraryBooks().add(b1);
		l1.getLibraryBooks().add(b2);
		l1.getLibraryBooks().add(b3);
		l1.getLibraryBooks().add(b4);
		l1.getLibraryBooks().add(b5);
		l1.getLibraryBooks().add(b6);
		l1.getLibraryBooks().add(b7);
		l1.getLibraryBooks().add(b8);
			
		b1.setDueDate("03 10 2018");
		b2.setDueDate("29 09 2018");
		b3.setDueDate("01 10 2018");
		b4.setDueDate("03 10 2018");
		b5.setDueDate("05 10 2018");
		b6.setDueDate("10 10 2018");
		b7.setDueDate("30 09 2018");
		b8.setDueDate("04 10 2018");
		
		//test
		assertEquals(2, l1.booksDueOnDate("03 10 2018").size());
	}
	
	@Test
	public void testLateFee1() {
		//set up
		Library l1 = new Library("Rice");
		
		Person p1 = new Person("Yu", "123 Grace St", 239874);
		Person p2 = new Person("James", "19 Emmet St", 487502);
		Person p3 = new Person("Yubin", "246 Ralph Ave", 283971);
		
		Book b1 = new Book("Crazy Rich Asians", "Kevin Kwan", 345821, 10.00);
		Book b2 = new Book("Crazy Rich Asians", "Kevin Kwan", 123021, 6.00);
		Book b3 = new Book("Crazy Rich Asians", "Kevin Kwan", 734568, 8.50);
		Book b4 = new Book("Crazy Rich Asians", "Kevin Kwan", 298734, 7.99);
		Book b5 = new Book("In Pieces", "Sally Field", 534821, 8.99);
		Book b6 = new Book("Crazy Rich Girlfriend", "Kevin Kwan", 834975, 10.00);
		Book b7 = new Book("1984", "George Orwell", 384523, 8.50);
		Book b8 = new Book("Animal Farm", "George Orwell", 932841, 7.99);
		
		l1.getLibraryBooks().add(b1);
		l1.getLibraryBooks().add(b2);
		l1.getLibraryBooks().add(b3);
		l1.getLibraryBooks().add(b4);
		l1.getLibraryBooks().add(b5);
		l1.getLibraryBooks().add(b6);
		l1.getLibraryBooks().add(b7);
		l1.getLibraryBooks().add(b8);
		
		l1.getPatrons().add(p1);
		l1.getPatrons().add(p2);
		l1.getPatrons().add(p3);
		
		l1.setCurrentDate("28 09 2018");
		
		l1.checkOut(p1, b1, "27 09 2018");
		
		//test
		assertTrue(l1.lateFee(p1) == 0.10);
		
	}
	
	@Test
	public void testLateFee2() {
		//set up
		Library l1 = new Library("Rice");
		
		Person p1 = new Person("Yu", "123 Grace St", 239874);
		Person p2 = new Person("James", "19 Emmet St", 487502);
		Person p3 = new Person("Yubin", "246 Ralph Ave", 283971);
		
		Book b1 = new Book("Crazy Rich Asians", "Kevin Kwan", 345821, 10.00);
		Book b2 = new Book("Crazy Rich Asians", "Kevin Kwan", 123021, 6.00);
		Book b3 = new Book("Crazy Rich Asians", "Kevin Kwan", 734568, 8.50);
		Book b4 = new Book("Crazy Rich Asians", "Kevin Kwan", 298734, 7.99);
		Book b5 = new Book("In Pieces", "Sally Field", 534821, 8.99);
		Book b6 = new Book("Crazy Rich Girlfriend", "Kevin Kwan", 834975, 10.00);
		Book b7 = new Book("1984", "George Orwell", 384523, 8.50);
		Book b8 = new Book("Animal Farm", "George Orwell", 932841, 7.99);
		
		l1.getLibraryBooks().add(b1);
		l1.getLibraryBooks().add(b2);
		l1.getLibraryBooks().add(b3);
		l1.getLibraryBooks().add(b4);
		l1.getLibraryBooks().add(b5);
		l1.getLibraryBooks().add(b6);
		l1.getLibraryBooks().add(b7);
		l1.getLibraryBooks().add(b8);
		
		l1.getPatrons().add(p1);
		l1.getPatrons().add(p2);
		l1.getPatrons().add(p3);
		
		l1.setCurrentDate("28 09 2018");
		
		l1.checkOut(p2, b2, "27 09 2018");
		
		//test
		assertTrue(l1.lateFee(p2) == 0.06);
	}
}
