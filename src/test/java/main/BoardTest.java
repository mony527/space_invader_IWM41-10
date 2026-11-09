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

    @Test
    public void testUShotsCN1(){
        try{
            Board board = new Board();
            Method metodo = Board.class.getDeclaredMethod("update_shots");
            metodo.setAccessible(true);

            Field campoDeaths = Board.class.getDeclaredField("deaths");
            campoDeaths.setAccessible(true);

            //Vaciamos la lista de aliens para comprobar qué ocurre si un shot no toca un alien
            Field aliens = Board.class.getDeclaredField("aliens");
            aliens.setAccessible(true);
            List<Alien> listaAliens =(List<Alien>)  aliens.get(board);
            listaAliens.clear();

            int preEjec = (int) campoDeaths.get(board);
            //ejecutamos metodo
            metodo.invoke(board);
            //Hay que comprobar que el numero de muertes se mantiene, o sea, no se elimino nigun alien
            int postEjec = (int) campoDeaths.get(board);
            assertEquals(preEjec, postEjec, "Se han eliminado aliens aunque no se haya alcanzado ninguno");

        }catch(Exception e){
            System.out.println("Error al actualizar los aliens");
        }
    }

    @Test
    public void testUShotsCN2(){
        try{
            Board board = new Board();
            Method metodo = Board.class.getDeclaredMethod("update_shots");
            metodo.setAccessible(true);

            Field campoDeaths = Board.class.getDeclaredField("deaths");
            campoDeaths.setAccessible(true);

            Field aliens = Board.class.getDeclaredField("aliens");
            aliens.setAccessible(true);
            List<Alien> listaAliens =(List<Alien>)  aliens.get(board);

            Field shot = Board.class.getDeclaredField("shot");

            int preEjec = (int) campoDeaths.get(board);
            metodo.invoke(board);
            int postEjec = (int) campoDeaths.get(board);

            assertEquals(postEjec, preEjec+1, "No se actualizan las muertes correctamente");
        }catch(Exception e){
            System.out.println("Error al actualizar los aliens");
        }
    }

    @Test
    public void testUShotsCN3(){
        try{
            Board board = new Board();
            Method metodo = Board.class.getDeclaredMethod("update_shots");
            metodo.setAccessible(true);

            Field campoDeaths = Board.class.getDeclaredField("deaths");
            campoDeaths.setAccessible(true);

            Field shot = Board.class.getDeclaredField("shot");
            //Vaciamos la lista de aliens para comprobar qué ocurre si un shot no toca un alien
            Field aliens = Board.class.getDeclaredField("aliens");
            aliens.setAccessible(true);
            List<Alien> listaAliens =(List<Alien>)  aliens.get(board);
            listaAliens.clear();

            //Hay que probar que llega al limite
            metodo.invoke(board);
            int fin = board.getShot().getY();
            //Su posición en el eje Y deberá acabar siendo 0
            assertEquals(fin,0, "El shot no se ha eliminado en la posición correcta");
        }catch(Exception e){
            System.out.println("Error al actualizar los aliens");
        }
    }

    @Test
    public void testUAlienCN1(){
        try{
            Board board = new Board();
            Method metodo = Board.class.getDeclaredMethod("update_aliens");
            metodo.setAccessible(true);
            Field aliens = Board.class.getDeclaredField("aliens");
            aliens.setAccessible(true);
            List<Alien> listaAliens =(List<Alien>) aliens.get(board);

            listaAliens.get(0).setX(0+Commons.ALIEN_WIDTH);
            int y = listaAliens.get(0).getY();

            int direccion = board.getDirection();
            metodo.invoke(board);

            boolean baja = true;

            for (Alien alien : listaAliens) {
                if (alien.getY() != y+15) {
                    baja = false;
                    break;
                }
            }
            assertEquals(true,baja, "Los aliens no descendieron");
            assertNotEquals(board.getDirection(), direccion,"La dirección no ha cambiado");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testUAlienCN2(){
        try{
            Board board = new Board();
            Method metodo = Board.class.getDeclaredMethod("update_aliens");
            metodo.setAccessible(true);
            Field aliens = Board.class.getDeclaredField("aliens");
            aliens.setAccessible(true);
            List<Alien> listaAliens =(List<Alien>)  aliens.get(board);

            int direccion = board.getDirection();
            int[] pos = new int[listaAliens.size()];

            for(int i=0;i<pos.length;i++){
                pos[i]=listaAliens.get(i).getX();
            }
            metodo.invoke(board);

            boolean desplaza = true;
            if  (direccion == 1){
                for (int i = 0; i < listaAliens.size(); i++) {
                    if (pos[i] != listaAliens.get(i).getX()+1) {
                        desplaza = false;
                    }
                }
            } else {
                for (int i = 0; i < listaAliens.size(); i++) {
                    if (pos[i] != listaAliens.get(i).getX()-1) {
                        desplaza = false;
                    }
                }
            }
            assertEquals(true,desplaza, "Los aliens no se desplazaron correctamente");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testUAlienCN3(){
        try{
            Board board = new Board();
            Method metodo = Board.class.getDeclaredMethod("update_aliens");
            metodo.setAccessible(true);
            Field aliens = Board.class.getDeclaredField("aliens");
            aliens.setAccessible(true);
            List<Alien> listaAliens =(List<Alien>) aliens.get(board);

            listaAliens.get(0).setX(Commons.BOARD_WIDTH-Commons.ALIEN_WIDTH);
            int y = listaAliens.get(0).getY();

            int direccion = board.getDirection();
            metodo.invoke(board);
            boolean baja = true;
            for (Alien alien : listaAliens) {
                if (alien.getY() != y+15) {
                    baja = false;
                    break;
                }
            }
            assertEquals(true,baja, "Los aliens no descendieron");
            assertNotEquals(board.getDirection(), direccion, "La dirección no ha cambiado");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testUAlienCN4(){
        try{
            Board board = new Board();
            Method metodo = Board.class.getDeclaredMethod("update_aliens");
            metodo.setAccessible(true);
            Field aliens = Board.class.getDeclaredField("aliens");
            aliens.setAccessible(true);
            List<Alien> listaAliens =(List<Alien>) aliens.get(board);

            listaAliens.get(0).setY(Commons.GROUND-Commons.ALIEN_HEIGHT);

            metodo.invoke(board);
            String mensaje = board.getMessage();
            assertEquals("Invasion!",mensaje, "El juego no acaba");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Test id: UBombCN1
    @Test
    public void decisionTableTesting_updateBomb1(){
        int numAleatorio = Commons.CHANCE;
        Board board = new Board();
        Method metodo = null;
        Field aliens = null;
        List<Alien> listaAliens = null;
        try {
            metodo = Board.class.getDeclaredMethod("update_bomb");
            metodo.setAccessible(true);
            aliens = Board.class.getDeclaredField("aliens");
            aliens.setAccessible(true);
            listaAliens =(List<Alien>) aliens.get(board);




        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Test id: UBombCN2
    @Test
    public void decisionTableTesting_updateBomb2(){
        Board board = new Board();
        Method metodo = null;
        Field fieldAliens = null;
        Field fieldPlayer = null;
        List<Alien> listaAliens = null;
        Player player = null;
        Alien alien = null;
        Alien.Bomb bomb = null;
        try {
            metodo = Board.class.getDeclaredMethod("update_bomb");
            metodo.setAccessible(true);
            fieldAliens = Board.class.getDeclaredField("aliens");
            fieldAliens.setAccessible(true);
            listaAliens =(List<Alien>) fieldAliens.get(board);
            fieldPlayer = Board.class.getDeclaredField("player");
            fieldPlayer.setAccessible(true);
            player = (Player) fieldPlayer.get(board);

            alien = listaAliens.get(0);
            int x = player.getX()-4;
            int y = player.getY()-Commons.BOMB_HEIGHT-4;
            bomb = alien.getBomb();
            bomb.setDestroyed(false);
            bomb.setX(x);
            bomb.setY(y);

            metodo.invoke(board);

            assertEquals(y + Commons.BOMB_SPEED, bomb.getY(), "Bomb.getY() should be "+ (player.getY()-Commons.BOMB_HEIGHT-4 + Commons.BOMB_SPEED));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Test id: UBombCN3
    @Test
    public void decisionTableTesting_updateBomb3(){
        Board board = new Board();
        Method metodo = null;
        Field fieldAliens = null;
        Field fieldPlayer = null;
        List<Alien> listaAliens = null;
        Player player = null;
        Alien alien = null;
        Alien.Bomb bomb = null;
        try {
            metodo = Board.class.getDeclaredMethod("update_bomb");
            metodo.setAccessible(true);
            fieldAliens = Board.class.getDeclaredField("aliens");
            fieldAliens.setAccessible(true);
            listaAliens =(List<Alien>) fieldAliens.get(board);
            fieldPlayer = Board.class.getDeclaredField("player");
            fieldPlayer.setAccessible(true);
            player = (Player) fieldPlayer.get(board);

            alien = listaAliens.get(0);
            bomb = alien.new Bomb(player.getX(),player.getY()-Commons.BOMB_HEIGHT); //Con colision con jugador

            metodo.invoke(board);

            assertTrue(bomb.isDestroyed(), "Bomb should be destroyed after collision");
            assertTrue(player.isDying(), "Player should die after colliding with the bomb");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Test id: UBombCN4
    @Test
    public void decisionTableTesting_updateBomb4(){

    }

    // Test id: UBombCN5
    @Test
    public void decisionTableTesting_updateBomb5(){
        int numAleatorio = Commons.CHANCE+2;

    }
}



