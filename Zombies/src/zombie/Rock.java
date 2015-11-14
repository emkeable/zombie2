package zombie;
import java.awt.Color;
import java.util.*;

public class Rock {
	private int x;
	private int y;
	private int radius;
	private Random ram = new Random();

	public Rock(ZombieModel modelArg){
		x=ram.nextInt(modelArg.getWidth());
		y=ram.nextInt(modelArg.getHeight());
		radius=ram.nextInt(4)+4;
		if(modelArg.getColor(x, y) != Color.BLACK)
		{
			x=ram.nextInt(modelArg.getWidth());
			y=ram.nextInt(modelArg.getHeight());
		}
		
		
		int x2=x+radius;
		int x1=x-radius;
		int y2=y+radius;
		int y1=y-radius;
		
		for(int i=x1; i<=x2; i++)
		{
			for(int j=y1; j<=y2; j++)
			{
				int dist=this.distance(x, i, y, j);
				if(dist<radius && i<modelArg.getWidth()&& j<modelArg.getHeight()){
				modelArg.setColor(i, j, Color.GRAY);
				}
				
			}
		}
		
		modelArg.setColor(x, y, Color.GRAY);
		
	
	}	
	public int distance(int x1, int x2, int y1, int y2){
		int distance;
		distance = (int) Math.hypot(x1-x2, y1-y2);	
		
	return distance;
}
}