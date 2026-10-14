package main;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import space_invaders.sprites.Alien;
import space_invaders.sprites.Sprite;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BombTest {
    //private void initBomb(int x, int y) --> robust single fault assumption valores límites
    //Inicializa el nuevo objeto bomba y le asigna las coordenadas indicadas y la imagen correspondiente en la interfaz
    //Parameters:
    //x - coordenada X de la posición de la nueva bomba
    //y - coordenada Y de la posición de la nueva bomba
    // Si el valor X o Y indicados superan el margen de la pantalla,
    // se les asignará el valor máximo permitido. Si se introduce algún valor negativo,
    // será reemplazado por 0.
    private final Alien alien = new Alien(0,0);
    private final Alien.Bomb bomb = alien.new Bomb(0,0);

    @Test
    public void robustBoundaryValueTesting_initBomb_1(){
        try{
            Method method = Alien.Bomb.class.getDeclaredMethod("initBomb", int.class, int.class);
            method.setAccessible(true);
            method.invoke(bomb, -1,175);

            Field valx = Sprite.class.getDeclaredField("x");
            valx.setAccessible(true);
            int valorx = ((Integer) valx.get(bomb)).intValue();
            Field valy = Sprite.class.getDeclaredField("y");
            valy.setAccessible(true);
            int valory = (int) valy.get(bomb);
            assertTrue((valorx == -1) && (valory==175));

        }catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException | NoSuchFieldException e){
            throw new RuntimeException(e);
        }

    }

    @Test
    public void robustBoundaryValueTesting_initBomb_2(){
        try{
            Method method = Alien.Bomb.class.getDeclaredMethod("initBomb", int.class, int.class);
            method.setAccessible(true);
            method.invoke(bomb, 0,175);

            Field valx = Sprite.class.getDeclaredField("x");
            valx.setAccessible(true);
            int valorx = ((Integer) valx.get(bomb)).intValue();
            Field valy = Sprite.class.getDeclaredField("y");
            valy.setAccessible(true);
            int valory = (int) valy.get(bomb);
            assertTrue((valorx == 0) && (valory==175));

        }catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException | NoSuchFieldException e){
            throw new RuntimeException(e);
        }

    }

    @Test
    public void robustBoundaryValueTesting_initBomb_3(){
        try{
            Method method = Alien.Bomb.class.getDeclaredMethod("initBomb", int.class, int.class);
            method.setAccessible(true);
            method.invoke(bomb, 1,175);

            Field valx = Sprite.class.getDeclaredField("x");
            valx.setAccessible(true);
            int valorx = ((Integer) valx.get(bomb)).intValue();
            Field valy = Sprite.class.getDeclaredField("y");
            valy.setAccessible(true);
            int valory = (int) valy.get(bomb);
            assertTrue((valorx == 1) && (valory==175));

        }catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException | NoSuchFieldException e){
            throw new RuntimeException(e);
        }

    }

    @Test
    public void robustBoundaryValueTesting_initBomb_4(){
        try{
            Method method = Alien.Bomb.class.getDeclaredMethod("initBomb", int.class, int.class);
            method.setAccessible(true);
            method.invoke(bomb, 179,175);

            Field valx = Sprite.class.getDeclaredField("x");
            valx.setAccessible(true);
            int valorx = ((Integer) valx.get(bomb)).intValue();
            Field valy = Sprite.class.getDeclaredField("y");
            valy.setAccessible(true);
            int valory = (int) valy.get(bomb);
            assertTrue((valorx == 179) && (valory==175));

        }catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException | NoSuchFieldException e){
            throw new RuntimeException(e);
        }

    }

    @Test
    public void robustBoundaryValueTesting_initBomb_5(){
        try{
            Method method = Alien.Bomb.class.getDeclaredMethod("initBomb", int.class, int.class);
            method.setAccessible(true);
            method.invoke(bomb, 357,175);

            Field valx = Sprite.class.getDeclaredField("x");
            valx.setAccessible(true);
            int valorx = ((Integer) valx.get(bomb)).intValue();
            Field valy = Sprite.class.getDeclaredField("y");
            valy.setAccessible(true);
            int valory = (int) valy.get(bomb);
            assertTrue((valorx == 357) && (valory==175));

        }catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException | NoSuchFieldException e){
            throw new RuntimeException(e);
        }

    }

    @Test
    public void robustBoundaryValueTesting_initBomb_6(){
        try{
            Method method = Alien.Bomb.class.getDeclaredMethod("initBomb", int.class, int.class);
            method.setAccessible(true);
            method.invoke(bomb, 358,175);

            Field valx = Sprite.class.getDeclaredField("x");
            valx.setAccessible(true);
            int valorx = ((Integer) valx.get(bomb)).intValue();
            Field valy = Sprite.class.getDeclaredField("y");
            valy.setAccessible(true);
            int valory = (int) valy.get(bomb);
            assertTrue((valorx == 358) && (valory==175));

        }catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException | NoSuchFieldException e){
            throw new RuntimeException(e);
        }

    }

    @Test
    public void robustBoundaryValueTesting_initBomb_7(){
        try{
            Method method = Alien.Bomb.class.getDeclaredMethod("initBomb", int.class, int.class);
            method.setAccessible(true);
            method.invoke(bomb, 359,175);

            Field valx = Sprite.class.getDeclaredField("x");
            valx.setAccessible(true);
            int valorx = ((Integer) valx.get(bomb)).intValue();
            Field valy = Sprite.class.getDeclaredField("y");
            valy.setAccessible(true);
            int valory = (int) valy.get(bomb);
            assertEquals(358, valorx);
            assertEquals(175, valory);
            //assertTrue((valorx == 358) && (valory==175));

        }catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException | NoSuchFieldException e){
            throw new RuntimeException(e);
        }

    }

    @Test
    public void robustBoundaryValueTesting_initBomb_8(){
        try{
            Method method = Alien.Bomb.class.getDeclaredMethod("initBomb", int.class, int.class);
            method.setAccessible(true);
            method.invoke(bomb, 179,-1);

            Field valx = Sprite.class.getDeclaredField("x");
            valx.setAccessible(true);
            int valorx = ((Integer) valx.get(bomb)).intValue();
            Field valy = Sprite.class.getDeclaredField("y");
            valy.setAccessible(true);
            int valory = (int) valy.get(bomb);
            assertTrue((valorx == 179) && (valory==-1));

        }catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException | NoSuchFieldException e){
            throw new RuntimeException(e);
        }

    }

    @Test
    public void robustBoundaryValueTesting_initBomb_9(){
        try{
            Method method = Alien.Bomb.class.getDeclaredMethod("initBomb", int.class, int.class);
            method.setAccessible(true);
            method.invoke(bomb, 179,0);

            Field valx = Sprite.class.getDeclaredField("x");
            valx.setAccessible(true);
            int valorx = ((Integer) valx.get(bomb)).intValue();
            Field valy = Sprite.class.getDeclaredField("y");
            valy.setAccessible(true);
            int valory = (int) valy.get(bomb);
            assertTrue((valorx == 179) && (valory==0));

        }catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException | NoSuchFieldException e){
            throw new RuntimeException(e);
        }

    }

    @Test
    public void robustBoundaryValueTesting_initBomb_10(){
        try{
            Method method = Alien.Bomb.class.getDeclaredMethod("initBomb", int.class, int.class);
            method.setAccessible(true);
            method.invoke(bomb, 179,1);

            Field valx = Sprite.class.getDeclaredField("x");
            valx.setAccessible(true);
            int valorx = ((Integer) valx.get(bomb)).intValue();
            Field valy = Sprite.class.getDeclaredField("y");
            valy.setAccessible(true);
            int valory = (int) valy.get(bomb);
            assertTrue((valorx == 179) && (valory==1));

        }catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException | NoSuchFieldException e){
            throw new RuntimeException(e);
        }

    }

    @Test
    public void robustBoundaryValueTesting_initBomb_11(){
        try{
            Method method = Alien.Bomb.class.getDeclaredMethod("initBomb", int.class, int.class);
            method.setAccessible(true);
            method.invoke(bomb, 179,349);

            Field valx = Sprite.class.getDeclaredField("x");
            valx.setAccessible(true);
            int valorx = ((Integer) valx.get(bomb)).intValue();
            Field valy = Sprite.class.getDeclaredField("y");
            valy.setAccessible(true);
            int valory = (int) valy.get(bomb);
            assertTrue((valorx == 179) && (valory==349));

        }catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException | NoSuchFieldException e){
            throw new RuntimeException(e);
        }

    }

    @Test
    public void robustBoundaryValueTesting_initBomb_12(){
        try{
            Method method = Alien.Bomb.class.getDeclaredMethod("initBomb", int.class, int.class);
            method.setAccessible(true);
            method.invoke(bomb, 179,350);

            Field valx = Sprite.class.getDeclaredField("x");
            valx.setAccessible(true);
            int valorx = ((Integer) valx.get(bomb)).intValue();
            Field valy = Sprite.class.getDeclaredField("y");
            valy.setAccessible(true);
            int valory = (int) valy.get(bomb);
            assertTrue((valorx == 179) && (valory==350));

        }catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException | NoSuchFieldException e){
            throw new RuntimeException(e);
        }

    }

    @Test
    public void robustBoundaryValueTesting_initBomb_13(){
        try{
            Method method = Alien.Bomb.class.getDeclaredMethod("initBomb", int.class, int.class);
            method.setAccessible(true);
            method.invoke(bomb, 179,351);

            Field valx = Sprite.class.getDeclaredField("x");
            valx.setAccessible(true);
            int valorx = ((Integer) valx.get(bomb)).intValue();
            Field valy = Sprite.class.getDeclaredField("y");
            valy.setAccessible(true);
            int valory = (int) valy.get(bomb);
            assertEquals(350, valory);
            assertEquals(179, valorx);
            //assertTrue((valorx == 179) && (valory==350));

        }catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException | NoSuchFieldException e){
            throw new RuntimeException(e);
        }

    }



}
