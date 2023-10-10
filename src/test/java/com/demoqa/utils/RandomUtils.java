package com.demoqa.utils;

import com.github.javafaker.Faker;

import java.security.SecureRandom;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {

    static Faker fakerEn = new Faker(new Locale("en"));

    public static void main(String[] args) {
        System.out.println(getRandomString(10));
        System.out.println(getRandomString(15));
        System.out.println(getRandomEmail());
        System.out.println(getRandomPhone());
        System.out.println(getRandomGender());
    }
    public static String getRandomString(int len) {
        String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder("");
        for(int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));

        return sb.toString();
    }

    public static int getRandomInt(int min, int max) {

        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static String getRandomItemFromArray(String[] array) {
        int index = getRandomInt(0, array.length - 1);

        return array[index];
    }

    public static String getRandomFirstName() {
        return fakerEn.name().firstName();
    }

    public static String getRandomLastName() {
        return fakerEn.name().lastName();

    }

    public static String getRandomEmail() {
         // return getRandomString(10) + "@qa.guru";
       // return String.format("%s@%s.%s",
        //        getRandomString(10),
         //       getRandomString(4),
          //      getRandomString(5));
        return fakerEn.internet().emailAddress();
    }

    public static String getRandomGender() {
        String[] genders = {"Male", "Female", "Other"};
        return new Faker().options().option(genders);

    }

    public static String getRandomMobileNumber() {

        //return String.format("+%s (%s) %s - %s - %s",
         //       getRandomInt(1, 9), getRandomInt(111, 999),
          //      getRandomInt(111, 999), getRandomInt(11, 99),
          //      getRandomInt(11, 99));
        return fakerEn.numerify("##########");
    }

    public static String getRandomYear() {
        int year = fakerEn.number().numberBetween(1950, 2005);
        return Integer.toString(year);

    }
    public static String getRandomMonth() {
        String[] months = {"January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};
        return new Faker().options().option(months);

    }

    public static String getRandomDay() {
        int day = getRandomInt(1, 28);
        if (day < 10) {
            return "0" + day;
        } else {
            return Integer.toString(day);
        }
    }

    public static String getRandomSubject() {
        String[] subjects = {"Accounting", "Arts", "Biology", "Chemistry", "Civics", "Economics",
                "English", "Commerce", "Computer Science", "Physics", "Maths", "Hindi", "History", "Social Studies"};
        return new Faker().options().option(subjects);
    }

    public static String getRandomHobie() {
        String[] hobbies = {"Sports", "Reading", "Music"};
        return new Faker().options().option(hobbies);
    }

    public static String getRandomPic() {
        String[] pics = {"ava.PNG", "ava1.PNG"};
        return new Faker().options().option(pics);
    }

    public static String getRandomAddress() {
        return fakerEn.address().fullAddress();
    }

    public static String getRandomState() {
        String[] states = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};
        return new Faker().options().option(states);
    }

    public static String getRandomCity(String stateValue) {
        switch (stateValue) {
            case "NCR" ->  {
                String[] city = {"Delhi", "Gurgaon", "Noida"};
                return new Faker().options().option(city);
            }
            case "Uttar Pradesh" -> {
                String[] city = {"Agra", "Lucknow", "Merrut"};
                return new Faker().options().option(city);
            }
            case "Haryana" -> {
                String[] city = {"Karnal", "Panipat"};
                return new Faker().options().option(city);
            }
            case "Rajasthan" -> {
                String[] city = {"Jaipur", "Jaiselmer"};
                return new Faker().options().option(city);
            }

        }
        return null;
    }
}
