// Yubin Lim | yl2vv | Homework 4
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class HW4Test {
/** Make the variables **/
	private Song s1;
	private Song s2;
	private Song s3;
	private Song s4;
	private Song s5;
	private Song s6;
	private Song s7;
	private Song s8;
	private Song s9;
	private PlayList p1;
	private PlayList p2;
	private PlayList p3;
	private PlayList p4;

/** Assign the variables and add songs to play list before testing **/
	@Before
	public void setUp() {
	s1 = new Song("Kanye West", "Runaway", 4, 21);
	s2 = new Song("Kanye West", "Hey Mama", 2, 13);
	s3 = new Song("Bazzi", "Mine", 2, 39);
	s4 = new Song("Kanye West", "Runaway", 4, 21);
	s5 = new Song("Travis Scott", "Stargazing", 4, 30);
	s6 = new Song("Lil Pump", "Gucci Gang", 3, 11);
	s7 = new Song("XXXTENTACION", "SAD!");
	s8 = new Song("J. Cole", "KOD");
	s9 = new Song(s7);
	
	p1 = new PlayList("songs");
	p2 = new PlayList("more songs");
	p3 = new PlayList("short");
	p4 = new PlayList("empty");
	
	p1.addSong(s1);
	p1.addSong(s2);
	p1.addSong(s3);
	p1.addSong(s4);
	p1.addSong(s5);
	
	p2.addSong(s6);
	p2.addSong(s7);
	p2.addSong(s8);
	p2.addSong(s9);
	p2.addSong(s1);
	
	p3.addSong(s1);
	
	p2.addPlayList(p3);
	}
/** Test methods for Song.java **/

/** Should return true or false**/
	@Test
	public void testEquals() {
		assertTrue(s1.equals(s4));
		assertFalse(s1.equals(s2));
		assertTrue(s7.equals(s9));
	}

/** Should return the string you want it to print**/
	@Test
	public void testToString() {
		assertEquals(s1.toString(), "{Song: title = Runaway artist = Kanye West}");
		assertEquals(s7.toString(), "{Song: title = SAD! artist = XXXTENTACION}");
	}
	
/** Should return integer of difference **/
	@Test
	public void testCompareTo() {
		assertEquals(s1.compareTo(s2), 10);
		assertEquals(s3.compareTo(s4), -9);
	}

/** Should return 1 **/
	@Test
	public void testNumberOfSongs() {
		assertEquals(s1.numberOfSongs(), 1);
		assertTrue(s1.numberOfSongs() == 1);
	}
	
/** Should return total time in seconds **/
	@Test
	public void testGetPlayTimeSeconds() {
		assertEquals(s1.getPlayTimeSeconds(), 261);
		assertTrue(s3.getPlayTimeSeconds() == 159);
	}
	
/** Should return name of song**/
	@Test
	public void testGetName() {
		assertEquals(s1.getName(), "Runaway");
		assertEquals(s7.getName(), "SAD!");
	}
	
/** Test Methods for PlayList **/
	
/** Should return how you want the string to look **/
	@Test
	public void testToString2() {
		assertFalse(p3.toString() == "Playlist : short \n {Song: title = Runaway artist = Kanye West}");
		assertFalse(p3.toString() == "{Song: title = Runaway artist = Kanye West}");
	}
	
/** Should return boolean **/
	@Test
	public void testLoadSongs() {
		assertEquals(p1.loadSongs("Mine"), false);
		assertEquals(p3.loadSongs("Kanye West"), false);
	}
	
/** Should return boolean **/
	@Test
	public void testClear() {
		assertTrue(p1.clear());
		assertFalse(p4.clear());
	}
	
/** Should return boolean **/
	@Test
	public void testAddSong() {
		assertTrue(p1.addSong(s1));
		assertFalse(p4.addSong(s5) == false);
	}
	
/** Should return playable removed **/
	@Test
	public void testRemovePlayable() {
		assertEquals(p3.removePlayable(0), s1);
		assertEquals(p1.removePlayable(1), s2);
	}
	
/** Should return playable removed **/
	@Test
	public void testRemovePlayable2() {
		assertEquals(p3.removePlayable(s1), s1);
		assertFalse(p1.removePlayable(s4) == s3);
	}
	
/** Should return playable or null **/
	@Test
	public void testGetPlayable() {
		assertTrue(p1.getPlayable(-1) == null);
		assertEquals(p1.getPlayable(0), s1);
	}
	
/** Should return boolean **/
	@Test
	public void testAddPlayList() {
		assertTrue(p1.addPlayList(p2));
		assertFalse(p2.addPlayList(p3));
	}
	
/** SHould return integer of number of songs **/
	@Test
	public void testNumberOfSongs2() {
		assertTrue(p4.numberOfSongs() == 0);
		assertFalse(p2.numberOfSongs() == 5);
	}
	
/** Should return integer seconds of play list **/
	@Test
	public void TestGetPlayTimeSeconds2() {
		assertEquals(p4.getPlayTimeSeconds(), 0);
		assertEquals(p1.getPlayTimeSeconds(), 1084);
	}
}
