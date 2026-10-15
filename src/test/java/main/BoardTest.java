package main;

import org.junit.jupiter.api.Test;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;


public class BoardTest {
    @Test
    public void creacionBoardTest(){
        Board board = new Board();
        assertNotNull(board, "Board should be created succesfully");
    }
    @Test
    public void PruebaUpdate(){
        try{
        Board board = new Board();

        Field campoDeaths = Board.class.getDeclaredField("deaths");
        campoDeaths.setAccessible(true);
        int valorDeaths = (int) campoDeaths.get(board);

        assertEquals(Commons.NUMBER_OF_ALIENS_TO_DESTROY, valorDeaths, "El número de muertes debe ser igual al número de aliens a destruir");

        Method metodoUpdate = Board.class.getDeclaredMethod("update");
        metodoUpdate.setAccessible(true);
        metodoUpdate.invoke(board);

        Field campoInGame = Board.class.getDeclaredField("inGame");
        campoInGame.setAccessible(true);
        boolean valorInGame = (boolean) campoInGame.get(board);
        
        assertFalse(valorInGame, "El juego debe terminar cuando deaths == Commons.NUMBER_OF_ALIENS_TO_DESTROY");

    } catch (Exception e) {
    }
}
}


