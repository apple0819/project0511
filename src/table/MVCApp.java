package table;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

/*
 JTable���� ���� ���� ���� �ִ� ���̺��� ��ü�Ҷ��� ���� ȿ��������
 �ڵ带 �����Ϸ��� ��� �ϴ°�? 
 �� ������ �����Ͱ� �ٸ���, ���� ���� �ҽ��� ������ �ϴ°�?
 ���) �����Ͱ� �ٲ�ٰ� �Ͽ� ���� �ڵ带 �����ٸ� ��û�� ����� ��������
 �ð��� �սǵ� ũ��!!
 �ذ�å) �����Ϳ� �������� ö���� �и����Ѽ� �����϶�!!
           �� ��Ģ�� ������  ���߹���� ������ MVC�����̶� �Ѵ�!!
 ����) JTable�� MVC������ ������� �ݿ��� ������Ʈ�̴�!!
 �ǽ�) emp, dept, student �� �����͸� ��ü��
          ������ Ŭ������ ū ������ ���� �ʴ� �ڵ� ����� ���������
          �Ѵ�                     
*/
public class MVCApp extends JFrame{
	JTable table;
	JScrollPane scroll;
	TableModel model;
	
	public MVCApp() {
		//TableModel �̶� ��ü�� JTable �� ������� �� �����Ϳ�, 
		//Table �������� �и������ִ� ������ ����!!
		//����) ��Ī�� ���� ������, ���ҷ� ���ٸ� Controller�̴�.
		//(by zino)
		table = new JTable(model = new DeptModel());
		scroll = new JScrollPane(table);
		
		//setLayout(new FlowLayout());
		add(scroll);
		setSize(600,400);
		setVisible(true);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				closeDB();
				System.exit(0);
			}
		});
	}
	
	public void closeDB() {
		
	}
	
	public static void main(String[] args) {
		new MVCApp();
	}
}




