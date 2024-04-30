package Demo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class QL_Ns extends JFrame {
	static Connection com;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable table;
	List<Nv> Nvs = new ArrayList<Nv>(); 
	/**
	 * Launch the application.
	 * @throws SQLException 
	 * 
	 */
	public static void save(Nv nv)
	{
		String sql = "insert into nv(manv,name,sdt,email)"
				+ "values('"+nv.getMasv()+"','"+nv.getName()+"','"+nv.getSdt()+"','"+nv.getEmail()+"')";
		PreparedStatement ttm;
		try {
			ttm = com.prepareStatement(sql);
			ttm.execute();
			System.out.println("thanh cong");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		try {
			//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Class.forName("org.postgresql.Driver");
//			String url = "jdbc:sqlserver://MSI\\SQLEXPRESS:1433;databasename=ns";
//			String pass = "123";
//			String name = "sa";
			String url = "jdbc:postgresql://localhost:5432/nv";
			String pass ="123456789 ";
			String name = "postgres";
			try {
				com = DriverManager.getConnection(url, name, pass);
				System.out.println("thanh cong");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QL_Ns frame = new QL_Ns();
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
	public void LoadData()
	{
		DefaultTableModel dm = (DefaultTableModel) table.getModel();
		dm.setRowCount(0);
		Object[] ob = new Object[6];
		int i =1 ;
		for (Nv obb : Nvs) {
			ob[0] = i;
			ob[1] = obb.getMasv();
			ob[2] = obb.getName();
			ob[3] = obb.getSdt();
			ob[4] = obb.getEmail();
			ob[5] = " ";
			dm.addRow(ob);
			i++;
		}
	}
	public QL_Ns() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1034, 619);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(30, 24, 946, 548);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ma Nv :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(53, 49, 81, 31);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(144, 49, 206, 31);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Số ĐT :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(450, 49, 81, 31);
		panel.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_1.setBounds(541, 49, 206, 31);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_2.setBounds(144, 107, 206, 31);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_3.setBounds(541, 107, 206, 31);
		panel.add(textField_3);
		
		JLabel lblNewLabel_1_1 = new JLabel("Email :");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(450, 107, 81, 31);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Họ Và Tên :");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_2.setBounds(53, 107, 81, 31);
		panel.add(lblNewLabel_1_2);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String manv = textField.getText();
				String sodt = textField_1.getText();
				String hovaten = textField_2.getText();
				String email = textField_3.getText();
				Nv nv = new Nv(manv, hovaten, sodt, email);
				System.out.println(sodt);
				Nvs.add(nv);
				LoadData();
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField.requestFocus();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(144, 181, 115, 31);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Delete");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String manv = textField.getText();
				String sodt = textField_1.getText();
				String hovaten = textField_2.getText();
				String email = textField_3.getText();
				Nv nv = new Nv(manv, hovaten, sodt, email);
				Nv n =new Nv();
				Boolean b = false;
				for (Nv nv2 : Nvs) {
					if(
						nv2.getMasv().compareTo(manv) ==0 &&
						nv2.getName().compareTo(hovaten) ==0 &&
						nv2.getSdt().compareTo(sodt) ==0 &&
						nv2.getEmail().compareTo(email) ==0
					 )
					{
						b = true;
						n = nv2;
					}
				}
				if(b)
				{
					Nvs.remove(n);
				}
				LoadData();
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField.requestFocus();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_1.setBounds(341, 181, 115, 31);
		panel.add(btnNewButton_1);
		
		JButton Exit = new JButton("Exit");
		Exit.setFont(new Font("Tahoma", Font.BOLD, 20));
		Exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				System.exit(0);
			}
		});
		Exit.setBounds(541, 185, 115, 31);
		panel.add(Exit);
//		ButtonGroup b = new ButtonGroup();
//		b.add(btnNewButton_1);
		
		JButton btnNewButton_3 = new JButton("Save");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (Nv nv : Nvs) {
					save(nv);
				}
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_3.setBounds(734, 181, 115, 31);
		panel.add(btnNewButton_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(53, 239, 796, 299);
		panel.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int vt = table.getSelectedColumn();
				System.out.println(vt);
				textField.setText(Nvs.get(vt-2).getMasv());
				textField_2.setText(Nvs.get(vt-2).getName());
				textField_1.setText(Nvs.get(vt-2).getSdt());
				textField_3.setText(Nvs.get(vt-2).getEmail());
			}
		});
		table.setFont(new Font("Tahoma", Font.BOLD, 20));
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
			},
			new String[] {
				"STT", "M\u00E3 Nv", "H\u1ECD v\u00E0 T\u00EAn", "S\u1ED1 \u0110T", "Email", "Ghi Ch\u00FA"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(36);
		table.getColumnModel().getColumn(1).setPreferredWidth(59);
		table.getColumnModel().getColumn(2).setPreferredWidth(164);
		table.getColumnModel().getColumn(3).setPreferredWidth(113);
		table.getColumnModel().getColumn(4).setPreferredWidth(184);
		table.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 20));
		table.setFont(new Font("Tahoma", Font.BOLD,20));
		table.setRowHeight(30);
		scrollPane.setViewportView(table);
	}
}
