/*���� Ǯ��
 * 
 * -----------------------------------------
 * IO ��? �Է°� ���
 * -----------------------------------------
 * �Է°� ����� �������� ���α׷��� �������� �Ѵ�
 * �Է�: �������� ���α׷����� �����Ͱ� ������ ��
 * ���: �������� ���α׷����� �����Ͱ� ������ ��
 * 
 * -----------------------------------------
 * Exception: ���������� ���� ���� ��Ȳ
 * -----------------------------------------
 * ���ܻ�Ȳ�� ���� : 
 * ���� : error �����ڰ� ������ �� ����
 * ���� : ���α׷��������� ó���� ������ ���
 * ���� : ������ ���Ḧ ���� 	
 * */
package stream;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class UIFileCopy extends JFrame{
	JTextField t_ori, t_dest;
	JButton bt_open, bt_save, bt_copy;
	FileInputStream fis;
	FileOutputStream fos;
	JFileChooser chooser; //Ž����
	
	public UIFileCopy() {
		t_ori = new JTextField(30);
		t_dest = new JTextField(30);
		
		bt_open = new JButton("����");
		bt_save = new JButton("����");
		bt_copy = new JButton("�������");
		
		chooser = new JFileChooser("D:/web_app/js_workspace/images");
		
		setLayout(new FlowLayout());
		
		add(t_ori);
		add(bt_open);
		add(t_dest);
		add(bt_save);
		add(bt_copy);
		
		setSize(430,150);
		setVisible(true);
		
		bt_open.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				open();
			}
		});
		bt_save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				save();
			}
		});
		bt_copy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				copy();
			}
		});
		
	}
	
	public void open(){
		//parent ��� �ܾ�� �θ�Ŭ������ �ƴ϶�, �θ� �����̳ʸ� ����
		if(chooser.showOpenDialog(this)==JFileChooser.APPROVE_OPTION) {
			//������ ������ ���� ��������!!
			File file=chooser.getSelectedFile();
			
			
			//��� ���ؼ� �ؽ�Ʈ�ڽ��� �ֱ�
			String ori=file.getAbsolutePath();
			t_ori.setText(ori);
			
			
		}
	};
	
	public void save(){
		int result = chooser.showSaveDialog(this);
		
		if(result == JFileChooser.APPROVE_OPTION) {
			
			File file=chooser.getSelectedFile();
			
			System.out.println(file.getAbsolutePath());
			
			String dest =file.getAbsolutePath(); 
			t_dest.setText(dest);
		}
	};
	
	public void copy(){
		// ����� : �Է½�Ʈ������ �о���� �����͸� �ٽ� ��½�Ʈ������
		//           ����ϴ� ����!!
		try {
			fis = new FileInputStream(t_ori.getText());
			fos= new FileOutputStream(t_dest.getText());
			
			//�б� 
			int data=-1;//������ ����
			while(true) {
				data=fis.read(); //1byte �б�
				if(data==-1)break;
				//���� 
				fos.write(data);//1byte ����
			}
			
			JOptionPane.showMessageDialog(this,"����Ϸ�");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			//�ϴ� try��  catch �� �� ����δ�  finally�� ���ذ���
			//����!! �����Ʈ�� ����!!
			//�����ִ� ��Ʈ��, �����ͺ��̽��� ������ ������ �ݾ�����!!
			if(fis!=null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(fos!=null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	};
	
	public static void main(String[] args) {
		new UIFileCopy();
	}

}




