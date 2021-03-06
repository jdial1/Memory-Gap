import javax.swing.*;



@SuppressWarnings("serial")
public class Character extends JButton{ //entire class by 

	// create attributes for gender and race 
	 private String race;
	 private String gender;
	 private int direction;
	 private int level;
	 private int xPos;
	 private int yPos;
	 private int width = 100;
	 private int height = 100;
	 private int charImage;

	// character constructor 
	public Character(String g, String r, int l)
	{
		
		this.gender=g;
		this.race=r;
		this.level = l;

		// call method to set character attributes 
		setAvatar();
		setBorder(null); 
		setContentAreaFilled(false);
	}

	// Accessors & Mutators  ********
	public void setChar(String g,String r)// accessor to set gender and race separately if needed 
	{
		this.gender = g;
		this.race = r;

		setAvatar();
	}
	//accessor to change level every 3 levels. 
	public void setLevel(int l){
		this.level = l;
	}

	// Methods *********************
	// Method to set avatar and death sound, updated for all levels 
	public void setAvatar()
	{
		//sets a default image if none is chosen and overwrites.
		ImageIcon image = new ImageIcon("images/humanM1-3.png");
		
		String racegend = race.toLowerCase();

		switch(gender){
			case "Male":racegend=racegend+"M";break;
			case "Female":racegend=racegend+"F";break;
			default:break;
		}

		switch (level){
			case 1:case 2:case 3:racegend=racegend+"1-3.png";break;
			case 4:case 5:case 6:racegend=racegend+"4-6.png";break;
			case 7:case 8:case 9:racegend=racegend+"7-9.png";break;
			default:break;
		}		

		image = new ImageIcon ("images/"+racegend);
		setIcon(image);// commit the image change
		validate();
		repaint();
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public int getxPos() {
		return xPos;
	}

	public void setxPos(int xPos) {
		this.xPos = xPos;
	}

	public int getyPos() {
		return yPos;
	}

	public void setyPos(int yPos) {
		this.yPos = yPos;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getCharImage() {
		return charImage;
	}

	public void setCharImage(int charImage) {
		this.charImage = charImage;
	}

}
