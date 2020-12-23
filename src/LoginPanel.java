import java.awt.*;
import java.awt.event.*;


import javax.swing.*;

public class LoginPanel extends JPanel implements ViewOnOff, ActionListener
{

	private JPanel TopPanel;
	private JLabel TopPanelLabel,username_label,password_label,Show_Password_Label;
	private JTextField username_input;
	private JPasswordField password_input;
	private JButton Loginbtn,CancelBtn,ForgotPasswordBtn;
	private JCheckBox ShowPasswordChkBox;
	private Font F1_BOLD=new Font("Rockwell",Font.BOLD,17);
	private Font F1_PLAIN=new Font("Rockwell",Font.PLAIN,17);
	
	public LoginPanel()
	{
		createComponents();
		setLayoutManager();
		addComponents();
		positionComponents();
		AddActionEvents();		
	}

	private void AddActionEvents() {
		ForgotPasswordBtn.addActionListener(this);
		Loginbtn.addActionListener(this);
		CancelBtn.addActionListener(this);
		ShowPasswordChkBox.addItemListener(new ItemListener() // Anonymous Inner Class
				{
					@Override
					public void itemStateChanged(ItemEvent e) 
					{
						if(e.getStateChange()==ItemEvent.SELECTED)
						{
							password_input.setEchoChar((char) 0);
						}
						else 
						{
							password_input.setEchoChar('*');
						}					
					}			
				});
		ForgotPasswordBtn.addMouseListener(new MouseAdapter() // Anonymous Inner Class
				{
				@Override
				public void mouseEntered(MouseEvent ev)
				{
					ForgotPasswordBtn.setFont(F1_BOLD);
				}
				
				@Override
				public void mouseExited(MouseEvent ev)
				{
					ForgotPasswordBtn.setFont(F1_PLAIN);
				}
				
				}
				);
	}

	private void positionComponents() 
	{
		TopPanel.setBounds(0,0 ,500 , 100);
		TopPanelLabel.setBounds(TopPanel.getWidth()/2-70,TopPanel.getY()/2,200,100);		
		username_label.setBounds(110, 150, 50, 50);
		username_input.setBounds(username_label.getX()+username_label.getWidth()+10, username_label.getY()+16, 180, 25);
		password_label.setBounds(username_label.getX(), username_label.getY()+username_label.getHeight()+5, 50, 50);
		password_input.setBounds(password_label.getX()+password_label.getWidth()+10, password_label.getY()+18, username_input.getWidth(), username_input.getHeight());
		Loginbtn.setBounds(password_input.getX(),password_input.getY()+40 , (username_input.getWidth()/2)-3, 30);
		CancelBtn.setBounds(Loginbtn.getX()+Loginbtn.getWidth()+2, Loginbtn.getY(), Loginbtn.getWidth()+3, Loginbtn.getHeight());
		ForgotPasswordBtn.setBounds(Loginbtn.getX()-20, Loginbtn.getY()+40, 220, 30);
		ShowPasswordChkBox.setBounds(password_input.getX()+password_input.getWidth()+5, password_input.getY()+3, 20, 20);
		Show_Password_Label.setBounds(ShowPasswordChkBox.getX()+25, ShowPasswordChkBox.getY()-6, 100, 30);
	}

	private void addComponents() {
		this.add(TopPanel);
		this.add(username_label);
		this.add(username_input);
		this.add(password_label);
		this.add(password_input);
		this.add(Loginbtn);
		this.add(CancelBtn);
		this.add(ForgotPasswordBtn);
		this.add(ShowPasswordChkBox);
		this.add(Show_Password_Label);
		TopPanel.add(TopPanelLabel);
		
	}

	private void setLayoutManager() {
		this.setLayout(null);
		this.setSize(500, 700);
		this.setBackground(new Color(135,206,250));
		TopPanel.setLayout(null);
		TopPanel.setSize(500, 200);
		TopPanel.setBackground(new Color(70,130,180));
	}

	private void createComponents() {
		TopPanel=new JPanel();
		TopPanelLabel=new JLabel("Login");
		TopPanelLabel.setFont(new Font("Rockwell",Font.BOLD,45));
		TopPanelLabel.setForeground(Color.white);

		// Icon For The UserName_Label //
		ImageIcon OriginalUI=new ImageIcon("UserNameIcon.png");
		ImageIcon Icon=new ImageIcon(OriginalUI.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH)); 
		username_label=new JLabel(Icon);
		
		// Icon For The Password_Label //
		ImageIcon OriginalPI=new ImageIcon("PasswordIcon.jpg");
		ImageIcon Icon2=new ImageIcon(OriginalPI.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH)); 
		password_label=new JLabel(Icon2);
		
		username_input=new JTextField(20);
		password_input=new JPasswordField(20);
		password_input.setEchoChar('*');
		password_input.setForeground(Color.black);
		
		Loginbtn=new JButton("Login");
		Loginbtn.setFont(F1_PLAIN);
		Loginbtn.setBackground(new Color(70,130,180));
		Loginbtn.setForeground(Color.white);
		
		CancelBtn=new JButton("Cancel");
		CancelBtn.setFont(F1_PLAIN);
		CancelBtn.setBackground(new Color(70,130,180));
		CancelBtn.setForeground(Color.white);
		
		ForgotPasswordBtn=new JButton("Forgot Password?");
		ForgotPasswordBtn.setFont(F1_PLAIN);
		ForgotPasswordBtn.setForeground(Color.white);
		ForgotPasswordBtn.setOpaque(false);
		ForgotPasswordBtn.setContentAreaFilled(false);
		ForgotPasswordBtn.setBorderPainted(false);
		
		Show_Password_Label=new JLabel("Show Password");
		Show_Password_Label.setFont(new Font("Rockwell",Font.PLAIN,14));
		Show_Password_Label.setForeground(Color.white);
		Show_Password_Label.setOpaque(false);
		
		ShowPasswordChkBox=new JCheckBox();
		ShowPasswordChkBox.setOpaque(false);
		

	}

	@Override
	public void ShowPanel() {
		this.setVisible(true);		
	}

	@Override
	public void HidePanel() {
		this.setVisible(false);
		
	}
	
	public void ClearFields()
	{
		this.username_input.setText("");
		this.password_input.setText("");
	}
	
	public String GetUserName()
	{
		return username_input.getText();
	}
	
	public String GetPassword()
	{
		return String.valueOf(password_input.getPassword());
	}
	
	@Override
	public void actionPerformed(ActionEvent ev) {
		
		String Command=ev.getActionCommand();
		if(ev.getSource()==Loginbtn)
		{
			Manager.ValidateEntry();
			
		}
		
		else if(ev.getSource()==CancelBtn)
		{
			Manager.CloseProgram();
		}
		
		else if(ev.getSource()==ForgotPasswordBtn)
		{
			 UIManager.put("OptionPane.background",new Color(135,206,250));
			 UIManager.put("Panel.background", new Color(70,130,180));
			 JLabel Label=new JLabel("Please Email to razgimi@gmail.com to restore password");
			 Label.setFont(new Font("Rockwell",Font.PLAIN,16));
			 Label.setForeground(Color.white);
			 JOptionPane.showMessageDialog(null,Label ,"Restore Password",JOptionPane.WARNING_MESSAGE);
		}						
	}
}
