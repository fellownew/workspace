package abstracttest;
//abstract �޼ҵ��� ���� Ŭ������ �ݵ�� abstract Ŭ������ �����ؾ���. -> ��ü ���� �Ұ� Ŭ����
public abstract class SuperClass {

		public abstract void abstractMethod();
		
		//�߻� Ŭ������ ������ �޼ҵ�, instance/static ����, ������ ��� ���� �� �ִ�.
		//������ �޼ҵ� - �ڽ�Ŭ�����鿡 ���������� ������ �޼ҵ�.
		public void templateMethod(){
			System.out.println("SuperClass-templateMethod");
		}
		
/*		�߻� Ŭ����
		�߻� �޼ҵ�(abstract �޼ҵ�) : ����Ŭ�������� ������ �ٸ����, ���𱸹��� �߻�Ŭ�������� ����, ������ �������� �˸°� ��.
		������ �޼ҵ�(Template �޼ҵ�) : ���� Ŭ�������� �������� ������ ������ ��� �θ� �����ϰ� ��ӹ޾� ���.*/
		
}
