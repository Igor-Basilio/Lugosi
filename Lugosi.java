/* Generated By:JavaCC: Do not edit this line. Lugosi.java */
    package parser;
    import java.io.*;
    import syntacticTree.*;
    import java.util.ArrayList;

    public class Lugosi implements LugosiConstants {

      final static String Version = "Lugosi Compiler / Transpiler 1.0 - 2024";

      // String com a tradução de lug -> js.
      static String target =
          "const readline = require('readline');\u005cn\u005cn"
         +"const rl = readline.createInterface({\u005cn"
         +"  input: process.stdin,\u005cn"
         +"  output: process.stdout\u005cn"
         +"});\u005cn\u005cn"
         +"function readIO(prompt)\u005cn{"
         +"\u005cn  return new Promise((resolve) => {\u005cn"
         +"    rl.question(prompt, resolve);\u005cn"
         +"  });\u005cn"
         +"}\u005cn\u005cn"
          ;

      public static void main(String args[]) throws ParseException,IOException {

         Lugosi analisador = new Lugosi(new FileInputStream(args[0]));
         ProgramNode ast = analisador.Lugosi();

         // System.out.println(ast); 
         // Não é necessário utilizar uma ast
         // porque o nível de abstração entre Lugosi e 
         // Javascript é similar.
         // Na verdade não seria necessário para nenhuma
         // linguagem de alto nível, já que os statements 
         // são bem parecidos 
         // Ex : let int x; ( lug ) -> let x; ( js ) -> int x; ( c )
         // Ainda é mais fácil já que javascript é uma 
         // linguagem dinamicamente tipada.

         PrintWriter out = null;
        try {
            out = new PrintWriter(args[0] + ".js");
            out.println(target);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }


      }

  final public ProgramNode Lugosi() throws ParseException {
  Token eof = null;
  MainNode main = null;
  FunctionNode bf = null, af = null;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case DEF:
      bf = FUNC();
      break;
    default:
      jj_la1[0] = jj_gen;
      ;
    }
    main = MAIN();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case DEF:
      af = FUNC();
      break;
    default:
      jj_la1[1] = jj_gen;
      ;
    }
    eof = jj_consume_token(0);
    {if (true) return new ProgramNode(eof, main, bf, af);}
    throw new Error("Missing return statement in function");
  }

  final public MainNode MAIN() throws ParseException {
  Token main = null;
  VarDeclBase vd = null;
  SeqCommandsNode sc = null;
  Token r_type = null;
    r_type = jj_consume_token(VOID);
                    target+="async ";
    main = jj_consume_token(MAIN);
                 target+="function main()\u005cn";
    jj_consume_token(ACHAVES);
             target+="{\u005cn";
    vd = VARDECL();
    sc = SEQCOMANDOS();
    jj_consume_token(FCHAVES);
             target+="}\u005cn\u005cnmain(); \u005cn\u005cn";
    {if (true) return new MainNode(main, vd, sc, r_type);}
    throw new Error("Missing return statement in function");
  }

  final public VarDeclBase VARDECL() throws ParseException {
  VarDeclBase b = new VarDeclBase();
  VarDeclNode n;
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case LET:
        ;
        break;
      default:
        jj_la1[2] = jj_gen;
        break label_1;
      }
      n = VARDECL_S();
                      b.decls.add(n);
    }
    {if (true) return b;}
    throw new Error("Missing return statement in function");
  }

  final public VarDeclNode VARDECL_S() throws ParseException {
   Token t = null, r = null;
   ArrayList<Token> ids;
    r = jj_consume_token(LET);
              target += "   let ";
    t = TIPO();
    ids = LISTID();
    jj_consume_token(SEMICOLON);
                 target +=";\u005cn";
    {if (true) return new VarDeclNode(r, t, ids);}
    throw new Error("Missing return statement in function");
  }

  final public ArrayList<Token> LISTID() throws ParseException {
  Token id;
  ArrayList<Token> ids = new ArrayList<Token>();
    id = jj_consume_token(ID);
              target += id.image; ids.add(id);
    LISTID_L(ids);
    {if (true) return ids;}
    throw new Error("Missing return statement in function");
  }

  final public void LISTID_L(ArrayList<Token> ids) throws ParseException {
  Token id;
    label_2:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case COMMA:
        ;
        break;
      default:
        jj_la1[3] = jj_gen;
        break label_2;
      }
      jj_consume_token(COMMA);
                 target += ", ";
      id = jj_consume_token(ID);
                   target += id.image; ids.add(id);
    }
  }

  final public Token TIPO() throws ParseException {
  Token t = null;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case FLOAT:
      t = jj_consume_token(FLOAT);
      break;
    case BOOLEAN:
      t = jj_consume_token(BOOLEAN);
      break;
    case VOID:
      t = jj_consume_token(VOID);
      break;
    case STRING:
      t = jj_consume_token(STRING);
      break;
    case INT:
      t = jj_consume_token(INT);
      break;
    default:
      jj_la1[4] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
      {if (true) return t;}
    throw new Error("Missing return statement in function");
  }

  final public SeqCommandsNode SEQCOMANDOS() throws ParseException {
    target += "\u005cn";
    label_3:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case IF:
      case WHILE:
      case RETURN:
      case PRINTIO:
      case ID:
        ;
        break;
      default:
        jj_la1[5] = jj_gen;
        break label_3;
      }
      COMANDO();
               target +="\u005cn";
    }
    target+="\u005cn"; {if (true) return null;}
    throw new Error("Missing return statement in function");
  }

  final public void COMANDO() throws ParseException {
                  Token id; Token attr;
    if (jj_2_1(3)) {
      id = jj_consume_token(ID);
                            target+="\u005cn   try {\u005cn      "+id.image;
      jj_consume_token(ATTRIB);
                      target+=" = ";
      jj_consume_token(READIO);
                      target+="parseInt( await readIO(\u005c"\u005c") );\u005cn"
             +"   }catch(err)\u005cn"
             +"   {\u005cn"
             +"      console.log(\u005c"Erro: \u005c", err);\u005cn"
             +"   }finally{\u005cn"
             +"      rl.close();\u005cn"
             +"   }\u005cn";
      jj_consume_token(APAREN);
      jj_consume_token(FPAREN);
      jj_consume_token(SEMICOLON);
    } else if (jj_2_2(2)) {
      id = jj_consume_token(ID);
              target+="   "+id.image;
      attr = jj_consume_token(ATTRIB);
                   target+=" = ";
      EXP();
      jj_consume_token(SEMICOLON);
                  target+=";";
    } else if (jj_2_3(2)) {
      id = jj_consume_token(ID);
               target+="   "+id.image;
      jj_consume_token(APAREN);
                                                   target+="(";
      LISTAEXP();
      jj_consume_token(FPAREN);
                           target+=")";
      jj_consume_token(SEMICOLON);
                                                       target+=";";
    } else {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case IF:
        jj_consume_token(IF);
            target+="   if(";
        EXP();
        jj_consume_token(ACHAVES);
                        target+="){\u005cn";
        SEQCOMANDOS();
        jj_consume_token(FCHAVES);
                 target+="   }";
        jj_consume_token(SEMICOLON);
                   target+=";";
        break;
      case WHILE:
        jj_consume_token(WHILE);
                target+="   while ";
        jj_consume_token(APAREN);
                                                 target+="(";
        EXP();
        jj_consume_token(FPAREN);
                       target+=")\u005cn";
        jj_consume_token(DO);
        jj_consume_token(ACHAVES);
                       target+="   {";
        SEQCOMANDOS();
        jj_consume_token(FCHAVES);
                                target+="   }";
        jj_consume_token(SEMICOLON);
                    target+=";";
        break;
      case RETURN:
        jj_consume_token(RETURN);
                target+="   return ";
        EXP();
        jj_consume_token(SEMICOLON);
                                                           target+=";";
        break;
      case PRINTIO:
        jj_consume_token(PRINTIO);
                 target+="   console.log(";
        EXP();
        jj_consume_token(SEMICOLON);
                                                                 target+=");";
        break;
      default:
        jj_la1[6] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
  }

  final public void EXP() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case APAREN:
      jj_consume_token(APAREN);
                   target += "(";
      EXP();
      jj_consume_token(FPAREN);
                                                     target += ")";
      break;
    case TRUE:
    case FALSE:
    case NUM:
    case ID:
    case STRING_LITERAL:
      FATOR();
                 target+=" ";
      break;
    default:
      jj_la1[7] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    label_4:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case PLUS:
      case MINUS:
      case MULT:
      case DIV:
      case AND:
      case OR:
      case LESSOP:
      case MOREOP:
      case LESSEQ:
      case MOREEQ:
      case EQUALS:
      case MODULO:
        ;
        break;
      default:
        jj_la1[8] = jj_gen;
        break label_4;
      }
      OP();
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case APAREN:
        jj_consume_token(APAREN);
                       target += "(";
        EXP();
        jj_consume_token(FPAREN);
                                                         target += ")";
        break;
      case TRUE:
      case FALSE:
      case NUM:
      case ID:
      case STRING_LITERAL:
        FATOR();
                     target+=" ";
        break;
      default:
        jj_la1[9] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
  }

  final public void FATOR() throws ParseException {
                Token id; Token num; Token str_literal;
    if (jj_2_4(2)) {
      id = jj_consume_token(ID);
                            target+=id.image;
      jj_consume_token(APAREN);
                target+="(";
      LISTAEXP();
      jj_consume_token(FPAREN);
                target+=")";
    } else {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case ID:
        id = jj_consume_token(ID);
               target+=id.image;
        break;
      case NUM:
        num = jj_consume_token(NUM);
                 target+=num.image;
        break;
      case STRING_LITERAL:
        str_literal = jj_consume_token(STRING_LITERAL);
                                    target+=str_literal.image;
        break;
      case TRUE:
        jj_consume_token(TRUE);
              target+="true";
        break;
      case FALSE:
        jj_consume_token(FALSE);
               target+="false";
        break;
      default:
        jj_la1[10] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
  }

  final public void OP() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case PLUS:
      jj_consume_token(PLUS);
            target+="+ ";
      break;
    case MINUS:
      jj_consume_token(MINUS);
             target+="- ";
      break;
    case MULT:
      jj_consume_token(MULT);
            target+="* ";
      break;
    case DIV:
      jj_consume_token(DIV);
           target+="/ ";
      break;
    case AND:
      jj_consume_token(AND);
           target+="&& ";
      break;
    case OR:
      jj_consume_token(OR);
          target+="|| ";
      break;
    case LESSOP:
      jj_consume_token(LESSOP);
              target+="< ";
      break;
    case MOREOP:
      jj_consume_token(MOREOP);
              target+="> ";
      break;
    case EQUALS:
      jj_consume_token(EQUALS);
              target+="== ";
      break;
    case LESSEQ:
      jj_consume_token(LESSEQ);
              target+="<= ";
      break;
    case MOREEQ:
      jj_consume_token(MOREEQ);
              target+=">= ";
      break;
    case MODULO:
      jj_consume_token(MODULO);
              target+="% ";
      break;
    default:
      jj_la1[11] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void LISTAEXP() throws ParseException {
    EXP();
    LISTAEXP_L();
  }

  final public void LISTAEXP_L() throws ParseException {
    label_5:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case COMMA:
        ;
        break;
      default:
        jj_la1[12] = jj_gen;
        break label_5;
      }
      jj_consume_token(COMMA);
            target+=",";
      EXP();
    }
  }

  final public void LISTAARG() throws ParseException {
                  Token var_id;
    TIPO();
    var_id = jj_consume_token(ID);
                  target += var_id.image;
    LISTAARG_L();
  }

  final public void LISTAARG_L() throws ParseException {
                    Token rvar_id;
    label_6:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case COMMA:
        ;
        break;
      default:
        jj_la1[13] = jj_gen;
        break label_6;
      }
      jj_consume_token(COMMA);
               target += ", ";
      TIPO();
      rvar_id = jj_consume_token(ID);
                    target += rvar_id;
    }
  }

  final public FunctionNode FUNC() throws ParseException {
    FUNC_D();
    FUNC_L();
      {if (true) return null;}
    throw new Error("Missing return statement in function");
  }

  final public void FUNC_L() throws ParseException {
    label_7:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case DEF:
        ;
        break;
      default:
        jj_la1[14] = jj_gen;
        break label_7;
      }
      FUNC_D();
    }
  }

  final public void FUNC_D() throws ParseException {
                 Token func_id;
    jj_consume_token(DEF);
             target += "function ";
    TIPO();
    func_id = jj_consume_token(ID);
                            target += func_id.image;
    jj_consume_token(APAREN);
                target += "(";
    LISTAARG();
    jj_consume_token(FPAREN);
               target += ")\u005cn";
    jj_consume_token(ACHAVES);
                 target +="{\u005cn";
    VARDECL();
    SEQCOMANDOS();
    jj_consume_token(FCHAVES);
                 target += "}\u005cn\u005cn";
  }

  private boolean jj_2_1(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_1(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(0, xla); }
  }

  private boolean jj_2_2(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_2(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(1, xla); }
  }

  private boolean jj_2_3(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_3(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(2, xla); }
  }

  private boolean jj_2_4(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_4(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(3, xla); }
  }

  private boolean jj_3_3() {
    if (jj_scan_token(ID)) return true;
    if (jj_scan_token(APAREN)) return true;
    return false;
  }

  private boolean jj_3_4() {
    if (jj_scan_token(ID)) return true;
    if (jj_scan_token(APAREN)) return true;
    return false;
  }

  private boolean jj_3_2() {
    if (jj_scan_token(ID)) return true;
    if (jj_scan_token(ATTRIB)) return true;
    return false;
  }

  private boolean jj_3_1() {
    if (jj_scan_token(ID)) return true;
    if (jj_scan_token(ATTRIB)) return true;
    if (jj_scan_token(READIO)) return true;
    return false;
  }

  /** Generated Token Manager. */
  public LugosiTokenManager token_source;
  SimpleCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private Token jj_scanpos, jj_lastpos;
  private int jj_la;
  private int jj_gen;
  final private int[] jj_la1 = new int[15];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
      jj_la1_init_0();
      jj_la1_init_1();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x0,0x0,0x1000,0x0,0x2e800,0xca00000,0xca00000,0x30080000,0xc0000000,0x30080000,0x30000000,0xc0000000,0x0,0x0,0x0,};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {0x400,0x400,0x0,0x800,0x0,0x2000,0x0,0xb000,0x3ff,0xb000,0xb000,0x3ff,0x800,0x800,0x400,};
   }
  final private JJCalls[] jj_2_rtns = new JJCalls[4];
  private boolean jj_rescan = false;
  private int jj_gc = 0;

  /** Constructor with InputStream. */
  public Lugosi(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public Lugosi(java.io.InputStream stream, String encoding) {
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new LugosiTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 15; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 15; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor. */
  public Lugosi(java.io.Reader stream) {
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new LugosiTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 15; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 15; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor with generated Token Manager. */
  public Lugosi(LugosiTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 15; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(LugosiTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 15; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      if (++jj_gc > 100) {
        jj_gc = 0;
        for (int i = 0; i < jj_2_rtns.length; i++) {
          JJCalls c = jj_2_rtns[i];
          while (c != null) {
            if (c.gen < jj_gen) c.first = null;
            c = c.next;
          }
        }
      }
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }

  static private final class LookaheadSuccess extends java.lang.Error { }
  final private LookaheadSuccess jj_ls = new LookaheadSuccess();
  private boolean jj_scan_token(int kind) {
    if (jj_scanpos == jj_lastpos) {
      jj_la--;
      if (jj_scanpos.next == null) {
        jj_lastpos = jj_scanpos = jj_scanpos.next = token_source.getNextToken();
      } else {
        jj_lastpos = jj_scanpos = jj_scanpos.next;
      }
    } else {
      jj_scanpos = jj_scanpos.next;
    }
    if (jj_rescan) {
      int i = 0; Token tok = token;
      while (tok != null && tok != jj_scanpos) { i++; tok = tok.next; }
      if (tok != null) jj_add_error_token(kind, i);
    }
    if (jj_scanpos.kind != kind) return true;
    if (jj_la == 0 && jj_scanpos == jj_lastpos) throw jj_ls;
    return false;
  }


/** Get the next Token. */
  final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  private int[] jj_expentry;
  private int jj_kind = -1;
  private int[] jj_lasttokens = new int[100];
  private int jj_endpos;

  private void jj_add_error_token(int kind, int pos) {
    if (pos >= 100) return;
    if (pos == jj_endpos + 1) {
      jj_lasttokens[jj_endpos++] = kind;
    } else if (jj_endpos != 0) {
      jj_expentry = new int[jj_endpos];
      for (int i = 0; i < jj_endpos; i++) {
        jj_expentry[i] = jj_lasttokens[i];
      }
      boolean exists = false;
      for (java.util.Iterator<?> it = jj_expentries.iterator(); it.hasNext();) {
        exists = true;
        int[] oldentry = (int[])(it.next());
        if (oldentry.length == jj_expentry.length) {
          for (int i = 0; i < jj_expentry.length; i++) {
            if (oldentry[i] != jj_expentry[i]) {
              exists = false;
              break;
            }
          }
          if (exists) break;
        }
      }
      if (!exists) jj_expentries.add(jj_expentry);
      if (pos != 0) jj_lasttokens[(jj_endpos = pos) - 1] = kind;
    }
  }

  /** Generate ParseException. */
  public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[48];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 15; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 48; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    jj_endpos = 0;
    jj_rescan_token();
    jj_add_error_token(0, 0);
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  final public void enable_tracing() {
  }

  /** Disable tracing. */
  final public void disable_tracing() {
  }

  private void jj_rescan_token() {
    jj_rescan = true;
    for (int i = 0; i < 4; i++) {
    try {
      JJCalls p = jj_2_rtns[i];
      do {
        if (p.gen > jj_gen) {
          jj_la = p.arg; jj_lastpos = jj_scanpos = p.first;
          switch (i) {
            case 0: jj_3_1(); break;
            case 1: jj_3_2(); break;
            case 2: jj_3_3(); break;
            case 3: jj_3_4(); break;
          }
        }
        p = p.next;
      } while (p != null);
      } catch(LookaheadSuccess ls) { }
    }
    jj_rescan = false;
  }

  private void jj_save(int index, int xla) {
    JJCalls p = jj_2_rtns[index];
    while (p.gen > jj_gen) {
      if (p.next == null) { p = p.next = new JJCalls(); break; }
      p = p.next;
    }
    p.gen = jj_gen + xla - jj_la; p.first = token; p.arg = xla;
  }

  static final class JJCalls {
    int gen;
    Token first;
    int arg;
    JJCalls next;
  }

    }
