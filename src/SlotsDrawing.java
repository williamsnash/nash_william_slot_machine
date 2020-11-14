import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;

/**
 * This class will add the all the tiles for the user to look at
 * It creates/ randomizes the tiles so no round is like the last
 * @author William Nash
 *
 */
@SuppressWarnings("serial" )
class SlotsDrawing extends JPanel
{
	private ArrayList<Tile> tiles;
	
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
		tiles = new ArrayList<Tile>();
		Tile tile1 = new Tile(0,0);
		tiles.add(tile1.tileRandom(tile1));
		tiles.add(tile1.tileRandom(tile1));
		tiles.add(tile1.tileRandom(tile1));
		tiles.add(tile1.tileRandom(tile1));
	}
	/**
	 * This is a function that other classes can call to randomize the tiles at any point
	 * Being used for the Restart button in the top bar
	 */
	public void RandomizerTile()
	{
		Tile tile1 = new Tile(0,0);
		tiles.set(0, tile1.tileRandom(tile1));
		tiles.set(1, tile1.tileRandom(tile1));
		tiles.set(2, tile1.tileRandom(tile1));
		tiles.set(3, tile1.tileRandom(tile1));
		repaint();
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
}