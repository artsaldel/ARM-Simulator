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

TEXT = ([a-zA-Z] | [0-9] | "_")*
ADDRESS = "#0x"[[0-9]|[A-F]]+
NUMBER = "#""-"?[0-9]+

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

    ";"                {  return symbol(sym.SEMICOLON);     }
    ","                {  return symbol(sym.COMA);          }
    "["                {  return symbol(sym.OPENBRACKET);   }
    "]"                {  return symbol(sym.CLOSEBRACKET);  }

    "AND"              {  return symbol(sym.AND);   }
    "EOR"              {  return symbol(sym.EOR);   }
    "SUB"              {  return symbol(sym.SUB);   } 
    "RSB"              {  return symbol(sym.RSB);   }  
    "ADD"              {  return symbol(sym.ADD);   }  
    "ADC"              {  return symbol(sym.ADC);   }  
    "SBC"              {  return symbol(sym.SBC);   }  
    "RSC"              {  return symbol(sym.RSC);   }  
    "CMP"              {  return symbol(sym.CMP);   } 
    "CMN"              {  return symbol(sym.CMN);   }  
    "ORR"              {  return symbol(sym.ORR);   }  
    "MOV"              {  return symbol(sym.MOV);   } 
    "LSL"              {  return symbol(sym.LSL);   }  
    "ASR"              {  return symbol(sym.ASR);   }  
    "RRX"              {  return symbol(sym.RRX);   }  
    "ROR"              {  return symbol(sym.ROR);   }  
    "BIC"              {  return symbol(sym.BIC);   }
    "MVN"              {  return symbol(sym.MVN);   } 
    "MUL"              {  return symbol(sym.MUL);   } 
    "MLA"              {  return symbol(sym.MLA);   }
    "STR"              {  return symbol(sym.STR);   } 
    "LDR"              {  return symbol(sym.LDR);   } 
    "STRB"             {  return symbol(sym.STRB);  }
    "LDRB"             {  return symbol(sym.LDRB);  }
    "B"                {  return symbol(sym.B);     }
    "BL"               {  return symbol(sym.BL);    }
    "BEQ"              {  return symbol(sym.BEQ);   }
    "BNE"              {  return symbol(sym.BNE);   }
    "BGT"              {  return symbol(sym.BGT);   }
    "BLT"              {  return symbol(sym.BLT);   }

    {JUMP}             {  return symbol(sym.NEWLINE);        }
    {SPACE}            {  /* do nothing */                   }

    {ADDRESS}          {  return symbol(sym.ADDRESS, new String(yytext()));   }
    {NUMBER}           {  return symbol(sym.NUMBER,  new String(yytext()));   }
    {TEXT}             {  return symbol(sym.TEXT,    new String(yytext()));   }
}

[^]                    { throw new Error("Caracter ilegal <"+yytext()+">");  }


