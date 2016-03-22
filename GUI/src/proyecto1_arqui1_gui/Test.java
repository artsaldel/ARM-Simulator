package proyecto1_arqui1_gui;

import javax.swing.*;
import java.awt.*;
import javax.swing.text.*;

/**
 *
 * @author http://stackoverflow.com/questions/14400946/how-to-change-the-color-of-specific-words-in-a-jtextpane
 */

public class Test extends JFrame {
    
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

    public Test (JTextPane txt) {
        
        final StyleContext cont = StyleContext.getDefaultStyleContext();
        final AttributeSet attr = cont.addAttribute(cont.getEmptySet(), StyleConstants.Foreground, Color.RED);
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
                        if (text.substring(wordL, wordR).matches("(\\W)*(R1|R2|R3)"))
                            setCharacterAttributes(wordL, wordR - wordL, attr, false);
                        else if (text.substring(wordL, wordR).matches("(\\W)*(MOV|ADD|SUB)"))
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

                if (text.substring(before, after).matches("(\\W)*(R1|R2|R3)")) 
                    setCharacterAttributes(before, after - before, attr, false);
                else if (text.substring(before, after).matches("(\\W)*(MOV|ADD|SUB)"))
                    setCharacterAttributes(before, after - before, attr, false);
                else 
                    setCharacterAttributes(before, after - before, attrBlack, false);
                
            }
        };
        txt.setDocument(doc);
    }


}   // FIN DE LA CLASE

