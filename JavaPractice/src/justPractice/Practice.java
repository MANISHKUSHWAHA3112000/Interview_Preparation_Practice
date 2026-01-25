package justPractice;

public class Practice {
	
	 class A {
		private String name;
		private int age;
		
		public A(){}
		
		public A(String name, int age){
			this.name=name;
			this.age=age;
		}
		
		public void setName(String name) {
			this.name=name;
		}
		public String getName() {
			return name;
		}
		
		public void setAge(int age) {
			this.age=age;
		}
		public int getAge() {
			return age;
		}
		
		@Override
		public String toString() {
			return "[name : name , age: age  ]";
		}
	 }
	
	public static void main(String[] args) {
		Practice p = new Practice();
		
		A a = p.new A("ABC",12);
		System.out.println(a);
		
	}
	 }


