package com.zooapp.dao;

import java.util.List;

import com.zooapp.exceptions.AnimalNotFoundException;
import com.zooapp.model.Animal;

public interface IAnimalDao {
	void addAnimal(Animal animal);
	int updateAnimal(int animalId, String type);
	void deleteAnimal(int animalId);
	
	Animal findById(int animalId);

	List<Animal> findAllAnimals();
	List<Animal> findByType(String type) throws AnimalNotFoundException;
	List<Animal> findByTypeAndCharacteristics(String type, String characteristics) throws AnimalNotFoundException;
	List<Animal> findByTypeAndAge(String type,int age) throws AnimalNotFoundException;
	
}
