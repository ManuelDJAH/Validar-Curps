import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Main {

    private static final String curp_regex = "^[A-Z]{4}\\d{6}[HM][A-Z]{5}\\d{2}$";

    public static void main(String[] args) {
        String filePath = "curps.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String linea;
            int numeroLinea = 0;

            while ((linea = br.readLine()) != null) {
                numeroLinea++;
                validarCURP(linea, numeroLinea);
            }
        } catch (IOException e) {
            System.err.println("No se encontro el archivo: " + e.getMessage());
        }
    }

    private static void validarCURP(String curp, int numeroLinea) {
        Pattern pattern = Pattern.compile(curp_regex);
        Matcher matcher = pattern.matcher(curp);

        if (matcher.matches()) {
            System.out.println("En la linea " + numeroLinea + " la CURP es valida: " + curp);
        } else {
            System.out.println("En la linea " + numeroLinea + " la CURP es invalida: " + curp);
        }
    }
}