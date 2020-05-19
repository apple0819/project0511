package util;

/*
 * String Ŭ������ ���� �˾ƺ���
 * 
 * 1)���ڰ� �ƴ� ���ڿ��� ǥ���� ��ü
 * 2)�ڹ� API ��Ű�� ��  import ������ �����Ƿ� java.lang���� ����
 * 3)��ü�� ? 
 * */
public class StringStudy {
	public static void main(String[] args) {
		/*�Ʒ��� �ڵ�� �Ѵ� ��Ʈ�� ��ü�� �����ϴ� ���
		 *� ����� �޸� ȿ���� �� ������? 
		 * */ 
		
		/*�Ʒ��� ���� String�� Ŭ�����ӿ��� �ұ��ϰ� new �����ڷ�
		 * �������� �ʰ� ��ü�� �ν��Ͻ��� �����ϴ� ����� ������ 
		 * ������,�Ϲ���(implicit) �������̶� �Ѵ�!!
		 * �� �̷� ����� ��������??
		 * ��Ʈ���� �ΰ����� ���� ���� ���̴� �����̴�!!���� ��ü�ӿ���
		 * �ұ��ϰ� �Ϲ� ������ó�� ����Ҽ� �ֵ��� ������� �����ϴ� ����
		 * ������ ��ü������, ���������� �ν��Ͻ�ȭ �ȴ�!! 
		 * */
		String str1="apple";
		String str2="apple";
		
		//��Ʈ���� ��ü�̹Ƿ� �Ʒ��� �񱳿����ڸ� ����񱳰� �ƴ϶� 
		//�κ����� �ּҰ� ���̴�!!
		System.out.println(str1==str2);
		/*
		 * �Ʒ��� ���� String Ŭ������ new �����ڿ� ���� �����ϴ� �����
		 * ������  explicit(�����) �������̶� �Ѵ�. 
		 * �Ϲ�Ŭ���� �������� �����ϹǷ� �޸� ȿ���� 1�� �������� ����
		 * */
		
		String s1=new String("banana");
		String s2=new String("banana");
		System.out.println(s1==s2);//�ּҰ� ���̹Ƿ�, �翬�� false
		
		//����񱳸� �ϰ������?
		//�̶� ����ϴ� �޼��尡  Object Ŭ�����κ��� �������� 
		//equals() �޼����̴�!! ��ü�� ������ ���� 
		System.out.println(str1.equals(str2));
		System.out.println(s1.equals(s2));
		
		//System.out.println("tomato".equals(new String("tomato")));
	}
	
}








