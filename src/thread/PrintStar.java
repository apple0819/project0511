package thread;

public class PrintStar {
	/*
	 * �ϳ��� ���μ��� �ȿ��� thread1, thread2 �� ���� �������
	 * �����Ǿ� ����ȴ�!! �� �������� ����ǰ�, ������ �� ���� ����������
	 * �ý����� JVM �� �����ϴ� ���̴�!!
	*/
	public static void main(String[] args) {
		Thread thread1 = new Thread() {
			public void run() {
				while(true) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("��");
				}
			}
		};
		
		Thread thread2 = new Thread() {
			public void run() {
				while(true) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("��");
				}
			}
		};
		
		thread1.start();
		thread2.start();
	}
}





