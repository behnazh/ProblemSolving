/*
Imagine that you are given a rectangular NxM grid with cells. There is a robot in a starting cell. The robot can pass through some of the cells while others are occupied and it cannot go through them. There is a cell where it must reach. Given the whole grid, the start and end cells, write a program, which determines if the robot can reach its goal.

What about cases where N, M < 10,000. What about 10,000,000?
*/
import java.io.*;
import java.util.*;

public class Robot{
	static int[] map;
	static int columns,rows;

	public static void main(String[] args){
		init(10000,10000);
	
		System.out.println(reachDestination(0,0,9999,9999));

		//test
		/*
		for(int j = 0; j < rows; j++ ){
			for(int i = 0; i < columns; i++){
				System.out.print(map[i+columns*j] + ",");
			}
			System.out.println();
		}
*/		
	}

	public static void init(int n, int m){
		columns = n;
		rows = m;
		map = new int[n*m];
		Random randomno = new Random();
		for(int j = 0; j < m; j++){
			for(int i = 0; i < n; i++){
				//map[i+n*j] = randomno.nextInt(2);
				if(i == 0 || j == 0 || i == n-1 || j == m-1 )
					map[i+n*j] = 0;
				else
					map[i+n*j] = 1;
			}
		}
		//map[0] = map[m*n-1] = 0;
	}

	public static void initFromFile(int n, int m){
		columns = n;
		rows = m;
		map = new int[n*m];
		try{
			BufferedReader input = new BufferedReader(new FileReader("map.txt"));
			String line;
			int row = 0;
			while((line = input.readLine()) != null){
				String[] cells = line.split(",");
				int col = 0;
				for(String c: cells){
					map[col+row*n] = Integer.valueOf(c);
					col ++;
				}		
				row ++;
			}
		}catch(IOException e){
		}
	}
	public static boolean reachDestination(int x, int y, int dx, int dy){
		Stack<Integer> worklist = new Stack<Integer>();
		if(x == dx && y == dy){
			return true;
		}

		int position = x+y*columns;
		if(map[position] != 0)
			return false;
		worklist.push(position);
		
		while(!worklist.isEmpty()){
			
			position = worklist.pop();

			if(position == dx + columns*dy){
				return true;
			}

			// node is visited
			if(map[position] != 0)
				return false;
			map[position] = -1;
	
			
			
			
			if(position-columns > -1 && map[position-columns] == 0){
				worklist.push(position-columns);
			}
			if(position-1 > -1 && map[position-1] == 0){
				worklist.push(position-1);
			}
			if(position+columns < columns*rows && map[position+columns] == 0){
				worklist.push(position+columns);
			}
			if(position+1 < columns*rows && map[position+1] == 0){
				worklist.push(position+1);
			}
		}	
		
		return false;	
	}
}
