/*
  �ڹٽ�ũ��Ʈ���� �ڵ�ȣ���� �����ϱ� ����  setInterval, setTimeout
  �� �����ϵ�, �ڹٿ����� �ڵ�ȣ���� ������ �� �ִ�!!
*/
package thread;
public class ThreadApp {
	/*Process ���μ�����? 
	 * �޸𸮿� �÷��� �������� ���α׷� �Ѵ���
	 * 
	 * Thread��?
	 * �ϳ��� ���μ������� ���������� ����Ǵ� ���� �������!!
	 * */
	Thread thread;
	int count=0;
	
	public ThreadApp() {
		
		//�н��ϳ� ����!!
		thread = new Thread() {
			//�����尡 �����Ű�� ���࿵��
			public void run() {
				while(true) {
					try {
						Thread.sleep(100);//non-runnable
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("d");
				}
			}
		};
		
		//������ �н��� �����带 ����!!
		thread.start();
	}
	public static void main(String[] args) {
		new ThreadApp();
	}

}





