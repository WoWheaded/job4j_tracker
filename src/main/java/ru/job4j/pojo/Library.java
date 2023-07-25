package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book book1 = new Book("Philosophy of Java", 1500);
        Book book2 = new Book("Clean code", 600);
        Book book3 = new Book("System design", 350);
        Book book4 = new Book("Spring in Action", 700);
        Book[] massiveOfBook = new Book[4];
        massiveOfBook[0] = book1;
        massiveOfBook[1] = book2;
        massiveOfBook[2] = book3;
        massiveOfBook[3] = book4;
        for (int i = 0; i < massiveOfBook.length; i++) {
            System.out.println(massiveOfBook[i].getName() + " - " + massiveOfBook[i].getCountsPepper());
        }
        massiveOfBook[0] = book4;
        massiveOfBook[3] = book1;
        for (int i = 0; i < massiveOfBook.length; i++) {
            if ("Clean code".equals(massiveOfBook[i].getName())) {
                System.out.println("Поиск книги Clean code: ");
                System.out.println(massiveOfBook[i].getName() + " - " + massiveOfBook[i].getCountsPepper());
            }
        }
    }
}
