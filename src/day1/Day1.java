package day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Day1 {

    public static void main(String[] args) throws Exception {
        ArrayList<Integer> list = lecturarArchivo();

        Integer suma = 0;
        for(Integer i : list) {
            suma += i;
        }
        System.out.println("SUMA: " + suma);
    }

    private static ArrayList<Integer> lecturarArchivo() throws Exception{

        ArrayList<Integer> ret = new ArrayList<>();

            BufferedReader br = new BufferedReader(new FileReader("resources/day1.txt"));
            try {
                String line = "";

                while ( (line = br.readLine()) != null) {

                    Integer numero = obtenNumero(line);

                    System.out.println(line);
                    System.out.println(numero);

                    ret.add(numero);
                }
                //String everything = sb.toString();

            } finally {
                br.close();
            }

            return ret;
        }


    private static Integer obtenNumero(String everything) {

        String numero = "";
        boolean first = true;
        String lastNumber = "";

        for(int i = 0; i < everything.length(); i++) {
            Character c = everything.charAt(i);
            if(Character.isDigit(c)) {
                if(first) {
                    numero = c.toString();
                    lastNumber = c.toString();
                    first = false;
                } else {
                    lastNumber = c.toString();
                }
            }
        }

        return Integer.parseInt(numero + lastNumber);
    }

}
