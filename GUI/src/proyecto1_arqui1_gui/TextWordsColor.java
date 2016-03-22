package proyecto1_arqui1_gui;

import javax.swing.*;
import java.awt.*;
import javax.swing.text.*;

/**
 *
 * @author http://stackoverflow.com/questions/14400946/how-to-change-the-color-of-specific-words-in-a-jtextpane
 * Editado por Daniel Araya
 */
public class TextWordsColor extends JFrame {
    
    private int findLastNonWordChar (String text, int index) {
        while (--index >= 0) {
            if (String.valueOf(text.charAt(index)).matches("\\W")) {
                break;
            }
        }
        return index;
    }   // FIN DEL MÉTODO findLastNonWordChar

    private int findFirstNonWordChar (String text, int index) {
        while (index < text.length()) {
            if (String.valueOf(text.charAt(index)).matches("\\W")) {
                break;
            }
            index++;
        }
        return index;
    }   // FIN DEL MÉTODO findFirstNonWordChar

    public TextWordsColor (JTextPane txt) {
        
        String mnemonic = "AND|EOR|SUB|RSB|ADD|ADC|SBC|RSC|CMP|CMN|ORR|MOV|LSL|"
                + "ASR|RRX|ROR|BIC|MVN|MUL|MLA|STR|LDR|STRB|LDRB|B|BL";
        String registros = "R1|R2|R3|R4|R5|R6|R7|R8|R9|R10|R11|R12|R13|R14|R15";
        final StyleContext cont = StyleContext.getDefaultStyleContext();
        // COLOREA DE ROJO LOS REGISTROS
        final AttributeSet attr = cont.addAttribute(cont.getEmptySet(), StyleConstants.Foreground, Color.RED);
        // COLOREA DE VERDE LOS MNEMÓNICOS
        final AttributeSet attr1 = cont.addAttribute(cont.getEmptySet(), StyleConstants.Foreground, Color.GREEN);
        final AttributeSet attrBlack = cont.addAttribute(cont.getEmptySet(), StyleConstants.Foreground, Color.BLACK);
        DefaultStyledDocument doc = new DefaultStyledDocument() {
            public void insertString (int offset, String str, AttributeSet a) throws BadLocationException {
                super.insertString(offset, str, a);

                String text = getText(0, getLength());
                int before = findLastNonWordChar(text, offset);
                if (before < 0) before = 0;
                int after = findFirstNonWordChar(text, offset + str.length());
                int wordL = before;
                int wordR = before;

                while (wordR <= after) {
                    if (wordR == after || String.valueOf(text.charAt(wordR)).matches("\\W")) {
                        if (text.substring(wordL, wordR).matches("(\\W)*("+ registros +")"))
                            setCharacterAttributes(wordL, wordR - wordL, attr, false);
                        else if (text.substring(wordL, wordR).matches("(\\W)*("+ mnemonic +")"))
                            setCharacterAttributes(wordL, wordR - wordL, attr1, false);
                        else
                            setCharacterAttributes(wordL, wordR - wordL, attrBlack, false);
                        wordL = wordR;
                    }
                    wordR++;
                }
            }

            public void remove (int offs, int len) throws BadLocationException {
                super.remove(offs, len);

                String text = getText(0, getLength());
                int before = findLastNonWordChar(text, offs);
                if (before < 0) before = 0;
                int after = findFirstNonWordChar(text, offs);

                if (text.substring(before, after).matches("(\\W)*("+ registros +")")) 
                    setCharacterAttributes(before, after - before, attr, false);
                else if (text.substring(before, after).matches("(\\W)*("+ mnemonic +")"))
                    setCharacterAttributes(before, after - before, attr, false);
                else 
                    setCharacterAttributes(before, after - before, attrBlack, false);
                
            }
        };
        txt.setDocument(doc);
    }


}   // FIN DE LA CLASE

    

