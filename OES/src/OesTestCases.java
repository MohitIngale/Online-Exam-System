import static org.junit.Assert.*;

import javax.swing.*;
import java.awt.event.*;

import org.junit.Test;

import admin.AdminPanel;
import login.LoginPanel;
import main.*;
import user.*;

public class OesTestCases extends JFrame {
	
	MainFrame mf;

	@Test //UserButton in LoginPanel
	public void test1() throws InterruptedException {
		mf = new MainFrame();
		mf.main(new String[] {});
		
		LoginPanel lp = new LoginPanel();
		lp.setVisible(true);
		
		lp.btnUser.doClick();
		Thread.sleep(3000);
		lp.btnUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainFrame.AddPanel(new UserLogin());
				assertTrue(true);
			}
		});
	}
	
	//AdminButton in LoginPanel
	@Test
	public void test2() throws InterruptedException {
		mf = new MainFrame();
		mf.main(new String[] {});
		
		LoginPanel lp = new LoginPanel();
		lp.setVisible(true);
		
		lp.btnAdmin.doClick();
		Thread.sleep(3000);
		lp.btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainFrame.AddPanel(new AdminPanel());
				assertTrue(true);
			}
		});
	}
	
	//UserLogin 
	@Test
	public void test3() throws InterruptedException {
		mf = new MainFrame();
		mf.main(new String[] {});
		
		UserLogin ul = new UserLogin();
		ul.setVisible(true);
		Thread.sleep(2000);
		
		String uname = "xyz";
		String pass = "xyz";
		ul.txtUsername.setText(uname);
		ul.add(ul.txtUsername);
		Thread.sleep(5000);
		ul.txtPassword.setText(pass);
		ul.add(ul.txtPassword);
		Thread.sleep(2000);
		
		assertEquals("abc",ul.txtUsername.getText());
		assertEquals("abc",ul.txtPassword.getPassword());
	}
	
	//UserLogin- correct
		@Test
		public void test4() throws InterruptedException {
			mf = new MainFrame();
			mf.main(new String[] {});
			
			UserLogin ul = new UserLogin();
			ul.setVisible(true);
			Thread.sleep(1000);
			
			String uname = "abc";
			String pass = "abc";
			ul.txtUsername.setText("abc");
			ul.add(ul.txtUsername);
			//Thread.sleep(2000);
			ul.txtPassword.setText("abc");
			ul.add(ul.txtPassword);
			Thread.sleep(2000);
			
			assertEquals("abc",ul.txtUsername.getText());
			assertEquals("abc",ul.txtPassword.getText());
		}
		
		//UserLogin - login
		@Test
		public void test5() throws InterruptedException {
			mf = new MainFrame();
			mf.main(new String[] {});
			
			UserLogin ul = new UserLogin();
			ul.setVisible(true);
			
			ul.btnLogin.doClick();
			Thread.sleep(2000);
			ul.btnLogin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					MainFrame.AddPanel(new UserPanel("abc"));
					assertTrue(true);
				}
			});

		}

}
