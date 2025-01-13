
package syntacticTree;
import parser.Token;
import java.util.ArrayList;

public class VarDeclBase extends GeneralNode
{
   public ArrayList<VarDeclNode> decls = new ArrayList<VarDeclNode>();
   public VarDeclBase()
   {
       super(null);
   }
}

