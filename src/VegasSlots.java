import javax.swing.JFrame;




/**
 * This is the first part of a slot machine
 * This program randomly displays tiles andcan save and load file of game states
 * @author William Nash
 * This class is the starting class, it gets the ball rolling
 */
public class VegasSlots
{
	public static void main(String[] args)
	{
		SlotFrame frm1 = new SlotFrame("Vegas Baby Vegas Slot Machine",100,100,800,380,JFrame.EXIT_ON_CLOSE);
		frm1.setVisible(true);

	}
}