package main;

import lab7.PhoneManager;
import lab7.Phone;
import lab7.File;

import java.io.Serializable;
import java.util.Collections;
import java.util.Arrays;
import java.io.*;
import java.util.Comparator;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;




public class Main {

    public static void main(String[] args) {new Main().run();}
    public void run() {



      ArrayList<Phone> phoneList = new ArrayList<>();

       phoneList.add(new Phone(1, "Ivanov", "Ivan", "Ivanovich", 12345, 15.5f, 8.2f));
       phoneList.add(new Phone(2, "Petrov", "Petro", "Petrovich", 67890, 5.3f, 12.7f));
       phoneList.add(new Phone(3, "Sidorov", "Sidor", "Sidorovich", 54321, 18.9f, 3.4f));
       phoneList.add(new Phone(4, "Kovalev", "Vitaliy", "Ivanovich", 98765, 9.6f, 6.1f));
       phoneList.add(new Phone(5, "Kovalenko", "Olena", "Petrovna", 13579, 12.8f, 4.3f));

        String filename = "PhoneNumbers";
        File file = new File();
        // Збереження об'єкта ArrayList у бінарний файл
        file.saveFile(phoneList, filename);
        // Зчитування об'єкта ArrayList з бінарного файлу
        List<Phone> readPhoneList = file.readFile(filename);
        // Вивід зчитаного списку абонентів
        if (readPhoneList != null) {
            for (Phone phone : readPhoneList) {
                System.out.println(phoneList);
            }
        }

        PhoneManager phoneManager = new PhoneManager(phoneList);
        Scanner scanner = new Scanner(System.in);
       int choice = 0;
       while (choice != 5) {
       printMenu();
       choice = scanner.nextInt();
       switch (choice) {
     //Відомості про абонентів, у яких час міських розмов перевищує заданий
       case 1-> {
       System.out.print("Введіть час міських розмов: ");
           float timeForTownTalks = scanner.nextFloat();
           System.out.println("Час міських розмов перевищує "+timeForTownTalks+":");
       phoneManager.getPhonesWithExcessiveLocalCallTime(timeForTownTalks);
          }

//Відомості про абонентів, які користувались міжміським зв'язком
       case 2-> {
      float longDistanceCallTime = scanner.nextFloat();
           List<Phone> internationalCallList = phoneManager.getPhonesWithInternationalCall(longDistanceCallTime);
           if (internationalCallList.isEmpty()) {
               System.out.println("Немає абонентів, які користувалися міжміським зв'язком.");
           } else {
               System.out.println("Абоненти, які користувалися міжміським зв'язком:");
               for (Phone phone : internationalCallList) {
                   System.out.println(phone.getSurname() + " " + phone.getName() + " " + phone.getMiddlename() + "("+ phone.getLongDistanceCallTime() +")");
               }
           }
           }

       //Відомості про абонентів чий номер рахунку знаходиться у вказаному діапазоні
       case 3-> {
         System.out.print("Введіть початок діапазону номерів рахунків: ");
       int startRange = scanner.nextInt();
       System.out.print("Введіть кінець діапазону номерів рахунків: ");
       int endRange = scanner.nextInt();
       List<Phone> inRange = getPhonesByAccountNumberRange(startRange, endRange);
           phoneManager.getAccountNumber(startRange,endRange);
       System.out.println(startRange);}

        //Список абонентів, впорядкованих за номером рахунку
       case 4-> {
       List<Phone> sortedList =phoneManager.sortByAccountNumber();
       System.out.println("Список абонентів, впорядкованих за номером рахунку:");
           for (Phone phone : sortedList) {
               System.out.println(phone.getSurname() + " " + phone.getName() + " "
                       + phone.getMiddlename() + ": " + phone.getAccountNumber());}
       }
       //Додати абонента
           case 5-> {
               addPhoneList(scanner);
           }
//Вилучити абонента
           case 6-> {
               removePhoneList(scanner);
           }
           //Показати всіх абонентів
           case 7-> {
               displayPhoneList(phoneList);
           }
           case 8->
       System.out.println("Вихід");
       default->
           System.out.println("Невірний вибір. Спробуйте ще раз.");}
                }
            }

