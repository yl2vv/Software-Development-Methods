// Yubin Lim | yl2vv | Homework 4
import java.util.Comparator;

public class PlayListSortByTime implements Comparator<Playable> {

	@Override
	public int compare(Playable o1, Playable o2) {
		// TODO Auto-generated method stub
		return o1.getPlayTimeSeconds() - o2.getPlayTimeSeconds();
	}

}
