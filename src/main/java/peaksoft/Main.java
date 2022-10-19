package peaksoft;


import peaksoft.service.UserService;
import peaksoft.service.UserServiceImpl;

import java.util.Scanner;

public class Main {
    static Scanner scannerN = new Scanner(System.in);
    static Scanner scannerS = new Scanner(System.in);
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
            UserService userService = new UserServiceImpl();
            commands();
            while (true) {
                int a = getButton();
                if (a == 1) {
                    userService.createUsersTable();
                } else if (a == 2) {
                    userService.dropUsersTable();
                } else if (a == 3) {
                    System.out.print("Введите имя: ");
                    String firstName = scannerS.nextLine();
                    System.out.print("Введите фамилию: ");
                    String lastName = scannerS.nextLine();
                    System.out.print("Введите возраст: ");
                    byte age = scannerN.nextByte();
                    userService.saveUser(firstName, lastName, age);
                } else if (a == 4) {
                    System.out.print("Введите номер пользователя: ");
                    long id = scannerN.nextLong();
                    if (userService.getAllUsers().get(0).getId() == id) {
                        userService.removeUserById(id);
                    } else {
                        System.out.println("Пользователь с №" + id +" не существует, задайте правильный уникальный номер");
                    }
                } else if (a == 5) {
                    if (userService.getAllUsers().isEmpty()) {
                        System.out.println("Таблица не содержит данных для очистки");
                    } else {
                        userService.getAllUsers().forEach(System.out::println);
                    }
                } else if (a == 6) {
                    userService.cleanUsersTable();
                } else if (a == 0){
                    System.out.println("До следующего запуска. Ждем тебя");
                    break;
                }
                else {
                    System.out.println("Неправильно выбрана цифра");
                }
            }
        }

        public static void commands() {
            System.out.println("--------------Команды------------------");
            System.out.println("Нажмите 1 для создания таблицы базы данных");
            System.out.println("Нажмите 2 для удаления таблицы");
            System.out.println("Нажмите 3 для ввода нового пользователя");
            System.out.println("Нажмите 4 для удаления пользователя по уникальному номеру");
            System.out.println("Нажмите 5 для просмотра всех пользователей");
            System.out.println("Нажмите 6 для очистки таблицы");
            System.out.println("Нажмите 0 для выхода из приложения");
            System.out.println("----------------------------------------");
        }

        public static int getButton() {
            System.out.print("Введиту цифру: ");
            int number = scannerN.nextInt();
            return number;
        }
    }

