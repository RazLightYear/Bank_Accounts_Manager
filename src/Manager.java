import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;

import javax.swing.*;

public class Manager extends JFrame
{
	private static LoginPanel loginPanel;
	private static MenuPanel menuPanel;
	private static AddNewAccountPanel newAccountPanel;

	public Manager()
	{
		createPanels();
		addPanels();
		startProgram();
		setGeneralFrameSettings();
		
	}
	
	private void setGeneralFrameSettings() 
	{
		this.setSize(500, 700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		this.setVisible(true);
		
	}

	private void startProgram() 
	{
		loginPanel.ShowPanel();
		menuPanel.HidePanel();
		newAccountPanel.HidePanel();
		
	}

	private void addPanels() 
	{
		this.add(menuPanel);
		this.add(newAccountPanel);
		this.add(loginPanel);		
		
		
	}

	private void createPanels() 
	{
		this.loginPanel=new LoginPanel();	
		this.menuPanel=new MenuPanel();
		this.newAccountPanel=new AddNewAccountPanel();
	}
	
	public static void ShowLoginPage()
	{
		menuPanel.HidePanel();
		loginPanel.ShowPanel();
	
		
	}
	public static void ShowMainMenu()
	{
		newAccountPanel.HidePanel();
		loginPanel.HidePanel();
		menuPanel.ShowPanel();
		
	}

	public static void CloseProgram() 
	{
		System.exit(0);		
	}

	public static void ShowAddNewAccountPage()
	{
		menuPanel.HidePanel();
		newAccountPanel.ShowPanel();
	}
	
	public static void ValidateEntry() 
	{
		boolean answer=Validation.CheckUsernamePassword(loginPanel.GetUserName(),loginPanel.GetPassword());
		if(Validation.CheckUsernamePassword(loginPanel.GetUserName(),loginPanel.GetPassword()))
		{
			ShowMainMenu();
			loginPanel.ClearFields();
		}
		else
		{
			ShowMessege("Cannot Match UserName And Password. Please Check Your Input Again","ERROR",loginPanel);
		}
		
	}
	
	public static void ShowMessege(String Messege,String Message_Type,JPanel ParentPanel) 
	{
		if(Message_Type.equals("ERROR"))
		{
			JOptionPane.showMessageDialog(ParentPanel, Messege, "Attention", JOptionPane.WARNING_MESSAGE);
		}
		else
		{
			JOptionPane.showMessageDialog(ParentPanel, Messege, "Attention", JOptionPane.PLAIN_MESSAGE);
		}
		
	}
	
	public static void main(String[] args) 
	{
		Manager obj=new Manager();

	}

	public static void CreateAccount(String[] fields_Contents) 
	{

	}

}
