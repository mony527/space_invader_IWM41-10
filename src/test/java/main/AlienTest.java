package main;

import org.junit.jupiter.api.Test;
import space_invaders.sprites.Alien;
import space_invaders.sprites.Sprite;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AlienTest {

    private final Alien alien = new Alien(0,0);

    @Test
    public void testCajaNegraAlienCreado(){
        int x = 2;
        int y = 7;
        Alien alien = new Alien(x,y);
        assertNotNull(alien, "Alien should be created succesfully");
        assertEquals(x, alien.getX(), "Alien x should be "+x);
        assertEquals(y, alien.getY(), "Alien y should be "+y);
    }

    @Test
    public void testCajaNegraAlienInicializado1(){
        try {
            Method method = Alien.class.getDeclaredMethod("initAlien", int.class, int.class);
            method.setAccessible(true);
            method.invoke(alien, 150,5);

            Field valx = Alien.class.getDeclaredField("x");
            valx.setAccessible(true);
            int x = ((Integer) valx.get(alien)).intValue();
            Field valy = Alien.class.getDeclaredField("y");
            valy.setAccessible(true);
            int y = (int) valy.get(alien);

            assertEquals(x, alien.getX(), "Alien x should be " + x);
            assertEquals(y, alien.getY(), "Alien y should be " + y);
        }catch (Exception e){

        }
    }

    @Test
    public void testCajaNegraAlienInicializado2(){
        try {
            Method method = Alien.class.getDeclaredMethod("initAlien", int.class, int.class);
            method.setAccessible(true);
            method.invoke(alien, 150,0);

            Field valx = Alien.class.getDeclaredField("x");
            valx.setAccessible(true);
            int x = ((Integer) valx.get(alien)).intValue();
            Field valy = Alien.class.getDeclaredField("y");
            valy.setAccessible(true);
            int y = (int) valy.get(alien);

            assertEquals(x, alien.getX(), "Alien x should be " + x);
            assertEquals(y, alien.getY(), "Alien y should be " + y);
        }catch (Exception e){

        }
    }

    @Test
    public void testCajaNegraAlienInicializado3(){
        try {
            Method method = Alien.class.getDeclaredMethod("initAlien", int.class, int.class);
            method.setAccessible(true);
            method.invoke(alien, 150,1);

            Field valx = Alien.class.getDeclaredField("x");
            valx.setAccessible(true);
            int x = ((Integer) valx.get(alien)).intValue();
            Field valy = Alien.class.getDeclaredField("y");
            valy.setAccessible(true);
            int y = (int) valy.get(alien);

            assertEquals(x, alien.getX(), "Alien x should be " + x);
            assertEquals(y, alien.getY(), "Alien y should be " + y);
        }catch (Exception e){

        }
    }

    @Test
    public void testCajaNegraAlienInicializado4(){
        try {
            Method method = Alien.class.getDeclaredMethod("initAlien", int.class, int.class);
            method.setAccessible(true);
            method.invoke(alien, 150,357);

            Field valx = Alien.class.getDeclaredField("x");
            valx.setAccessible(true);
            int x = ((Integer) valx.get(alien)).intValue();
            Field valy = Alien.class.getDeclaredField("y");
            valy.setAccessible(true);
            int y = (int) valy.get(alien);

            assertEquals(x, alien.getX(), "Alien x should be " + x);
            assertEquals(y, alien.getY(), "Alien y should be " + y);
        }catch (Exception e){

        }
    }

    @Test
    public void testCajaNegraAlienInicializado5(){
        try {
            Method method = Alien.class.getDeclaredMethod("initAlien", int.class, int.class);
            method.setAccessible(true);
            method.invoke(alien, 150,358);

            Field valx = Alien.class.getDeclaredField("x");
            valx.setAccessible(true);
            int x = ((Integer) valx.get(alien)).intValue();
            Field valy = Alien.class.getDeclaredField("y");
            valy.setAccessible(true);
            int y = (int) valy.get(alien);

            assertEquals(x, alien.getX(), "Alien x should be " + x);
            assertEquals(y, alien.getY(), "Alien y should be " + y);
        }catch (Exception e){

        }
    }

    @Test
    public void testCajaNegraAlienInicializado6(){
        try {
            Method method = Alien.class.getDeclaredMethod("initAlien", int.class, int.class);
            method.setAccessible(true);
            method.invoke(alien, 150,-1);

            Field valx = Alien.class.getDeclaredField("x");
            valx.setAccessible(true);
            int x = ((Integer) valx.get(alien)).intValue();
            Field valy = Alien.class.getDeclaredField("y");
            valy.setAccessible(true);
            int y = (int) valy.get(alien);

            assertEquals(x, alien.getX(), "Alien x should be " + x);
            assertEquals(0, alien.getY(), "Alien y should be "+0);
        }catch (Exception e){

        }
    }

    @Test
    public void testCajaNegraAlienInicializado7(){
        try {
            Method method = Alien.class.getDeclaredMethod("initAlien", int.class, int.class);
            method.setAccessible(true);
            method.invoke(alien, 150,359);

            Field valx = Alien.class.getDeclaredField("x");
            valx.setAccessible(true);
            int x = ((Integer) valx.get(alien)).intValue();
            Field valy = Alien.class.getDeclaredField("y");
            valy.setAccessible(true);
            int y = (int) valy.get(alien);

            assertEquals(x, alien.getX(), "Alien x should be " + x);
            assertEquals(358, alien.getY(), "Alien y should be "+ 358);
        }catch (Exception e){

        }
    }

    @Test
    public void testCajaNegraAlienInicializado8(){
        try {
            Method method = Alien.class.getDeclaredMethod("initAlien", int.class, int.class);
            method.setAccessible(true);
            method.invoke(alien, 0,5);

            Field valx = Alien.class.getDeclaredField("x");
            valx.setAccessible(true);
            int x = ((Integer) valx.get(alien)).intValue();
            Field valy = Alien.class.getDeclaredField("y");
            valy.setAccessible(true);
            int y = (int) valy.get(alien);

            assertEquals(x, alien.getX(), "Alien x should be " + x);
            assertEquals(y, alien.getY(), "Alien y should be "+y);
        }catch (Exception e){

        }
    }

    @Test
    public void testCajaNegraAlienInicializado9(){
        try {
            Method method = Alien.class.getDeclaredMethod("initAlien", int.class, int.class);
            method.setAccessible(true);
            method.invoke(alien, 1,5);

            Field valx = Alien.class.getDeclaredField("x");
            valx.setAccessible(true);
            int x = ((Integer) valx.get(alien)).intValue();
            Field valy = Alien.class.getDeclaredField("y");
            valy.setAccessible(true);
            int y = (int) valy.get(alien);

            assertEquals(x, alien.getX(), "Alien x should be " + x);
            assertEquals(y, alien.getY(), "Alien y should be "+y);
        }catch (Exception e){

        }
    }

    @Test
    public void testCajaNegraAlienInicializado10(){
        try {
            Method method = Alien.class.getDeclaredMethod("initAlien", int.class, int.class);
            method.setAccessible(true);
            method.invoke(alien, 349,5);

            Field valx = Alien.class.getDeclaredField("x");
            valx.setAccessible(true);
            int x = ((Integer) valx.get(alien)).intValue();
            Field valy = Alien.class.getDeclaredField("y");
            valy.setAccessible(true);
            int y = (int) valy.get(alien);

            assertEquals(x, alien.getX(), "Alien x should be " + x);
            assertEquals(y, alien.getY(), "Alien y should be "+y);
        }catch (Exception e){

        }
    }
    @Test
    public void testCajaNegraAlienInicializado11(){
        try {
            Method method = Alien.class.getDeclaredMethod("initAlien", int.class, int.class);
            method.setAccessible(true);
            method.invoke(alien, 350,5);

            Field valx = Alien.class.getDeclaredField("x");
            valx.setAccessible(true);
            int x = ((Integer) valx.get(alien)).intValue();
            Field valy = Alien.class.getDeclaredField("y");
            valy.setAccessible(true);
            int y = (int) valy.get(alien);

            assertEquals(x, alien.getX(), "Alien x should be " + x);
            assertEquals(y, alien.getY(), "Alien y should be "+y);
        }catch (Exception e){

        }
    }

    @Test
    public void testCajaNegraAlienInicializado12(){
        try {
            Method method = Alien.class.getDeclaredMethod("initAlien", int.class, int.class);
            method.setAccessible(true);
            method.invoke(alien, -1,5);

            Field valx = Alien.class.getDeclaredField("x");
            valx.setAccessible(true);
            int x = ((Integer) valx.get(alien)).intValue();
            Field valy = Alien.class.getDeclaredField("y");
            valy.setAccessible(true);
            int y = (int) valy.get(alien);

            assertEquals(0, alien.getX(), "Alien x should be " + 0);
            assertEquals(y, alien.getY(), "Alien y should be "+y);
        }catch (Exception e){

        }
    }

    @Test
    public void testCajaNegraAlienInicializado13(){
        try {
            Method method = Alien.class.getDeclaredMethod("initAlien", int.class, int.class);
            method.setAccessible(true);
            method.invoke(alien, 351,5);

            Field valx = Alien.class.getDeclaredField("x");
            valx.setAccessible(true);
            int x = ((Integer) valx.get(alien)).intValue();
            Field valy = Alien.class.getDeclaredField("y");
            valy.setAccessible(true);
            int y = (int) valy.get(alien);

            assertEquals(350, alien.getX(), "Alien x should be " + 350);
            assertEquals(y, alien.getY(), "Alien y should be "+y);
        }catch (Exception e){

        }
    }
}
