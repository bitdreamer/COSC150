package ssdd;
import java.util.HashMap;

public class StingySlot {
    HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
    
    public static void main(String args[]) {
    	StingySlot hello = new StingySlot(); 
    	int a[] = new int[5];
  		a[0] = 9; 
  		a[1] = 7; 
  		a[2] = 17; 
  		a[3] = 5; 
  		a[4] = 3; 
  		
  		hello.setSpin(a);
  		System.out.println(hello.payoff());
    }
  	//The following "spins" the slot five times. I use a hashmap for
  	//easy counts of numbers. The keys are the number and the value 
  	//is the frequency of the number
  	public void doSpin() {
  		for(int i = 0; i < 5; i++) {
  			int n = (int)(Math.random() * 60 + 1); 

  			if(hmap.containsKey(n)) {
  	  	  		int var = hmap.get(i) + 1; 
  	  	  		hmap.put(n, var); 
  			}
  			else {
  				hmap.put(n, 1); 
  			}
  		}
  	}
  	
  	//The user can set the slots into any array of ints. (Mostly used
  	//to test the functions on JUnit
  	public void setSpin(int[] m){
  		hmap.clear(); 
  		for(int i = 0; i < m.length; i++) {
  			if(hmap.containsKey(m[i])) {
  	  	  		int var = hmap.get(m[i]) + 1; 
  	  	  		hmap.put(m[i], var); 
  			}
  			else {
  				hmap.put(m[i], 1); 
  			}
  		}
  	}
  	
  	//The following calculates the payoff of the slots that were 
  	//randomly chosen for the user 
  	//These are all the possible scenarios: (Possibility of values)
  	//5 = (All 5 are the same numbers)
  	//4 1 (4 of the same number and one different)
	//3 2 (Full house)
	//3 1 1 (Trips and two different numbers)
	//2 2 1 (Two pairs of the same number)
	//2 1 1 1 (One pair of the same number)
	//1 1 1 1 1 (All different numbers)
  	
  	public double payoff() {
		double payload = 0; 
		int slotSize = hmap.size(); 
		//This means that all slots are in one number
		if(slotSize == 5){
			payload = 0; 
		}
		else {
			if(slotSize == 1) {
				payload = 1000000; 
			}
			else if (slotSize == 2 ) {
				if(hmap.containsValue(4)){
					payload = 10000; 
				}
				else {
					payload = 500; 
				}
			}
			else if(slotSize == 3) {
				if(hmap.containsValue(3)){
					payload = 10; 
				}
				else {
					payload = 4; 
				}
				
			}
			else if(slotSize == 4) {
				if(hmap.containsValue(2)){
					payload = 2; 
				}
			}
			else {
				payload = 0; 
			}
		}
		
		//If any of the keys equals 42 then you add the frequency of
		//the key by $.35 and add it to the payload 
		if(hmap.containsKey(42)){
			payload = payload + .35 * hmap.get(42); 
		}
		
		//Two conditions: 
		//1. If any of the keys is divisible by 17, then you multiple
		//the frequency of the key by $.17 and add it to the payload
		//2. If any of the keys equals is considered a perfect square
		//then you multiply the the frequency of the key by $.10 and
		//add it to the payload 
		for(Integer key: hmap.keySet()){
			if(key % 17 == 0) {
				payload = payload + hmap.get(key) * .17; 
			}
			
			double sqrt = Math.sqrt(key);
	  		int x = (int) sqrt;
	  		if(Math.pow(sqrt,2) == Math.pow(x,2)) {
				payload = payload + hmap.get(key) * .10; 
	  		}

        }
		
  		return payload;
  	}
}
