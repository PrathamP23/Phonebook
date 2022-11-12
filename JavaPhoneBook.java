import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class JavaPhoneBook {

	private JFrame frame;
	private JTextField txtmobile_1;
	private JTextField txt_name;
	private JTextField txt_dob;
	private JTextField txt_email;
	private JTextField txt_rel;
	private JTextField txt_search;
	private JTable table;
	private JTable table_1;
	private JTextField txt_id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JavaPhoneBook window = new JavaPhoneBook();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public JavaPhoneBook() {
		initialize();
		Connect();
		table_load();
	}

	
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	 
	public void Connect()
	    {
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            con = DriverManager.getConnection("jdbc:mysql://localhost/javaphoebook", "root","");
	        }
	        catch (ClassNotFoundException ex)
	        {
	          ex.printStackTrace();
	        }
	        catch (SQLException ex)
	        {
	            ex.printStackTrace();
	        }
	 
	    }
	
	public void table_load()
    {
     try
     {
    pst = con.prepareStatement("select * from contacts");
    rs = pst.executeQuery();
    table_1.setModel(DbUtils.resultSetToTableModel(rs));
}
     catch (SQLException e)
     {
     e.printStackTrace();
  }
    }
	

	// EDITABLE
	
	public void table_load_using_mobile(String mobile)
    {
     try
     {
    pst = con.prepareStatement("select * from contacts where mobile_no=? ");
    pst.setString(1, mobile);
    rs = pst.executeQuery();
    table_1.setModel(DbUtils.resultSetToTableModel(rs));
}
     catch (SQLException e)
     {
     e.printStackTrace();
  }
    }
	
	public void table_load_using_name(String name)
    {
     try
     {
    pst = con.prepareStatement("select * from contacts where name=? ");
    pst.setString(1, name);
    rs = pst.executeQuery();
    table_1.setModel(DbUtils.resultSetToTableModel(rs));
}
     catch (SQLException e)
     {
     e.printStackTrace();
  }
    }
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 793, 479);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Phone Book");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 40));
		lblNewLabel.setBounds(10, 11, 402, 43);
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(20, 65, 319, 221);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Mobile No:");
		lblNewLabel_1.setFont(new Font("Calibri", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(10, 11, 85, 23);
		panel.add(lblNewLabel_1);
		
		txtmobile_1 = new JTextField();
		txtmobile_1.setFont(new Font("Calibri", Font.BOLD, 17));
		txtmobile_1.setBounds(107, 12, 185, 22);
		panel.add(txtmobile_1);
		txtmobile_1.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Name     :");
		lblNewLabel_1_1.setFont(new Font("Calibri", Font.PLAIN, 17));
		lblNewLabel_1_1.setBounds(10, 45, 85, 23);
		panel.add(lblNewLabel_1_1);
		
		txt_name = new JTextField();
		txt_name.setFont(new Font("Calibri", Font.BOLD, 17));
		txt_name.setColumns(10);
		txt_name.setBounds(107, 46, 185, 22);
		panel.add(txt_name);
		
		JLabel lblNewLabel_1_2 = new JLabel("DOB       :");
		lblNewLabel_1_2.setFont(new Font("Calibri", Font.PLAIN, 17));
		lblNewLabel_1_2.setBounds(10, 79, 85, 23);
		panel.add(lblNewLabel_1_2);
		
		txt_dob = new JTextField();
		txt_dob.setFont(new Font("Calibri", Font.BOLD, 17));
		txt_dob.setColumns(10);
		txt_dob.setBounds(107, 80, 185, 22);
		panel.add(txt_dob);
		
		JLabel lblNewLabel_1_3 = new JLabel("Email ID :");
		lblNewLabel_1_3.setFont(new Font("Calibri", Font.PLAIN, 17));
		lblNewLabel_1_3.setBounds(10, 113, 85, 23);
		panel.add(lblNewLabel_1_3);
		
		txt_email = new JTextField();
		txt_email.setFont(new Font("Calibri", Font.BOLD, 17));
		txt_email.setColumns(10);
		txt_email.setBounds(107, 114, 185, 22);
		panel.add(txt_email);
		
		JLabel lblNewLabel_1_4 = new JLabel("Relation :");
		lblNewLabel_1_4.setFont(new Font("Calibri", Font.PLAIN, 17));
		lblNewLabel_1_4.setBounds(10, 147, 85, 23);
		panel.add(lblNewLabel_1_4);
		
		txt_rel = new JTextField();
		txt_rel.setFont(new Font("Calibri", Font.BOLD, 17));
		txt_rel.setColumns(10);
		txt_rel.setBounds(107, 148, 185, 22);
		panel.add(txt_rel);
		
		JButton btnNewButton = new JButton("ADD NEW");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String mobileno,name,dob,emailID,rel;
				
				mobileno = txtmobile_1.getText();
				name = txt_name.getText();
				dob = txt_dob.getText();
				emailID =txt_email.getText();
				rel = txt_rel.getText();
				try {
					pst = con.prepareStatement("insert into contacts(NAME,MOBILE_NO,DOB,Email, Relation)values(?,?,?,?,?)");
					pst.setString(1, name);
					pst.setString(2, mobileno);
					pst.setString(3, dob);
					pst.setString(4, emailID);
					pst.setString(5, rel);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Contact Saved!!!!!");
					table_load();
					          
					txtmobile_1.setText("");
					txt_name.setText("");
					txt_dob.setText("");
					txt_email.setText("");
					txt_rel.setText("");
					txtmobile_1.requestFocus();
					   }
					 
					catch (SQLException e1)
					        {
					e1.printStackTrace();
					}
				
			}
		});
		btnNewButton.setBounds(20, 187, 89, 23);
		panel.add(btnNewButton);
		
		JButton btnClear = new JButton("CLEAR");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtmobile_1.setText("");
				txt_name.setText("");
				txt_dob.setText("");
				txt_email.setText("");
				txt_rel.setText("");
				txtmobile_1.requestFocus();
			}
		});
		btnClear.setBounds(117, 187, 89, 23);
		panel.add(btnClear);
		
		JButton btnNewButton_1_1 = new JButton("EXIT");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_1_1.setBounds(216, 187, 89, 23);
		panel.add(btnNewButton_1_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Search Tab", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(377, 83, 346, 80);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		txt_search = new JTextField();
		txt_search.setFont(new Font("Calibri", Font.BOLD, 12));
		txt_search.setColumns(10);
		txt_search.setBounds(10, 17, 326, 22);
		panel_1.add(txt_search);
		
		JButton btnMobileNo = new JButton("Mobile No");
		btnMobileNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mobile;
				mobile = txt_search.getText();
				table_load_using_mobile(mobile);
			}
		});
		btnMobileNo.setBounds(34, 46, 140, 23);
		panel_1.add(btnMobileNo);
		
		JButton btnName = new JButton("Name");
		btnName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name;
				name = txt_search.getText();
				table_load_using_name(name);
			}
		});
		btnName.setBounds(184, 46, 133, 23);
		panel_1.add(btnName);
		
		table = new JTable();
		table.setBounds(387, 190, 1, 1);
		frame.getContentPane().add(table);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(376, 190, 346, 213);
		frame.getContentPane().add(scrollPane);
		
		table_1 = new JTable();
		scrollPane.setViewportView(table_1);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Edit/Delete", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1_1.setBounds(10, 306, 332, 57);
		frame.getContentPane().add(panel_1_1);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Person ID");
		lblNewLabel_1_3_1.setFont(new Font("Calibri", Font.BOLD, 14));
		lblNewLabel_1_3_1.setBounds(10, 25, 112, 24);
		panel_1_1.add(lblNewLabel_1_3_1);
		
		txt_id = new JTextField();
		txt_id.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {
			          
		            String id = txt_id.getText();
		 
		                pst = con.prepareStatement("select name,mobile_no,dob,email,relation from contacts where personid = ?");
		                pst.setString(1, id);
		                ResultSet rs = pst.executeQuery();
		 
		            if(rs.next()==true)
		            {
		              
		                String name = rs.getString(1);
		                String mobile = rs.getString(2);
		                String dob = rs.getString(3);
		                String email = rs.getString(4);
		                String relation = rs.getString(5);

		                
		                txt_name.setText(name);
		                txtmobile_1.setText(mobile);
		                txt_dob.setText(dob);
		                txt_email.setText(email);
		                txt_rel.setText(relation);

		                
		                
		            }  
		            else
		            {
			txtmobile_1.setText("");
			txt_name.setText("");
			txt_dob.setText("");
			txt_email.setText("");
			txt_rel.setText("");
			txtmobile_1.requestFocus();
		                
		            }
		            
		 
		 
		        }
		catch (SQLException ex) {
		          
		        }
			}
		});
		txt_id.setColumns(10);
		txt_id.setBounds(132, 27, 177, 20);
		panel_1_1.add(txt_id);
		
		JButton btnUpdate = new JButton("EDIT");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
