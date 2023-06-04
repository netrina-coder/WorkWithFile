package lab7;

import main.Main;
import lab7.Phone;
import lab7.PhoneManager;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class File  {




    //
     public static void saveFile(List<Phone> phoneList, String filename) {
        try {
            FileOutputStream fos = new FileOutputStream("PhoneNumbers");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(phoneList);
            oos.close();
            fos.close();
            System.out.println("Об'єкт ArrayList успішно збережений у бінарний файл.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Phone> readFile(String filename) {
        List<Phone> phoneList = null;
        try {
            FileInputStream fis = new FileInputStream("PhoneNumbers");
            ObjectInputStream ois = new ObjectInputStream(fis);
            phoneList = (ArrayList<Phone>) ois.readObject();
            ois.close();
            fis.close();
            System.out.println("Об'єкт ArrayList успішно зчитаний з бінарного файлу.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return phoneList;
    }










    /*
    //
    public List<Phone> readBinaryFromFile(String filePath) {
        List<Phone> phoneList = new ArrayList<>();
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filePath))) {
            phoneList = (ArrayList<Phone>) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Помилка при зчитуванні даних з файлу: " + e.getMessage());
        }
        return phoneList;
    }
    public void writeBinaryToFile(ArrayList<Phone> phoneList, String filePath) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(filePath);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(phoneList);
        } catch (IOException e) {
            System.out.println("Помилка при збереженні даних у бінарний файл: " + e.getMessage());
        }
    }
//
    public List<Phone> readArrayListFromFile(String filePath) {
        List<Phone> phoneList = new ArrayList<>();
        try (FileInputStream fileInputStream = new FileInputStream(filePath);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            phoneList = (ArrayList<Phone>) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Помилка при зчитуванні даних з бінарного файлу: " + e.getMessage());
        }
        return phoneList;
    }
    public void saveDataToFile(ArrayList<Phone> phoneList, String filePath) {
        try (PrintWriter writer = new PrintWriter(filePath)) {
            for (Phone phone : phoneList) {
                String line = phone.getID() + "," + phone.getSurname() + "," + phone.getName() + "," + phone.getMiddlename()
                        + "," + phone.getAccountNumber() + "," + phone.getTimeForTownTalks() + "," + phone.getLongDistanceCallTime();
                writer.println(line);
            }
            System.out.println("Дані успішно збережено у файл " + filePath);
        } catch (FileNotFoundException e) {
            System.out.println("Помилка при збереженні даних у файл: " + e.getMessage());
            saveDataToFile(phoneList, "PhoneNumber.txt");
        }
    }

*/
}
