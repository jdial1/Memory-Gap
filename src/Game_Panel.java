import java.awt.*;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Game_Panel extends JPanel {
	//added to display picks 
	private String race= "Human";
	@SuppressWarnings("unused")
	private int difficulty;
	@SuppressWarnings("unused")
	private String sex;

	JButton bmenu; //menu button JD
	JButton bnewGame; // new game button JD
	JButton bcontinue; // continue button JD

	private JLabel gtitle = new JLabel("Memory Gap"); //text for title JD

	// JLabels to display race and difficulty//
	private JLabel grace = new JLabel("Race: ");
	private JLabel gdiff = new JLabel("Difficulty: ");
	private JLabel selecteddiff = new JLabel("");
	private JButton selectedRace = new JButton("");

	private String fontStyle = Back_Panel.getFontStyle(); //gets fontstyle from Back Panel JD

	private static String[] ComboboxStrings = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};

	@SuppressWarnings({ "unchecked", "rawtypes" }) 
	JComboBox cblevelList = new JComboBox(ComboboxStrings);

	public Game_Panel() { //Constructor

		super();
		setLayout(null);

		gtitle.setBounds(245, 70, 400, 100); //sets location of title JD
		gtitle.setFont(new Font(fontStyle, Font.BOLD, 50)); //sets font of title JD

		grace.setBounds(330, 600, 50, 50);
		grace.setFont(new Font(fontStyle, Font.BOLD, 30));

		gdiff.setBounds(560, 380, 50, 50);
		gdiff.setFont(new Font(fontStyle, Font.BOLD, 30));
		gdiff.setForeground(Color.WHITE);

		bmenu = new JButton("Main Menu");
		bnewGame = new JButton("New Game");
		bcontinue = new JButton("Continue");

		bmenu.setBounds(200,350,150,50); //sets location of menu button JD
		bnewGame.setBounds(200, 400, 150, 50); //sets location of new game button JD
		bcontinue.setBounds(200, 450, 150, 50); //sets location of continue button JD
		
		//add(gtitle); //adds title JD
		add(bmenu); //adds menu button JD
		add(bnewGame); //adds new game button JD
		add(bcontinue); //adds continue button JD

		cblevelList.setBounds(220, 615, 100, 25); //sets location of levellist combobox JD
		cblevelList.setSelectedItem(1);
		add(cblevelList);//adds combobox JD

		bmenu.setToolTipText("Return To Main Menu");
		bnewGame.setToolTipText("New Game");
		bcontinue.setToolTipText("Continue");
		
		
		setButton(bmenu,650,0,"images/ReturnButton.png");
		setButton(bnewGame,170,0,"images/PlayButton.png");
		setButton(bcontinue,320,0,"images/NextLevelButton.png");
	
	}
	
	public void setButton(JButton buttonName , int xCoord,int size, String buttonImage){

		buttonName.setFont(new Font("Impact", Font.PLAIN,size));
		buttonName.setForeground(Color.white);
		buttonName.setBounds(xCoord, 600, 50, 50);
		buttonName.setIcon(new ImageIcon(buttonImage));
		buttonName.setHorizontalTextPosition(AbstractButton.CENTER);
		buttonName.setFocusPainted(false);
		buttonName.setContentAreaFilled(false);
		buttonName.setBorderPainted(false);
		buttonName.setOpaque(false);

		add(buttonName);
	}
	
	 //Method created to handle display of race and diff 
	 public void displayRaceDif(String r, String s, int d,String loc){
		this.race = r;
		this.difficulty = d;
		this.sex=s;


		if ("Human".equals(race) && "Male".equals(s)){
			selectedRace.setIcon(new ImageIcon("images/humanm1-3_opt.png"));
		}
		if ("Human".equals(race) && "Female".equals(s)){
			selectedRace.setIcon(new ImageIcon("images/humanf1-3_opt.png"));
		}
		else if ("Ostrich".equals(race) && "Male".equals(s)){
			selectedRace.setIcon(new ImageIcon("images/ostrichm1-3_opt.png"));
		}
		else if ("Ostrich".equals(race) && "Female".equals(s)){
			selectedRace.setIcon(new ImageIcon("images/ostrichf1-3_opt.png"));
		}
		else if ("Ostrich".equals(race) && "Male".equals(s)){
			selectedRace.setIcon(new ImageIcon("images/potatom1-3_opt.png"));
		}
		else if ("Ostrich".equals(race)&& "Female".equals(s)){
			selectedRace.setIcon(new ImageIcon("images/potatof1-3_opt.png"));
		}
		selectedRace.setBounds(400,600,50,50);
		selectedRace.setVisible(true);
		selectedRace.setFocusPainted(false);
		selectedRace.setContentAreaFilled(false);
		selectedRace.setBorderPainted(false);
		add(selectedRace);


		if("Potato".equals(race))
			selecteddiff.setText("Infinite Lifes");
		else if (d>1)
			selecteddiff.setText(d+" Lives");
		else if(d<1)
			selecteddiff.setText(d+" Life");


		switch(loc){
		case "ip":
		case "gp":
		case "wp":
		case "op":
			selecteddiff.setBounds(470,600,250,50);
			break;
			
		}


		selecteddiff.setVisible(true);
		selecteddiff.setFont(new Font("Impact", Font.BOLD, 30));
		selecteddiff.setForeground(Color.WHITE);
		add(selecteddiff);

		validate();
		repaint();

	}

	public void paintComponent (Graphics g) //method to set background 
	{
		super.paintComponent(g);
		Image myImage = Toolkit.getDefaultToolkit().getImage("images/background.jpg");
		g.drawImage(myImage, 0, 0, this);

	}
}

