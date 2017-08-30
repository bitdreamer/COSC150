package yahtzee;

import java.util.*;

public class TotalSlot extends Slot
{
   LinkedList<Slot> addThese; // list of Slots that this is a total of
	
    // constructor, takes label, what it is called
	public TotalSlot(String name)
	{
		super(name);
		addThese = new LinkedList<Slot>();
		used = true;
	}
	
	// call this to tell it what to add up
	public void addToSumList( Slot s )
	{
		addThese.add(s);
	}
	
	@Override
	public int computeScore()
	{
		score = 0;
		Iterator<Slot> it = addThese.iterator();
		while ( it.hasNext() )
		{
			Slot s = it.next();
			score += s.getScore();
		}
	    theScoreField.setText(""+score);
        return score;
	}
}
