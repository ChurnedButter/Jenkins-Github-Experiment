package dummydata;

import org.apache.commons.lang3.RandomStringUtils;
import java.util.Random;

public class GenerateData
{

    private static final String[] domain = {"@email.com", "@gmail.com", "@yahoo.com", "@hotmail.com"};

    private static final String[] firstNames = {"Naoko", "Anastasia", "Praveen",
                                        "Minerva", "Antonio", "Bill", "Ini",
                                        "Shiori", "Mei-Ling", "Adewale",
                                        "Hasan", "Sarah", "Thalia"};

    private static final String[] lastNames = {"Gutierrez", "Akiloye", "Fujimoto",
                                        "Williamson", "Park", "Smith",
                                        "Orwell", "Waheed", "Bukowski",
                                        "Woolf", "Brodder", "Nazari", "Al-Ghazzawi"};

    private static String getDomain() { return domain[new Random().nextInt(domain.length)]; }

    public static String getFirstNames() { return firstNames[new Random().nextInt(firstNames.length)]; }

    public static String getLastNames() { return lastNames[new Random().nextInt(lastNames.length)];}

    public static String emailCharacters() {return RandomStringUtils.random(3, "123456789");}

    public static String genEmail(String firstName, String lastName) {return firstName + "." + lastName + emailCharacters() + getDomain(); }

    public static String genPassword()
    {
        return RandomStringUtils.random
                (8, "abcdefghijklmnopqrstuvwxyz" +
                        "ABCDEFGHIJKLMNOPQRSTUVWXYZ" +
                        "1234567890!@#$%&*()-_=+");
    }

}
