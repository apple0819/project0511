package util;

public class StringApp {
	public static void main(String[] args) {
		/*���԰����ڰ� ��Դ� �ڵ��� ��*/
		/*
		for(int i=0;i<10000;i++) {
			new String("korea");
		}
		*/
		
		//��Ʈ���� �Һ��̴�(=immutable)
		//�ѹ� ������ ��Ʈ���� �����޵Ǳ� ������ �� �����͸� �����
		//������ �� ����!
		//�޸� ȿ������ ���� �����Һ���, ���������ϰ� �ؾ��Ѵ�!!
		StringBuilder sb= new StringBuilder();
		
		sb.append("");
		
		for(int  i=1;i<=10000;i++) {
			//��Ʈ���� = �����ڷ� �����Ϸ���������, �Ʒ�ó�� append
			//�޼��带 �̿��Ѵ�
			sb.append("ko"+i); //10000���� ��ü ����
		}
		
		String result=sb.toString();
		
	}
}





