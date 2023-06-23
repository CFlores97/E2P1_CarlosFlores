package e2p1_carlosflores;

public class Numero {

    private int base;
    private String numero;

    public Numero(int base, int numero_a_convertir) {
        this.base = base;
        this.numero = decToBase(numero_a_convertir);
    }

    public char numToChar(int residuo) {
        char correspondingChar = 'a';

        if (residuo >= 0 && residuo <= 9) {
            correspondingChar = (char) (residuo + 48);
        } else if (residuo >= 10) {
            correspondingChar = (char) (residuo + 87);
        }

        return correspondingChar;
    }
    
    public int charToNum(char correspChar){
        int num = 0;
        
        if(correspChar <= 97 && correspChar >= 122){
            num = correspChar - 87;
        }
        
        return num;
    }

    public String decToBase(int dec) {
        String residuo = "";
        int resultado = 0;
        String legitResiduo = "";

        while (base <= dec) {
            resultado = dec / base;
            residuo += dec % base;

            dec = resultado;

        }

        char result_converted = numToChar(resultado);
        if (resultado >= 10 && resultado <= 35) {
            legitResiduo += result_converted;
        } else {
            legitResiduo += resultado;
        }

        int resi = Integer.parseInt(residuo);
        char char_converted = numToChar(resi);

        if (resi >= 10 && resi <= 35) {
            legitResiduo += char_converted;
        } else if (resi < 10 || resi > 35){
            for (int i = residuo.length() - 1; i >= 0; i--) {
                legitResiduo += residuo.charAt(i);
            }

        }

        return legitResiduo;
    }

    public int baseToDec(String cadena) {
        int new_base = 0;
        
        for (int i = cadena.length() - 1; i >= 0; i--) {
            int power = cadena.length() - 1 - i;
            new_base += cadena.charAt(i) * Math.pow(base, power);
        }
        return new_base;
    }
}
