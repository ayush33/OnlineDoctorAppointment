import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.awt.Color;
public class fixa extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
    String fees="";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					fixa frame = new fixa(null,null,null,"");
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
	public fixa(String s,String s1,String s2,String name) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(this);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblDoctor = new JLabel("doctor ");
		
		JComboBox comboBox = new JComboBox(DBInfo.getDoctor(s1));
		
		JLabel lblFees = new JLabel("fees");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JButton btnFixAppointment = new JButton("Fix appointment");
		btnFixAppointment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				int flag=0;
				String doctor=(String)comboBox.getSelectedItem();
				String query="insert into appointment values(?,?,?,?,?)";
				
				Connection con=(Connection) DBInfo.con;
				try
				{
					java.sql.PreparedStatement ps=con.prepareStatement(query);
					
					
					ps.setString(1,s);
					ps.setString(2,doctor);
					ps.setString(3,s1);
					ps.setString(4,s2);
					ps.setInt(5, 1);
					
					flag=ps.executeUpdate();
					
					
					
					if(flag==1)
					{
						JOptionPane.showMessageDialog(getParent(), "Appointment Fixed","Success",JOptionPane.INFORMATION_MESSAGE);
					}
					else
					{
						JOptionPane.showMessageDialog(getParent(), "Appointment Not Fixed","Failed",JOptionPane.ERROR_MESSAGE);
					}
					dispose();
					details b=new details(name,fees,doctor);
					b.setVisible(true);
  
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			
		});
		
		JButton btnAddFees = new JButton("ADD FEES");
		btnAddFees.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				
				String query="select * from doctor where Name =?";
				String doctor=(String)comboBox.getSelectedItem();
				java.sql.Connection con= DBInfo.con;
				try
				{     
			
				
				     	java.sql.PreparedStatement ps= con.prepareStatement(query);
						ps.setString(1,doctor);
						
					   try{
						java.sql.ResultSet rs=ps.executeQuery();
						while(rs.next())
						{
						 fees=rs.getString(3);
						}
					   }
					   catch(SQLException z)
					   {
						   z.printStackTrace();
					   }
					   
					   textField.setText(fees);
					   textField.setEditable(false);
				}	
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(54)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnFixAppointment)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblFees)
								.addComponent(lblDoctor))
							.addGap(44)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnAddFees))))
					.addContainerGap(206, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(62)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDoctor)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addComponent(btnAddFees)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFees)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
					.addComponent(btnFixAppointment)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
}
