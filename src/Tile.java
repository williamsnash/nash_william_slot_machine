import java.io.Serializable;
import java.util.Random;


public class Tile implements Serializable
{
	private int color;
	private int shape;
	
	/**
	 * Allows other classes to access the data
	 * @return returns integer
	 */
	public int getColor()
	{
		return color;
	}
	
	/**
	 * Allows other classes to access the data
	 * @return returns integer
	 */
	public int getShape()
	{
		return shape;
	}
	
	/**
	 * Allows other classes to set the data
	 * @param color The integer value of the 4 colour options
	 */
	public void setColor(int color)
	{
		this.color = color;
	}
	
	/**
	 * Allows other classes to set the data
	 * @param color The integer value of the 4 colour options
	 */
	public void setShape(int shape)
	{
		this.shape = shape;
	}
	
	/**
	 * Default Constructor
	 */
	public Tile()
	{
		color = 0;
		shape = 0;
	}
	
	/**
	 * Non-Default Constructor
	 * @param color Integervalue for one of the 4 colors
	 * @param shape Integer value for one of the 2 shapes
	 */
	public Tile(int color, int shape)
	{
		setColor(color);
		setShape(shape);
	}
	
	/**
	 * Allows println to print a text representation of the object
	 */
	@Override
	public String toString()
	{
		return String.format("%d %d",color,shape);
	}
	
	public Tile tileRandom(Tile tile1)
	{
		Random rand = new Random();
		int colorRand = rand.nextInt(5);
		int shapeRand = rand.nextInt(2);
		Tile tileRand = new Tile(colorRand,shapeRand);
		return tileRand;
	}
}
