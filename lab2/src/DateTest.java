import java.time.LocalDate;
import java.util.Scanner;

public class DateTest {
   public static void main(String[] args) {
      Scanner in = new Scanner(System.in);

      System.out.print("Enter your birth month [1..12]: ");
      int month = in.nextInt();
      System.out.print("Enter your birth day of month: ");
      int day = in.nextInt();
      System.out.print("Enter your birth year [4-digit year]: ");
      int year = in.nextInt();
      LocalDate birthday = LocalDate.of(year, month, day);
      LocalDate today = LocalDate.now();
      LocalDate thisBirthday = LocalDate.of(today.getYear(), month, day);
      int flag = -1;

      if (thisBirthday.isAfter(today)) {
         flag = 0;
         System.out.println("Your birthday has not yet happened this year.");
      }
      else {
         flag = 1;
         System.out.println("Your birthday has already happened this year.");
      }
      if (thisBirthday.isEqual(today)) {
         System.out.println("Happy birthday!!");
      }

      int age = today.getYear() - birthday.getYear();
      if (flag == 0) {
         age --;
      }
      if (age > 1) {
         System.out.println("You're " + age + " years old.");
      }
      else {
         System.out.println("You're " + age + " year old.");
      }

   }
}