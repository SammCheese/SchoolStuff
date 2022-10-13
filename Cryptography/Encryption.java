public class Enc {
   static String Alphabet = "abcdefghijklmnopqrstuvwxyz";

   public String encrypt(String data, int method) {
      String encrypted = "";

      switch(method) {
        case 0 : {
            encrypted = this.Caesar(data);
            break;
        }
        case 1 : {
            encrypted = this.Vigenere(data);
            break;
        }
      }
      return encrypted;
   }
   
   public HashMap encryptionModules() {
      HashMap<Integer, String> modules = new HashMap<Integer, String>();
      modules.put(0, "Ceasar");
      modules.put(1, "Vigenere");
      return modules;
   }

   public String Vigenere(String input) {
      String encString = "";

      // We need a second argument, the Key
      String Key = Input.readString("Key:");

      for (int i = 0, j = 0; i < input.length(); i++) { 
        if (j == Key.length()) j = 0;

        // This will be our shift :D
        int keyIndexInAlphabet = Alphabet.indexOf(Key.charAt(j));

        // Check if the Character is in the Alphabet Array
        if(Alphabet.indexOf(input.charAt((i))) < 0) {
            encString += input.charAt(i);
            continue;
        }

        // Wrap if resulting index is higher than the alphabet length
        if(Alphabet.indexOf(input.charAt(i)) + keyIndexInAlphabet >= Alphabet.length()) {
            int numberOver = Alphabet.indexOf(input.charAt(i)) + keyIndexInAlphabet - Alphabet.length();
            encString += Alphabet.charAt(numberOver);
            j++;
            continue;
        }

        encString += Alphabet.charAt(Alphabet.indexOf(input.charAt(i)) + keyIndexInAlphabet);
        j++;
      }

      return encString;
   }

   public String Caesar(String input) {
      String encString = "";

      // We need a second argument, the shift
      int shift = Input.readInt("Shift:\n", 4);

      for (int i = 0; i < input.length(); i++) {

        // If the character isnt in our Alphabet Array, just keep it
        if(Alphabet.indexOf(input.charAt(i)) < 0) {
            encString += input.charAt(i);
            continue;
        }

        // Wrap if too big   
        if(Alphabet.indexOf(input.charAt(i)) + shift >= Alphabet.length()) {
            int numberOver = Alphabet.indexOf(input.charAt(i)) + shift - Alphabet.length();
            encString += Alphabet.charAt(numberOver);
            continue;
        } 

         encString += Alphabet.charAt(Alphabet.indexOf(input.charAt(i)) + shift);
      }
      return encString;
   }
}