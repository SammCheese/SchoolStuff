public class Dec {
   String Alphabet = "abcdefghijklmnopqrstuvwxyz";

   public String decrypt(String data, int method) {
      String decrypted = "";
      switch(method) {
         case 0 : {
               decrypted = this.Ceasar(data);
               break;
            }
         case 1 : {
               decrypted = this.Vigenere(data);
               break;
            }
      }
      return decrypted;
   }

   public HashMap decryptionModules() {
      HashMap<Integer, String> modules = new HashMap<Integer, String>();
      modules.put(0, "Ceasar");
      modules.put(1, "Vigenere");
      modules.put(2, "Beaufort");
      return modules;
   }

   public String Vigenere(String input) {
      String decString = "";

      // We need a second argument, the Key
      String Key = Input.readString("Key:");

      for (int i = 0, j = 0; i < input.length(); i++) { 
         if(j == Key.length()) j = 0;

         // This will be our shift :D
         int keyIndexInAlphabet = Alphabet.indexOf(Key.charAt(j));

         // Check if the Character is in the Alphabet Array
         if(Alphabet.indexOf(input.charAt((i))) < 0) {
            decString += input.charAt(i);
            continue;
         }

         // Wrap if resulting index is higher than the alphabet length
         if(Alphabet.indexOf(input.charAt(i)) - keyIndexInAlphabet < 0) {
            int numberUnder = Alphabet.indexOf(input.charAt(i)) - keyIndexInAlphabet + Alphabet.length();
            decString += Alphabet.charAt(numberUnder);
            j++;
            continue;
         }

         decString += Alphabet.charAt(Alphabet.indexOf(input.charAt(i)) - keyIndexInAlphabet);
         j++;
      }

      return decString;
   }

   public String Ceasar(String input) {
      String decString = "";

      int Shift = Input.readInt("Shift", 4);

      for (int i = 0; i < input.length(); i++) {

         // If the character isnt in our Alphabet Array, just keep it
         if(Alphabet.indexOf(input.charAt(i)) < 0) {
            decString += input.charAt(i);
            continue;
         }

         // Wrap if too small  
         if(Alphabet.indexOf(input.charAt(i)) - Shift < 0) {
            int numberUnder = Alphabet.indexOf(input.charAt(i)) - Shift + Alphabet.length();
            decString += Alphabet.charAt(numberUnder);
            continue;
         } 

         decString += Alphabet.charAt(Alphabet.indexOf(input.charAt(i)) - Shift);
      }
      return decString;
   }

}