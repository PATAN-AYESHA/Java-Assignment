package com.zooapp.util;

public class Queries {
	public static final String CREATEQUERY=
			"create table animals (animalId integer primary key ,animalName varchar(20),type varchar(30),"
			+"characteristics varchar(50), age int)";
	public static final String INSERTQUERY = 
			"insert into animals(animalId,animalName,type,characteristics,age) values(?,?,?,?,?)";
	public static final String UPDATEQUERY = 
			"update animals set type=? where animalId=?";
	public static final String DELETEQUERY = 
			"delete from animals where animalId=?";
	public static final String GETALLQUERY = 
			"select * from animals";
	public static final String QUERYBYID = 
			"select * from animals where animalId=?";
	public static final String QUERYBYTYPE = 
			"select * from animals where type=?";
	public static final String QUERYBYTYPEANDCHARACTER = 
			"select * from animals where type=? and characteristics=?";
	public static final String QUERYBYTYPEANDAGE = 
			"select * from animals where type=? and age=?";

}
