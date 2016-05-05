/*
This problem was used for: Single Round Match 519 Round 1 - Division II, Level Two, TopCoder
    	
You are a frog. You live on an infinite lattice of grid points. For each pair of integers x, y there is a grid point with coordinates (x,y). At this moment, you sit on the grid point (xMe,yMe). You want to get home: to the grid point (xHome,yHome).

There are two ways in which you can travel. Your first option is jumping: if you are at (x,y), you can jump to one of the four neighboring grid points: (x+1,y), (x-1,y), (x,y+1), or (x,y-1). Each jump takes one second.

Your second option is using a teleport. There are three teleports in the entire world. Each of them connects two different grid points. If you are at one of the endpoints, you may activate the teleport and travel to its other endpoint. Traveling by teleport takes 10 seconds.

You are given ints xMe, yMe, xHome, yHome, and a String[] teleports that describes the three teleports. Each element of teleports will be a String containing four integers x1, y1, x2, and y2, separated by single spaces. These integers describe a teleport with endpoints at (x1,y1) and (x2,y2).

Your method must return the shortest time in which you can reach your home.
*/

public class ThreeTeleports{
	public int shortestDistance(int xMe, int yMe, int xHome, int yHome, String[] teleports){
		int normal_time = Math.abs(yHome - yMe);
		normal_time += Math.abs(xHome - xMe);
		int teleport_time = findShortestTeleport(xMe, yMe, xHome, yHome, teleports);
		if (normal_time < teleport_time)
			return normal_time;
		return teleport_time;
	}

	private int findShortestTeleport(int xMe, int yMe, int xHome, int yHome, String[] teleports){
		int[][] tele_cord = new int[3][4];
		
		for(int i = 0; i < 3; i++){
			String[] token = teleports[i].split(" ");
			tele_cord[i][0] = Integer.parseInt(token[0]);
			tele_cord[i][1] = Integer.parseInt(token[1]);
			tele_cord[i][2] = Integer.parseInt(token[2]);
			tele_cord[i][3] = Integer.parseInt(token[3]);

			//swap the teleports if they are reversed
			if(distance(xMe, yMe, tele_cord[i][2], tele_cord[i][3]) < distance(xMe, yMe, tele_cord[i][0], tele_cord[i][1])){
				int temp = tele_cord[i][2];
				tele_cord[i][2] = tele_cord[i][0];
				tele_cord[i][0] = temp;
				temp = tele_cord[i][3];
				tele_cord[i][3] = tele_cord[i][1];
				tele_cord[i][1] = temp;
			}			
		}
		
		tele_cord = sort(tele_cord, xMe, yMe);
	
		int min_time = (int)Math.pow(2, 31);
		for(int i = 1; i < 8; i++){
			int current_time = findTimeSubSet(xMe, yMe, xHome, yHome, tele_cord, i);
			if(current_time < min_time)
				min_time = current_time;
		}

		return min_time;
	}

	private int findTimeSubSet(int xMe, int yMe, int xHome, int yHome, int[][] tele_cord, int subset){
		int current_time = 0;
		int prevx1 = xMe;
		int prevy1 = yMe;
		int prevx2 = xMe;
		int prevy2 = yMe;
			
		for(int i = 0; i < 3; i++){
			
			if((subset & ((int)Math.pow(2,i))) > 0){		 
				int case1 = distance(tele_cord[i][0], tele_cord[i][1], prevx1, prevy1);
				int min_dist = case1;
				int case2 = distance(tele_cord[i][2], tele_cord[i][3], prevx1, prevy1);
				if(min_dist > case2)
					min_dist = case2;
				int case3 = distance(tele_cord[i][0], tele_cord[i][1], prevx2, prevy2);
				if(min_dist > case3)
					min_dist = case3;
				int case4 = distance(tele_cord[i][2], tele_cord[i][3], prevx2, prevy2);
				if(min_dist > case4)
					min_dist = case4;
				
				current_time += min_dist;
				current_time += 10;

				prevx1= tele_cord[i][0];
				prevy1= tele_cord[i][1];
				prevx2= tele_cord[i][2];
				prevy2= tele_cord[i][3];
			}
		}

		int case1 = distance(prevx1, prevy1, xHome, yHome);
		int min_dist = case1;
		int case2 = distance(prevx2, prevy2, xHome, yHome);
		if(min_dist > case2)
			min_dist = case2;

		current_time += min_dist;
		if(current_time < 0)
			return (int)Math.pow(2, 31);
		return current_time;
	}

	public int[][] sort(int[][] array, int xMe, int yMe){
		
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 2 - i; j++){
				if(distance(array[j][0], array[j][1], xMe, yMe) > distance(array[j+1][0], array[j+1][1], xMe, yMe)){
					int temp = array[j+1][0];
					array[j+1][0] = array[j][0];
					array[j][0] = temp;
					temp = array[j+1][1];
					array[j+1][1] = array[j][1];
					array[j][1] = temp;
					temp = array[j+1][2];
					array[j+1][2] = array[j][2];
					array[j][2] = temp;
					temp = array[j+1][3];
					array[j+1][3] = array[j][3];
					array[j][3] = temp;
				}
			}
		}
		return array;
	}	

	private int distance(int sx, int sy, int dx, int dy){
		return Math.abs(sx - dx) + Math.abs(sy - dy);
	}

	
}
