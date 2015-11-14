package zombie;

import java.awt.Color;
import java.util.Random;

public class ZombieModel {
	
	private final Color[][] matrix;
	private final int width;
	private final int height;
	private final int dotSize;
	private Human human;
	private Tree tree;
	private Rock rock;
	private Random ram = new Random();
	
	public ZombieModel(int widthArg, int heightArg, int dotSizeArg) {
		width = widthArg;
		height = heightArg;
		dotSize = dotSizeArg;
		matrix = new Color[width][height];
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				matrix[i][j] = Color.BLACK;
			}
		}
	}
	
	
	public int getWidth() { return width; }
	public int getHeight() { return height; }
	public int getDotSize() { return dotSize; }
	public Color getColor(int x, int y) { 
		if(x>=0 && y>=0 && x<=width && y<=height){return matrix[x][y]; }
		else{
			return null;
		}
	}


	public void setColor(int x, int y, Color color) 
	{
		if(x>=0 && y>=0 && x<=width && y<height){
		matrix[x][y] = color; 
		}
		}
	
	public void initialize() {
		// 1 river, 6 rocks, 40 trees
		// create a human
		for(int i=0;i<40; i++)
		{
		tree= new Tree (this);
		}
		for(int i=0; i<6; i++){
			rock = new Rock (this);
			}
		
		int x= ram.nextInt(width-5);
	
		int y= x+5;
		
		for(int i=x; i<y; i++)
		{
			
			for (int j = 0; j < height; j++) {
				this.setColor(i, j, Color.BLUE);
		}
		}
		
		setHuman(new Human (this));
		
		

	}

	
	public void update() {
		getHuman().update(this);
	}


	public Human getHuman() {
		return human;
	}


	public void setHuman(Human human) {
		this.human = human;
	}
}
