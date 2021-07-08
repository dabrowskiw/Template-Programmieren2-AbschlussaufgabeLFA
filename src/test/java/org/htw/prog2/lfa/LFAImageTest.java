package org.htw.prog2.lfa;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class LFAImageTest {

    @Test
    void constructorThrowsInexistentFile() {
        assertThrows(IOException.class, () -> {
            LFAImage image = new LFAImage(new File("IDONTEXIST"));
        });
    }

    @Test
    void getAverageIntensity() throws IOException {
        LFAImage image = new LFAImage(new File("LFA-3.png"));
        assertEquals(517, image.getAverageIntensity(new int[] {7, 15, 24, 24}), 2);
    }

    @Test
    void getAverageIntensityOutside() throws IOException {
        LFAImage image = new LFAImage(new File("LFA-3.png"));
        assertEquals(451, image.getAverageIntensity(new int[] {7, -5, 24, 15}), 2);
    }

    @Test
    void getCorrectedAverageIntensity() throws IOException {
        LFAImage image = new LFAImage(new File("LFA-3.png"));
        assertEquals(142, image.getAverageIntensityCorrected(new int[] {7, 15, 24, 24}, 10), 2);
    }

    @Test
    void getCorrectedAverageIntensityOutside() throws IOException {
        LFAImage image = new LFAImage(new File("LFA-3.png"));
        assertEquals(176, image.getAverageIntensityCorrected(new int[] {7, 15, 24, 24}, 30), 2);
    }

}