            public static void printMenu() {
                System.out.println("Меню:");
                System.out.println("1. Відомості про абонентів, у яких час міських розмов перевищує заданий");
                System.out.println("2. Відомості про абонентів, які користувались міжміським зв'язком");
                System.out.println("3. Відомості про абонентів чий номер рахунку знаходиться у вказаному діапазоні");
                System.out.println("4. Список абонентів, впорядкованих за номером рахунку");
                System.out.println("5. Додати абонента");
                System.out.println("6. Вилучити абонента");
                System.out.println("7. Показати всіх абонентів");
                System.out.println("8. Вийти");
                System.out.print("Виберіть пункт меню: ");
            }
//1
    private static List<Phone> getPhonesWithExcessiveLocalCallDuration(double townTalkTime) {
        List<Phone> phoneList = new ArrayList<>();
        for (Phone phone : phoneList) {
            if (phone.getTimeForTownTalks() > townTalkTime) {
                System.out.println(phone.getSurname() + " " + phone.getName() + " "
                        + phone.getMiddlename());
            }

        }
        return phoneList;
    }
//2

    private void getPhonesWithInternationalCall(float longDistanceCallTime) {
        boolean found = false;
        ArrayList<Phone> phoneList = new ArrayList<>();
        for (Phone phone : phoneList) {
            if (phone.getLongDistanceCallTime() > longDistanceCallTime) {
                found = true;
            }
        }
        if (!found) {
            System.out.println("Немає абонентів, які користувались міжміським зв'язком з тривалістю більше " + longDistanceCallTime + " хвилин");
        }
    }

//3
    public static ArrayList<Phone> getPhonesByAccountNumberRange(int startRange, int endRange) {
        ArrayList<Phone> result = new ArrayList<>();
        ArrayList<Phone> phoneList = new ArrayList<>();
        for (Phone phone : phoneList) {
            int accountNumber = phone.getAccountNumber();
            if (accountNumber >= startRange && accountNumber <= endRange) {
                System.out.println(phone.getSurname() + " " + phone.getName() + " "
                        + phone.getMiddlename());
                // result.add(phone);}
            }
        }
        return phoneList;
    }
//4
public List<Phone> sortByAccountNumber() {
    List<Phone> sortedList = new ArrayList<>();
    Collections.sort(sortedList, Comparator.comparingInt(Phone::getAccountNumber));
    if (sortedList.isEmpty()) {
        System.out.println("Немає даних для відображення");
    } else {
        for (Phone phone : sortedList) {
            System.out.println(phone.getSurname() + " " + phone.getName() + " "
                    + phone.getMiddlename() + ":" + phone.getAccountNumber());
        }
    }
    return sortedList;

}

    public static void printPhoneList(ArrayList<Phone> phones) {
        if (phones.isEmpty()) {
            System.out.println("Немає даних, що відповідають заданим критеріям.");
        } else {
            System.out.println("Результат:");
            for (Phone phone : phones) {
                System.out.println(phone);}}}
//5
public static void addPhoneList(Scanner scanner) {
    List<Phone> phoneList = new ArrayList<>();
      System.out.print("Введіть ID:");
    int ID= scanner.nextInt();
    System.out.println("Введіть прізвище абонента: ");
    String surname = scanner.nextLine();

    System.out.print("Введіть ім'я абонента: ");
    String name = scanner.nextLine();

     System.out.print("Введіть по батькові абонента:");
     String middlename = scanner.nextLine();
     System.out.print("Введіть номер телефону:");
     int accountNumber = scanner.nextInt();
     System.out.print("Введіть час міських розмов:");
     float timeForTownTalks = scanner.nextFloat();
     System.out.print("Введіть час міжміських розмов: ");
     float longDistanceCallTime = scanner.nextFloat();

    Phone phone = new Phone (ID,surname,name,middlename,accountNumber,timeForTownTalks,longDistanceCallTime);
    phoneList.add(phone);

    System.out.println("Абонент доданий до списку.");
}
//6
public static void removePhoneList(Scanner scanner) {
    List<Phone> phoneList = new ArrayList<>();
    System.out.print("Введіть індекс абонента, якого потрібно видалити: ");
    int ID = scanner.nextInt();
    if (ID >= 0 && ID < phoneList.size()) {
        Phone removedPhoneList = phoneList.remove(ID);
        System.out.println("Абонент вилучений зі списку: " + removedPhoneList);
    } else {
        System.out.println("Невірний індекс абонента. Спробуйте ще раз.");
    }
}
//7
public static void displayPhoneList(ArrayList<Phone> phoneList) {
    if (phoneList.isEmpty()) {
        System.out.println("Список абонентів порожній.");
    } else {
        System.out.println("Список абонентів:");
        for (int i = 0; i < phoneList.size(); i++) {
            System.out.println(i + ": " + phoneList.get(i));
        }
    }
}


}










