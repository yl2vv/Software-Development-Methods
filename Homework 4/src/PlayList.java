// Yubin Lim | yl2vv | Homework 4
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import org.junit.Before;

public class PlayList implements Playable, Comparator<Playable> {
/** fields **/
	private String name; /** name- contains the name of the playlist **/
	private ArrayList<Playable> playableList; /** ArrayList of Playable elements that make up the playlist **/

/** Getters and Setters for fields **/
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<Playable> getPlayableList() {
		return this.playableList;
	}
	public void setPlayableList(ArrayList<Playable> playableList) {
		this.playableList = playableList;
	}

/** toString() method that returns the name of the play list followed by its contents **/
	public String toString() {
		String playlistname = "Playlist : " + this.name; 
		for (Playable song : playableList) {
			playlistname += "\n" + song;
		}
		return playlistname;
	}

/** Constructors with all fields initialized regardless of the number of parameters **/
	public PlayList() {
		this.name = "Untitled";
		this.playableList = new ArrayList<Playable>();
	}
	
	public PlayList(String newName) {
		this.name = newName;
		this.playableList = new ArrayList<Playable>();
	}

/** *Loads songs from file*
 A total of 4 lines for each song,
 The fourth line (last line) is blank,
 First Line will be the song title,
 Second Line will be the artist,
 Third Line will be the song's duration in the form M:SS or MM:SS,
 Remove any leading or trailing blanks from any of the lines.
  **/
	public boolean loadSongs(String fileName) {
		File file = new File(fileName);
		Scanner input = null;
		try {
			input = new Scanner(file);
			while (input.hasNextLine()) {
				String title = input.nextLine().trim();
				String artist = input.nextLine().trim();
				String time = input.nextLine().trim();
				
				/** Take the substring of the time line to get the minutes, which is before the colon,
				 and seconds, which is after the colon, for the next step **/
				int colon = time.indexOf(':');
				int minutes = Integer.parseInt(time.substring(0,  colon));
				int seconds = Integer.parseInt(time.substring(colon +1));
				
				/** Calculate proper values of minutes and seconds-less-than-60 if
				 the integer value for seconds is >= 60, **/
				minutes += seconds / 60;
				int sec = seconds % 60;
				
				Song a = new Song(artist, title, minutes, sec);
				this.addSong(a);
				
				input.nextLine();
			}
			input.close();
			return true;
		}
		/** If fileName is not a file, then the method returns false**/
		catch (FileNotFoundException e) {
			return false;
		}
	}
	
/** Removes all playable elements in the play list **/
	public boolean clear() {
		if (playableList.size() > 0) {
			playableList.clear();
			return true;
		}
		return false;
	}

/** Adds Song s to the end of the play list **/
	public boolean addSong(Song s) {
		playableList.add(s);
		return true;
	}
	
/** Removes Playable element at index from the list and returns it **/
	public Playable removePlayable(int index) {
		Playable removed_item = playableList.get(index);
		playableList.remove(index);
		return removed_item;
	}
	
/** Removes every occurrence of Playable p from the list and returns p **/
	public Playable removePlayable(Playable p) {
		while (playableList.contains(p)) {
			playableList.remove(p);
		}
		return p;
	}
	
/** Returns the Playable element at the appropriate index **/
	public Playable getPlayable(int index) {
		if (index > playableList.size() - 1 || index < 0) {
			return null;
		}
		return playableList.get(index);
	}

/** adds the PlayList that is being passed to the end of the playableList and returns true
 unless the playableList already contains a play list with the same name,
 in this case, do not add the play list and return false. **/
public boolean addPlayList(PlayList pl) {
	if (!playableList.contains(pl)) {
		playableList.add((Playable) pl); 
		return true;
	}
	return false;
	}

/** Plays the play list by calling play() on each item in the play list in order**/
public void play() {
	for (int i = 0; i < playableList.size(); i++)
		playableList.get(i).play();
}

/** Sort the Playable items by the value returned by getName() in ascending order **/
public void sortByName() {
	Collections.sort(playableList, new PlayListSortByName());
}

/** Sorts by the Song or PlayList's total time in seconds, in ascending order (shortest first).
 Used a comparator object to achieve this.
 Object use method in the Playable interface to get the time for each object  **/
public void sortByTime() {
	Collections.sort(playableList, new PlayListSortByTime());
}

/** Methods needed to implement the Playable interface **/
	public int numberOfSongs() {
		int songs = 0;
		for (Playable song : playableList) {
			songs += song.numberOfSongs();
		}
		return songs;
	}
	
	public int getPlayTimeSeconds() {
		int seconds = 0;
		for (Playable song : playableList) {
			seconds += song.getPlayTimeSeconds();
		}
		return seconds;
	}
	@Override
	public int compare(Playable o1, Playable o2) {
		// TODO Auto-generated method stub
		return 0;
	}

}
