import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MazeSolver {
	
	//0 = wall
	//1 = path
	//2 = destination
	
	public static void main(String[] args) throws FileNotFoundException {
		
		ArrayList<Maze> mazes = readMazes(); //Read from file
		ArrayList<Direction> directions = new ArrayList<Direction>();
		
		int i = 0;
		while(i < mazes.size()) {
			Direction dir = solveMaze(mazes.get(i));
			if(!dir.directions.isEmpty()) {
				System.out.println("Solution maze " + (i + 1));
				directions.add(dir);
				showPath(dir);
				System.out.println("You won!");
			} else {
				System.out.println("No path");
			}
			i++;
		}
	}
	
	private static ArrayList<Maze> readMazes() throws FileNotFoundException {
		ArrayList<Maze> mazes = new ArrayList<Maze>();
			
		Scanner in = new Scanner(new File("mazes.txt"));
		
		while(in.hasNext()) {
			Maze m = new Maze();
			
			int rows = Integer.parseInt(in.nextLine());
			m.maze = new int[rows][];
			
			for(int i = 0; i < rows; i++) {
				String line = in.nextLine();
				m.maze[i] = Arrays.stream(line.split(", ")).mapToInt(Integer::parseInt).toArray();			
			}
			
			m.start = new Position(Integer.parseInt(in.nextLine()), Integer.parseInt(in.nextLine()));
			
			in.nextLine(); //toss the extra space
			
			mazes.add(m);
		}	
		in.close();
		return mazes;
	}

	private static Direction solveMaze(Maze m) {
		
		Direction dir = new Direction();
		Position p = m.start;
		m.path.push(p);
		
		while(true) {
			
			int x = m.path.peek().x;
			int y = m.path.peek().y;
			
			m.maze[y][x] = 0;
			
			//down
			if(isValid(y + 1, x, m)) {
				if(m.maze[y + 1][x] == 2) {
					//Moved down
					dir.directions.add("Down");
					return dir;
				} else if(m.maze[y + 1][x] == 1) {
					//Moved down
					dir.directions.add("Down");
					m.path.push(new Position(y + 1, x));
					continue;
				}
			}
			
			//left
			if(isValid(y, x - 1, m)) {
				if(m.maze[y][x - 1] == 2) {
					//Moved left
					dir.directions.add("Left");
					return dir;
				} else if(m.maze[y][x - 1] == 1) {
					//Moved left
					dir.directions.add("Left");
					m.path.push(new Position(y, x - 1));
					continue;
				}
			}
					
			//up
			if(isValid(y - 1, x, m)) {
				if(m.maze[y - 1][x] == 2) {
					//Moved up
					dir.directions.add("Up");
					return dir;
				} else if(m.maze[y - 1][x] == 1) {
					//Moved up
					dir.directions.add("Up");
					m.path.push(new Position(y - 1, x));
					continue;
				}
			}
			
			//right
			if(isValid(y, x + 1, m)) {
				if(m.maze[y][x + 1] == 2) {
					//Moved right
					dir.directions.add("Right");
					return dir;
				} else if(m.maze[y][x + 1] == 1) {
					//Moved right
					dir.directions.add("Right");
					m.path.push(new Position(y, x + 1));
					continue;
				}
			}
			
			m.path.pop();
			//Moved back
			dir.directions.poll();
			
			if(m.path.size() <= 0) {
				return dir;
			}
		}
		
	}

	public static boolean isValid(int y, int x, Maze m) {
		if(y < 0 || y >= m.maze.length || x < 0 || x >= m.maze[y].length) {
			return false;
		}
		return true;
	}
	
	private static void showPath(Direction dir) {
		for(String direction: dir.directions) {
			System.out.println(direction);
		}
		
	}

}
