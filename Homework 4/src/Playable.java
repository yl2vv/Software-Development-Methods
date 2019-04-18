// Yubin Lim | yl2vv | Homework 4
/** Both the Song and PlayList classes will implement this interface **/
public interface Playable {

	public void play();
		
	public String getName(); /** returns the name (for PlayList) or title (for Song) **/
		
	public int getPlayTimeSeconds(); /** For Song: returns the number of seconds in the song. For PlayList: returns the number of seconds in the entire PlayList **/ 
		
	public int numberOfSongs(); /** For Song: returns 1.  For PlayList returns the number of songs in the playlist and all playlists contained within **/
		
}
