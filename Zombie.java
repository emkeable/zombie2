package zombie;

import java.awt.Color;
import java.util.Random;

public class Zombie  {
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	private int x;

	private Color color;
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public Boolean getAlphaZombie() {
		return alphaZombie;
	}
	public void setAlphaZombie(Boolean alphaZombie) {
		this.alphaZombie = alphaZombie;
	}
	private Boolean alphaZombie;
	private int y;
	public Boolean getFollow() {
		return follow;
	}
	public void setFollow(Boolean follow) {
		this.follow = follow;
	}
	private Boolean follow;
	private Random ram = new Random();
	private Boolean obstacle;
	public Boolean getObstacle() {
		return obstacle;
	}
	public void setObstacle(Boolean obstacle) {
		this.obstacle = obstacle;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	
	private String direction;
	public void follow(ZombieModel modelArg)
	{


		if(this.getDirection()=="North")
		{

			for(int i=x; i<=x+10; i++)
			{
				if(modelArg.getColor(i, y)==Color.WHITE || modelArg.getColor(i,y)==Color.CYAN)
				{
					this.setFollow(true);
					
				}
				else
				{
					this.setFollow(false);
				}
				
			}
		}
		else if(this.getDirection()=="South")
		{
			for(int i=x; i>=x-10; i--)
			{
				if(modelArg.getColor(i, y)==Color.WHITE || modelArg.getColor(i,y)==Color.CYAN)
				{
					this.setFollow(true);
					

				}
				else
				{
					this.setFollow(false);
				}
				
				
			}
		
		}
		else if(this.getDirection()=="East")
		{
			for(int i=y; i<=y+10; i++)
			{
				if(modelArg.getColor(x, i)==Color.WHITE|| modelArg.getColor(x,i)==Color.CYAN)
				{
					this.setFollow(true);
				}
				else
				{
					this.setFollow(false);
				}
			
				
			}
		}
		else if(this.getDirection()=="West")
		{
			for(int i=y; i>=y-10; i--)
			{
				if(modelArg.getColor(x, i)==Color.WHITE || modelArg.getColor(x,i)==Color.CYAN)
				{
					this.setFollow(true);
				}
				else
				{
					this.setFollow(false);
				}
			}
		}
	}

	public Zombie(ZombieModel modelArg, Boolean alphaZombie, int a, int b){
		this.setAlphaZombie(alphaZombie);
		if(alphaZombie==true){
		x=(ram.nextInt(modelArg.getWidth()));
		y=(ram.nextInt(modelArg.getHeight()));
		}
		else if(alphaZombie==false){
			x=a;
			y=b;
		}
		
		if(modelArg.getColor(x, y) != Color.BLACK)
		{
			x=ram.nextInt(modelArg.getWidth());
			y=ram.nextInt(modelArg.getHeight());
		}
		else if (modelArg.getColor(x, y)==Color.BLACK)
		{
		if(alphaZombie==true)
		{
		this.setColor(Color.MAGENTA);
		}
		else if(alphaZombie==false)
		{
		this.setColor(Color.PINK);
		}
		modelArg.setColor(x, y, this.getColor());
		}
	this.setDirection("North");
	this.setObstacle(false);
	this.update(modelArg);
	this.setAlphaZombie(alphaZombie);
	}
	public void changeDirection(String direction){
		int x=ram.nextInt(100);
		
		if(this.getDirection()=="North")
		{
			if(this.getObstacle()==true){
				this.setDirection("South");
				this.setObstacle(false);
				return;
			}
			if(x<50)
			{
				this.setDirection("North");
			}
			else if(x>=50 && x<70)
			{
				this.setDirection("East");
			}
			else if(x>=70 && x<90){
				this.setDirection("West");
			}
			else if(x>=90)
			{
				this.setDirection("South");
			}
		}
		else if(this.getDirection()=="South")
		{
			if(this.getObstacle()==true){
				this.setDirection("North");
				this.setObstacle(false);
				return;
			}
			if(x<50)
			{
				this.setDirection("South");
			}
			else if(x>=50 && x<70)
			{
				this.setDirection("East");
			}
			else if(x>=70 && x<90){
				this.setDirection("West");
			}
			else if(x>=90)
			{
				this.setDirection("North");
			}
		}
		else if(this.getDirection()=="East")
		{
			if(this.getObstacle()==true){
				this.setDirection("West");
				this.setObstacle(false);
				return;
			}
			if(x<50)
			{
				this.setDirection("East");
			}
			else if(x>=50 && x<70)
			{
				this.setDirection("North");
			}
			else if(x>=70 && x<90){
				this.setDirection("South");
			}
			else if(x>=90)
			{
				this.setDirection("West");
			}
		}
		if(this.getDirection()=="West")
		{
			if(this.getObstacle()==true){
				this.setDirection("East");
				this.setObstacle(false);
				return;
			}
			if(x<50)
			{
				this.setDirection("West");
			}
			else if(x>=50 && x<70)
			{
				this.setDirection("North");
			}
			else if(x>=70 && x<90){
				this.setDirection("South");
			}
			else if(x>=90)
			{
				this.setDirection("East");
			}
		}
	}
	public void update(ZombieModel modelArg) {
		this.follow(modelArg);
		for(int i=modelArg.getRx(); i<modelArg.getRy(); i++)
		{
			
			for (int j = 0; j < modelArg.getHeight(); j++) {
				modelArg.setColor(i, j, Color.BLUE);
		}
		}
		if(this.getFollow()==true)
		{
			this.setColor(Color.RED);
		}
		else
		{
			this.setColor(Color.PINK);
		}
		if(this.getAlphaZombie()==false && this.getFollow()==false)
		{
			this.changeDirection(this.getDirection());
		}
		
		if(this.getDirection()=="North")
		{
			int y2=y-1;
			if(modelArg.getColor(x, y2)==Color.ORANGE)
			{
				this.setColor(Color.BLACK);
			}
			if((y2>=modelArg.getHeight()))
			{
				this.setObstacle(true);
				return;
			}
			else if(y2<0) 
			{
				this.setObstacle(true);
				return;
			}
			else if (modelArg.getColor(x, y2) != Color.BLACK && modelArg.getColor(x, y2) != Color.BLUE)
			{
				this.setObstacle(true);
				return;
			}
			else{
			if(modelArg.getColor(x, y)==Color.BLUE)
			{
				modelArg.setColor(x, y, Color.BLUE);
			}
			else{
			modelArg.setColor(x, y, Color.BLACK);
			}
			modelArg.setColor(x, y2, this.getColor());
			}
			y--;
		}
		else if(this.getDirection() == "South")
		{
			
				int y2=y+1;
				if(modelArg.getColor(x, y2)==Color.ORANGE)
				{
					this.setColor(Color.BLACK);
				}
				if((y2>=modelArg.getHeight()))
				{
					this.setObstacle(true);
					return;
				}
				else if(y2<0) 
				{
					this.setObstacle(true);
					return;
				}
				else if (modelArg.getColor(x, y2) != Color.BLACK && modelArg.getColor(x, y2) != Color.BLUE)
				{
					
					this.setObstacle(true);
					return;
				}
				else{
					if(modelArg.getColor(x, y)==Color.BLUE)
					{
						modelArg.setColor(x, y, Color.BLUE);
					}
					else{
					modelArg.setColor(x, y, Color.BLACK);
					}	
				
				modelArg.setColor(x, y2, this.getColor());
				}
				y++;
			}
		else if(this.getDirection() == "East")
		{
			
				int x2=x+1;
				if(modelArg.getColor(x2, y)==Color.ORANGE)
				{
					this.setColor(Color.BLACK);
				}
				if((x2>=modelArg.getWidth()))
				{
					this.setObstacle(true);
					return;
				}
				else if(x2<0) 
				{
					this.setObstacle(true);
					return;
				}
				else if (modelArg.getColor(x2, y) != Color.BLACK && modelArg.getColor(x2, y) != Color.BLUE)
				{
					this.setObstacle(true);
					return;
				}
				else{
					if(modelArg.getColor(x, y)==Color.BLUE)
					{
						modelArg.setColor(x, y, Color.BLUE);
					}
					else{
					modelArg.setColor(x, y, Color.BLACK);
					}	
				
				modelArg.setColor(x2, y, this.getColor());
				}
				x++;
			}
		else if(this.getDirection() == "West")
		{
			
				int x2=x-1;
				if(modelArg.getColor(x2, y)==Color.ORANGE)
				{
					this.setColor(Color.BLACK);
				}
				if((x2>=modelArg.getWidth()))
				{
					this.setObstacle(true);
					return;
				}
				else if(x2<0) 
				{
					this.setObstacle(true);
					return;
				}
				else if (modelArg.getColor(x2, y) != Color.BLACK  && modelArg.getColor(x2, y) != Color.BLUE)
				{
					this.setObstacle(true);
					return;
				}
				else{
					if(modelArg.getColor(x, y)==Color.BLUE)
					{
						modelArg.setColor(x, y, Color.BLUE);
					}
					else{
					modelArg.setColor(x, y, Color.BLACK);
					}
				modelArg.setColor(x2, y, this.getColor());
				}
				x--;
			}
		
		}
	}
