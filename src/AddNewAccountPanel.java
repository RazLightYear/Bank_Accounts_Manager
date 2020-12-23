import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

import javax.swing.*;

public class AddNewAccountPanel extends JPanel implements ViewOnOff, ActionListener
{
	private JPanel Top_panel_Head;
	private JLabel Top_Panel_Label,Generated_Accnt_Num_Label,Generated_PIN_Num_Label;	
	private  String[] LabelsNames_Array= {"ID No.:",
										"First Name:",
										"Last Name:",
										"Date Of Birth:",
										"Gender:",
										"Address:",
										"Phone:",
										"Email:"}; 
	private JLabel[] Labels_Array=new JLabel[LabelsNames_Array.length];
	private JTextField[] Text_Fields_Array=new JTextField[Labels_Array.length];
	private  String[] BtnNames_Array= {"Finish","Cancel"}; 
	private JButton[] Btn_Array=new JButton[BtnNames_Array.length];
	
	private String[] regex={"\\d{9}",
							"([A-Z][a-z]+\\s*)+",
							"([A-Z][a-z]+\\s?|[A-Z][a-z]+['-]?)+",
							"^((0[1-9]|1[0-9]|2[0-8])/02/((19|2[0-9])[0-9]{2}))$"
							+ "|^((0[1-9]|[12][0-9]|3[01])/(0[13578]|10|12)/((19|2[0-9])[0-9]{2}))$"
							+ "|^((0[1-9]|[12][0-9]|30)/(0[469]|11)/((19|2[0-9])[0-9]{2}))$"
							+ "|^(29/02/(2000|2400|2800|(19|2[0-9](0[48]|[2468][048]|[13579][26]))))$",
							"Male|Female|None",
							"(([A-Z][a-z]+\\s*)+\\d+,([A-Z][a-z]+\\s*)+)|(([A-Z][a-z]+\\s*)+\\d+/\\d+,([A-Z][a-z]+\\s*)+)",
							"05[0|2-5]-[0-9]{3}-[0-9]{4}",
							"([A-Za-z]+@[A-Za-z]+.com)|([A-Za-z]+@[A-Za-z]+.ac.il)"}; // {ID, FirstName,LastName,DateOfBirth,Gender,Address,Phone,Email //
	
	private Font F1_PLAIN=new Font("Rockwell",Font.PLAIN,18);
	private Color TOP_BLUE=new Color(70,130,180);
	private Color BACKGROUND_BLUE=new Color(135,206,250);
	public AddNewAccountPanel()
	{
		createComponents();
		setLayoutManager();
		addComponents();
		positionComponents();
	}
	
	private void createComponents() 
	{
		this.Top_panel_Head=new JPanel();
		Top_Panel_Label=new JLabel("Add New Account");
		Top_Panel_Label.setFont(new Font("Rockwell",Font.BOLD,40));
		Top_Panel_Label.setForeground(Color.white);		
		CreateButtons();
		CreateLabels();			
	}

	private void CreateLabels() 
	{
		int Lbl_X_Start_First_row=60,Lbl_Y_Start_First_Row=120,Lbl_Width=120,Lbl_Height=20;
		int Lbl_X_Start_Second_row=270;
		int Space_Y_Multiplier=70; // Space between Buttons
		int Multiplier_Index1=0;
		int Multiplier_Index2=0;
		for(int i=0;i<LabelsNames_Array.length;i++)
		{
			Labels_Array[i]=new JLabel(LabelsNames_Array[i]);
			Text_Fields_Array[i]=new JTextField();
			Labels_Array[i].setFont(F1_PLAIN);
			Labels_Array[i].setForeground(Color.white);
			
			if(i%2==0)
			{
				Labels_Array[i].setBounds(Lbl_X_Start_First_row, Lbl_Y_Start_First_Row+Space_Y_Multiplier*Multiplier_Index1, Lbl_Width, Lbl_Height);
				Multiplier_Index1++;
			}
			else
			{
				Labels_Array[i].setBounds(Lbl_X_Start_Second_row, Lbl_Y_Start_First_Row+Space_Y_Multiplier*Multiplier_Index2, Lbl_Width, Lbl_Height);
				Multiplier_Index2++;
			}
			Text_Fields_Array[i].setBounds(Labels_Array[i].getX(), Labels_Array[i].getY()+Labels_Array[i].getHeight()+5, 150, 25);
			this.add(Labels_Array[i]);
			this.add(Text_Fields_Array[i]);		
		}	
		Generated_Accnt_Num_Label = new JLabel("Account Number: ");
		Generated_Accnt_Num_Label.setFont(F1_PLAIN);
		Generated_Accnt_Num_Label.setForeground(Color.white);
		Generated_Accnt_Num_Label.setVisible(false);
		Generated_PIN_Num_Label=new JLabel("PIN Number: ");
		Generated_PIN_Num_Label.setFont(F1_PLAIN);
		Generated_PIN_Num_Label.setForeground(Color.white);
		Generated_PIN_Num_Label.setVisible(false);
	}

