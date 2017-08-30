package ssdd;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

//The following test 10 cases: 
//1. All five numbers are the same
//2. Four numbers are the same and one is different
//3. A full house
//4. Just a triple and two different numbers
//5. Two pairs of the same number
//6. One pair of the same number
//7. No matches at all
//8. Tests whenever there is an occurrence of the key 42
//9. Tests whenever the keys are perfect squares
//10. Tests whenever the keys are divisible by 17

@RunWith(Suite.class)
@SuiteClasses({ AllDifferent.class, AllTheSame.class, DivisibleBy17.class, FourTheSame.class, FullHouse.class,
		Occuring42.class, OnePairOfTheSameNumber.class, OnlyTriples.class, PerfectSquares.class,
		TwoPairsOfTheSameNumber.class })
public class TestStingySlot {

}
