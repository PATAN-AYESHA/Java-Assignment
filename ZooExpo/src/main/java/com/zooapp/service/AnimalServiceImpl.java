package com.zooapp.service;

import java.util.List;import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.zooapp.dao.AnimalDaoImpl;
import com.zooapp.dao.IAnimalDao;
import com.zooapp.exceptions.AnimalNotFoundException;
import com.zooapp.model.Animal;

public class AnimalServiceImpl implements IAnimalService{
	IAnimalDao animalDao = new AnimalDaoImpl();
	@Override
	public void addAnimal(Animal animal) {
		animalDao.addAnimal(animal);
	}

	@Override
	public int updateAnimal(int animalId, String type)  {
		int result = animalDao.updateAnimal(animalId, type);
		return result;
	}

	@Override
	public Animal getById(int animalId) {
		Animal animal= animalDao.findById(animalId);
		if(animal==null)
			return null;
		return animal;
	}

	@Override
	public void deleteAnimal(int animalId) {
		animalDao.deleteAnimal(animalId);
	}

	@Override
	public List<Animal> getAllAnimals() throws AnimalNotFoundException {
		List<Animal> animals = animalDao.findAllAnimals();
		if(animals.isEmpty())
			throw new AnimalNotFoundException("No such animal is found.");
		return animals.stream()
				.sorted((d1,d2)->d1.getAnimalName().compareTo(d2.getAnimalName())).collect(Collectors.toList());
	}

	@Override
	public List<Animal> getByType(String type) throws AnimalNotFoundException {
		List<Animal> animals = animalDao.findByType(type);
		if(animals.isEmpty())
			throw new AnimalNotFoundException("No such element found..");
		
		return animals.stream()
		.sorted((d1,d2)->d1.getAnimalName().compareTo(d2.getAnimalName())).collect(Collectors.toList());
		
	}

	@Override
	public List<Animal> getByTypeAndCharacteristics(String type, String characteristics) throws AnimalNotFoundException {
		List<Animal> animals = animalDao.findByTypeAndCharacteristics(type, characteristics);
		if(animals.isEmpty())
			throw new AnimalNotFoundException("No such animal is found.");
		
		return animals.stream()
		.sorted((d1,d2)->d1.getAnimalName().compareTo(d2.getAnimalName())).collect(Collectors.toList());
		
	}

	@Override
	public List<Animal> getByTypeAndAge(String type, int age) throws AnimalNotFoundException {
		List<Animal> animals = animalDao.findByTypeAndAge(type, age);
		if(animals.isEmpty())
			throw new AnimalNotFoundException("No such animal is found.");
		
		return animals.stream()
		.sorted((d1,d2)->d1.getAnimalName().compareTo(d2.getAnimalName())).collect(Collectors.toList());
		
	}

}
