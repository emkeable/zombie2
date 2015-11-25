package zombie;
import java.awt.Color;
import java.util.*;
public class Tree {
	//
	
	private int x;
	private int y;
	
	private Random ram = new Random();

	public Tree(ZombieModel modelArg){
		x=ram.nextInt(modelArg.getWidth()-1);
		y=ram.nextInt(modelArg.getHeight()-1);
		do{
		if(modelArg.getColor(x, y) != Color.BLACK)
		{
			x=ram.nextInt(modelArg.getWidth());
			y=ram.nextInt(modelArg.getHeight());
		}
		} while (modelArg.getColor(x, y) != Color.BLACK);
		
		modelArg.setColor(x, y, Color.GREEN);
		for(int i=x-1; i<=x+1; i++){
			if((modelArg.getColor(i, y)==Color.BLACK) && (i>0 && y>0) &&(i<modelArg.getWidth() && y<modelArg.getHeight())){
			modelArg.setColor(i, y, Color.GREEN);
			}
		}
			for(int j=y-1; j<=y+1; j++){
				if((modelArg.getColor(x, j)==Color.BLACK) && (j>0 && x>0) && (j< modelArg.getHeight())){
				modelArg.setColor(x, j, Color.GREEN);
				}
		
			}
		}
		
