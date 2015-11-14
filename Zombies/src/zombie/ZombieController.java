package zombie;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Timer;

public class ZombieController implements MouseListener {

	private final ZombieModel model;
	private final ZombieView view;
	private final int delay;

	public ZombieController(ZombieModel modelArg, ZombieView viewArg, int sleepTimeArg) {
		model = modelArg;
		view = viewArg;
		delay = sleepTimeArg;
	}

	public void beginSimulation() {
		model.initialize();
		view.draw();
		ActionListener taskPerformer = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				model.update();
				view.draw();
			}
		};
		new Timer(delay, taskPerformer).start();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
		if((e.getX()>200) && (e.getX()<600) &&(e.getY()<200) && (e.getY()>0))
				{
					model.getHuman().setDirection("North");
				}
		else if((e.getX()>200) && (e.getX()<600) &&(e.getY()>400) && (e.getY()<800))
		{
			
			model.getHuman().setDirection("South");
		}
		else if((e.getX()>600) && (e.getX()<800) &&(e.getY()>0) && (e.getY()<400))
		{
			
			model.getHuman().setDirection("East");
		}
		else if((e.getX()<200) && (e.getX()>0) &&(e.getY()>0) && (e.getY()<400))
		{
			
			model.getHuman().setDirection("West");
		}
	}
	

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

		

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
	
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}


