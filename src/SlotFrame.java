import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * This is program set the frame up for the slot machine 
 * It include the top bar options and sets the look of the frame
 * @author William Nash
 *
 */
@SuppressWarnings({ "unused", "serial" })
public class SlotFrame extends JFrame
{
	private SlotsDrawing drawSlots;
	/**
	 * setupMenu sets up the top bar
	 * This allows users to save, load restart and exit the game
	 * It also includes a help tab if the user gets suck
	 */
	public void setupMenu()
	{
		Tile tileInfo = new Tile();
		JMenuBar slotBar = new JMenuBar();
		JMenu slotMenu = new JMenu("File");
		JMenuItem menuSave = new JMenuItem("Save");
		menuSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser();
				SlotsWriter tileWrite = new SlotsWriter();
				if(jfc.showSaveDialog(null)== JFileChooser.APPROVE_OPTION)
				{
					if(tileWrite.write(jfc.getSelectedFile(), drawSlots.getTiles()))
					{
						JOptionPane.showMessageDialog(null, "Wrote Tiles to file");
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Failed to write Tiles");
					}
				}
			}
		});
		slotMenu.add(menuSave);
		JMenuItem menuLoad = new JMenuItem("Load");
		menuLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SlotsReader sr = new SlotsReader();
				JFileChooser jfc = new JFileChooser();
				if(jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
				{
					ArrayList<Tile> TileRead = sr.read(jfc.getSelectedFile());
					if(TileRead == null)
					{
						JOptionPane.showMessageDialog(null, "Could not read Tiles From File.");
					}
					else
					{
						drawSlots.setTiles(TileRead);
						repaint();
					}
				}

			}
		});
		slotMenu.add(menuLoad);
		JMenuItem menuRestart = new JMenuItem("Restart");
		menuRestart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drawSlots.RandomizerTile();
				repaint();
			}
		});
		JMenuItem menuExit = new JMenuItem("Exit");
		menuExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
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
	/**
	 * This is the non-default constructor
	 * @param title It is brought in from the VegasSlots class
	 * @param left It is brought in from the VegasSlots class
	 * @param top It is brought in from the VegasSlots class
	 * @param width It is brought in from the VegasSlots class
	 * @param height It is brought in from the VegasSlots class
	 * @param closeOp It is brought in from the VegasSlots class
	 */
	public SlotFrame(String title, int left, int top, int width, int height, int closeOp)//non-default constructor, takes in settings
	{
		setLook(title,left,top,width,height);
		setDefaultCloseOperation(closeOp);
	}
	
	/**
	 * The setlook function adds all the visuals
	 * It sets the look of the frame and add the containers
	 * It adds the buttons on the bottom to allow the user to bet away their life savings
	 * @param title It is brought in from the VegasSlots class
	 * @param left It is brought in from the VegasSlots class
	 * @param top It is brought in from the VegasSlots class
	 * @param width It is brought in from the VegasSlots class
	 * @param height It is brought in from the VegasSlots class
	 */
	public void setLook(String title, int left, int top, int width, int height) {
        setTitle(title);
        setBounds(left,top,width,height);
        Container c = getContentPane();
        
        c.setLayout(new BorderLayout());
        
        drawSlots = new SlotsDrawing();
        c.add(drawSlots, BorderLayout.CENTER);
        
        JPanel panelSouth = new JPanel();
        panelSouth.setLayout(new FlowLayout());

        
        //Max Button
        JButton btnMax = new JButton("Max");
        btnMax.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	drawSlots.RandomizerTile();
                repaint();
            }
        });
        panelSouth.add(btnMax);
        
        //Mid Button
        JButton btnMid = new JButton("Mid");
        btnMid.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	drawSlots.RandomizerTile();
                repaint();
            }
        });
        panelSouth.add(btnMid);
        
        //Min Button
        JButton btnMin = new JButton("Min");
        btnMin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	drawSlots.RandomizerTile();
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