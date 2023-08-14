package com.zooapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zooapp.util.DbConnection;
import com.zooapp.util.Queries;
import com.zooapp.exceptions.AnimalNotFoundException;
import com.zooapp.model.Animal;

public class AnimalDaoImpl implements IAnimalDao {

	@Override
	public void addAnimal(Animal animal) {
		try (Connection connection = DbConnection.openConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(Queries.INSERTQUERY);) {
			preparedStatement.setInt(1, animal.getAnimalId());
			preparedStatement.setString(2,animal.getAnimalName());
			preparedStatement.setString(3,animal.getType());
			preparedStatement.setString(4,animal.getCharacteristics());
			preparedStatement.setInt(5, animal.getAge());
			preparedStatement.execute();
			System.out.println("Animal added sucesfully");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Animal> findAllAnimals() {
		List<Animal> animals = new ArrayList<>();
		try(Connection connection = DbConnection.openConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(Queries.GETALLQUERY);){
			System.out.println("Fetching all animals...");
			try(ResultSet resultSet = preparedStatement.executeQuery();){
				while (resultSet.next()) {
					Integer animalId = resultSet.getInt("animalId");
					String animalName = resultSet.getString("animalName");
					String type = resultSet.getString("type");
					String  characteristics= resultSet.getString("characteristics");
					int age=resultSet.getInt("age");
					Animal animal = new Animal(animalId,animalName,type,characteristics,age);

					animals.add(animal);
					System.out.println(animal.toString());
			
				}}
			return animals;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int updateAnimal(int animalId, String type) {
		try (Connection connection = DbConnection.openConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(Queries.UPDATEQUERY);) {
			preparedStatement.setString(1, type);
			preparedStatement.setInt(2, animalId);
			preparedStatement.execute();
			System.out.println("Animal updated sucesfully");

		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return animalId;
	}

	@Override
	public void deleteAnimal(int animalId) {
		try (Connection connection = DbConnection.openConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(Queries.DELETEQUERY);) {
			preparedStatement.setInt(1, animalId);
			preparedStatement.execute();
			System.out.println("Animal with id " + animalId + " is deleted successfully...");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Animal findById(int animalId) {
		Animal animal = new Animal();
		try (Connection connection = DbConnection.openConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(Queries.QUERYBYID);) {
			preparedStatement.setInt(1, animalId);
			try (ResultSet rt = preparedStatement.executeQuery();) {
				while (rt.next()) {

					String animalName = rt.getString("animalName");
					String  type= rt.getString("type");
					Integer animalId1 = rt.getInt("animalId");
					String characteristics = rt.getString("characteristics");
					int age= rt.getInt("age");
					animal.setAnimalName(animalName);
					animal.setAnimalId(animalId1);
					animal.setType(type);
					animal.setCharacteristics(characteristics);
					animal.setAge(age);
					System.out.println("Animal found sucesfully");
					System.out.println(animal.toString());
				}
				return animal;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Animal> findByType(String type) throws AnimalNotFoundException {
		List<Animal> animals = new ArrayList<>();

		try (Connection connection = DbConnection.openConnection();
				PreparedStatement ps = connection.prepareStatement(Queries.QUERYBYTYPE);) {

			ps.setString(1, type);
			System.out.println("Getting animals with type: " + type);
			try (ResultSet rt = ps.executeQuery()) {
				while (rt.next()) {
					String AnimalName = rt.getString("animalName");
					Integer animalId = rt.getInt("animalId");
					String type1 = rt.getString("type");
					String characteristics = rt.getString("characteristics");
					int age=rt.getInt("age");
					Animal animal = new Animal(animalId,AnimalName,type1,characteristics,age);
					animals.add(animal);
					System.out.println(animal.toString());
				}
			}
			return animals;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Animal> findByTypeAndCharacteristics(String type, String characteristics)
			throws AnimalNotFoundException {
		List<Animal> animals = new ArrayList<>();

		try (Connection connection = DbConnection.openConnection();
				PreparedStatement ps = connection.prepareStatement(Queries.QUERYBYTYPEANDCHARACTER);) {

			ps.setString(1, type);
			ps.setString(2, characteristics);
			System.out.println("Getting animals with type- " + type + " and with characteristics-"
					+ characteristics);
			try (ResultSet rt = ps.executeQuery()) {
				while (rt.next()) {
					Integer animalId = rt.getInt("animalId");
					String animalName = rt.getString("animalName");
					String type1 = rt.getString("type");
					String characteristics1 = rt.getString("characteristics");
					int age = rt.getInt("age");
					Animal animal = new Animal(animalId,animalName,type1,characteristics1,age);
					animals.add(animal);
					System.out.println(animal.toString());
				}
			}
			return animals;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Animal> findByTypeAndAge(String type,int age) throws AnimalNotFoundException {
		List<Animal> animals = new ArrayList<>();

		try (Connection connection = DbConnection.openConnection();
				PreparedStatement ps = connection.prepareStatement(Queries.QUERYBYTYPEANDAGE);) {

			ps.setString(1, type);
			ps.setInt(2,age);
			System.out.println("Getting animals with type-" +type+ " and with age-" + age);
			try (ResultSet rt = ps.executeQuery()) {
				while (rt.next()) {
					Integer animalId = rt.getInt("animalId");
					String animalName = rt.getString("animalName");
					String type1 = rt.getString("type");
					String characteristics= rt.getString("characteristics");
					int age1=rt.getInt("age");
					Animal animal = new Animal(animalId,animalName,type1,characteristics,age1);
					animals.add(animal);
					System.out.println(animal.toString());
				}
			}
			return animals;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
