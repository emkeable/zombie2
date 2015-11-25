package zombie;

import java.awt.Color;
import java.util.Random;
import java.util.*;

public class ZombieModel {
	
	private final Color[][] matrix;
	private final int width;
	private final int height;
	private final int dotSize;
	public int getAx() {
		return ax;
	}



	public void setAx(int ax) {
		this.ax = ax;
	}



	public int getAy() {
		return ay;
	}



	public void setAy(int ay) {
		this.ay = ay;
	}



	private int ax, ay;
	
	public int getCount() {
		return count;
	}



	public void setCount(int count) {
		this.count = count;
	}



	private int count;
	public int getRx() {
		return rx;
	}



	public void setRx(int rx) {
		this.rx = rx;
	}



	public void setRy(int ry) {
		this.ry = ry;
	}



	public int getRy() {
		return ry;
	}
	


	private  int rx, ry;
	private Human human;


	List<Human> humans = new ArrayList<Human>();
	List<Zombie> zombies = new ArrayList<Zombie>();

	public int getHumanNum() {
		return humanNum;
	}



	public void setHumanNum(int humanNum) {
		this.humanNum = humanNum;
	}


	private int humanNum;

	
	public int getZombieNum() {
		return zombieNum;
	}



	public void setZombieNum(int zombieNum) {
		this.zombieNum = zombieNum;
	}


	private int zombieNum;
	public AlphaZombie getaZombie() {
		return aZombie;
	}



	public void setaZombie(AlphaZombie aZombie) {
		this.aZombie = aZombie;
	}


	private AlphaZombie aZombie;
	public Zombie getZombie() {
		
		return zombie;
		
		
		
	}
	


	public void setZombie(Zombie zombie) {
		this.zombie = zombie;
	}
	public void addZombie(ZombieModel modelArg, int x, int y)
	{
		Zombie a= new Zombie(this, false, x, y);
		zombies.add(a);
	}

	private Zombie zombie;
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
		if(x>0 && y>0 && x<width && y<height){return matrix[x][y]; }
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
		
		this.setRx(ram.nextInt(width-5));
	
		this.setRy(this.getRx()+5);
		
		for(int i=this.getRx(); i<this.getRy(); i++)
		{
			
			for (int j = 0; j < height; j++) {
				this.setColor(i, j, Color.BLUE);
		}
		}
		this.setHumanNum(30);

		for(int i=0; i<this.getHumanNum(); i++)
		{
			Human a= new Human(this, i);
			humans.add(a);
		}
		//setHuman(new Human (this));

		setaZombie(new AlphaZombie(this, true, 0, 0));
		this.setZombieNum(1);
		
		

	}

	
	public void update() {
		for(int i=0; i<this.humans.size(); i++)
		{
			humans.get(i).update(this);
		}
		for(int i=0; i<this.zombies.size(); i++)
		{
			zombies.get(i).update(this);
		}
		getaZombie().update(this);
		if(this.getCount()==0)
		{
		int a=ram.nextInt(5);
		if(a==1)
		{
			this.setAx(ram.nextInt(this.getHeight()));
			this.setAy(ram.nextInt(this.getWidth()));
			this.bomb(ax, ay);
		}
		}
		if(this.getCount()>1)
		{
			this.setCount(this.getCount()-1);
		}
		else if(this.getCount()==1)
		{
			for(int i=this.getAx(); i<this.getAx()+5; i++)
			{
			for (int j = this.getAy(); j < this.getAy()+5; j++) {
				if(this.getColor(i, j)==Color.ORANGE){
				this.setColor(i, j, Color.BLACK);
				}
		}
		}
			this.setCount(0);
		}
	}

	public void bomb(int ax, int ay)
	{
		if(this.getColor(ax, ay)==Color.BLACK){
		for(int i=this.getAx(); i<this.getAx()+5; i++)
			{
				
				for (int j = this.getAy(); j < this.getAy()+5; j++) {
					if(this.getColor(i, j)==Color.BLACK){
					this.setColor(i, j, Color.ORANGE);
					}
			}
				int r=ram.nextInt(15)+5;
				this.setCount(r);
			}
		}
	}
	public Human getHuman() {
		return human;
	}


	public void setHuman(Human human) {
		this.human = human;
	}
}
