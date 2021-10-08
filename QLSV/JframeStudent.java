package QLSV;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.table.DefaultTableModel;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class JframeStudent extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtMajor;
	private JTextField txtAge;
	private JTextField txtScore;
	private static JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JframeStudent frame = new JframeStudent();
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
	public JframeStudent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 648, 457);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Student Managerment");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblNewLabel.setBounds(157, 11, 277, 55);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Major");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(27, 117, 55, 28);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Age");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1.setBounds(238, 69, 55, 28);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Name");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_2.setBounds(27, 69, 55, 28);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Score");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_3.setBounds(238, 117, 55, 28);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Gender");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_4.setBounds(444, 69, 55, 28);
		contentPane.add(lblNewLabel_1_4);
		
		txtName = new JTextField();
		txtName.setBounds(92, 70, 121, 28);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		txtMajor = new JTextField();
		txtMajor.setColumns(10);
		txtMajor.setBounds(92, 118, 121, 28);
		contentPane.add(txtMajor);
		
		txtAge = new JTextField();
		txtAge.setColumns(10);
		txtAge.setBounds(303, 70, 121, 28);
		contentPane.add(txtAge);
		
		txtScore = new JTextField();
		txtScore.setColumns(10);
		txtScore.setBounds(303, 118, 121, 28);
		contentPane.add(txtScore);
		
		JComboBox cbGender = new JComboBox();
		cbGender.setFont(new Font("Tahoma", Font.BOLD, 14));
		cbGender.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		cbGender.setBounds(517, 69, 93, 28);
		contentPane.add(cbGender);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Student st=new Student();
				st.setName(txtName.getText());
				st.setAge(Integer.parseInt(txtAge.getText()));
				st.setGender(cbGender.getSelectedIndex());
				st.setMajor(txtMajor.getText());
				st.setScore(Float.parseFloat(txtScore.getText()));
				ConnJDBC.insert(st);
				JOptionPane.showMessageDialog(null, "Save Success! ");
				showData(ConnJDBC.findAll());
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(517, 118, 93, 28);
		contentPane.add(btnNewButton);
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtName.setText("");
				txtAge.setText("");
				txtMajor.setText("");
				txtScore.setText("");
			}
		});
		btnRefresh.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRefresh.setBounds(27, 379, 93, 28);
		contentPane.add(btnRefresh);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Student st=new Student();
				st.setName(txtName.getText());
				st.setAge(Integer.parseInt(txtAge.getText()));
				st.setGender(cbGender.getSelectedIndex());
				st.setMajor(txtMajor.getText());
				st.setScore(Float.parseFloat(txtScore.getText()));
				ConnJDBC.Update(st);
				JOptionPane.showMessageDialog(null, "Save Success! ");
				showData(ConnJDBC.findAll());
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnUpdate.setBounds(185, 379, 93, 28);
		contentPane.add(btnUpdate);
		
		JButton btnFind = new JButton("Find");
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Student st =new Student();
				st.setName(txtName.getText());
				showData(ConnJDBC.findByName(st));
			}
		});
		btnFind.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnFind.setBounds(361, 379, 93, 28);
		contentPane.add(btnFind);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Student st=new Student();
				st.setName(txtName.getText());
				ConnJDBC.delete(st);
				showData(ConnJDBC.findAll());
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDelete.setBounds(517, 379, 93, 28);
		contentPane.add(btnDelete);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 156, 583, 212);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"ID", "Name", "Age", "Gender", "Major", "Score"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		table.getColumnModel().getColumn(0).setMinWidth(30);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setMinWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(30);
		table.getColumnModel().getColumn(2).setMinWidth(30);
		table.getColumnModel().getColumn(3).setPreferredWidth(60);
		table.getColumnModel().getColumn(3).setMinWidth(60);
		table.getColumnModel().getColumn(4).setPreferredWidth(100);
		table.getColumnModel().getColumn(4).setMinWidth(100);
		table.getColumnModel().getColumn(5).setMinWidth(50);
		scrollPane.setViewportView(table);
		showData(ConnJDBC.findAll());
	}
	public void showData(List<Student>studentl) {
		List<Student>listStudent=new ArrayList<>();
		listStudent=studentl;
		DefaultTableModel tableModel;
	    table.getModel();
	    tableModel=(DefaultTableModel)table.getModel();
	    tableModel.setRowCount(0);
	    listStudent.forEach((student) -> { 
	    	String gender;
	    	if(student.getGender()==0)gender="Male";
	    	else {gender="Female";}
	    	tableModel.addRow(new Object [] {
	    		student.getId(),student.getName(),student.getAge(),
	    		gender,student.getMajor(),student.getScore()
	    	});
	    });
	    }
}
