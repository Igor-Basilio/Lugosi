
package syntacticTree;
import parser.Token;

public class MainNode extends GeneralNode
{

   public Token r_type;
   public VarDeclBase vd;
   public SeqCommandsNode sc;
  
   public MainNode(
            Token r,
            VarDeclBase vd,
            SeqCommandsNode sc,
            Token r_type )
   {
       super(r);
       r_type = r_type;
       vd = vd;
       sc = sc;
   }

}
