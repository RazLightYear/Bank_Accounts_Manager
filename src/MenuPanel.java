import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MenuPanel extends JPanel implements ViewOnOff, ActionListener
{
	private JPanel Top_Panel;
	private JLabel Top_Panel_Label;
	private Font F1_BOLD=new Font("Rockwell",Font.BOLD,17);
	private Font F1_PLAIN=new Font("Rockwell",Font.PLAIN,17);
	private  String[] BtnNames_Array= {"Create New Account","Search Account","Transfer Money","Delete Account","Logout"}; 
	private JButton[] Btn_Array=new JButton[BtnNames_Array.length];
	public MenuPanel()
	{
		createComponents();
		setLayoutManager();
		addComponents();
		positionComponents();
	}
	
	private void createComponents() 
	{
		int Btn_X_Start=145,Btn_Y_Start=120,Btn_Width=200,Btn_Height=40;
		int Space_Y_Multiplier=50; // Space between Buttons
		
		Top_Panel=new JPanel();
		Top_Panel_Label=new JLabel("Main Menu");
		Top_Panel_Label.setFont(new Font("Rockwell",Font.BOLD,40));
		Top_Panel_Label.setForeground(Color.white);
		
		for(int i=0;i<BtnNames_Array.length;i++)
		{
			Btn_Array[i]=new JButton(BtnNames_Array[i]);
			Btn_Array[i].setFont(F1_PLAIN);
			Btn_Array[i].setBackground(new Color(70,130,180));
			Btn_Array[i].setForeground(Color.white);
			Btn_Array[i].setBounds(Btn_X_Start, Btn_Y_Start+Space_Y_Multiplier*i, Btn_Width, Btn_Height);
			this.add(Btn_Array[i]);
			Btn_Array[i].addActionListener(this);
		}	
	}
	
	private void addComponents() 
	{
		this.add(Top_Panel);
		Top_Panel.add(Top_Panel_Label);
	}
	
	private void positionComponents() 
	{
		Top_Panel.setBounds(0, 0, 500, 100);
		Top_Panel_Label.setBounds(Top_Panel.getWidth()/2-115,Top_Panel.getY()/2,400,100);
	}
	
	private void setLayoutManager() {
		this.setLayout(null);
		this.setSize(500, 700);
		this.setBackground(new Color(135,206,250));
		Top_Panel.setLayout(null);
		Top_Panel.setSize(500, 200);
		Top_Panel.setBackground(new Color(70,130,180));

	}
	
	@Override
	public void ShowPanel() 
	{
		this.setVisible(true);
		
	}

	@Override
	public void HidePanel() 
	{
		this.setVisible(false);		
	}

	@Override
	public void actionPerformed(ActionEvent ev) 
	{
		if(ev.getSource()==Btn_Array[0])
		{
			Manager.ShowAddNewAccountPage();
		}
		
		else if(ev.getSource()==Btn_Array[1])
		{
			
		}
		
		else if(ev.getSource()==Btn_Array[2])
		{
			
		}
		
		else if(ev.getSource()==Btn_Array[3])
		{
			
		}
		
		else if(ev.getSource()==Btn_Array[4])
		{
			Manager.ShowLoginPage();
		}
	}

}
