package zombie;
import java.awt.Color;
import java.util.*;

public class Human {
	
	private int run;
	private boolean zomSight;
	private int x;
	private int y;
	private Random ram = new Random();
	private Boolean obstacle;
	private boolean dead;
	private String direction;  
	public boolean isFreeze() {
		return freeze;
	}
	public void setFreeze(boolean freeze) {
		this.freeze = freeze;
	}
	private boolean freeze;
	private int rest;
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	private Color color;
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	private int num;
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
	public int getRun() {
		return run;
	}
	public void setRun(int run) {
		this.run = run;
	}
	public boolean getZomSight() {
		return zomSight;
	}
	public void setZomSight(boolean zomSight) {
		this.zomSight = zomSight;
	}
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
	public int getRest() {
		return rest;
	}
	public void setRest(int rest) {
		this.rest = rest;
	}
	
	public void zSight(ZombieModel modelArg)
	{


		if(this.getDirection()=="North")
		{

			for(int i=x; i<=x+10; i++)
			{
				if(modelArg.getColor(i, y)==Color.MAGENTA || modelArg.getColor(i,y)==Color.PINK)
				{
					this.setZomSight(true);
					this.setDirection("South");
					this.setRun(4);
				}
				
			}
		}
		else if(this.getDirection()=="South")
		{
			for(int i=x; i>=x-10; i--)
			{
				if(modelArg.getColor(i, y)==Color.MAGENTA || modelArg.getColor(i,y)==Color.PINK)
				{
					this.setZomSight(true);
					this.setDirection("North");
					this.setRun(4);
					

				}
				
				
			}
		
		}
		else if(this.getDirection()=="East")
		{
			for(int i=y; i<=y+10; i++)
			{
				if(modelArg.getColor(x, i)==Color.MAGENTA|| modelArg.getColor(x,i)==Color.PINK)
				{
					this.setZomSight(true);
					this.setDirection("West");
					this.setRun(4);
					


				}
			
				
			}
		}
		else if(this.getDirection()=="West")
		{
			for(int i=y; i>=y-10; i--)
			{
				if(modelArg.getColor(x, i)==Color.MAGENTA || modelArg.getColor(x,i)==Color.PINK)
				{
					this.setZomSight(true);
					this.setDirection("East");
					this.setRun(4);
					


				}
				
			
			}
		}
		

	}
	
	
	
	public void humanKill(ZombieModel modelArg, int a, int b, int i ){
		dead=true;
		this.setColor(Color.BLACK);
		modelArg.setColor(a, b, Color.BLACK);
		modelArg.addZombie(modelArg, a, b);
		//modelArg.setZombie(new Zombie(modelArg, false, a, b));
		int zomNum=modelArg.getZombieNum();
		zomNum++;
		modelArg.setZombieNum(zomNum);
	}
	public void run(ZombieModel modelArg)
	{
		this.setColor(Color.CYAN);
		int a=x-1; 
		int b=x+1;
		int c=y-1;
		int d=y+1;
		if((modelArg.getColor(a, c) == (Color.MAGENTA)) || (modelArg.getColor(a, c) == (Color.PINK)))
		{
			this.humanKill(modelArg, x, y, this.getNum());
		}
		else if((modelArg.getColor(b, c) == (Color.MAGENTA)) || (modelArg.getColor(b, c) == (Color.PINK)))
		{
			this.humanKill(modelArg, x, y, this.getNum());
		}
		else if((modelArg.getColor(a, d) == (Color.MAGENTA)) || (modelArg.getColor(a, d) == (Color.PINK)))
		{
			this.humanKill(modelArg, x, y, this.getNum());
		}
		else if((modelArg.getColor(b, d) == (Color.MAGENTA)) || (modelArg.getColor(b, d) == (Color.PINK)))
		{
			this.humanKill(modelArg, x, y, this.getNum());
		}
		
	////////////////////////////////////	
		if(this.getDirection()=="North")
		{
			int y2=y-1;
			if((y2>=modelArg.getHeight()))
			{
				this.setObstacle(true);
				this.setRest(1);
				return;
			}
			else if(y2<0) 
			{
				this.setObstacle(true);
				this.setRest(1);
				return;
			}
			else if (modelArg.getColor(x, y2) != Color.BLACK)
			{
				this.setObstacle(true);
				this.setRest(1);
				return;
			}
			else{
				
			modelArg.setColor(x, y, Color.BLACK);
			modelArg.setColor(x, y2, this.getColor());
			}
			
			y--;

		}
		else if(this.getDirection() == "South")
		{
			
				int y2=y+1;
				if((y2>=modelArg.getHeight()))
				{
					this.setObstacle(true);
					this.setRest(1);
					return;
				}
				else if(y2<0) 
				{
					this.setObstacle(true);
					this.setRest(1);
					return;
				}
				else if (modelArg.getColor(x, y2) != Color.BLACK)
				{
					this.setObstacle(true);
					this.setRest(1);
					return;
				}
				else{
					
				modelArg.setColor(x, y, Color.BLACK);
				modelArg.setColor(x, y2, this.getColor());
				}

				y++;
			}
		else if(this.getDirection() == "East")
		{
			
				int x2=x+1;
				if((x2>=modelArg.getWidth()))
				{
					this.setObstacle(true);
					this.setRest(1);
					return;
				}
				else if(x2<0) 
				{
					this.setObstacle(true);
					this.setRest(1);
					return;
				}
				else if (modelArg.getColor(x2, y) != Color.BLACK)
				{
					this.setObstacle(true);
					this.setRest(1);
					return;
				}
				else{
					
				modelArg.setColor(x, y, Color.BLACK);
				modelArg.setColor(x2, y, this.getColor());
				}
		
				x++;
			}
		else if(this.getDirection() == "West")
		{
			
				int x2=x-1;
				if((x2>=modelArg.getWidth()))
				{
					this.setObstacle(true);
					this.setRest(1);
					return;
				}
				else if(x2<0) 
				{
					this.setObstacle(true);
					this.setRest(1);
					return;
				}
				else if (modelArg.getColor(x2, y) != Color.BLACK)
				{
					this.setObstacle(true);
					this.setRest(1);
					return;
				}
				else{
					
				modelArg.setColor(x, y, Color.BLACK);
				modelArg.setColor(x2, y, this.getColor());
				}

				x--;
			}
		}
	
