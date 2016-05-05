/*

This problem was used for: Single Round Match 588 Round 1 - Division II, Level Two, TopCoder

Gumi loves singing. She knows N songs. The songs are numbered 0 through N-1. She now has some time and she would love to sing as many different songs as possible. 

You are given a int[] duration. For each i, duration[i] is the duration of song i in Gumi's time units. 

Gumi finds it difficult to sing songs with quite different tones consecutively. You are given a int[] tone with the following meaning: If Gumi wants to sing song y immediately after song x, she will need to spend |tone[x]-tone[y]| units of time resting between the two songs. (Here, || denotes absolute value.) 

You are also given an int T. Gumi has T units of time for singing. She can start singing any song she knows immediately at the beginning of this time interval. Compute the maximal number of different songs she can sing completely within the given time.
*/


public class GUMIAndSongsDiv2{
	public int maxSongs(int[] duration, int[] tone, int T){
		int max = 0;
		int N = duration.length;
		int all_cases = (int)Math.pow(2,N);
		for(int i = 0; i < all_cases; i++){
			int subset_max = maxSongSubset(duration, tone, T, i);
			if(subset_max > max)
				max = subset_max;
		}
		return max;
	}

	public int maxSongSubset(int[] duration, int[] tone, int T, int subset){
		if(subset == 0)
			return 0;
		int subset_duration = 0;
		int min_tone = (int)Math.pow(2,31) - 1;
		int max_tone = 0;
		int N = duration.length;
		int count = 0;
		for(int i = 0; i < N; i++){
			int bit_1 = (int)Math.pow(2,i);
			if((subset & bit_1) > 0){
				subset_duration += duration[i];
				if(min_tone > tone[i])
					min_tone = tone[i];
				if(max_tone < tone[i])
					max_tone = tone[i];
				count = count + 1;
			} 
		}
		if((subset_duration + max_tone - min_tone) <= T)
			return count;
		return 0;
			
	}
}