String mobileno,name,dob,emailID,rel,id;
				
				mobileno = txtmobile_1.getText();
				name = txt_name.getText();
				dob = txt_dob.getText();
				emailID =txt_email.getText();
				rel = txt_rel.getText();
				id  = txt_id.getText();
				try {
				pst = con.prepareStatement("update contacts set name= ?,mobile_no=?,dob=?,relation=?,email=? where personid =?");
				pst.setString(1, name);
				            pst.setString(2, mobileno);
				            pst.setString(3, dob);
				            pst.setString(4, rel);
					    pst.setString(5, emailID);
					    pst.setString(6, id);
				            pst.executeUpdate();
				            JOptionPane.showMessageDialog(null, "Contact Updated!!");
				            table_load();
				          
				           txtmobile_1.setText("");
					   txt_name.setText("");
					   txt_dob.setText("");
					   txt_email.setText("");
					   txt_rel.setText("");
					   txtmobile_1.requestFocus();
				}
				 
				            catch (SQLException e1) {
				e1.printStackTrace();
				}
			}
		});
		btnUpdate.setBounds(72, 380, 89, 23);
		frame.getContentPane().add(btnUpdate);
		
		JButton btnNewButton_1 = new JButton("DELETE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id;
				id  = txt_id.getText();
				try {
				pst = con.prepareStatement("delete from contacts where personid =?");
			
				            pst.setString(1, id);
				            pst.executeUpdate();
				            JOptionPane.showMessageDialog(null, "Record Deleted!!!");
				            table_load();
					txtmobile_1.setText("");
					txt_name.setText("");
					txt_dob.setText("");
					txt_email.setText("");
					txt_rel.setText("");
					txtmobile_1.requestFocus();
				      }
				 
				            catch (SQLException e1) {
				e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(171, 380, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
	}
}
