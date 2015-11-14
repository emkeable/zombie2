package zombie;
import java.awt.Color;
import java.util.*;

public class Human {
	private ZombieModel model;
	private int x;
	private int y;
	private Random ram = new Random();
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	private String direction;  
	public Human (ZombieModel modelArg){
		x=ram.nextInt(modelArg.getWidth());
		y=ram.nextInt(modelArg.getHeight());
		
		
		if(modelArg.getColor(x, y) != Color.BLACK)
		{
			x=ram.nextInt(modelArg.getWidth());
			y=ram.nextInt(modelArg.getHeight());
		}
		else if (modelArg.getColor(x, y)==Color.BLACK)
		{
		modelArg.setColor(x, y, Color.WHITE);
		}
	this.setDirection("North");
	this.update(modelArg);
}
	public void update(ZombieModel modelArg) {
		//update newx and newy based on dir(use switch)
		//check whether the new location on the canvas and is qualified
		if(this.getDirection()=="North")
		{
			int y2=y-1;
			if((y2>=modelArg.getHeight()))
			{
				return;
			}
			else if(y2<0) 
			{
				return;
			}
			else if (modelArg.getColor(x, y2) != Color.BLACK)
			{
				
				return;
			}
			else{
				
			modelArg.setColor(x, y, Color.BLACK);
			modelArg.setColor(x, y2, Color.WHITE);
			}
			y--;
		}
		else if(this.getDirection() == "South")
		{
			
				int y2=y+1;
				if((y2>=modelArg.getHeight()))
				{
					return;
				}
				else if(y2<0) 
				{
					return;
				}
				else if (modelArg.getColor(x, y2) != Color.BLACK)
				{
					
					return;
				}
				else{
					
				modelArg.setColor(x, y, Color.BLACK);
				modelArg.setColor(x, y2, Color.WHITE);
				}
				y++;
			}
		else if(this.getDirection() == "East")
		{
			
				int x2=x+1;
				if((x2>=modelArg.getWidth()))
				{
					return;
				}
				else if(x2<0) 
				{
					return;
				}
				else if (modelArg.getColor(x2, y) != Color.BLACK)
				{
					
					return;
				}
				else{
					
				modelArg.setColor(x, y, Color.BLACK);
				modelArg.setColor(x2, y, Color.WHITE);
				}
				x++;
			}
		else if(this.getDirection() == "West")
		{
			
				int x2=x-1;
				if((x2>=modelArg.getWidth()))
				{
					return;
				}
				else if(x2<0) 
				{
					return;
				}
				else if (modelArg.getColor(x2, y) != Color.BLACK)
				{
					
					return;
				}
				else{
					
				modelArg.setColor(x, y, Color.BLACK);
				modelArg.setColor(x2, y, Color.WHITE);
				}
				x--;
			}
		}
		
		
		
	}
	

