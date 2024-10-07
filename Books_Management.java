import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class Books_Management {

    ArrayList<String> booksNameList = new ArrayList<>(Arrays.asList("Computer Networking", "Ethical Hacking",
            "Penetration Testing", "Malware Analysis", "Threat Hunting"));

    ArrayList<String> booksTitleList = new ArrayList<>(
            Arrays.asList("Mastering Computer Networking: From Basics to Advanced Protocols",
                    "The Ethical Hacker's Handbook: Techniques and Tools for Cyber Security",
                    "Penetration Testing: The Complete Guide to Ethical Hacking",
                    "Malware Analysis Essentials: A Practical Approach to Threat Detection",
                    "Advanced Threat Hunting: Techniques for Proactive Cyber Defense"));

    ArrayList<String> booksAuthorList = new ArrayList<>(Arrays.asList("James A. Thompson", "Sara L. Mitchell",
            "Michael R. Grant", "David J. Fisher", "Brian W. Hart"));

    int booksAmount = booksNameList.size();

    public void displayBooksName() {
        System.out.printf("%-5s %-30s %-80s %-30s%n", "No.", "Book Name", "Title", "Author");
        System.out.println(
                "---------------------------------------------------------------------------------------------------------------------------------------");

        for (int i = 0; i < booksNameList.size(); i++) {
            System.out.printf("%-5d %-30s %-80s %-30s%n", (i + 1), booksNameList.get(i), booksTitleList.get(i),
                    booksAuthorList.get(i));
        }
    }

    public void amountOfBooksCheck() {
        System.out.println("There are " + booksAmount + " books in library.");
    }

    public void addNameOfBook(String nameOfBook) {
        booksNameList.add(nameOfBook);
        booksAmount++;
    }

    public void addTitleOfBook(String titleOfBook) {
        booksTitleList.add(titleOfBook);
    }

    public void addAuthorNameOfBook(String authorOfBook) {
        booksAuthorList.add(authorOfBook);
    }

    public void removeNameOfBook(String nameOfBook) {
        booksNameList.remove(nameOfBook);
        booksAmount--;
    }

    public void removeTitleOfBook(String titleOfBook) {
        booksTitleList.remove(titleOfBook);
    }

    public void removeAuthorOfBook(String authorOfBook) {
        booksAuthorList.remove(authorOfBook);
    }

    public String getValueOfNames(int choice) {
        return booksNameList.get(choice - 1);
    }

    public String getValuesOfTitle(int choice) {
        return booksTitleList.get(choice - 1);
    }

    public String getValuesOfAuthor(int choice) {
        return booksAuthorList.get(choice - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Books_Management user1 = new Books_Management();
        while (true) {
            System.out.println();
            System.out.println("Please choose any one of the following: ");
            System.out.println("1. Check total Books.       2. Add Book");
            System.out.println("3. Remove book.             4. Search for Book");
            System.out.println("5. Display all Books.       6. Exit");
            System.out.println();
            int userOptionsChoice = sc.nextInt();
            if (userOptionsChoice == 1) {
                user1.amountOfBooksCheck();
            } else if (userOptionsChoice == 2) {

                sc.nextLine();

                System.out.println("Enter the name of Book very carefully: ");
                String userBookName = sc.nextLine();

                System.out.println("Enter the title name of Book very carefully: ");
                String userBooktitle = sc.nextLine();

                System.out.println("Enter the author name of Book very carefully: ");
                String userBookauthor = sc.nextLine();

                user1.addNameOfBook(userBookName);
                user1.addTitleOfBook(userBooktitle);
                user1.addAuthorNameOfBook(userBookauthor);
                System.out.println("Successfully Added a Book.");
            } else if (userOptionsChoice == 3) {
                System.out.println("Following are the books available: ");
                user1.displayBooksName();

                System.out.println();

                sc.nextLine();
                System.out.println("Choose any one of the above to delete: ");
                int choiceToDelete = sc.nextInt();
                user1.removeNameOfBook(user1.getValueOfNames(choiceToDelete));
                user1.removeTitleOfBook(user1.getValuesOfTitle(choiceToDelete));
                user1.removeAuthorOfBook(user1.getValuesOfAuthor(choiceToDelete));
                System.out.println("Successfully Deleted Book.");

            } else if (userOptionsChoice == 4) {
                sc.nextLine();
                System.out.println("Enter the name, title, or author of the book: ");
                String searchingChoice = sc.nextLine();

                boolean bookFound = false;

                for (int i = 0; i < user1.booksNameList.size(); i++) {
                    if (searchingChoice.equalsIgnoreCase(user1.booksNameList.get(i)) ||
                            searchingChoice.equalsIgnoreCase(user1.booksTitleList.get(i)) ||
                            searchingChoice.equalsIgnoreCase(user1.booksAuthorList.get(i))) {
                        System.out.println("Book found!");
                        System.out.println("Name: " + user1.booksNameList.get(i));
                        System.out.println("Title: " + user1.booksTitleList.get(i));
                        System.out.println("Author: " + user1.booksAuthorList.get(i));
                        bookFound = true;
                        break;
                    }
                }
                if (!bookFound) {
                    System.out.println("Sorry, no matching book found.");
                }
            } else if (userOptionsChoice == 5) {
                System.out.println();
                System.out.println("Following are the books available: ");
                user1.displayBooksName();
            } else {
                System.out.println("Thanks for using. Exiting the program...");
                break;
            }

        }
        sc.close();
    }
}
