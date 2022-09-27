public class bubbleSort {
   public static int[] genTestcase(int amount) {
      int[] numbers = new int[amount];
      Random gen = new Random();
      for (int i = 0; i < amount; i++) {
         numbers[i] = gen.nextInt(100);
      }
      return numbers;
   }

   public static void printArray(int[] Arr) {
      String Output = "'";
      for (int i = 0; i < Arr.length; i++) {
         
         Output += Arr[i] + ", ";
      }
      Output += "'";
      System.out.println(Output);
   }

   public static int[] bubbleSort(int[] n) {
      int max = 0;

      int smaller;
      int bigger;

      boolean run = true;

      for (int i = 0; i < n.length && run == true; i++) {
         run = false;
         for (int y = 0; y < n.length - 1; y++) {
            if(n[y] > n[y + 1]) {
               bigger = n[y];
               smaller = n[y + 1];
               n[y] = smaller;
               n[y + 1] = bigger;
               run = true;
            }
         }
      }

      return n;
   }

   public static void main(String[] args) {
      int[] n = genTestcase(6);
      int[] result = bubbleSort(n);
      
      for (int a = 0; a < result.length; a++) {
         System.out.print(result[a] + " ");
      }
   }
}