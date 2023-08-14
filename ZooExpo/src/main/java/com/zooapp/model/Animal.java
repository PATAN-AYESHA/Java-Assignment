package com.zooapp.model;

public class Animal {
	private Integer animalId;
	private String animalName;
	private String type;
	private String characteristics;
	private int age;
	public Animal() {
		super();
	}
	
	public Animal(Integer animalId, String animalName, String type, String characteristics, int age) {
		super();
		this.animalId = animalId;
		this.animalName = animalName;
		this.type = type;
		this.characteristics = characteristics;
		this.age = age;
	}

	public Integer getAnimalId() {
		return animalId;
	}

	public void setAnimalId(Integer animalId) {
		this.animalId = animalId;
	}

	public String getAnimalName() {
		return animalName;
	}
	public void setAnimalName(String animalName) {
		this.animalName = animalName;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCharacteristics() {
		return characteristics;
	}
	public void setCharacteristics(String characteristics) {
		this.characteristics = characteristics;
	}

	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Zoo [animalId=" + animalId + ", animalName=" + animalName + ", type=" + type + ", characteristics="
				+ characteristics + ", age=" + age + "]";
	}
	
	
}
