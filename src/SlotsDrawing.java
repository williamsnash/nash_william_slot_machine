import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

/**
 * This class will add the all the tiles for the user to look at
 * It creates/ randomizes the tiles so no round is like the last
 * @author William Nash
 *
 */
@SuppressWarnings("serial" )
class SlotsDrawing extends JPanel implements MouseListener, MouseMotionListener
{
	private ArrayList<Tile> tiles;
	private String mouseStatus;
	
	/**
	 * This function allows other class to edit the private tiles arrayList
	 * @param tile and arrayList provided by another class
	 */
	public void setTiles(ArrayList<Tile> tile)
	{
		this.tiles = tile;
	}
	/**
	 * This function allows other class to read the private arrayList tiles
	 * @return an ArrayList<Tile> for other class to use
	 */
	public ArrayList<Tile> getTiles()
	{
		return tiles;
	}
	
	/**
	 * SlotsDrawing is the default constructor
	 * It creates and randomly assigns each tile a color and shape
	 */
	public SlotsDrawing()
	{
		addMouseListener(this);//This breaks everything!!!!
		//addMouseMotionListener(this);
		tiles = new ArrayList<Tile>();
		Tile tile1 = new Tile(0,0);
		tiles.add(tile1.tileRandom());
		tiles.add(tile1.tileRandom());
		tiles.add(tile1.tileRandom());
		tiles.add(tile1.tileRandom());
	}
	/**
	 * This is a function that other classes can call to randomize the tiles at any point
	 * Being used for the Restart button in the top bar
	 */
	public void RandomizerTile()
	{
		Tile tile1 = new Tile(0,0);
		tiles.set(0, tile1.tileRandom());
		tiles.set(1, tile1.tileRandom());
		tiles.set(2, tile1.tileRandom());
		tiles.set(3, tile1.tileRandom());
		repaint();
	}
	
	/**
	 * This will change the correct tile based on where the user clicks
	 * The math was done knowing that the the shapes are all the same size, the just comparing the value to see which to randomize
	 */
	public void clickChange(int x, int y)
	{
		Tile tile1 = new Tile(0,0);
		if(x > 30 & x < 155)
		{
			if(y > 100 & y < 225)
			{
				//Randomize first Tile
				tiles.set(0, tile1.tileRandom());
			}
		}
		if(x > 230 & x < 355)
		{
			if(y > 100 & y < 225)
			{
				//Randomize second Tile
				tiles.set(1, tile1.tileRandom());
			}
		}
		if(x > 430 & x < 555)
		{
			if(y > 100 & y < 225)
			{
				//Randomize third Tile
				tiles.set(2, tile1.tileRandom());
			}
		}
		if(x > 630 & x < 755)
		{
			if(y > 100 & y < 225)
			{
				//Randomize fourth tile
				tiles.set(3, tile1.tileRandom());
			}
		}
		/*
		 * Clickable areas for Tiles
		 * First Tile
		 * 		X = [30-155]
		 * 		Y = [100-225]
		 * Second Tile
		 * 		X = [230-355]
		 * 		Y = [100-225]
		 * Third Tile
		 * 		X = [430-555]
		 * 		Y = [100-225]
		 * Fourth Tile
		 * 		X = [630-755]
		 * 		Y = [100-225]
		 */
	}
	
	/**
	 * This does the drawing
	 * For every entry in the tiles arrayList the for loop runs- First Looking at the shape of the tile, then looking at the color of the tile. Finally drawing the tile
	 * A predetermined starting x value of 30 was chosen, then very time 200 is added on.
	 */
	@Override
	public void paintComponent(Graphics g)
	{
		int x = 30;
		for(Tile tile: tiles)
		{
			if(tile.getShape() == 0)//Square
			{
				if(tile.getColor() == 0)//yellow
				{
					g.setColor(Color.YELLOW); //Test
					g.fillRect(x,100,125,125);
				}
				else if (tile.getColor() == 1)//Green
				{
					g.setColor(Color.GREEN); //Test
					g.fillRect(x,100,125,125);
				}
				else if (tile.getColor() == 2)//Orange
				{
					g.setColor(Color.ORANGE); //Test
					g.fillRect(x,100,125,125);
				}
				else if (tile.getColor() == 3)//Red
				{
					g.setColor(Color.RED); //Test
					g.fillRect(x,100,125,125);
				}
				else if (tile.getColor() == 4)//Blue
				{
					g.setColor(Color.BLUE); //Test
					g.fillRect(x,100,125,125);
				}
			}
			else if(tile.getShape() == 1)//Circle
			{
				if(tile.getColor() == 0)//yellow
				{
					g.setColor(Color.YELLOW); //Test
					g.fillOval(x,100,125,125);
				}
				else if (tile.getColor() == 1)//Green
				{
					g.setColor(Color.GREEN); //Test
					g.fillOval(x,100,125,125);
				}
				else if (tile.getColor() == 2)//Orange
				{
					g.setColor(Color.ORANGE); //Test
					g.fillOval(x,100,125,125);
				}
				else if (tile.getColor() == 3)//Red
				{
					g.setColor(Color.RED); //Test
					g.fillOval(x,100,125,125);
				}
				else if (tile.getColor() == 4)//Blue
				{
					g.setColor(Color.BLUE); //Test
					g.fillOval(x,100,125,125);
				}
			}
			x = x+200;
		}
	}
	public String getMouseStatus() {
		return mouseStatus;
	}
	public void setMouseStatus(String ms) {
		mouseStatus = ms;
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		mouseStatus = "Mouse entered the panel.";
		repaint();
	}
	@Override
	public void mouseExited(MouseEvent e) {
		mouseStatus = "Mouse exited the panel.";
		repaint();
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		mouseStatus = String.format("mouse clicked at (%d, %d)", e.getX(),e.getY());
		clickChange(e.getX(),e.getY());
		repaint();
	}
	@Override
	public void mousePressed(MouseEvent e) {
		mouseStatus = String.format("mouse pressed at (%d, %d)", e.getX(),e.getY());
		repaint();
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		mouseStatus = String.format("mouse released at (%d, %d)", e.getX(),e.getY());
		repaint();
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		mouseStatus = "Mouse entered the panel.";
		repaint();
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		mouseStatus = "Mouse entered the panel.";
		repaint();
	}
}