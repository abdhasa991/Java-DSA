public class Class_2 {
    public static int printSum(int num1, int num2) {
        return num1 + num2;
    }
    public static void printName(String Name){
        System.out.println("Name: " + Name);
    }

    public static void main(String[] args) {
        String[] array = { "Tahir", "Abdullah" };
        System.out.println(array[0]);
        System.out.println(array[1]);
        System.out.println("Sum = " + printSum(5, 10));
        char[] char_array = {'a','b','c'};
        for (int i = 0; i < char_array.length; i++){
            System.out.println(char_array[i] + " ");
        }
        printName("Abdullah");
    }
}
