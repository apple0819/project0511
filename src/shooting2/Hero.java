package shooting2;

import java.awt.Color;
import java.awt.Graphics;

public class Hero extends GameObject{
	
	
	public Hero(int x, int y, int width, int height, int velX, int velY) {
		super(x, y, width, height, velX, velY);		
	}
	
	//�Ѿ� �߻� 
	public void fire() {
		
	}
	
	@Override
	public void tick() {
		this.x+=this.velX;
		this.y+=this.velY;
	}

	//���ΰ��̰� ������ ���� �ᱹ �гο� �׷����� �ϹǷ� �г��� ������ 
	//Graphics ��ü�� ���;� �Ѵ�!!
	public void render(Graphics g) {
		//�׷��� ó���� �Ǿ�� ��!!
		g.setColor(Color.RED);
		
		//g.drawRect(x, y, 70, 40);
		g.drawImage(img, x, y, 60, 40, null);
		
	}

}


