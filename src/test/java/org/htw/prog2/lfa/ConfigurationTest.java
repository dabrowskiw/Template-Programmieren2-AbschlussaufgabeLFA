package org.htw.prog2.lfa;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ConfigurationTest {

    @Test
    void constructorWrongLineLengthCoords() {
        try {
            Configuration coords = new Configuration(new File("coordinates_wrong1.txt"));
        } catch(FormatException e) {
            assertEquals("Wrong format in line 'test 7 23 64': wrong number of fields (expected 5: test <upper left x> <upper left y> <lower right x> <lower right y>).", e.getMessage());
            return;
        } catch(IOException e) {
        }
        fail("Es sollte beim Einlesen von coordinates_wrong1.txt eine FormatException fliegen.");
    }

    @Test
    void constructorWrongLineLengthRatio() {
        try {
            Configuration coords = new Configuration(new File("coordinates_wrong4.txt"));
        } catch(FormatException e) {
            assertEquals("Wrong format in line 'ratio 0.7 2': wrong number of fields (expected 2: ratio <ratio>).", e.getMessage());
            return;
        } catch(IOException e) {
        }
        fail("Es sollte beim Einlesen von coordinates_wrong4.txt eine FormatException fliegen.");
    }

    @Test
    void constructorWrongNumberFormatCoords() {
        try {
            Configuration coords = new Configuration(new File("coordinates_wrong2.txt"));
        } catch(FormatException e) {
            assertEquals("Wrong format in line 'control 7 16a 23 23': one of the coordinates could not be parsed as an integer.", e.getMessage());
            return;
        } catch(IOException e) {
        }
        fail("Es sollte beim Einlesen von coordinates_wrong1.txt eine FormatException fliegen.");
    }

    @Test
    void constructorWrongNumberFormatRatio() {
        try {
            Configuration coords = new Configuration(new File("coordinates_wrong5.txt"));
        } catch(FormatException e) {
            assertEquals("Wrong format in line 'ratio ten': ratio could not be parsed as a double.", e.getMessage());
            return;
        } catch(IOException e) {
        }
        fail("Es sollte beim Einlesen von coordinates_wrong5.txt eine FormatException fliegen.");
    }

    @Test
    void constructorWrongName() {
        try {
            Configuration coords = new Configuration(new File("coordinates_wrong3.txt"));
        } catch(FormatException e) {
            assertEquals("Wrong format in line 'controll 7 16 23 23': unknown name 'controll'.", e.getMessage());
            return;
        } catch(IOException e) {
        }
        fail("Es sollte beim Einlesen von coordinates_wrong1.txt eine FormatException fliegen.");
    }

    @Test
    void constructorMissingFile() {
        assertThrows(IOException.class, () -> {
            Configuration coords = new Configuration(new File("IDONTEXIST"));
        });
    }


    @Test
    void getCoordinatesControl() throws IOException, FormatException {
        Configuration coords = new Configuration(new File("coordinates_correct.txt"));
        assertArrayEquals(new int[] {1, 22, 333, 4444}, coords.getControlCoordinates());
    }

    @Test
    void getCoordinatesTest() throws IOException, FormatException {
        Configuration coords = new Configuration(new File("coordinates_correct.txt"));
        assertArrayEquals(new int[] {5555, 666, 77, 8}, coords.getTestCoordinates());
    }

    @Test
    void isBorderEnabled() throws IOException, FormatException {
        Configuration coords = new Configuration(new File("coordinates_correct.txt"));
        assertFalse(coords.isBorderEnabled());
    }

    @Test
    void setBorderEnabled() throws IOException, FormatException {
        Configuration coords = new Configuration(new File("coordinates_correct.txt"));
        coords.setBorderEnabled(true);
        assertTrue(coords.isBorderEnabled());
    }

    @Test
    void getBorderWidth() throws IOException, FormatException {
        Configuration coords = new Configuration(new File("coordinates_correct.txt"));
        assertEquals(10, coords.getBorderWidth());
    }
}