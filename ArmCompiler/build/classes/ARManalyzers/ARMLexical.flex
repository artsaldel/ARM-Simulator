package ARManalyzers;

import java_cup.runtime.*;
import java.io.Reader;
import ARManalyzers.ModuloError;
      
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
    "-"                {  return symbol(sym.LESS);          }

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

    "ADDEQ"            {  return symbol(sym.ADDEQ); }
    "ADDLT"            {  return symbol(sym.ADDLT); }
    "ADDGT"            {  return symbol(sym.ADDGT); }
    "ADDNE"            {  return symbol(sym.ADDNE); }

    "ORREQ"            {  return symbol(sym.ORREQ); }
    "ORRLT"            {  return symbol(sym.ORRLT); }
    "ORRGT"            {  return symbol(sym.ORRGT); }
    "ORRNE"            {  return symbol(sym.ORRNE); }

    "ANDEQ"            {  return symbol(sym.ANDEQ); }
    "ANDLT"            {  return symbol(sym.ANDLT); }
    "ANDGT"            {  return symbol(sym.ANDGT); }
    "ANDNE"            {  return symbol(sym.ANDNE); }

    "SUBEQ"            {  return symbol(sym.SUBEQ); }
    "SUBLT"            {  return symbol(sym.SUBLT); }
    "SUBGT"            {  return symbol(sym.SUBGT); }
    "SUBNE"            {  return symbol(sym.SUBNE); }

    "EOREQ"            {  return symbol(sym.EOREQ); }
    "EORLT"            {  return symbol(sym.EORLT); }
    "EORGT"            {  return symbol(sym.EORGT); }
    "EORNE"            {  return symbol(sym.EORNE); }

    "ROREQ"            {  return symbol(sym.ROREQ); }
    "RORLT"            {  return symbol(sym.RORLT); }
    "RORGT"            {  return symbol(sym.RORGT); }
    "RORNE"            {  return symbol(sym.RORNE); }


    "and"              {  return symbol(sym.AND);   }
    "eor"              {  return symbol(sym.EOR);   }
    "sub"              {  return symbol(sym.SUB);   } 
    "rsb"              {  return symbol(sym.RSB);   }  
    "add"              {  return symbol(sym.ADD);   }  
    "adc"              {  return symbol(sym.ADC);   }  
    "sbc"              {  return symbol(sym.SBC);   }  
    "rsc"              {  return symbol(sym.RSC);   }  
    "cmp"              {  return symbol(sym.CMP);   } 
    "cmn"              {  return symbol(sym.CMN);   }  
    "orr"              {  return symbol(sym.ORR);   }  
    "mov"              {  return symbol(sym.MOV);   } 
    "lsl"              {  return symbol(sym.LSL);   }  
    "asr"              {  return symbol(sym.ASR);   }  
    "rrx"              {  return symbol(sym.RRX);   }  
    "ror"              {  return symbol(sym.ROR);   }  
    "bic"              {  return symbol(sym.BIC);   }
    "mvn"              {  return symbol(sym.MVN);   } 
    "mul"              {  return symbol(sym.MUL);   } 
    "mla"              {  return symbol(sym.MLA);   }
    "str"              {  return symbol(sym.STR);   } 
    "ldr"              {  return symbol(sym.LDR);   } 
    "strb"             {  return symbol(sym.STRB);  }
    "lsdrb"             {  return symbol(sym.LDRB);  }
    "b"                {  return symbol(sym.B);     }
    "bl"               {  return symbol(sym.BL);    }
    "beq"              {  return symbol(sym.BEQ);   }
    "bne"              {  return symbol(sym.BNE);   }
    "bgt"              {  return symbol(sym.BGT);   }
    "blt"              {  return symbol(sym.BLT);   }

    "addeq"            {  return symbol(sym.ADDEQ); }
    "addlt"            {  return symbol(sym.ADDLT); }
    "addgt"            {  return symbol(sym.ADDGT); }
    "addne"            {  return symbol(sym.ADDNE); }

    "orreq"            {  return symbol(sym.ORREQ); }
    "orrlt"            {  return symbol(sym.ORRLT); }
    "orrgt"            {  return symbol(sym.ORRGT); }
    "orrne"            {  return symbol(sym.ORRNE); }

    "andeq"            {  return symbol(sym.ANDEQ); }
    "andlt"            {  return symbol(sym.ANDLT); }
    "andgt"            {  return symbol(sym.ANDGT); }
    "andne"            {  return symbol(sym.ANDNE); }

    "subeq"            {  return symbol(sym.SUBEQ); }
    "sublt"            {  return symbol(sym.SUBLT); }
    "subgt"            {  return symbol(sym.SUBGT); }
    "subne"            {  return symbol(sym.SUBNE); }

    "eoreq"            {  return symbol(sym.EOREQ); }
    "eorlt"            {  return symbol(sym.EORLT); }
    "eorgt"            {  return symbol(sym.EORGT); }
    "eorne"            {  return symbol(sym.EORNE); }

    "roreq"            {  return symbol(sym.ROREQ); }
    "rorlt"            {  return symbol(sym.RORLT); }
    "rorgt"            {  return symbol(sym.RORGT); }
    "rorne"            {  return symbol(sym.RORNE); }

    {JUMP}             {  return symbol(sym.NEWLINE);        }
    {SPACE}            {  /* do nothing */                   }

    {ADDRESS}          {  return symbol(sym.ADDRESS, new String(yytext()));   }
    {NUMBER}           {  return symbol(sym.NUMBER,  new String(yytext()));   }
    {TEXT}             {  return symbol(sym.TEXT,    new String(yytext()));   }
}

[^]                    { 
                        ModuloError.insertError("Caracter ilegal <"+yytext()+">");
                        throw new Error("Caracter ilegal <"+yytext()+">");
                       }


