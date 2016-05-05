/*
This problem was used for: Single Round Match 593 Round 1 - Division II, Level Two, TopCoder

Wolf Sothe is playing the game Delaymaster. In this game, he can create new words according to the following rules:
For each positive integer n, the string which consists of n copies of 'w', then n copies of 'o', then n copies of 'l', and finally n copies of 'f' is a valid word.
The concatenation of two valid words is a valid word.
Only the words that can be obtained by rules 1 and 2 are valid. There are no other valid words.
Thus, for example:
By rule 1, "wolf", "wwoollff", and "wwwooolllfff" are valid words.
Then, by rule 2, "wolfwwoollff" is a valid word.
By applying rule 2 twice, "wolfwwoollffwolf" is a valid word.
The string "wfol" is not a valid word (order matters).
The string "wwolfolf" is not a valid word (we can only concatenate, not insert one word into another).
The string "wwwoolllfff" is not a valid word (only two 'o's instead of three).
You are given a String str. Return "VALID" if str is a valid word and "INVALID" otherwise. Note that the return value is case-sensitive: you must return the strings "VALID" and "INVALID" in all-uppercase.
*/

public class WolfDelaymaster{
	String wolf;

	public void init(String pattern){
		wolf = pattern;
	}
	public String check(String word){
		int[] count = new int[wolf.length()];
		return checkRecursive(word, count);
	}
	
	public String checkRecursive(String word, int[] count){
		int position = 0;
		for(int i=0; i< wolf.length(); i++){
			//check if counts are same
			for(int test = 1; test < i; test++){
				if(count[test]  != count[test -1])
					return "INVALID";	
			}

			char wolf_char = wolf.charAt(i);
			while(position < word.length()){
				char word_char = word.charAt(position);
				if(word_char == wolf_char){
					count[i] ++;
				}
				else if(i == wolf.length() - 1){
					count = new int[wolf.length()];
					return checkRecursive(word.substring(position), count);
				}
				else{
					break;
				}
				position ++;
			}
		}
		return "VALID";
	}
	
}
