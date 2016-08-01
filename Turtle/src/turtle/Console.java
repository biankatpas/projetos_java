package turtle;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Bianka Passos
 */
public class Console {

    Scanner ler = new Scanner(System.in);

    /**
     *
     * @return palavras compostas
     */
    public String readText() {
        String texto;
        texto = ler.nextLine();
        return texto;
    }

    /**
     *
     * @return palavras simples que não usam o caractere de espaço (ou barra de
     * espaço)
     */
    public String readWord() {
        String palavra;
        palavra = ler.next();
        return palavra;
    }

    /**
     *
     * @return um valor inteiro
     */
    public int readInteger() {
        int n;
        n = ler.nextInt();
        return n;
    }

    /**
     *
     * @return valor double
     */
    public double readDouble() {
        double n;
        n = ler.nextDouble();
        return n;
    }

    /**
     *
     * @return valor float
     */
    public float readFloat() {
        float n;
        n = ler.nextFloat();
        return n;
    }

    /**
     *
     * @return caracter
     * @throws IOException
     */
    public char readChar() throws IOException {
        char c;
        c = (char) System.in.read();
        return c;
    }

    //esvazia o buffer do teclado
    /**
     * @
     */
    public void clearBuffer() {
        ler.nextLine();
    }

}