	public void runObstacle(String direction)
	{
		int x=ram.nextInt(100);
		if(this.getDirection()=="North")
		if(x<40)
		{
			this.setDirection("East");
		}
		else if(x>=40 && x<80)
		{
			this.setDirection("West");
		}
		else if(x>=80 && x<90){
			this.setDirection("South");
		}
		else if(x>=90)
		{
			this.setFreeze(true);
		}
	
	else if(this.getDirection()=="South")
	{
		
		if(x<40)
		{
			this.setDirection("East");
		}
		else if(x>=40 && x<80)
		{
			this.setDirection("West");
		}
		else if(x>=80 && x<90){
			this.setDirection("North");
		}
		else if(x>=90)
		{
			this.setFreeze(true);
		}
	}
	else if(this.getDirection()=="East")
	{
		
		if(x<40)
		{
			this.setDirection("North");
		}
		else if(x>=40 && x<80)
		{
			this.setDirection("South");
		}
		else if(x>=80 && x<90){
			this.setDirection("West");
		}
		else if(x>=90)
		{
			this.setFreeze(true);
		}
	}
	if(this.getDirection()=="West")
	{
		
		if(x<40)
		{
			this.setDirection("North");
		}
		else if(x>=40 && x<80)
		{
			this.setDirection("South");
		}
		else if(x>=80 && x<90){
			this.setDirection("East");
		}
		else if(x>=90)
		{
			this.setFreeze(true);
		}
	}
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
			if(x<75)
			{
				this.setDirection("North");
			}
			else if(x>=75 && x<85)
			{
				this.setDirection("East");
			}
			else if(x>=85 && x<95){
				this.setDirection("West");
			}
			else if(x>=95)
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
			if(x<75)
			{
				this.setDirection("South");
			}
			else if(x>=75 && x<85)
			{
				this.setDirection("East");
			}
			else if(x>=85 && x<95){
				this.setDirection("West");
			}
			else if(x>=95)
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
			if(x<75)
			{
				this.setDirection("East");
			}
			else if(x>=75 && x<85)
			{
				this.setDirection("North");
			}
			else if(x>=85 && x<95){
				this.setDirection("South");
			}
			else if(x>=95)
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
			if(x<75)
			{
				this.setDirection("West");
			}
			else if(x>=75 && x<85)
			{
				this.setDirection("North");
			}
			else if(x>=85 && x<95){
				this.setDirection("South");
			}
			else if(x>=95)
			{
				this.setDirection("East");
			}
		}
	}
	
	
	public Human (ZombieModel modelArg, int num){
		this.setNum(num);
		this.setColor(Color.WHITE);
		x=ram.nextInt(modelArg.getWidth());
		y=ram.nextInt(modelArg.getHeight());
		
		
		if(modelArg.getColor(x, y) != Color.BLACK)
		{
			x=ram.nextInt(modelArg.getWidth());
			y=ram.nextInt(modelArg.getHeight());
		}
		else if (modelArg.getColor(x, y)==Color.BLACK)
		{
		modelArg.setColor(x, y, this.getColor());
		}
	this.setDirection("North");
	this.setObstacle(false);
	this.update(modelArg);
	this.setRest(0);
}
	public void update(ZombieModel modelArg) {
		if(dead==true)
		{
			return;
		}
		if(this.getRest()>0)
		{
			this.setRest(this.getRest()-1);
			return;
		}
		
		int a=x-1; 
		int b=x+1;
		int c=y-1;
		int d=y+1;
		if((modelArg.getColor(a, c) == (Color.MAGENTA)) || (modelArg.getColor(a, c) == (Color.PINK)))
		{
			this.humanKill(modelArg, x, y, this.getNum());
		}
		else if((modelArg.getColor(b, c) == (Color.MAGENTA)) || (modelArg.getColor(b, c) == (Color.PINK)))
		{
			this.humanKill(modelArg, x, y, this.getNum());
		}
		else if((modelArg.getColor(a, d) == (Color.MAGENTA)) || (modelArg.getColor(a, d) == (Color.PINK)))
		{
			this.humanKill(modelArg, x, y, this.getNum());
		}
		else if((modelArg.getColor(b, d) == (Color.MAGENTA)) || (modelArg.getColor(b, d) == (Color.PINK)))
		{
			this.humanKill(modelArg, x, y, this.getNum());
		}
	this.zSight(modelArg);
	if(this.getRun()==1)
	{
	this.setRest(2);
	this.setRun(0);
	this.setColor(Color.WHITE);
	
	}
	else if(this.getRun()>1)
		{
			
			this.run(modelArg);
			this.run(modelArg);
			int r=this.getRun() -1;
			this.setRun(r);
			return;
		}
		if(this.getRest()>0)
		{
			modelArg.setColor(x, y, Color.YELLOW);
			this.setRest(this.getRest()-1);
			return;
		}
		this.changeDirection(this.getDirection());
		if(this.getDirection()=="North")
		{
			int y2=y-1;
			if((y2>=modelArg.getHeight()))
			{
				this.setObstacle(true);
				this.setRest(1);
				return;
			}
			else if(y2<0) 
			{
				this.setObstacle(true);
				this.setRest(1);
				return;
			}
			else if (modelArg.getColor(x, y2) != Color.BLACK)
			{
				this.setObstacle(true);
				this.setRest(1);
				return;
			}
			else{
				
			modelArg.setColor(x, y, Color.BLACK);
			modelArg.setColor(x, y2, this.getColor());
			}
			
			y--;
		}
		else if(this.getDirection() == "South")
		{
			
				int y2=y+1;
				if((y2>=modelArg.getHeight()))
				{
					this.setObstacle(true);
					this.setRest(1);
					return;
				}
				else if(y2<0) 
				{
					this.setObstacle(true);
					this.setRest(1);
					return;
				}
				else if (modelArg.getColor(x, y2) != Color.BLACK)
				{
					this.setObstacle(true);
					this.setRest(1);
					return;
				}
				else{
					
				modelArg.setColor(x, y, Color.BLACK);
				modelArg.setColor(x, y2, this.getColor());
				}
				y++;
			}
		else if(this.getDirection() == "East")
		{
			
				int x2=x+1;
				if((x2>=modelArg.getWidth()))
				{
					this.setObstacle(true);
					this.setRest(1);
					return;
				}
				else if(x2<0) 
				{
					this.setObstacle(true);
					this.setRest(1);
					return;
				}
				else if (modelArg.getColor(x2, y) != Color.BLACK)
				{
					this.setObstacle(true);
					this.setRest(1);
					return;
				}
				else{
					
				modelArg.setColor(x, y, Color.BLACK);
				modelArg.setColor(x2, y, this.getColor());
				}
				x++;
			}
		else if(this.getDirection() == "West")
		{
			
				int x2=x-1;
				if((x2>=modelArg.getWidth()))
				{
					this.setObstacle(true);
					this.setRest(1);
					return;
				}
				else if(x2<0) 
				{
					this.setObstacle(true);
					this.setRest(1);
					return;
				}
				else if (modelArg.getColor(x2, y) != Color.BLACK)
				{
					this.setObstacle(true);
					this.setRest(1);
					return;
				}
				else{
					
				modelArg.setColor(x, y, Color.BLACK);
				modelArg.setColor(x2, y, this.getColor());
				}
				x--;
			}
		}
		
		
		
	}
