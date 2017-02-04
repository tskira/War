/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package war;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Usuario
 */
public class JogadorTest {
    
    public JogadorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of conqTerritorio method, of class Jogador.
     */
    @Test
    public void testConqTerritorio() {
        System.out.println("conqTerritorio");
        Territorio conquistado = null;
        Jogador instance = null;
        instance.conqTerritorio(conquistado);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of nroTerritorios method, of class Jogador.
     */
    @Test
    public void testNroTerritorios() {
        System.out.println("nroTerritorios");
        Jogador instance = null;
        int expResult = 0;
        int result = instance.nroTerritorios();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTerritorio method, of class Jogador.
     */
    @Test
    public void testGetTerritorio() {
        System.out.println("getTerritorio");
        Jogador instance = null;
        List<Territorio> expResult = null;
        List<Territorio> result = instance.getTerritorio();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCor method, of class Jogador.
     */
    @Test
    public void testGetCor() {
        System.out.println("getCor");
        Jogador instance = null;
        Cor expResult = null;
        Cor result = instance.getCor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of nroExercitos method, of class Jogador.
     */
    @Test
    public void testNroExercitos() {
        System.out.println("nroExercitos");
        Exercito exercito = null;
        Jogador instance = null;
        int expResult = 0;
        int result = instance.nroExercitos(exercito);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of recebeExercito method, of class Jogador.
     */
    @Test
    public void testRecebeExercito() {
        System.out.println("recebeExercito");
        Exercito novo = null;
        Jogador instance = null;
        instance.recebeExercito(novo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of alocarExercito method, of class Jogador.
     */
    @Test
    public void testAlocarExercito_Territorio_Exercito() {
        System.out.println("alocarExercito");
        Territorio destino = null;
        Exercito exercito = null;
        Jogador instance = null;
        instance.alocarExercito(destino, exercito);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of alocarExercito method, of class Jogador.
     */
    @Test
    public void testAlocarExercito_3args() {
        System.out.println("alocarExercito");
        Territorio origem = null;
        Territorio destino = null;
        Exercito exercito = null;
        Jogador instance = null;
        instance.alocarExercito(origem, destino, exercito);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of commitJogada method, of class Jogador.
     */
    @Test
    public void testCommitJogada() {
        System.out.println("commitJogada");
        Jogador instance = null;
        instance.commitJogada();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of resetaMovimentos method, of class Jogador.
     */
    @Test
    public void testResetaMovimentos() {
        System.out.println("resetaMovimentos");
        Jogador instance = null;
        instance.resetaMovimentos();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of atacarTerritorio method, of class Jogador.
     */
    @Test
    public void testAtacarTerritorio_4args() {
        System.out.println("atacarTerritorio");
        Territorio origem = null;
        Territorio alvo = null;
        Terrestre exercito = null;
        int nroAtk = 0;
        Jogador instance = null;
        int[] expResult = null;
        int[] result = instance.atacarTerritorio(origem, alvo, exercito, nroAtk);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of atacarTerritorio method, of class Jogador.
     */
    @Test
    public void testAtacarTerritorio_Aereo_Territorio() {
        System.out.println("atacarTerritorio");
        Aereo exercito = null;
        Territorio alvo = null;
        Jogador instance = null;
        int[] expResult = null;
        int[] result = instance.atacarTerritorio(exercito, alvo);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of verificaGanhou method, of class Jogador.
     */
    @Test
    public void testVerificaGanhou() {
        System.out.println("verificaGanhou");
        Jogador instance = null;
        boolean expResult = false;
        boolean result = instance.verificaGanhou();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
