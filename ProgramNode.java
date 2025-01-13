
package syntacticTree;
import parser.Token;

public class ProgramNode extends GeneralNode
{
   public MainNode main;
   public FunctionNode bf, af;
  
   public ProgramNode( Token r,
           MainNode main, FunctionNode af,
           FunctionNode bf )
   {
        super(r);
        main=main;
        af=af;
        bf=bf;
   }
}

