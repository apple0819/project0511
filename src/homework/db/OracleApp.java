package homework.db;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class OracleApp extends JFrame{
	JButton bt_exe, bt_con;
	JTextField t_query;
	JTextArea area;
	
	String url="jdbc:oracle:thin:@localhost:1521:XE";
	String user="c##java";
	String password="1234";
	
	Connection con;//���� ��ü
	PreparedStatement pstmt;//������ ���� ��ü
	
	public OracleApp() {
		bt_exe = new JButton("��������");
		bt_con = new JButton("DB����");
		
		t_query = new JTextField(30);
		area = new JTextArea(15,30);
		
		setLayout(new FlowLayout());
		
		add(bt_exe);
		add(bt_con);
		add(t_query);
		add(area);
		
		setSize(400,450);
		setVisible(true);
		
		//��ư�� ������ ���� 
		bt_exe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exeQuery();
			}
		});
		
		bt_con.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				connect();
			}
		});
		
		//������� ������ ����
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				close();
			}
		});
		
	}

	public void connect() {
		try {
			//1�ܰ�:����̹� �ε�
			Class.forName("oracle.jdbc.driver.OracleDriver");
			area.append("����̹� �ε�\n");
			
			//2�ܰ�:���� 
			con=DriverManager.getConnection(url, user, password);
			if(con!=null){
				area.append("���Ӽ���\n");
			}else {
				area.append("���ӽ���\n");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			area.append("����̹� �ε� ����\n");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void exeQuery() {
		//�ؽ�Ʈ �ڽ��� �Է��� �������� ����Ŭ�� �����Ͽ� ��������!!
		//�� ������ ���ִ� ��ü�� �ٷ� PreparedStatement  �̴�!!
		String sql=t_query.getText();
		
		try {
			pstmt=con.prepareStatement(sql);
			int result=pstmt.executeUpdate();//��������!!
			if(result==0){
				area.append("��Ͻ���\n");
			}else {
				area.append("��ϼ���\n");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//��������(db���� ��� ��ü���� ����)
	public void close() {
		if(pstmt!=null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
	}
	
	public static void main(String[] args) {
		new OracleApp();
	}
}








