package ARManalyzers;

import java_cup.runtime.*;
import java.io.Reader;
      
%% 

%class LexicalAnalyzer

%line
%column
%cup
%{
    private Symbol symbol(int type) {
        return new Symbol(type, yyline, yycolumn);
    }
    private Symbol symbol(int type, Object value) {
        return new Symbol(type, yyline, yycolumn, value);
    }
%}

JUMP = \r|\n|\r\n
SPACE = [ \t\f]

LETTER =   [a-fA-F]
INT   =   -?[0-9]+
HEX   =   (({LETTER} | [0-9]){0,3})+



%% 
   
<YYINITIAL> {
    
    "r0"               {  return symbol(sym.REGISTER, new String(yytext()));      }
    "r1"               {  return symbol(sym.REGISTER, new String(yytext()));      }
    "r2"               {  return symbol(sym.REGISTER, new String(yytext()));      }
    "r3"               {  return symbol(sym.REGISTER, new String(yytext()));      }
    "r4"               {  return symbol(sym.REGISTER, new String(yytext()));      }
    "r5"               {  return symbol(sym.REGISTER, new String(yytext()));      }
    "r6"               {  return symbol(sym.REGISTER, new String(yytext()));      }
    "r7"               {  return symbol(sym.REGISTER, new String(yytext()));      }
    "r8"               {  return symbol(sym.REGISTER, new String(yytext()));      }
    "r9"               {  return symbol(sym.REGISTER, new String(yytext()));      }
    "r10"              {  return symbol(sym.REGISTER, new String(yytext()));      }
    "r11"              {  return symbol(sym.REGISTER, new String(yytext()));      }
    "r12"              {  return symbol(sym.REGISTER, new String(yytext()));      }
    "r13"              {  return symbol(sym.REGISTER, new String(yytext()));      }
    "r14"              {  return symbol(sym.REGISTER, new String(yytext()));      }
    "r15"              {  return symbol(sym.REGISTER, new String(yytext()));      }

    ","                {  return symbol(sym.COMA);          }
    ";"                {  return symbol(sym.SEMICOLON);     }
    "#"                {  return symbol(sym.SHARP);         }
    "0x"               {  return symbol(sym.ZEROX);         }
    "["                {  return symbol(sym.OPENBRACKET)    }
    "]"                {  return symbol(sym.CLOSEBRACKET)   }

    "AND"              {  return symbol(sym.AND)   }
    "EOR"              {  return symbol(sym.EOR)   }
    "SUB"              {  return symbol(sym.SUB)   } 
    "RSB"              {  return symbol(sym.RSB)   }  
    "ADD"              {  return symbol(sym.ADD)   }  
    "ADC"              {  return symbol(sym.ADC)   }  
    "SBC"              {  return symbol(sym.SBC)   }  
    "RSC"              {  return symbol(sym.RSC)   }  
    "CMP"              {  return symbol(sym.CMP)   } 
    "CMN"              {  return symbol(sym.CMN)   }  
    "ORR"              {  return symbol(sym.ORR)   }  
    "MOV"              {  return symbol(sym.MOV)   } 
    "LSL"              {  return symbol(sym.LSL)   }  
    "ASR"              {  return symbol(sym.ASR)   }  
    "RRX"              {  return symbol(sym.RRX)   }  
    "ROR"              {  return symbol(sym.ROR)   }  
    "BIC"              {  return symbol(sym.BIC)   }
    "MVN"              {  return symbol(sym.MVN)   } 
    "MUL"              {  return symbol(sym.MUL)   } 
    "MLA"              {  return symbol(sym.MLA)   }
    "STR"              {  return symbol(sym.STR)   } 
    "LDR"              {  return symbol(sym.LDR)   } 
    "STRB"             {  return symbol(sym.STRB)  }
    "LDRB"             {  return symbol(sym.LDRB)  }
    "B"                {  return symbol(sym.B)     }
    "BL"               {  return symbol(sym.BL)    }

    {JUMP}             {  return symbol(sym.NEWLINE);        }
    {SPACE}            {  /* do nothing */                   }

    {HEX}              {  return symbol(sym.HEX, new String(yytext()));   }
    {INT}              {  return symbol(sym.INT, new Integer(yytext()));  }
}

[^]                    { throw new Error("Caracter ilegal <"+yytext()+">");  }