	private void CreateButtons() 
	{
		int Btn_X_Start=130,Btn_Y_Start=460,Btn_Width=110,Btn_Height=30;
		for(int i=0;i<BtnNames_Array.length;i++) 
		{
			Btn_Array[i]=new JButton(BtnNames_Array[i]);
			Btn_Array[i].setFont(F1_PLAIN);
			Btn_Array[i].setBackground(TOP_BLUE);
			Btn_Array[i].setForeground(Color.white);
			Btn_Array[i].setBounds(Btn_X_Start+Btn_X_Start*i, Btn_Y_Start, Btn_Width, Btn_Height);
			Btn_Array[i].addActionListener(this);
			this.add(Btn_Array[i]);
		}		
	}

	private void setLayoutManager() {
		this.setLayout(null);
		this.setSize(500, 700);
		this.setBackground(BACKGROUND_BLUE);
		this.Top_panel_Head.setLayout(null);
		this.Top_panel_Head.setSize(500, 200);
		this.Top_panel_Head.setBackground(TOP_BLUE);		
	}

	private void addComponents() {
		this.add(Top_panel_Head);
		this.Top_panel_Head.add(Top_Panel_Label);
		this.add(Generated_Accnt_Num_Label);
		this.add(Generated_PIN_Num_Label);
	}

	private void positionComponents() {
		Top_panel_Head.setBounds(0, 0, 500, 100);
		Top_Panel_Label.setBounds(Top_panel_Head.getWidth()/2-176,Top_panel_Head.getY()/2,400,100);
		Generated_Accnt_Num_Label.setBounds(60, 510, 200, 30);
		Generated_PIN_Num_Label.setBounds(60, 560, 200, 30);
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

	public String GetFirstName()
	{
		return null;		
	}
	
	public void ClearFields()
	{
		for(int i=0;i<Text_Fields_Array.length;i++)
		{
			Text_Fields_Array[i].setText("");
		}
		Generated_Accnt_Num_Label.setVisible(false);
		Generated_PIN_Num_Label.setVisible(false);
	}
	
	@Override
	public void actionPerformed(ActionEvent ev) 
	{
		if(ev.getSource()==Btn_Array[0]) // "Finish Button"
		{
			if(ValidateFields())
			{
				String [] Fields_Contents=new String[Text_Fields_Array.length];
				
				for(int i=0;i<Text_Fields_Array.length;i++)
				{
					Fields_Contents[i]=Text_Fields_Array[i].getText();
				}
				Manager.CreateAccount(Fields_Contents);
			}
		}
		
		else if(ev.getSource()==Btn_Array[1]) // "Cancel Button"
		{
			ClearFields();
			Manager.ShowMainMenu();
		}
	}
	
	
	


	private boolean ValidateFields() 
	{
		boolean[] Fields_Answers=new boolean[Text_Fields_Array.length]; // Array of boolean flags to know if all the text fields are validated correctly
		for(int i=0;i<Text_Fields_Array.length;i++)
		{
			if(!(Text_Fields_Array[i].getText().matches(regex[i])))
			{
				Labels_Array[i].setForeground(Color.red);
				Fields_Answers[i]=false;
			}
			else
			{
				Labels_Array[i].setForeground(Color.white);
				Fields_Answers[i]=true;
			}
		}
		for(int i=0;i<Fields_Answers.length;i++)
		{			
			if(!Fields_Answers[i])
			{
				return false;
			}
		}
		return true;
	}	
}
