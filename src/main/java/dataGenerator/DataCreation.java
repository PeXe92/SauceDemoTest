package dataGenerator;

import com.github.javafaker.Faker;

import java.util.Locale;

public class DataCreation {
    public static String generateFirstName() {
        /*Faker faker = new Faker();
        String firstName = faker.name().firstName();
        return firstName;*/
        return new Faker(new Locale("sr")).name().firstName();
    }
    public static String generateLastName(){
        return new Faker(new Locale("sr")).dragonBall().character();
    }
    public static String generateZipCode(){
        return new Faker(new Locale("sr")).address().zipCode();
    }

}
