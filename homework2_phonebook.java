import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class homework2_phonebook {
    public static void main(String[] args) {
        Map<String, String> phonebook = new HashMap<>();
        phonebook.put("+79991111111", "Contact1");
        phonebook.put("+79992222222", "Contact2");
        menu(phonebook);
    }

    public static void menu (Map<String, String> list) {
        Scanner input = new Scanner(System.in);
        System.out.println("Меню телефонной книги.\n1. Добавить контакт\n2. Удалить контакт\n3. Вывести контакт\n4. Выйти\nВведи номер нужной функции:");
        int point = 0;
        while (point != 1 && point != 2 && point != 3 && point != 4) {
            point = input.nextInt();
        }
        switch (point) {
            case 1:
                addContact(list);
                break;
            case 2:
                deleteContact(list);
                break;
            case 3:
                outputContact(list);
                break;
            case 4:
                break;
        }
    }

    public static void addContact(Map<String, String> list) {
        Scanner input = new Scanner(System.in);
        System.out.println("Введи имя и телефон через пробел: ");
        String[] contact = input.next().split("");
        if (list.containsValue(contact[0]) || list.containsKey(contact[1])) {
            System.out.printf("Такой человек или номер уже есть в контактах. Выбери:\n1. Перезаписать\n2. Пропустить");
            int point = 0;
            while (point != 1 && point != 2) {
                point = input.nextInt();
            }
            switch (point) {
                case 1:
                    list.put(contact[1], contact[0]);
                    break;
                case 2:
                    break;
            }
        } else {
            list.put(contact[1], contact[0]);
            System.out.println("Контакт сохранён.");
        }
        menu(list);
    }

    public static void deleteContact(Map<String, String> list) {
        Scanner input = new Scanner(System.in);
        System.out.println("Введи имя контакта, который нужно удалить: ");
        String contactToDel = input.next();
        for (Map.Entry<String, String> item : list.entrySet()) {
            if (item.getValue().equalsIgnoreCase(contactToDel)) {
                list.remove(item.getKey());
                System.out.println("Удаление выполнено.");
            }
        }
        menu(list);
    }

    public static void outputContact(Map<String, String> list) {
        Scanner input = new Scanner(System.in);
        System.out.println("Введи имя контакта: ");
        String contactToOutput = input.next();
        if (list.containsValue(contactToOutput)) {
            String contactOut = contactToOutput + ": ";
            for (Map.Entry<String, String> item : list.entrySet()) {
                if (item.getValue().equalsIgnoreCase(contactToOutput)) {
                    contactOut += item.getKey() + " ";
                }
            }
            System.out.println(contactOut);
        } else System.out.println("Такого контакта нет.");
        menu(list);
    }
}