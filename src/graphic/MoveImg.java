package graphic;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MoveImg extends JFrame{
	/*
  �˹����� �ٸ� ������Ʈ�ʹ� �޸�, � �׸��� �׸����� ���� ������
  �����ڰ� �ֵ��Ͽ� �Ҽ��ִ�..�ֺ� ��ȭ��...�� ���ϴ� �׸� �׸���� �ذŴ�
  
  �ڹٺо߿����� �׸��� ��ü�� �����ͽ� ������ �̱� ������, �ڱ� �ڽ��� �׸���
  �̶� �׸��� �ൿ��  paint() �޼���� �����Ѵ�!! ���� �츮�� ��� 
  �˹����� ������ �׷����� �ƹ��͵� ���� ������, �̹��� �����ڰ� ��ü��  �Ǿ�
  �׸��� ����� �Ѵ�..���� Canvas��  paint �޼��带 �������̵�!
	*/
	Canvas can;
	JPanel p_north;
	JButton bt_prev, bt_next;
	int x=0;
	int velX=0;
	
	Toolkit kit;//���û��� �̹����� �ҷ����� ���� ��ü
	Image img;
	
	public MoveImg() {
		p_north = new JPanel();
		bt_prev = new JButton("����");
		bt_next = new JButton("����");
		
		//�߻�Ŭ������ new�� ����Ҽ� ���� ������, 
		//1) �ڽ��� �����Ͽ� �ڽ��� new ���
		//2) ��ü������ �ν��Ͻ��� ��Բ� ���ִ� static �޼��带 ����
		kit = Toolkit.getDefaultToolkit();//�ν��Ͻ� ���
		img=kit.getImage("D:/web_app/java_workspace/project0506/res/pica.png");
		
		p_north.add(bt_prev);
		p_north.add(bt_next);
		add(p_north, BorderLayout.NORTH);
		
		//������ Ŭ������  Canvas �� �����Ű��, ������ ���Ǽ�, ȿ������
		//���ϵǹǷ� �� Ŭ�����ȿ� �ΰڴ�!! ������ �׷��� �ȵǰ�, ��Ȳ�� �°�
		//������ ������Ʈ�� ��� Canvas �� ��Ȱ�뼺�� ���� ������ �̷��� ��
		
		//�����͸�Ŭ����(Annoymous Inner Class)�� �ٱ��� �ܺ� Ŭ������
		//����� ����ó�� ������ �� �ִ�
		can = new Canvas(){
			//�����ڰ� ȣ���ص� �ȵǰ�, ȣ���Ҽ��� ����!!
			//�����ڴ� ���� �Ʒ���  paint�޼��尡 �ٽ� ȣ��Ǳ⸦ ��û���Ҽ��ִ�
			//repaint(�ٽñ׷��޶�)  --> update() --> paint()
			public void paint(Graphics g) {
				//g.drawOval(x, 200, 50, 50);
				
				//��ī�� �̹����� �׸���!!
				g.drawImage(img, x, 150, 50, 50, this);
				
			}
		};
		
		can.setBackground(Color.WHITE);
		add(can);
		setSize(600,550);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//��ư�� ������ ���� 
		bt_prev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				velX=-5;
				tick();
				render();
			}
		});
		bt_next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				velX=5;
				tick();
				render();
			}
		});
		
	}
	public void tick() {
		x+=velX;
	}
	public void render() {
		//��ȭ�� �������� �̿��Ͽ� �׷��ȿ� �ݿ�����!!
		//ȭ���� ��~����� �ٽ� �׸��� ������!!
		can.repaint();
		
	}
	public static void main(String[] args) {
		new MoveImg();
	}
}








