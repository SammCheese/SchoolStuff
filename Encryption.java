public class Enc {

   public String encrypt(String data, int method) {
      String encrypted = "";

      switch(method) {
         case 0 : {
               encrypted = this.Caesar(data);
               break;
            }
      }

      return encrypted;
   }
   
   public HashMap encryption_modules() {
      HashMap<Integer, String> modules = new HashMap<Integer, String>();
      modules.put(0, "Ceasar");
      return modules;
   }


   public String Caesar(String toEncrypt) {
      String encString = "";
      toEncrypt = toEncrypt.toLowerCase();

      // We need a second argument
      int Shift = Input.readInt("Shift", 4);

      String Alphabet = "abcdefghijklmnopqrstuvwxyz";
      for (int i = 0; i < toEncrypt.length(); i++) {

         // If the character isnt in our Alphabet Array, just keep it
         if(Alphabet.indexOf(toEncrypt.charAt(i)) < 0) {
            encString += toEncrypt.charAt(i);
            System.out.println(toEncrypt.charAt(i));
            continue;
         }

         // Wrap if too big   
         if(Alphabet.indexOf(toEncrypt.charAt(i)) + Shift >= Alphabet.length()) {
            int numberOver = Alphabet.indexOf(toEncrypt.charAt(i)) + Shift - Alphabet.length();
            encString += Alphabet.charAt(numberOver);
            continue;
         } 

         encString += Alphabet.charAt(Alphabet.indexOf(toEncrypt.charAt(i)) + Shift);
      }
      return encString;
   }
}

public class Dec {
   public String decrypt(String data, int method) {
      String decrypted = "";
      switch(method) {
         case 0 : {
               decrypted = this.Ceasar(data);
               break;
            }
      }
      return decrypted;
   }

   public HashMap decryption_modules() {
      HashMap<Integer, String> modules = new HashMap<Integer, String>();
      modules.put(0, "Ceasar");
      return modules;
   }

   public String Ceasar(String toDecrypt) {
      String decString = "";

      // We dont need uppercase letters.
      toDecrypt = toDecrypt.toLowerCase();

      int Shift = Input.readInt("Shift", 4);
      String Alphabet = "abcdefghijklmnopqrstuvwxyz";

      for (int i = 0; i < toDecrypt.length(); i++) {

         // If the character isnt in our Alphabet Array, just keep it
         if(Alphabet.indexOf(toDecrypt.charAt(i)) < 0) {
            decString += toDecrypt.charAt(i);
            continue;
         }

         // Wrap if too small  
         if(Alphabet.indexOf(toDecrypt.charAt(i)) - Shift < 0) {
            int numberUnder = Alphabet.indexOf(toDecrypt.charAt(i)) - Shift + Alphabet.length();
            decString += Alphabet.charAt(numberUnder);
            continue;
         } 

         decString += Alphabet.charAt(Alphabet.indexOf(toDecrypt.charAt(i)) - Shift);
      }
      return decString;
   }

}

public class Encryption {
   public static void main(String[] args) {

      // Decrypt or Encrypt
      int cryptMethod = Input.readInt("Options:\n0 - Encrypt\n1 - Decrypt");

      
      if(cryptMethod == 0) {
         Enc EncObj = new Enc();
         String strFormat = EncObj.encryption_modules().toString().replace(",", "\n");
         int cipher = Input.readInt("Cipher:\n" + strFormat, 0);
         String inputText = Input.readString("Text to Encrypt");
         System.out.println("Encrypted Text: "+ EncObj.encrypt(inputText, cipher));

      } else {
         Dec DecObj = new Dec();
         String strFormat = DecObj.decryption_modules().toString().replace(",", "\n");
         int cipher = Input.readInt("Decipher:\n" + strFormat, 0);
         String inputText = Input.readString("Text to Decrypt");
         System.out.println("Decrypted Text: " + DecObj.decrypt(inputText, cipher));
      }
   }



}
