/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package br.com.Utilitarios;
import javax.sound.sampled.*;

/**
 *
 * @author Lavanderia
 */
public class CustomBeep {
    public static void beep(int freq, int durationMs) throws LineUnavailableException {
        byte[] buf = new byte[1];
        AudioFormat af = new AudioFormat((float) 44100, 8, 1, true, false);
        SourceDataLine sdl = AudioSystem.getSourceDataLine(af);
        sdl.open(af);
        sdl.start();

        for (int i = 0; i < durationMs * 44100 / 1000; i++) {
            double angle = i / (44100.0 / freq) * 2.0 * Math.PI;
            buf[0] = (byte)(Math.sin(angle) * 127);
            sdl.write(buf, 0, 1);
        }

        sdl.drain();
        sdl.stop();
        sdl.close();
    }
}