import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class main extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main frame = new main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(this);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblEnterName = new JLabel("username");
		
		JLabel lblPassword = new JLabel("password");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				String usertype="";
				String s1=textField.getText();
				String s2=textField_1.getText();
				/*String s2=String.copyValueOf(ch);//password*/
				String query="select * from main where username=? and password=?";
				Connection con=DBInfo.con;
				int i=0;
				try
				{
			      PreparedStatement ps=con.prepareStatement(query);
			      ps.setString(1, s1);ps.setString(2, s2);
			      ResultSet res=ps.executeQuery();
			      while(res.next())
			      {
			    	  
			    	  i=1;
			    	  usertype=res.getString(3);
			    	  
			    	  break;
			    	  
			      }
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				if(i==1 && usertype.equalsIgnoreCase("patient"))
				{
			            Login ad=new Login();
			            ad.setVisible(true);
			            dispose();
				}
				if(i==1 && usertype.equalsIgnoreCase("admin"))
				{
					admins ss=new admins();
					ss.setVisible(true);
					dispose();
				}
				
				if(i==0)
				{
			JOptionPane.showMessageDialog(getParent(),"Wrong username or password!","Error",JOptionPane.ERROR_MESSAGE);		
				}
				
			}	
			}	);
		
		JLabel lblWelcome = new JLabel("Welcome ");
		
		JButton btnBack = new JButton(new ImageIcon("C:\\Users\\Ayush\\Desktop\\images (4).jpg"));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				login1 s=new login1();
				s.setVisible(true);
			}
		});
		
		JLabel lblWelcome_1 = new JLabel("Welcome");
		lblWelcome_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JButton btnNewButton = new JButton("Sign Up\r\n");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				dispose();
				sign ad=new sign();
				ad.setVisible(true);
			}
		});
		
		JLabel lblEnterYourUsername = new JLabel("Enter Your Username And Password");
		lblEnterYourUsername.setFont(new Font("Viner Hand ITC", Font.PLAIN, 20));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
					.addGap(90)
					.addComponent(lblWelcome_1)
					.addGap(283)
					.addComponent(lblWelcome, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(62)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblPassword, GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
							.addGap(355))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblEnterName, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(textField_1, Alignment.LEADING, 113, 113, 113)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE))
							.addGap(333)))
					.addGap(71))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(55)
					.addComponent(lblEnterYourUsername)
					.addContainerGap(275, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(57)
					.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(314, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblWelcome)
						.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblWelcome_1))
					.addGap(18)
					.addComponent(lblEnterYourUsername)
					.addGap(34)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEnterName, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnLogin))
					.addContainerGap(29, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
