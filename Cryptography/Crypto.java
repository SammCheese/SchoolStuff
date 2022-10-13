public class Crypto {
    public static void main(String[] args) {

    // Decrypt or Encrypt
    int cryptMethod = Input.readInt("Options:\n0 - Encrypt\n1 - Decrypt\n2 - Exit");

      
    if (cryptMethod == 0) {
        Enc EncObj = new Enc();

        // a hashmap looks like this -> [0 => x, 1 => y, ...] we remove the [] and ,
        String strFormat = EncObj.encryptionModules().toString().replaceAll(", ", "\n").replaceAll("(\\[|\\])", "");

        int cipher = Input.readInt("Cipher:\n" + strFormat);
        String inputText = Input.readString("Text to Encrypt").toLowerCase();
        System.out.println("Encrypted Text: " + EncObj.encrypt(inputText, cipher));

    } 
    if (cryptMethod == 1) {
        Dec DecObj = new Dec();

        String strFormat = DecObj.decryptionModules().toString().replaceAll(", ", "\n").replaceAll("(\\[|\\])", "");

        int cipher = Input.readInt("Cipher:\n" + strFormat);
        String inputText = Input.readString("Text to Decrypt").toLowerCase();
        System.out.println("Decrypted Text: " + DecObj.decrypt(inputText, cipher));
    } else {
        System.exit(1);
    }
}