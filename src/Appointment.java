import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;

public class Appointment extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
     
	/**
	 * Launch the application.
	 */
	String date;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Appointment frame = new Appointment("");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public String getappointmentId()
	{
		String id="";
		for(int i=1;i<=3;i++)
		{
			id+=(int)(Math.random()*9)+1;
			//System.out.println(id);
		}
		return id;
	}

	/**
	 * Create the frame.
	 */
	public Appointment(String name) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 571, 395);
		setLocationRelativeTo(this);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setForeground(SystemColor.activeCaptionText);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblAppointmentid = new JLabel("Appointment_id");
		
		JLabel lblCategory = new JLabel("Category");
		
		JLabel lblDate = new JLabel("Date");
		
		textField = new JTextField(getappointmentId());
		textField.setEditable(false);
		
		
		
		textField.setColumns(10);
		
		
		JComboBox comboBox_1 = new JComboBox(DBInfo.getCategory());
       comboBox_1.insertItemAt("select",0);
        comboBox_1.setSelectedIndex(0);
        
		String w=(String)comboBox_1.getSelectedItem();
		/*comboBox.insertItemAt("select",0);
        comboBox.setSelectedIndex(0);*/
		
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.insertItemAt("dd", 0);
		comboBox_2.setSelectedIndex(0);
		comboBox_2.insertItemAt("1", 0);
		comboBox_2.insertItemAt("2", 1);
		comboBox_2.insertItemAt("3", 2);
		comboBox_2.insertItemAt("4", 3);
		comboBox_2.insertItemAt("5", 4);comboBox_2.insertItemAt("6", 5);comboBox_2.insertItemAt("7", 6);comboBox_2.insertItemAt("8", 7);
		
		comboBox_2.insertItemAt("9", 8);comboBox_2.insertItemAt("10", 9);comboBox_2.insertItemAt("11", 10);comboBox_2.insertItemAt("12", 11);
		comboBox_2.insertItemAt("13", 12);comboBox_2.insertItemAt("14", 13);comboBox_2.insertItemAt("15", 14);comboBox_2.insertItemAt("16", 15);
		comboBox_2.insertItemAt("17", 0);comboBox_2.insertItemAt("18", 0);comboBox_2.insertItemAt("19", 0);comboBox_2.insertItemAt("20", 0);
		comboBox_2.insertItemAt("21",16);comboBox_2.insertItemAt("22", 17);comboBox_2.insertItemAt("23", 18);comboBox_2.insertItemAt("24", 19);
		comboBox_2.insertItemAt("25", 20);comboBox_2.insertItemAt("26", 21);comboBox_2.insertItemAt("27", 22);comboBox_2.insertItemAt("28", 23);
		comboBox_2.insertItemAt("29", 28);comboBox_2.insertItemAt("30", 29);comboBox_2.insertItemAt("31", 30);
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.insertItemAt("mm", 0);
		comboBox_3.setSelectedIndex(0);
		comboBox_3.insertItemAt("1", 0);
		comboBox_3.insertItemAt("2", 1);
		comboBox_3.insertItemAt("3", 2);
		comboBox_3.insertItemAt("4", 3);
		comboBox_3.insertItemAt("5", 4);comboBox_3.insertItemAt("6", 5);comboBox_3.insertItemAt("7", 6);comboBox_3.insertItemAt("8", 7);
		
		comboBox_3.insertItemAt("9", 8);comboBox_3.insertItemAt("10", 9);comboBox_3.insertItemAt("11", 10);comboBox_3.insertItemAt("12", 11);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.insertItemAt("yyyy", 0);
		comboBox_4.setSelectedIndex(0);
		comboBox_4.insertItemAt("2016", 0);
		String s1=(String)comboBox_2.getSelectedItem();
		String s2=(String)comboBox_3.getSelectedItem();
		String s3=(String)comboBox_4.getSelectedItem();
		String s4=(String)comboBox_4.getSelectedItem();
		JButton btnCheck = new JButton("Check");
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				String id=textField.getText();
				String category=(String)comboBox_1.getSelectedItem();
				String s1=(String)comboBox_2.getSelectedItem();
				String s2=(String)comboBox_3.getSelectedItem();
				String s3=(String)comboBox_4.getSelectedItem();
                 String date=s1+"/"+s2+"/"+s3;
                 if(id.length()==0||category.equalsIgnoreCase("select") || date.equalsIgnoreCase("select"))
				  {
					  JOptionPane.showMessageDialog(Appointment.this, "Pls fill/select all the fields", "Error", JOptionPane.ERROR_MESSAGE);				  
				  }
                 else
                 {
                	 dispose();
                 new fixa(id,category,date,name).setVisible(true);
                 }
                 
                 /*
				System.out.println(date);*/
				
				

				/*String Appointment_id=textField.getText();
				  
				  String Doctor=(String)comboBox.getSelectedItem();
				  String Category=(String)comboBox_1.getSelectedItem();
				  String Date=(String)comboBox_2.getSelectedItem();
				  String Time=(String)comboBox_5.getSelectedItem();
				  
				  if(Appointment_id.length()==0||Doctor.equalsIgnoreCase("select") || Category.equalsIgnoreCase("select") || Date.equalsIgnoreCase("select") || Time.equalsIgnoreCase("select"))
				  {
					  JOptionPane.showMessageDialog(Appointment.this, "Pls fill/select all the fields", "Error", JOptionPane.ERROR_MESSAGE);				  
				  }
				  else
				  {
					  
				
				  String query="insert into Appointment values(?,?,?,?)";
				  int flag=0;
				  Connection con=DBInfo.con;
				  try
				  {
					 PreparedStatement ps=con.prepareStatement(query);
					 ps.setString(1, Appointment_id);
					 ps.setString(2, Doctor);
					 ps.setString(3, Category);
					 ps.setString(4, Date);
					 ps.setString(5, Time);
					flag=ps.executeUpdate();
					 
				  }
				  catch(Exception e)
				  {
					  e.printStackTrace();
				  }
				  if(flag==1)
				  {
					  JOptionPane.showMessageDialog(Appointment.this, "Book Added", "Added", JOptionPane.INFORMATION_MESSAGE);
				      
				      comboBox.setSelectedIndex(0);
				      comboBox_1.setSelectedIndex(0);
				      comboBox_2.setSelectedIndex(0);
				      comboBox_3.setSelectedIndex(0);
				      
				      
				  }
				  else
				  {
					  JOptionPane.showMessageDialog(Appointment.this, "Book Not Added", "Error", JOptionPane.ERROR_MESSAGE);
				  }
				  }*/
				}
             
		});
		
		JButton btnCancelAppointmnet = new JButton("Cancel Appointment");
		btnCancelAppointmnet.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JButton btnDoctorDetail = new JButton("Details\r\n");
		btnDoctorDetail.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnDoctorDetail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
			
				open x=new open();
				x.setVisible(true);
			 dispose();
			}
		});
		
		JButton btnFeedback = new JButton("Feedback");
		btnFeedback.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnFeedback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				dispose();
				feedback a=new feedback();
				a.setVisible(true);
			}
		});
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				dispose();
				login1 a=new login1();
				a.setVisible(true);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(116)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblCategory)
								.addComponent(lblDate)
								.addComponent(lblAppointmentid)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(21)
							.addComponent(btnCancelAppointmnet, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)))
					.addGap(17)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnCheck)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnDoctorDetail)
							.addGap(14)
							.addComponent(btnFeedback)
							.addGap(18)
							.addComponent(btnLogout))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(comboBox_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(comboBox_4, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(textField, Alignment.LEADING)
							.addComponent(comboBox_1, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addGap(15))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnFeedback)
							.addComponent(btnLogout))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnCancelAppointmnet)
							.addComponent(btnDoctorDetail)))
					.addGap(94)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAppointmentid)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCategory)
						.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDate)
						.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnCheck)
					.addContainerGap(75, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
