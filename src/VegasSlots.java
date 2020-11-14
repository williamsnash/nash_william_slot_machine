import javax.swing.JFrame;





public class VegasSlots
{
	public static void main(String[] args)
	{
		SlotFrame frm1 = new SlotFrame("Vegas Baby Vegas Slot Machine",100,100,800,380,JFrame.EXIT_ON_CLOSE);
		frm1.setVisible(true);

	}
}
/*
 * Old And crappy code
 * Saving because don't want to delete
class TileData
{

	private int tileLeftColor;
	private int tileLeftShape;
	private int tileLeftMiddleColor;
	private int tileLeftMiddleShape;
	private int tileRightColor;
	private int tileRightShape;
	private int tileRightMiddleColor;
	private int tileRightMiddleShape;
	private ArrayList<Integer> slotData;
	
	public TileData()
	{
		this(0, 0, 0, 0, 0, 0, 0, 0);
	}
	public TileData(int LeftColor, int LeftShape, int LeftMiddleColor, int LeftMiddleShape, int RightColor, int RightShape, int RightMiddleColor, int RightMiddleShape)
	{
		setTileLeftColor(LeftColor);
		setTileLeftShape(LeftShape);
		//
		setTileLeftMiddleColor(LeftMiddleColor);
		setTileLeftMiddleShape(LeftMiddleShape);
		//
		setTileRightColor(RightColor);
		setTileRightShape(RightShape);
		//
		setTileRightMiddleColor(RightMiddleColor);
		setTileRightMiddleShape(RightMiddleShape);
	}
	//
	//Left
	public void setTileLeftColor(int LeftColor)
	{
		this.tileLeftColor = LeftColor;
	}
	public int getTileLeftColor()
	{
		return tileLeftColor;
	}
	public void setTileLeftShape(int leftShape)
	{
		this.tileLeftShape = leftShape;
	}
	public int getTileLeftShape()
	{
		return tileLeftShape;
	}
	//
	//Left Middle
	public void setTileLeftMiddleColor(int LeftMiddleColor)
	{
		this.tileLeftMiddleColor = LeftMiddleColor;
	}
	public int getTileLeftMiddleColor()
	{
		return tileLeftMiddleColor;
	}
	public void setTileLeftMiddleShape(int leftMiddleShape)
	{
		this.tileLeftMiddleShape = leftMiddleShape;
	}
	public int getTileLeftMiddleShape()
	{
		return tileLeftMiddleShape;
	}
	//
	//Right
	public void setTileRightColor(int rightColor)
	{
		this.tileRightColor = rightColor;
	}
	public int getTileRightColor()
	{
		return tileRightColor;
	}
	public void setTileRightShape(int rightShape)
	{
		this.tileRightShape = rightShape;
	}
	public int getTileRightShape()
	{
		return tileRightShape;
	}
	//
	//Right Middle
	public void setTileRightMiddleColor(int rightMiddleColor)
	{
		this.tileRightMiddleColor = rightMiddleColor;
	}
	public int getTileRightMiddleColor()
	{
		return tileRightMiddleColor;
	}
	public void setTileRightMiddleShape(int rightMiddleShape)
	{
		this.tileRightMiddleShape = rightMiddleShape;
	}
	public int getTileRightMiddleShape()
	{
		return tileRightMiddleShape;
	}
	//
	//
	public void setRandomly(Random rand)
	{
		setTileLeftColor(rand.nextInt(5));
		setTileLeftMiddleColor(rand.nextInt(5));
		setTileRightMiddleColor(rand.nextInt(5));
		setTileRightColor(rand.nextInt(5));
		
		setTileLeftShape(rand.nextInt(2));
		setTileLeftMiddleShape(rand.nextInt(2));
		setTileRightMiddleShape(rand.nextInt(2));
		setTileRightShape(rand.nextInt(2));
	}
	
	public void setArrayList()
	{
		slotData.add(getTileLeftColor());
		slotData.add(getTileLeftShape());
		
		slotData.add(getTileLeftMiddleColor());
		slotData.add(getTileLeftMiddleShape());
		
		slotData.add(getTileRightMiddleColor());
		slotData.add(getTileRightMiddleShape());
		
		slotData.add(getTileRightColor());
		slotData.add(getTileRightShape());
	}
	public ArrayList<Integer> getArrayList()
	{
		return slotData;
	}
}

class TileRandomizer
{
}
class TilePanel
{
	//Allows user to click and randomize tiles
}

@SuppressWarnings("serial")
class SlotsFrame extends JFrame
{
	//private SlotsWriter tileWrite;
	public void setupMenu()
	{
		TileData tileInfo = new TileData();
		JMenuBar slotBar = new JMenuBar();
		JMenu slotMenu = new JMenu("File");
		JMenuItem menuSave = new JMenuItem("Save");
		menuSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser();
				SlotsWriter tileWrite = new SlotsWriter();
				if(jfc.showSaveDialog(null)== JFileChooser.APPROVE_OPTION)
				{
					if(tileWrite.write(jfc.getSelectedFile(), tileInfo.getArrayList()))
					{
						JOptionPane.showMessageDialog(null, "Wrote Tiles to File.");
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Could not write tiles to File.");
					}
				}
			}
		});
		JMenuItem menuLoad = new JMenuItem("Load");
		menuSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		JMenuItem menuRestart = new JMenuItem("Restart");
		menuRestart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		JMenuItem menuExit = new JMenuItem("Exit");
		menuExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		slotMenu.add(menuSave);
		slotMenu.add(menuLoad);
		slotMenu.add(menuRestart);
		slotMenu.add(menuExit);
		slotBar.add(slotMenu);
		
		JMenu slotHelp = new JMenu("Help");
		JMenuItem helpAbout = new JMenuItem("About");
		helpAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Slot Machine Program made by Will Nash\n https://github.com/williamsnash/nash_william_slot_machine");
			}
		});
		slotHelp.add(helpAbout);
		slotBar.add(slotHelp);
		setJMenuBar(slotBar);
	}
	public SlotsFrame(String title, int left, int top, int width, int height, int closeOp)//non-default constructor, takes in settings
	{
		setLook(title,left,top,width,height);
		setDefaultCloseOperation(closeOp);
	}
	
	public void setLook(String title, int left, int top, int width, int height) {
        setTitle(title);
        setBounds(left,top,width,height);
        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        JPanel panelSouth = new JPanel();
        
        SlotsDrawing drawSlots = new SlotsDrawing();
        c.add(drawSlots, BorderLayout.CENTER);
        
        //Max Button
        JButton btnMax = new JButton("Max");
        btnMax.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        });
        panelSouth.add(btnMax);
        
        //Mid Button
        JButton btnMid = new JButton("Mid");
        btnMid.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        });
        panelSouth.add(btnMid);
        
        //Min Button
        JButton btnMin = new JButton("Min");
        btnMin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        });
        panelSouth.add(btnMin);
        
        //Dollar button
        panelSouth.add(new JLabel("$"));
        JTextField txtDollar = new JTextField(6);
        panelSouth.add(txtDollar);
        
        c.add(panelSouth,BorderLayout.SOUTH);
        setupMenu();
        
	}
}
*/

