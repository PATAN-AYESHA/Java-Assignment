package com.zooapp.client;

import java.util.Scanner;

import com.zooapp.exceptions.AnimalNotFoundException;
import com.zooapp.model.Animal;
import com.zooapp.service.AnimalServiceImpl;
import com.zooapp.service.IAnimalService;

public class ZooMain {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		IAnimalService animalService = new AnimalServiceImpl();
		System.out.println("Welcome to Zoo!\n Please choose the below operations to perform: ");
		System.out.println(
				"1. Add an Animal\n 2. Update an Animal \n 3. Delete an Animal\n 4. Get animal using animalID\n 5. Get all Animals details\n 6. Get Animals using animal type\n 7. Get Animals using type and characteristics\n 8. Get Animals using type and age\n");
		int choice = scanner.nextInt();
		switch(choice) {
		case 1:{
			scanner.nextLine();
			System.out.println("Enter animal name: ");
			String animalName = scanner.nextLine();
			System.out.println("Enter animal type: ");
			String animalType = scanner.nextLine();
			System.out.println("Enter animal characteristics: ");
			String characteristics = scanner.nextLine();
			System.out.println("Enter animal age: ");
			int age= scanner.nextInt();
			System.out.println("Enter animalID: ");
			Integer animalId = scanner.nextInt();
			Animal animal = new Animal(animalId, animalName, animalType, characteristics, age);
			animalService.addAnimal(animal);
			break;
		}
		case 2:{
			System.out.println("Enter animalID: ");
			Integer animalId = scanner.nextInt();
			System.out.println("Enter animal type: ");
			String animalType = scanner.nextLine();
			animalService.updateAnimal(animalId, animalType);
			break;
		}
		case 3:{
			System.out.println("Enter animalID: ");
			Integer animalId = scanner.nextInt();
			animalService.deleteAnimal(animalId);
			break;
		}
		case 4:{
			System.out.println("Enter animalID: ");
			Integer animalId = scanner.nextInt();
			animalService.getById(animalId);
			break;
		}
		case 5:{
			try {
				animalService.getAllAnimals();
			} catch (AnimalNotFoundException e) {
				e.printStackTrace();
			}
			break;
			
		}
		case 6:{
			scanner.nextLine();
			System.out.println("Enter animal type:");
			String animalType = scanner.nextLine();
			try {
				animalService.getByType(animalType);
			} catch (AnimalNotFoundException e) {
				e.printStackTrace();
			}
			break;
		}
		case 7:{
			scanner.nextLine();
			System.out.println("Enter animal type: ");
			String animalType = scanner.nextLine();
			System.out.println("Enter animal characteristics");
			String animalCharacteristics = scanner.nextLine();
			try {
				animalService.getByTypeAndCharacteristics(animalType, animalCharacteristics);
			} catch (AnimalNotFoundException e) {
				e.printStackTrace();
				
			}
			break;
			
		}
		case 8:{
			scanner.nextLine();
			System.out.println("Enter animal type: ");
			String animalType = scanner.nextLine();
			System.out.println("Enter animal age: ");
			int age = scanner.nextInt();
			try {
				animalService.getByTypeAndAge(animalType, age);
			} catch (AnimalNotFoundException e) {
				e.printStackTrace();
			}
			break;
		}
		default :{
			System.out.println("You choice is invalid...Please choose a correct choice");
		}
		}
		
		scanner.close();


	}

}
