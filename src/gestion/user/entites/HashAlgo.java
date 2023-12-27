package gestion.user.entites;

public class HashAlgo {

    public static String crypter(String texteClair) {
        StringBuilder texteCrypte = new StringBuilder();

        for (int i = 0; i < texteClair.length(); i++) {
            char caractere = texteClair.charAt(i);
            int nouveauCodeASCII = (int) caractere + 1;

            texteCrypte.append((char) nouveauCodeASCII);
        }

        return texteCrypte.toString();
    }

    public static String decrypter(String texteCrypte) {
        StringBuilder texteClair = new StringBuilder();

        for (int i = 0; i < texteCrypte.length(); i++) {
            char caractere = texteCrypte.charAt(i);
            int nouveauCodeASCII = (int) caractere - 1;

            texteClair.append((char) nouveauCodeASCII);
        }

        return texteClair.toString();
    }

}
