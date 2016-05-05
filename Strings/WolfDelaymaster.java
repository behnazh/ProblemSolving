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
