package homework.shop;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

//�ϳ��� ȭ���� ������ �гη� ó������!~!
public class ProductManage extends Page{
	//--------------------------���� ����
	JPanel p_west;//���ʿ� �ٿ��� �����̳�
	JTextField t_name;
	JTextField t_price;
	JTextField t_brand;
	JButton bt_find;//�̹��� ã�� ��ư
	JPanel p_thumb;//��Ͻ� ������ �̸����� ����� 
	JButton bt_regist;// ��Ϲ�ư
	
	//-------------------------���Ϳ���
	JPanel p_content;//������ �� ��� ������Ʈ�� �����!!
	JTable table;
	JScrollPane scroll;
	JPanel p_detailBox;//�󼼺��� �����̳�
	JPanel p_detail;//����� ������ �󼼺��� 
	JPanel p_info;//�̸�,����,�귻�� ���� ���� 
	JLabel la_name;
	JLabel la_price;
	JLabel la_brand;
	
	
	public ProductManage(ShopApp shopApp, String title,Color color, int width,int height,boolean showFlag) {
		super(shopApp,title,color,width,height,showFlag);
		
		p_west=new JPanel();
		t_name = new JTextField(10);
		t_price = new JTextField(10);
		t_brand = new JTextField(10);
		
		bt_find = new JButton("�̹���");
		p_thumb = new JPanel();
		bt_regist = new JButton("���");
		
		p_content=new JPanel();
		table = new JTable();
		scroll = new JScrollPane(table);
		
		p_detailBox= new JPanel();
		p_detail = new JPanel();
		p_info = new JPanel();
		la_name = new JLabel("��ǰ��:Ƽ����");
		la_price = new JLabel("����:80,000��");
		la_brand = new JLabel("�귣��:POLHAM");
		
		//��Ÿ�� ���� 
		p_content.setBackground(Color.PINK);
		p_west.setPreferredSize(new Dimension(120, height));
		
		p_thumb.setBackground(Color.WHITE);
		p_thumb.setPreferredSize(new Dimension(120, 120));
		p_detail.setBackground(Color.BLACK);
		p_detail.setPreferredSize(new Dimension(180, 180));
		p_info.setBackground(Color.RED);
		
		la_name.setPreferredSize(new Dimension(350, 50));
		la_price.setPreferredSize(new Dimension(350, 50));
		la_brand.setPreferredSize(new Dimension(350, 50));
		
		la_name.setFont(new Font("����",Font.BOLD,14));
		la_price.setFont(new Font("����",Font.BOLD,14));
		la_brand.setFont(new Font("����",Font.BOLD,14));
		
		//���� ���̾ƿ� ���� 
		this.setLayout(new BorderLayout());
		p_content.setLayout(new BorderLayout());
		p_detailBox.setLayout(new BorderLayout());
		
		//���� 
		add(p_content, BorderLayout.CENTER);
		p_west.add(t_name);
		p_west.add(t_price);
		p_west.add(t_brand);
		p_west.add(bt_find);
		p_west.add(p_thumb);
		p_west.add(bt_regist);
		
		add(p_west, BorderLayout.WEST);
		p_content.add(scroll);
		
		//�󼼺��� ���� ����
		p_info.add(la_name);
		p_info.add(la_price);
		p_info.add(la_brand);
		
		p_detailBox.add(p_detail, BorderLayout.WEST);
		p_detailBox.add(p_info);
		
		p_content.add(p_detailBox, BorderLayout.SOUTH);
	}

}













