package db.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
 * �ڹ� ���� DBMS �����غ���!! 
 * ��) DBeaver(Ŭ���̾�Ʈ ���α׷�)
*/
public class MySQLManager {

	public static void main(String[] args) {
		/*
		 * ������ ���̽� ���� ���� 
		 * 0.�ش� DBMS��ǰ�� �ڵ鸵 �� �� �ִ� ���̺귯���� ����̺긦 �ε�
		 * 1.����
		 * 2.������ ������!!(����)
		 * 3.���� ����!!
		 */
		String url="jdbc:mysql://localhost:3306/javadev";
		String user="root";
		String password="1234";
		
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
			//0�ܰ�: ����̹� �ε�~~ .class��  static �� �÷����°�!!
			Class.forName("com.mysql.cj.jdbc.Driver");//�ε��� Ŭ������ ��ġ�� Ŭ�������� ���´�
			System.out.println("����̹� �ε� ����!!");
			
			//1�ܰ�: �����ͺ��̽��� ����!!
			con=DriverManager.getConnection(url, user, password);
			if(con==null) {
				System.out.println("���ӽ���");
			}else {
				System.out.println("���Ӽ���");
				
				//2�ܰ�: ������ ���� 
				String sql="insert into member(name,phone,age)";
				sql=sql+" values('superman','010-7777-8888',35)";
				
				//�������� �����ϱ� ���� �������̽��� PreparedStatement ��
				//��������, �� ��ü�� ������ �Ǿ�� ���ü������Ƿ�, Connection
				//��ü�� ���� ���;� �Ѵ�!!
				pstmt=con.prepareStatement(sql);
				int result=pstmt.executeUpdate();//������ ����!!
				if(result==0) {
					System.out.println("��Ͻ���");
				}else {
					System.out.println("��ϼ���");
				}
			}
		} catch (ClassNotFoundException e) {
			System.out.println("����̹��� ã�� �� �����ϴ�.");
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//�����ͺ��̽� ������ ����ߴ� ��� ��ü�� �ݾƾ� �Ѵ�!!
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
		

	}

}




