package db.join;

//DB�� Table�� ���ڵ� 1���� ������ ��ü ���� 
//�� ��ü�� ������ ��� �ִ� ���� �ƴ϶�, ���� �����͸��� �����Ѵٰ� �Ͽ� 
//���ø����̼� ���� �о߿����� VO(value object),
//DTO(Data Transfer Object)
public class TopCategory {
	private int topcategory_id;
	private String name;
	
	public int getTopcategory_id() {
		return topcategory_id;
	}
	public void setTopcategory_id(int topcategory_id) {
		this.topcategory_id = topcategory_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}