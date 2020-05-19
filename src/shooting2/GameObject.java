package shooting2;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

/*���ӻ��� ��� ��ü�� ����� Ŭ���� ���� */
abstract public class GameObject {
	int x;
	int y;
	int width;
	int height;
	int velX;
	int velY;
	Image img;
	
	public GameObject(int x, int y,int width, int height, int velX, int velY) {
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		this.velX=velX;
		this.velY=velY;
	}
	
	//��� ��ü���� ����� �̹Ƿ�, ���� ������ Ȯ���������� ����, 
	//Ȯ������� �ȵȴ�!! ���� �ҿ����� �޼���� �����Ѵ�!!
	abstract public void tick();
	abstract public void render(Graphics g);
	
	//�̹��� ��� �޼���!!
	//�� �޼��� ȣ���ڴ�, �ڽ��� ���ϴ� �̹��� ���ϰ�θ� �μ��� �Ѱܾ���
}











