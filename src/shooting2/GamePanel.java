package shooting2;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/*������ �׷���ó���� ����ϴ� ��ũ��!!*/
public class GamePanel extends JPanel{
	int[][] screenSize=new int[][] {
		{600,400},{800,600},{1024,768}
	};
	int ratio;	
	Hero hero;
	Image[] backImg=new Image[2];//�гο� �׷��� ��� �̹���
	int bgX;
	int bgY;
	int speedX=-1;
	
	public GamePanel() {
		setScreenSize(0);//ź���� ���ÿ� 600*400 ����...
		backImg[0]=createImage("/resource/game_bg.jpg");
		backImg[1]=createImage("/resource/game_bg.jpg");
		
		createHero();
		
		//�гο� ���콺 ������ ���� 
		this.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				
				switch(key) {
					case KeyEvent.VK_LEFT:hero.velX=-5;break;
					case KeyEvent.VK_RIGHT:hero.velX=5;break;
					case KeyEvent.VK_UP:hero.velY=-5;break;
					case KeyEvent.VK_DOWN:hero.velY=5;break;
					case KeyEvent.VK_SPACE:hero.fire();break;
				}
			}
			//Ű���� ��������, �� ������ ����!!
			public void keyReleased(KeyEvent e) {
				int key = e.getKeyCode();
				
				switch(key) {
					case KeyEvent.VK_LEFT:hero.velX=0;break;
					case KeyEvent.VK_RIGHT:hero.velX=0;break;
					case KeyEvent.VK_UP:hero.velY=0;break;
					case KeyEvent.VK_DOWN:hero.velY=0;break;
				}
			}
		});
		
	}
	
	public void setScreenSize(int ratio) {
		this.ratio=ratio;
		setPreferredSize(new Dimension(screenSize[ratio][0], screenSize[ratio][1]));
	}
	
	//���ΰ� ���� 
	public void createHero() {
		hero =new Hero(50, 100, 80, 60, 0, 0);
		hero.img=createImage("/resource/plane.png");		
	}
	
	public Image createImage(String path) {
		URL url=this.getClass().getResource(path);
		Image img=null;
		try {
			img=ImageIO.read(url);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return img;
	}
	
	//���ΰ�, ���, ������ ���!~!~������ ������Ʈ�� �ٷ� �� �гο�
	//�׷���!! ���� �Ʒ��� paint �޼�����  g�� �� ������ �Ѵ�!!
	public void paint(Graphics g) {
		Graphics2D g2=(Graphics2D)g;
		
		//ä���� �簢������ ������ ó������!!
		bgX+=speedX;
		//g.setColor(Color.YELLOW);
		//g.fillRect(0, 0, screenSize[ratio][0], screenSize[ratio][1]);//ȭ�鸸�� �簢������ ȭ���� ����
		g2.drawImage(backImg[0], 0, bgY, screenSize[ratio][0], screenSize[ratio][1], null);
		g2.drawImage(backImg[1], screenSize[ratio][0], bgY, screenSize[ratio][0], screenSize[ratio][1], null);
		
		g.translate(bgX, bgY);
		
		hero.tick();
		hero.render(g2);
	}
}









