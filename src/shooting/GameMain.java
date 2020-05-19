package shooting;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
/*�� �������۽� �������� ���� �����츸 �����ϰ� �ٸ� ������
 * ���Ұ���!!
 * ��κ��� �׷���ó���� JPanel ���� ó���� �Ŵ�!!
 * */
public class GameMain extends JFrame implements ActionListener{
	JMenuBar bar;
	JMenu menu_config;//ȯ�漳��
	JMenu menu_screen; //��ũ���� ũ������
	
	//ȯ�漳�� ����
	JMenuItem item_start;
	JMenuItem item_pause;
	JMenuItem item_fps; //frame per second
	JMenuItem item_exit;
	
	
	//ȭ����� ����
	JMenuItem item_1m;//1�� 
	JMenuItem item_2m;//2�� 
	JMenuItem item_3m;//3�� 1024*768

	GamePanel gamePanel;
	
	Thread thread;//������ ������ ó���� ������!!(����)
	boolean gameFlag=false;
	int fps=10; //������ �ӵ��� �������� ����
	
	public GameMain() {
		bar = new JMenuBar();
		menu_config = new JMenu("���Ӽ���");
		menu_screen = new JMenu("ȭ�����");
		
		item_start=new JMenuItem("���ӽ���");
		item_pause=new JMenuItem("pause");
		item_fps=new JMenuItem("���Ӽӵ�");
		item_exit=new JMenuItem("��������");
		
		item_1m = new JMenuItem("x1");
		item_2m = new JMenuItem("x2");
		item_3m = new JMenuItem("x3");
		
		gamePanel = new GamePanel();
		
		thread = new Thread() {
			//�����ڴ� ������� ������ �����ڵ带 run�� ¥�θ�, 
			//JVM�� �˾Ƽ� ȣ��!! ���� �����ڴ� ���� ��  start()ȣ���
			//JVM���� �ðܾ� �Ѵ�!! �̶� start()ȣ�⿡ ���� �������
			//�����ֱ� �� Runnable ���·� ����!!
			public void run() {
				while(true) {
					
					try {
						Thread.sleep(fps);//Non-Runnable  �������� 
						//������ �ð� ��ŭ �����ִٰ� �ٽ� ����!!
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					gameLoop();
				}
			}
		};
		
		thread.start();
		
		//��Ÿ�� �ο� 
		bar.setBackground(Color.BLACK);
		menu_config.setForeground(Color.WHITE);
		menu_screen.setForeground(Color.WHITE);
		
		
		//���Ӽ��� �޴� ���� 
		menu_config.add(item_start);
		menu_config.add(item_pause);
		menu_config.add(item_fps);
		menu_config.add(item_exit);
		
		//����ȭ�� ���� �޴� ���� 
		menu_screen.add(item_1m);
		menu_screen.add(item_2m);
		menu_screen.add(item_3m);

		bar.add(menu_config);
		bar.add(menu_screen);
		
		//�ٸ� �����쿡 ���� 
		setJMenuBar(bar);
		
		add(gamePanel);
		
		setVisible(true);
		
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				exitProcess();
			}
		});
		
		setOptimize(0);
		
		//�޴������۵鿡 ������ ���� 
		item_start.addActionListener(this);
		item_pause.addActionListener(this);
		item_fps.addActionListener(this);
		item_exit.addActionListener(this);
		
		item_1m.addActionListener(this);
		item_2m.addActionListener(this);
		item_3m.addActionListener(this);
		
		//��Ŀ���� �гο� �÷����ƾ�, Ű���� �̺�Ʈ�� ����ȴ�!!
		gamePanel.setRequestFocusEnabled(true);
		gamePanel.requestFocus();
	}
	
	//���� ���� 
	public void gameLoop() {
		//�����带 ���߷��� ��������, �������� ó������!!
		//����? ��������  run�޼��尡 ����Ǹ� ������� �����ֱ⿡�� 
		//Dead���°� �Ǿ� �׾������!!
		if(gameFlag) {
			//System.out.println("gameLoop() called..");
			//ȭ�鿡 �����ϴ� ��� ��ü�� �������  tick(), render() ȣ���� ����
			gamePanel.repaint();
		}
		
	}
	
	//���α׷� ���� �޼���
	public void exitProcess() {
		//���μ�����? �������� ���α׷� �� ����
		System.exit(0);//���μ��� ����
	}
	
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();//�̺�Ʈ ����Ų ������Ʈ
		
		if(obj==item_start) {
			gameFlag=true;
		}else if(obj==item_pause) {
			gameFlag=false;
		}else if(obj==item_fps) {
			//������Ʈ â ����!!
			String msg=JOptionPane.showInputDialog("FPS �Է�");
			/*
			 *�ڹ��� ��ü�ڷ����� �⺻�ڷ����� ����ȯ�� �����ϴ� Ŭ������
			 *Wrapper Ŭ������ �ϰ�, ��� �⺻ �ڷ������� Wrapper
			 *Ŭ������ �����ȴ�..  ex) int --> Integer, 
			 *							boolean -->Boolean
			 *Ư¡) ����ȯ�� �����ϰ�, ��ü�� ��ȯ�ϸ� �޼������ ������
			 *�Ƿ� �ξ� �� ���� ����� ������ �� �ִ�..
			 * */
			fps = Integer.parseInt(msg);
		}else if(obj==item_exit) {
			exitProcess();
		}else if(obj==item_1m) {
			setOptimize(0);
			setLocationRelativeTo(null);
		}else if(obj==item_2m) {
			setOptimize(1);
		}else if(obj==item_3m) {
			setOptimize(2);
		}
	}
	
	public void setOptimize(int ratio) {
		gamePanel.setScreenSize(ratio);
		pack();
		setLocationRelativeTo(null);		
	}
	
	public static void main(String[] args) {
		new GameMain();
	}
	
}



