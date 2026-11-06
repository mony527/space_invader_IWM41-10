package main;

import org.junit.jupiter.api.Test;
import space_invaders.sprites.Player;

import java.awt.*;
import space_invaders.sprites.Alien;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class BoardTest {
    @Test
    public void testCajaNegraBoardCreado(){
        Board board = new Board();

        try{
            Method metodo = Board.class.getDeclaredMethod("initBoard");
            metodo.setAccessible(true);
            metodo.invoke(board);

            Field valX = Player.class.getDeclaredField("d");
            valX.setAccessible(true);
            Dimension dimension = (Dimension) valX.get(board);
            int dimX = dimension.width;
            int dimY = dimension.height;

            assertEquals(358, dimX, "La dimension X del tablero no es correcta");
            assertEquals(350, dimY, "La dimension Y del tablero no es correcta");
            assertNotNull(board, "Board se ha creado correctamente");

        } catch (Exception e){
            System.out.println("Error al crear el board");
        }
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


    @Test
    public void testCajaNegraJuegoCreado(){
        try{
            Board board = new Board();

            Field aliens = Board.class.getDeclaredField("aliens");
            aliens.setAccessible(true);
            List<Alien> listaAliens =(List<Alien>)  aliens.get(board);
            int k = 0;
            for(int j = 0; j < 4; j++) {
                for (int i = 0; i < 6; i++) {
                    assertEquals(Commons.ALIEN_INIT_X + i * Commons.ALIEN_SEPARATOR, listaAliens.get(k).getX(),
                            "El alien número: " + k+1 + " no está bien colocado en el eje X");
                    assertEquals(Commons.ALIEN_INIT_Y + j * Commons.ALIEN_SEPARATOR, listaAliens.get(k).getY(),
                            "El alien número: " +  k+1 + " no está bien colocado en el eje Y");
                    k++;
                }
            }
        } catch (Exception e) {
        }
    }

    @Test
    public void testUpdateBoard(){
       try{
           Board board = new Board();

           // Obtener parametros y funciones privados
           Method updateMethod = Board.class.getDeclaredMethod("update");
           updateMethod.setAccessible(true);

           Field campoDeaths = Board.class.getDeclaredField("deaths");
           campoDeaths.setAccessible(true);

           Field campoMessage = Board.class.getDeclaredField("message");
           campoMessage.setAccessible(true);

           // Caso 1: Valor -> NUMBER_OF_ALIENS_TO_DESTROY
           board.setDeaths(Commons.NUMBER_OF_ALIENS_TO_DESTROY);
           updateMethod.invoke(board);

           int valorDeaths1 = board.getDeaths();
           String valorMessage1 = board.getMessage();

           System.out.println("1 - El valor dado es " + valorDeaths1 + " y el esperado era " + Commons.NUMBER_OF_ALIENS_TO_DESTROY);
           assertEquals(Commons.NUMBER_OF_ALIENS_TO_DESTROY, valorDeaths1);
           assertEquals("Game Over", valorMessage1);

           // Caso 2: Valor -> 25
           board.setDeaths(25);
           updateMethod.invoke(board);

           int valorDeaths2 =  board.getDeaths();
           String valorMessage2 = board.getMessage();
           System.out.println("2 - El valor dado es " + valorDeaths2 + " y el esperado era " + 25);
           assertEquals(25, valorDeaths2);
           assertEquals("Game Over", valorMessage2);

           // Caso 3: Valor -> 24
           board.setDeaths(24);
           updateMethod.invoke(board);

           int valorDeaths3 =  board.getDeaths();
           String valorMessage3 = board.getMessage();
           System.out.println("3 - El valor dado es " + valorDeaths3 + " y el esperado era " + 24);
           assertEquals(24, valorDeaths3);
           assertEquals("Game Won!", valorMessage3);

       } catch (Exception e){
           System.out.println("Error al actualizar el board");
           System.out.println(e.getMessage());
       }

    }
}



