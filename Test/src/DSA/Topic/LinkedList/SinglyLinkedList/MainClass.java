package DSA.Topic.LinkedList.SinglyLinkedList;

import java.util.Scanner;

public class MainClass {

    public static void printMenu(){
        System.out.println();
        System.out.println("********MENU********");
        System.out.println("Enter 1 To Insert");
        System.out.println("Enter 2 To Delete");
        System.out.println("Enter 3 To Search");
        System.out.println("Enter 4 To Display");
        System.out.println("Enter 5 To Exit");
        System.out.println("Enter Your Choice ?");
        System.out.println("********************");
    }

    public static void printInsertMenu(){
        System.out.println("Press 1 to Insert At Beginning");
        System.out.println("Press 2 to Insert At End");
        System.out.println("Press 3 to Insert At Specific Position");
    }

    public static void printDeleteMenu(){
        System.out.println("Press 1 to Delete At Beginning");
        System.out.println("Press 2 to Delete At End");
        System.out.println("Press 3 to Delete At Specific Position");
    }

    public static void main(String[] args) {
//        LinkedList list = new LinkedList();
//        list.insertAtBeginning(12);
//        list.insertAtEnd(13);
//        list.insertAtEnd(15);
//        list.insertAtSpecificPosition(20,2);
//
//        list.printData();
        System.out.println("********WelCome To LinkedList App********");
        LinkedList list = new LinkedList();
        Scanner sc = new Scanner(System.in);
        while (true){
            try {
                printMenu();
                int choice = sc.nextInt();
                if (choice == 1){
                    insertLinkedList(list);
                } else if (choice == 2) {
                    deleteFromLinkedList(list);
                }else if (choice == 3) {
                    System.out.println("Enter the Data To Search ?");
                    int data = sc.nextInt();
                    boolean result = list.searchData(data);
                    if (result){
                        System.out.println("Yes Data Is Present In List");
                    }else {
                        System.out.println("Yes Data Is Not Present In List");
                    }
                } else if (choice == 4) {
                    list.printData();
                } else if (choice == 5) {
                    System.out.println("****Thank you For Using App****");
                    break;
                }else {
                    System.out.println("Invalid Choice !");
                }
            } catch (Exception e) {
               e.getMessage();
            }
        }

    }
    public static void deleteFromLinkedList(LinkedList linkedList){
        printDeleteMenu();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Delete Choice ?");
        int deleteChoice = sc.nextInt();
        if (deleteChoice == 1){
            linkedList.deleteFromBegining();
            System.out.println("****Deleted****");
        } else if (deleteChoice == 2) {
            linkedList.deleteFromEnd();
            System.out.println("****Deleted****");
        } else if (deleteChoice == 3) {
            System.out.println("Enter The Position : ");
            int position = sc.nextInt();
            linkedList.deleteFromSpecificPosition(position);
            System.out.println("****Deleted****");
        }else {
            System.out.println("Invalid Delete Choice !");
        }
    }
    public static void insertLinkedList(LinkedList linkedList){
        printInsertMenu();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Insert Choice ?");
        int insertChoice = sc.nextInt();
        if (insertChoice == 1){
            System.out.println("Enter Your Data");
            int data = sc.nextInt();
            linkedList.insertAtBeginning(data);
            System.out.println("****Inserted****");
        } else if (insertChoice == 2) {
            System.out.println("Enter Your Data");
            int data = sc.nextInt();
            linkedList.insertAtEnd(data);
            System.out.println("****Inserted****");
        } else if (insertChoice == 3) {
            System.out.println("Enter The Position : ");
            int position = sc.nextInt();
            System.out.println("Enter Your Data");
            int data = sc.nextInt();
            linkedList.insertAtSpecificPosition(data,position);
            System.out.println("****Inserted****");
        }else {
            System.out.println("Invalid Inserted Choice !");
        }
    }
}
