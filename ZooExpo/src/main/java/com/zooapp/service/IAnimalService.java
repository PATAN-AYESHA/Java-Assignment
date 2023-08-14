package com.zooapp.service;

import java.util.List;

import com.zooapp.exceptions.AnimalNotFoundException;
import com.zooapp.model.Animal;

public interface IAnimalService {

	void addAnimal(Animal animal);
	int updateAnimal(int animalId, String type);
	void deleteAnimal(int animalId);
	
	Animal getById(int animalId);

	List<Animal> getAllAnimals()  throws AnimalNotFoundException;
	List<Animal> getByType(String type) throws AnimalNotFoundException;
	List<Animal> getByTypeAndCharacteristics(String type, String characteristics) throws AnimalNotFoundException;
	List<Animal> getByTypeAndAge(String type,int age) throws AnimalNotFoundException;
	
}
