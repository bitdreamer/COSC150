// IntegerComparitor.java
// Koster and Sherr 2016 for COSC-150

package stingy;

import java.util.*;

public class PPComparator implements Comparator
{
	
	// returns positive number if a is smaller, negative if b is smaller, 0 if equal
	// Note: this will sort biggest first
	@Override
    public int  compare( Object  a, Object b )
    {
		int ret; // return value 
		
		PartishPart ap = (PartishPart) a; // We know they are Integers in this case
		PartishPart bp = (PartishPart) b; // so cast them as such.
		
		if      ( ap.getCount() <  bp.getCount() ) { ret =  1; }
	    else if ( ap.getCount() == bp.getCount() ) { ret =  0; }
	    else                 { ret = -1; }
		
		return ret;
    }
}
