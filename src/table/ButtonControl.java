package table;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ButtonControl extends JFrame implements ActionListener{
	JButton bt_create, bt_bg;
	JPanel p_container;
	int n;
	//��κ��� ���α׷��� ������ �迭������ �ݵ�� �� ũ�⸦ ���!!
	//ũ�⸦ �������� ���� ���߽� �Ѱ����� �ִ�..
	//but �ڹٽ�ũ��Ʈ�� �迭�� ũ�Ⱑ �������̴�..�ڹپ����� ������
	//�迭 �������� ����..
	//�ڷᱸ��!!
	//�ڹٿ����� ��ü�� ��Ƽ� ó���Ҷ� ������  api�� �����ϸ�, �� api
	//���� java.util �� �� �ִ�..�� ���̺귯���� ������ �ڹٿ�����
	//Collection Framework(�̹� ������� Ʋ )
	//���� �÷��� �����ӿ��� ������� �ϴ� �����ʹ� ���� ��ü�̴�!!
	/*
	 * �ڹپ����� ��ü�� ����� �ִ� ����� ũ�� 3������ ����..
	 * 1.�������� ���� : Set 
	 * 2.�����ִ� ����: List :���� �迭�̴�!!
	 * 							�� ������ 
	 *                             1) ũ�Ⱑ �������̴�!!
	 *                             2) ��ü���� �ٷ�� 
	 * 3.key-value �� : Map ex) json  {name:"ȣ����"}
	 * */
	ArrayList<JButton> list=new ArrayList<JButton>();//ũ��� 0������,
												//����ó�� �þ�� �ִ�!!		
	
	public ButtonControl() {
		bt_create = new JButton("����");
		bt_bg = new JButton("����");
		p_container = new JPanel();
		
		p_container.setPreferredSize(new Dimension(300, 300));
		p_container.setBackground(Color.BLUE);
		
		setLayout(new FlowLayout());
		add(bt_create);
		add(bt_bg);
		add(p_container);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300,400);
		setVisible(true);
		
		bt_create.addActionListener(this);
		bt_bg.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if(obj ==bt_create) {
			create();
		}else if(obj ==bt_bg) {
			bg();
		}
	}
	public void create() {
		
		JButton bt=new JButton("��ư"+n++);
		p_container.add(bt);
		p_container.updateUI();
		
		list.add(bt);
		System.out.println("������� ����� ��ư�� ���� "+list.size());
	}
	
	public void bg() {
		for(int i=0;i<list.size();i++) {
			//ArrayList �� ���� �� �ִ� ��ü�� �ڷ����� ��� �ڷ����̹Ƿ�
			//Object ������ ����ȯ�Ǿ� ����..���� ������ ���� 
			//Object ���̱� ������, �ٽ� �������� �ʿ��� �ڷ������� 
			//down casting �ؾ��Ѵ�!!
			
			//���ʸ����� ����� �÷��� �����ӿ� ��ü�� ����ȯ�� �ʿ����
			//��? ������ ������ �ڷ��� �����̹Ƿ�..(�� �������� ���ɼ���
			//0%�̱� ������...)
			JButton bt=list.get(i);
			bt.setBackground(Color.YELLOW);
		}
	}
	
	public static void main(String[] args) {
		new ButtonControl();
	}
}





