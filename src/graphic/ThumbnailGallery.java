package graphic;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class ThumbnailGallery extends JFrame{
	JPanel p_west;
	JPanel p_center;//������ ����
	JPanel p_canvas;//ū �̹��� �׷��� �г�
	Toolkit kit=Toolkit.getDefaultToolkit();//�̹����� ��� ����� ���������� ������, �̹����� ��Ŷ�̿�
	Image bigImage;//ū �̹��� ��ü
	ImageIcon prev_icon, next_icon;
	JButton bt_prev, bt_next;
	String dir="D:/web_app/js_workspace/images/";
	String[] path= {"t1.jpg","t2.jpg","t3.jpg","t4.jpg","t5.jpg","t6.jpg","t7.jpg","t8.jpg","t9.jpg","t10.jpg"};
	ThumbLabel[] la_thumb;//���� ����� �󺧵�!!
	ImageIcon[] icon;//�� �󺧿� �� ������
	JScrollPane scroll;
	JTextField t_id;//���� �����ִ� �̹�����  id �������
	int cursor=0; //���� �����ִ� �̹����� �ε���!!
	
	public ThumbnailGallery() {
		p_west = new JPanel();
		p_center = new JPanel();
		
		//.java �ҽ��� �и���Ű�� ���� ���۷����� �ְ�޾ƾ��ϴ�
		//�������� �ֱ� ������, �г��� ���� Ŭ������ ��������� ���� ����
		//�Ϸ��� �����͸����� ó������!!
		p_canvas = new JPanel(){
			public void paint(Graphics g) {
				g.drawImage(bigImage, 0, 0, 450, 400,this);
			}
		};
		
		prev_icon = new ImageIcon("D:/web_app/js_workspace/images/prev.webp");
		next_icon = new ImageIcon("D:/web_app/js_workspace/images/next.webp");
		bt_prev = new JButton("prev");
		bt_next = new JButton("next");
		scroll = new JScrollPane(p_west);
		t_id = new JTextField("0", 5);
		
		//��Ÿ�� �ο�
		p_west.setBackground(Color.YELLOW);
		p_center.setBackground(Color.CYAN);
		p_center.setBackground(Color.RED);
		p_west.setPreferredSize(new Dimension(100, 400));
		p_canvas.setPreferredSize(new Dimension(450, 400));
		t_id.setFont(new Font("����", Font.BOLD, 45));
		
		//������ ���� ���� 
		p_center.add(bt_prev);
		p_center.add(bt_next);
		p_center.add(p_canvas);
		p_center.add(t_id);
		
		
		add(scroll, BorderLayout.WEST);//���ʿ� ����� �г� ����!!
		add(p_center);//���Ϳ� ������ �����̳� ����!!
		
		
		//���� �гο� �󺧵� ����!!
		createImage();//�� �� ������ ���� 
		
		for(int i=0;i<path.length;i++) {
			p_west.add(la_thumb[i]);
			
			la_thumb[i].addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					//�̺�Ʈ�� ����Ų ���� ������Ʈ�� ������ �̺�Ʈ �ҽ�
					ThumbLabel obj=(ThumbLabel)e.getSource();
					//System.out.println(obj.id);
					
					//��Ģ�� �⺻�ڷ����� ��ü�ڷ����� ���� ��ȯ�� �Ұ����ϹǷ�
					//Wrapper Ŭ������ �̿��ϸ� �ȴ� 
					//int(�⺻�ڷ���) --> String(��ü)
					cursor=obj.id;
					t_id.setText(Integer.toString(obj.id));
					
					showImage(obj.id);//������ ����ϰ� ��Ī�Ǵ� ū�̹��� �����ֱ�
				}
			});
		}
		
		//��ư�� ������ ���� 
		bt_prev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cursor--;//���� �������� Ŀ���� �̵�
				//cursor�� ����� 0���� ������ ��!!
				if(cursor<0) {
					JOptionPane.showMessageDialog(ThumbnailGallery.this ,"���� ������ ���׿�");
					cursor=0;
				}else {
					showImage(cursor);
					t_id.setText(Integer.toString(cursor));
				}
			}
		});
		
		bt_next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				cursor++;//���� �������� Ŀ���� �̵�
				if(cursor > path.length-1) {
					JOptionPane.showMessageDialog(ThumbnailGallery.this ,"���� ������ ���׿�");
					cursor=path.length-1;
				}else {
					showImage(cursor);
					t_id.setText(Integer.toString(cursor));
				}
			}
		});
		
		setSize(600,700);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	//���� ����� �� ������ ������ �� �̹��� ó��
	public void createImage() {
		//�̹��� �������� ����, �� 10�� ����!!
		la_thumb = new ThumbLabel[path.length];//�� �迭����
		icon = new ImageIcon[path.length];//������ �迭����
		
		//�ֺ� �迭�� �ݺ������� ä������!!
		for(int i=0;i<path.length;i++) {
			la_thumb[i] = new ThumbLabel(i, new ImageIcon(dir+path[i]));
		}
		
		//ū �̹��� ó�� 
		bigImage = kit.getImage(dir+path[0]);
	}
	
	//ū�̹��� ����ϴ� �޼��� 
	//�Ű������� ������� ������ȣ�� �Ѱܹ޴´� 
	public void showImage(int id) {
		//System.out.println(id+"��° ū �̹��� ����?");
		
		bigImage = kit.getImage(dir+path[id]);
		//�г��� �ٽ� �׸��� ��������!!
		p_canvas.repaint();
	}
	
	public static void main(String[] args) {
		new ThumbnailGallery();

	}

}





