package algoPractice;

class Parent {
	String name;

	public Parent(String name) {
		super();
		this.name = name;
	}

	public void Print() {
		System.out.println("Parent");
		System.out.println("this.name : " + this.name);
	}
}

class Child extends Parent {
	String attribute;

	public Child(String attribute, String name) {
		super(name);
		this.attribute = attribute;
	}

	public void Print() {
		System.out.println("Child");
		System.out.println("this.name : " + this.name);
		System.out.println("super.name : " + super.name);
	}
}

public class Plymorphism_practice {

	public static void main(String[] args) {
		Parent pc = new Child("ATT", "nameChild");
		pc.Print();
		Parent p = new Parent("nameParent");
//		p.Print();
	}

}
