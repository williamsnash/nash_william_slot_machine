import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;

@SuppressWarnings("serial" )
class SlotsDrawing extends JPanel
{
	private ArrayList<Tile> tiles;
	
	public void setTiles(ArrayList<Tile> tile)
	{
		this.tiles = tile;
	}
	public ArrayList<Tile> getTiles()
	{
		return tiles;
	}
	
	public SlotsDrawing()
	{
		tiles = new ArrayList<Tile>();
		Tile tile1 = new Tile(0,0);
		tiles.add(tile1.tileRandom(tile1));
		tiles.add(tile1.tileRandom(tile1));
		tiles.add(tile1.tileRandom(tile1));
		tiles.add(tile1.tileRandom(tile1));
	}
	public void RandomizerTile()
	{
		Tile tile1 = new Tile(0,0);
		tiles.set(0, tile1.tileRandom(tile1));
		tiles.set(1, tile1.tileRandom(tile1));
		tiles.set(2, tile1.tileRandom(tile1));
		tiles.set(3, tile1.tileRandom(tile1));
		repaint();
	}
	
	
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