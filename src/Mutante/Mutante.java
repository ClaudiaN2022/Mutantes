package Mutante;

import javax.imageio.stream.ImageInputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Mutante {

    public static void main(String[] args) {
    }
    public static boolean isMutant(String[] dna) {

            int n = dna.length;
            if (n != 6) {
                throw new IllegalArgumentException("La matriz debe ser cuadrada (6x6).");
            }

            char[][] grid = new char[n][n];

            // Llenar la cuadrícula con las letras del ADN
            for (int i = 0; i < n; i++) {
                String row = dna[i];
                if (row.length() != 6) {
                    throw new IllegalArgumentException("Cada fila debe tener exactamente 6 caracteres.");
                }
                grid[i] = row.toCharArray();
            }

            return hasMutantSequence(grid);
        }


        private static boolean hasMutantSequence ( char[][] grid){
            int n = grid.length;
            Pattern pattern = Pattern.compile("(.)\\1{3}"); // Expresión regular para encontrar 4 letras iguales.

            for (int i = 0; i < n; i++) {
                String row = new String(grid[i]);
                String column = "";

                for (int j = 0; j < n; j++) {
                    column += grid[j][i];
                }

                Matcher rowMatcher = pattern.matcher(row);
                Matcher columnMatcher = pattern.matcher(column);

                if (rowMatcher.find() || columnMatcher.find()) {
                    return true;
                }
            }

            return false;
        }


    }
