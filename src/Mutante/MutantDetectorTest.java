package Mutante;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;


public class MutantDetectorTest {
    @Test
    public void testIsMutant() {
        // Caso de ADN mutante
        String[] mutantDna = {
                "ATGCGA",
                "CAGTGC",
                "TTATGT",
                "AGAAGG",
                "CCCCTA",
                "TCACTG"
        };
        assertTrue(Mutante.isMutant(mutantDna));

        // Caso de ADN no mutante (todas las letras son diferentes)
        String[] nonMutantDna1 = {
                "ACGTAG",
                "TAGCTA",
                "CGATCG",
                "GCTAGC",
                "AGCTAG",
                "TAGCTA"
        };
        assertFalse(Mutante.isMutant(nonMutantDna1));

        // Caso de ADN no mutante (ninguna secuencia de cuatro letras iguales)
        String[] nonMutantDna2 = {
                "ATGCGA",
                "CAGTGC",
                "TTATGT",
                "AGAAGG",
                "TCACTA",
                "TCACTG"
        };
//        assertFalse(Mutante.isMutant(nonMutantDna2));

        // Caso de ADN mutante con secuencia horizontal
        String[] mutantHorizontal = {
                "AAAAAA",
                "CAGTGC",
                "TTATGT",
                "AGAAGG",
                "CCCCTA",
                "TCACTG"
        };
        assertTrue(Mutante.isMutant(mutantHorizontal));

        // Caso de ADN mutante con secuencia vertical
        String[] mutantVertical = {
                "ATGCGA",
                "AAGTGC",
                "AAGTGT",
                "AAGAGG",
                "CCCCTA",
                "TCACTG"
        };
        assertTrue(Mutante.isMutant(mutantVertical));

        // Caso de ADN mutante con secuencia diagonal derecha
        String[] mutantDiagonalDerecha = {
                "ATGCGA",
                "CAGTGC",
                "TTATGA",
                "AGAAAG",
                "CCCCTA",
                "TCACTG"
        };
        assertTrue(Mutante.isMutant(mutantDiagonalDerecha));

        // Caso de ADN mutante con secuencia diagonal izquierda
        String[] mutantDiagonalIzquierda = {
                "ATGCGA",
                "CAGTGC",
                "TATATG",
                "AGAAGG",
                "CCCCTA",
                "TCACTG"
        };
        assertTrue(Mutante.isMutant(mutantDiagonalIzquierda));
    }
}
