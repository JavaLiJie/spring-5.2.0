/**
 * @program: spring
 * @ClassName Person
 * @description:$
 * @author: 李杰
 * @create: 2020-09-04 15:56
 * @Version 1.0
 **/

public class Person {
	private String name;
	private String age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public Person() {
	}

	public Person(String name, String age) {
		this.name = name;
		this.age = age;
	}
	private void playGame(){
		System.out.println("私有方法玩游戏");
	}
}