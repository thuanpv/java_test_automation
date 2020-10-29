import java.util.Scanner;

public class Triangle
{
  /**
   * This method is used for triangle classification.
   * It takes 3 inputs that represent the lengths of the 3 sides.
   * @param a The length of the 1st side
   * @param b The length of the 2nd side
   * @param c The length of the 3rd side
   * @return int This returns an integer
   * 1 means it is equilateral (all sides equal length)
   * 2 means it is isosceles (exactly 2 equal sides)
   * 3 means it is scalene (no equal sides)
   * 4 means it is an illegal triangle
   */
  public int classify(int a, int b, int c)
  {
    if (a <= 0 && b <= 0 && c <= 0)
      return 4; //invalid
    if (a <= c - b || b <= a - c || c <= b - a)
      return 4; //invalid
    if (a == b && b == c)
      return 1; //equilateral
    if (a == b || b == c || c == a)
      return 2; //isoscele
    return 3;   //scalene
  }

  public static void main(String[] args)
  {
    Triangle obj = new Triangle();
    Scanner keyboard = new Scanner(System.in);
    while(true)
    {
      int a, b, c;
      System.out.println("Enter the length of 3 edges:");
      System.out.print("a: ");
      a = keyboard.nextInt();
      System.out.print("b: ");
      b = keyboard.nextInt();
      System.out.print("c: ");
      c = keyboard.nextInt();
      
      System.out.printf("Given lengths: a=%d, b=%d, c=%d\n", a, b, c);
      int result = obj.classify(a, b, c);
      switch (result)
      {
        case 1:
          System.out.println("This is an equilateral triangle");
          break;
        case 2:
          System.out.println("This is an isoscele triangle");
          break;
        case 3:
          System.out.println("This is a scalene triangle");
          break;
        case 4:
          System.out.println("This is not a triangle");
          break;
        default:
          break;
      }

      keyboard.nextLine();
      System.out.print("Test more cases? (Y/N): ");
      char selectedOption = Character.toLowerCase(keyboard.next().charAt(0));
      if (selectedOption == 'n') break;      
    }   
  }
}
