package lab7;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PhoneManager implements Serializable {
    private ArrayList<Phone> phoneList;

    public PhoneManager() {
        phoneList = new ArrayList<>();
    }

    public PhoneManager(ArrayList<Phone> phoneList) {
        this.phoneList = phoneList;
    }

    public void addPhoneList(Phone phone) {
        phoneList.add(phone);
    }

    public void removePhone(Phone phone) {
        phoneList.remove(phone);
    }
//1
    public List<Phone> getPhonesWithExcessiveLocalCallTime(float threshold) {
        ArrayList<Phone> result = new ArrayList<>();
        for (Phone phone : phoneList) {
            if (phone.getTimeForTownTalks() > threshold) {
                System.out.println(phone.getSurname() + " " + phone.getName() + " "
                        + phone.getMiddlename());

            }
        }
        return phoneList;
    }
//2
    public List<Phone> getPhonesWithInternationalCall(float longDistanceCallTime) {
        List<Phone> result = new ArrayList<>();
        for (Phone phone : phoneList) {
            if (phone.getLongDistanceCallTime() > longDistanceCallTime) {
                result.add(phone);
            }
        }
        return phoneList;
    }


//3
    public void getAccountNumber(int startRange, int endRange) {
        List<Phone> result = new ArrayList<>();
        for (Phone phone : phoneList) {
            int accountNumber = phone.getAccountNumber();
            if (accountNumber>=startRange && accountNumber <= endRange) {
                System.out.println(phone.getSurname() + " " + phone.getName() + " "
                        + phone.getMiddlename());
                result.add(phone);}
        }
    }

//4
    public List<Phone> sortByAccountNumber() {
        List<Phone> sortedList = new ArrayList<>(phoneList);
        Collections.sort(sortedList, Comparator.comparingInt(Phone::getAccountNumber));
        if (sortedList.isEmpty()) {
            System.out.println("Немає даних для відображення");
        } else {
            for (Phone phone : sortedList) {
                System.out.println(phone.getSurname() + " " + phone.getName() + " "
                        + phone.getMiddlename() + ": " + phone.getAccountNumber());
            }
        }

        return sortedList;
    }

    public void addPhoneList(int ID, String surname,String name, String middlename,
                             int accountNumber, float timeForTownTalks, float longDistanceCallTime) {
        Phone phone = new Phone(ID,surname,name,middlename,accountNumber,timeForTownTalks,longDistanceCallTime);
        phoneList.add(phone);
        System.out.println("Абонент доданий до списку.");
    }

    public void removePhoneList(int ID) {
        if (ID >= 0 && ID < phoneList.size()) {
            Phone removedPhoneList = phoneList.remove(ID);
            System.out.println("Абонент вилучений зі списку: " + removedPhoneList);
        } else {
            System.out.println("Невірний індекс абонента. Спробуйте ще раз.");
        }
    }
}

