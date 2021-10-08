package QLSV;

public class Student {
	private int id;
	private String name;
	private int age,gender;
	private String major;
	private float score;
	public Student() {	
	}
	public Student(int id,String name,int age,int gender,String major,float score) {
		this.id=id;
		this.name=name;
		this.age=age;
		this.gender=gender;
		this.major=major;
		this.score=score;
	}
	 public void setName(String name) {
		 this.name=name;
	 }
	 public void setId(int id) {
		 this.id=id;
	 }
	 public void setAge(int age) {
		 this.age=age;
	 }
	 public void setGender(int gender) {
		 this.gender=gender;
	 }
	 public void setMajor(String major) {
		 this.major=major;
	 }
	 public void setScore(float score) {
		 this.score=score;
	 }
	 public String getName() {
		 return name;
	 }
	 public int getAge() {
		 return age;
	 }
	 public int getGender() {
		 return gender;
	 }
	 public String getMajor() {
		 return major;
	 }
	 public float getScore() {
		 return score;
	 }
	 public int getId() {
		 return id;
	 }
}
