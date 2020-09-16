import java.util.ArrayList;
import java.util.LinkedList;

public class MazeSolver {
	
	public static void main(String[] args) {
		
		ArrayList<Maze> mazes = new ArrayList<Maze>();
				
		//0 = wall
		//1 = path
		//2 = destination
		
		//Maze 1
		Maze m1 = new Maze();
		
		int[][] m1_maze = {
			{1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0},
			{0, 0, 1, 1, 1, 1, 0, 0, 0, 1, 0},
			{0, 0, 0, 1, 0, 1, 1, 0, 1, 1, 1},
			{1, 1, 1, 2, 0, 1, 0, 1, 0, 1, 0},
			{0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0},
			{0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1}			
		};
		m1.maze = m1_maze;
		m1.start = new Position(4,8);
		m1.path = new LinkedList<Position>();
		
		//Maze 2
		Maze m2 = new Maze();
		
		int[][] m2_maze = {
			{1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0},
			{0, 0, 1, 1, 1, 1, 0, 0, 0, 1, 0},
			{0, 0, 0, 1, 0, 1, 1, 0, 1, 1, 1},
			{1, 1, 1, 2, 0, 1, 0, 1, 0, 1, 0},
			{0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0},
			{0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1}			
		};
		m2.maze = m2_maze;
		m2.start = new Position(4,8);
		m2.path = new LinkedList<Position>();
		
		mazes.add(m1);
		mazes.add(m2);
		
		int i = 0;
		while(i < mazes.size()) {
			if(solveMaze(mazes.get(i))) {
				System.out.println("You won!");
			} else {
				System.out.println("No path");
			}
			i++;
		}
	}
	
	private static boolean solveMaze(Maze m) {
		
		Position p = m.start;
		m.path.push(p);
		
		while(true) {
			
			int x = m.path.peek().x;
			int y = m.path.peek().y;
			
			m.maze[y][x] = 0;
			
			//down
			if(isValid(y + 1, x, m)) {
				if(m.maze[y + 1][x] == 2) {
					System.out.println("Moved down");
					return true;
				} else if(m.maze[y + 1][x] == 1) {
					System.out.println("Moved down");
					m.path.push(new Position(y + 1, x));
					continue;
				}
			}
			
			//left
			if(isValid(y, x - 1, m)) {
				if(m.maze[y][x - 1] == 2) {
					System.out.println("Moved left");
					return true;
				} else if(m.maze[y][x - 1] == 1) {
					System.out.println("Moved left");
					m.path.push(new Position(y, x - 1));
					continue;
				}
			}
					
			//up
			if(isValid(y - 1, x, m)) {
				if(m.maze[y - 1][x] == 2) {
					System.out.println("Moved up");
					return true;
				} else if(m.maze[y - 1][x] == 1) {
					System.out.println("Moved up");
					m.path.push(new Position(y - 1, x));
					continue;
				}
			}
			
			//right
			if(isValid(y, x + 1, m)) {
				if(m.maze[y][x + 1] == 2) {
					System.out.println("Moved right");
					return true;
				} else if(m.maze[y][x + 1] == 1) {
					System.out.println("Moved right");
					m.path.push(new Position(y, x + 1));
					continue;
				}
			}
			
			
			m.path.pop();
			System.out.println("Moved back");
			if(m.path.size() <= 0) {
				return false;
			}
		}
		
	}

	public static boolean isValid(int y, int x, Maze m) {
		if(y < 0 || y >= m.maze.length || x < 0 || x >= m.maze[y].length) {
			return false;
		}
		return true;
	}

}
