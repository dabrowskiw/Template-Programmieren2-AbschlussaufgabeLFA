package org.htw.prog2.lfa;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Configuration {
    public Configuration(File configfile) throws IOException, FormatException {
    }

    public int[] getControlCoordinates() {
        return null;
    }

    public int[] getTestCoordinates() {
        return null;
    }

    public double getRatio() {
        return 0;
    }

    public boolean isBorderEnabled() {
        return false;
    }

    public void setBorderEnabled(boolean enabled) {
    }

    public int getBorderWidth() {
        return 0;
    }
}
