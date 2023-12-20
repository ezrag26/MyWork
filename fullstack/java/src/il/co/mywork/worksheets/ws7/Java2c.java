package il.co.mywork.worksheets.ws7;

class Animal{

	static {
		System.out.println("Static block Animal 1");
	}

	{
		System.out.println("Instance initialization block Animal");
	}

	public Animal(){
		System.out.println("Animal Ctor");
		this.ID = ++counter;
		sayHello();
		showCounter();
		System.out.println(toString());
		System.out.println(super.toString());
	}

	public Animal(int num_masters){
		System.out.println("Animal Ctor int");
		this.ID = ++counter;
		this.num_masters = num_masters;
	}

	public void sayHello(){
		System.out.println("Animal Hello!");
		System.out.println("I have "+ num_legs + " legs");
	}

	public static void showCounter(){
		System.out.println(counter);
	}

	public int getNumMasters(){
		return this.num_masters;
	}

	@Override
	public String toString(){
		return "Animal with ID: " + ID;
	}

	@Override
	protected void finalize() throws Throwable{
		System.out.println("finalize Animal with ID:" + this.ID);
		super.finalize();
	}

	static {
		System.out.println("Static block Animal 2");
	}

	private int num_legs = 5;
	public static int counter = 0;
	private int num_masters = 1;
	int ID;
}

class Dog extends Animal{
	public Dog(){
		super(2);
		System.out.println("Dog Ctor");
	}

	static {
		System.out.println("Static block Dog");
	}

	public void sayHello(){
		System.out.println("Dog Hello!");
		System.out.println("I have "+ num_legs + " legs");
	}

	{
		System.out.println("Instance initialization block Dog");
	}

	@Override
	protected void finalize() throws Throwable{
		System.out.println("finalize Dog with ID:" + this.ID);
		super.finalize();
	}

	@Override
	public String toString(){
		return "Dog with ID: " + ID;
	}

	private int num_legs = 4;
}

class Cat extends Animal{
	public Cat(){
		this("black");
		System.out.println("Cat Ctor");
		this.num_masters = 2;
	}

	static {
		System.out.println("Static block Cat");
	}

	public Cat(String colors){
		this.colors = colors;
		System.out.println("Cat Ctor with color: " + this.colors);
	}

	@Override
	protected void finalize() throws Throwable{
		System.out.println("finalize Cat with ID:" + this.ID);
		super.finalize();
	}

	@Override
	public String toString(){
		return "Cat with ID: " + ID;
	}

	private String colors;
	private int num_masters = 5;
}

class LegendaryAnimal extends Cat{
	public LegendaryAnimal(){
		System.out.println("Legendary Ctor");
	}

	static {
		System.out.println("Static block Legendary Animal");
	}

	public void sayHello(){
		System.out.println("Legendary Hello!");
	}

	@Override
	protected void finalize() throws Throwable{
		System.out.println("finalize LegendaryAnimal with ID:" + this.ID);
		super.finalize();
	}

	@Override
	public String toString(){
		return "LegendaryAnimal with ID: " + ID;
	}
}

public class Java2c {

	public static void foo(Animal a){
		System.out.println(a.toString());
	}
	@SuppressWarnings("deprecation")
	public static void main(String[] args){
		Object obj;
		Animal animal = new Animal();
		Dog dog = new Dog();
		Cat cat = new Cat();
		LegendaryAnimal la = new LegendaryAnimal();

		Animal.showCounter();

		System.out.println(animal.ID);
		System.out.println(((Animal)dog).ID);
		System.out.println(((Animal)cat).ID);
		System.out.println(((Animal)la).ID);

		Animal[] array = {
				new Dog(),
				new Cat(),
				new Cat("white"),
				new LegendaryAnimal(),
				new Animal()
		};

		for(Animal a : array){
			a.sayHello();
			System.out.println(a.getNumMasters());
		}

		for(Animal a : array){
			foo(a);
		}

		System.gc();
		System.out.println("After gc");
//       Runtime.runFinalizersOnExit(true);
	}
}
