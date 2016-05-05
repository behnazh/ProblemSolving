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
