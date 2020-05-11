/*
 ��Ʈ���� �Է°� ����� �̿��Ͽ� ���Ϻ��� ����� ����!!
*/
package stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
//��°� �Է��� ������ �������� ���α׷��� �������� �Ѵ�!!
//��, �������� ���α׷����� �����Ͱ� ���´ٸ� �Է�, �����ٸ� ���!!
import java.io.IOException;

public class FileCopy {
	FileInputStream fis;//������ ������� �� �Է½�Ʈ�� 
	FileOutputStream fos;//������ ������� �� ��� ��Ʈ��
	
	public FileCopy() {
		try {
			//�Է½�Ʈ�� ����!!(���Ͽ� ���� ����, ���� �������� �ʾҴ�..)	
			fis = new FileInputStream("D:/web_app/java_workspace/Project0511/res/pica.png");
			
			//���� ��½�Ʈ���� �������� �������ش�!!
			fos = new FileOutputStream("D:/web_app/java_workspace/Project0511/res/pica_copy.png");
				
			
			//����մ� ���Ͽ�, fis���� �ҷ��� �����͸� �ϳ��� ä���ֱ�!
			int data=-1;

			while(true) {
				data=fis.read();//1byte �б�
				System.out.println(data);
				if(data==-1)break;//���̻� �����Ͱ� ���ٸ� �ݺ��� ����
				fos.write(data);//1byte ���� �� ���!!
			}
	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static void main(String[] args) {
		new FileCopy();
	}
}
