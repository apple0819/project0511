package stream;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class FileCopyUI extends JFrame implements ActionListener{
	JTextField t_ori,t_dest;
	JButton bt;
	/*
	 * ��Ʈ���� �����ͺ��̽��� ���α׷��� ���� ���� ��, �ݵ�� 
	 * ������ �������Ѿ� �Ѵ�!!
	 * ���ϸ�?? �޸𸮿� ��� ���� �ְԵǾ�, �ᱹ�� �޸𸮰� ���ڶ�� �ȴ�
	 * 				�޸� ����(Memory leak)
	 * */
	FileInputStream fis;
	FileOutputStream fos;
	
	public FileCopyUI() {
		t_ori = new JTextField(25);
		t_dest = new JTextField(25);
		
		bt = new JButton("copy����");
		setLayout(new FlowLayout());
		
		add(t_ori);
		add(t_dest);
		add(bt);
		
		//��ư�� ������ ����!!
		bt.addActionListener(this); //���� ������ �������̱� ������..is a����
		
		setSize(370,150);
		setVisible(true);
	}
	
	//�������� �������� �߻�޼���!!
	public void actionPerformed(ActionEvent e) {
		//JOptionPane.showMessageDialog(this, "�� ������?");	
		copy();	
	}
	
	public void copy() {
		//t_ori  ���� ���� ��θ� �̿��Ͽ��Է� ��Ʈ�� ���� �� , 
		//������ �о t_dest ��ο� ���� ��� ��Ʈ���� �̿��� ������ ���!!
		String ori_path = t_ori.getText();//�������
		String dest_path = t_dest.getText();//����� ���
		
		System.out.println("�������"+ori_path);
		System.out.println("����� ���"+dest_path);
		
		try {
			fis = new FileInputStream(ori_path);
			fos=new FileOutputStream(dest_path);
			
			//try���� ������ ������� ������ٸ�, ������ �ȳ����̹Ƿ�, 
			//������ ��Ʈ���� �̿��Ͽ� �����͸� �о���̰�, ����غ���!!(IO)
			int data=-1; //ó���� �о���� �����Ͱ� ���ٰ� ����!!
			
			while(true) {
				data=fis.read(); //1byte �о����!!
				if(data==-1)break; //while �� ��������!!
				fos.write(data);//�о���� �����͸� �ٽ� ���!!
			}
			
	
		} catch (FileNotFoundException e) {
			e.printStackTrace();//�����ڰ� �ܼ��� ���� ������ �м�...
			JOptionPane.showMessageDialog(this,"���ϰ�θ� Ȯ���� �ּ���");
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			/*try���̳�  catch ���� ������ ����ΰ� �ݵ�� ���ľ��� ����
			 * ���� ���𰡸� ������ ���ų� �ڿ��� �������Ѿ� �� ��� 
			 * finally�� ���ȴ�!!
			 * */
			if(fis !=null) {//�ùٸ��� ����Ǿ� ��ü�� �����Ǿ��� ��츸...
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(fos !=null){//�� ��Ʈ���� �����Ǿ������� �ݾƶ�!!
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		}
		
		
	}
	public static void main(String[] args) {
		new FileCopyUI();

	}

}





