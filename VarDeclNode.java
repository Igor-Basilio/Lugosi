
package syntacticTree;
import parser.Token;
import java.util.ArrayList;

public class VarDeclNode extends GeneralNode
{
   public Token type;
   public ArrayList<Token> idents;

   public VarDeclNode(Token r, Token t, ArrayList<Token> ids)
   {
       super(r);
       type=t;
       idents=ids;
   }
}

