// Yubin Lim | yl2vv | Homework 4
public class Song implements Playable, Comparable<Song>{
/** fields **/
	private String artist; /** artist- the artist performing the song **/
	private String title; /** title- title of the song **/
	private int minutes; /** minutes- number of minutes of song **/
	private int seconds;/** seconds- number of seconds of the song **/

/** Getters and Setters for all fields **/
	public String getArtist() {
		return this.artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public String getTitle() {
		return this.title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getMinutes() {
		return this.minutes;
	}
	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}
	public int getSeconds() {
		return this.seconds;
	}
	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}

/** Constructors with all fields initialized regardless of the number of parameters **/
	public Song(String artist, String title) {
		this.artist = artist;
		this.title = title;
		this.minutes = minutes;
		this.seconds = seconds;
	}

	public Song(String artist, String title, int minutes, int seconds) {
		this.artist = artist;
		this.title = title;
		this.minutes = minutes;
		this.seconds = seconds;
	}

	public Song(Song s) {
		this.artist = s.artist;
		this.title = s.title;
		this.minutes = s.minutes;
		this.seconds = s.seconds;
	}

/**Equals method- two songs are equal if all four fields are equal (return true) if fields are not equal return false **/
	public boolean equals(Object o) { 
		if (o == null) {
			return false; 
		}
		if( o instanceof Song) {
			Song song2 = (Song) o; 
			if ((this.minutes == song2.getMinutes())
					&& (this.seconds == song2.getSeconds())
					&& (this.artist.equals(song2.getArtist()))
					&& (this.title.equals(song2.getTitle()))) {
				return true;
			}
		}
		return false;
	}
	
/** toString method to make sure the Song prints how I want it to print **/
	public String toString() { // Use this code for toString EXACTLY
		return "{Song: title = " + title + " artist = " + artist + "}";
	}
	
/** toString method to make sure Playing Song prints how I want it to print **/
	public void play() { // Use this code for toString EXACTLY
		 System.out.printf("Playing Song: artist = %-20s title = %s\n", artist, title);
	}
	
/** Puts the songs in order by artist in ascending order.
 If artists are the same, then by title in ascending order.
 If bother artist and title are the same, then any order is acceptable **/	
	public int compareTo(Song o) {
		if (this.artist.compareTo(o.artist) == 0) {
			return this.title.compareTo(o.title);
		}
			return this.artist.compareTo(o.artist);
	}

/** Methods needed to implement the Playable interface **/
	public int numberOfSongs() {
		return 1;
	}
	
	public int getPlayTimeSeconds() {
		int minutes_in_seconds = this.minutes * 60;
		int total_seconds = minutes_in_seconds + this.seconds;
		return total_seconds;
	}
	
	public String getName() {
		return this.title;
	}
	public static void main(String[] arg) {
		Song s1 = new Song("Kanye West", "Runaway", 4, 21);
		System.out.println(s1.toString());
	}
}


