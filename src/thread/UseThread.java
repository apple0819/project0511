package thread;


public class UseThread {
	public static void main(String[] args) {
		//�����带 �����Ͽ� ���۽��Ѻ���
		MyThread t=new MyThread();//��������� �����ڰ�
		//�����̴�.!!
		//t.run();// ����ӽſ��� �ñ�� ���� �ʴ´�!!
		t.start();//jvm���� �ñ�� ��
	}
}
