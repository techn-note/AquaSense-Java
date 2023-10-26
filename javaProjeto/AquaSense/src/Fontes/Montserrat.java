/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fontes;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.IOException;

/**
 *
 * @author dsm2
 */
public class Montserrat {

    public Font FonteRegular(int pTamanhoFonte) {
        Font minhaFont = null;
        try {
            minhaFont = Font.createFont(
                    Font.TRUETYPE_FONT,
                    getClass().getResourceAsStream("/Fontes/Montserrat-Regular.ttf")
            ).deriveFont(Font.BOLD, pTamanhoFonte);
            GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(minhaFont);
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (FontFormatException ex) {
            ex.printStackTrace();
        }
        return minhaFont;

    }

    public Font FonteBold(int pTamanhoFonte) {
        Font minhaFont = null;
        try {
            minhaFont = Font.createFont(
                    Font.TRUETYPE_FONT,
                    getClass().getResourceAsStream("/Fontes/Montserrat-Bold.ttf")
            ).deriveFont(Font.BOLD, pTamanhoFonte);
            GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(minhaFont);
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (FontFormatException ex) {
            ex.printStackTrace();
        }
        return minhaFont;

    }
}
