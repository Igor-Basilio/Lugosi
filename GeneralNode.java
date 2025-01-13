
package syntacticTree;
import parser.Token;

abstract public class GeneralNode 
{
    public Token ref;
    
    public GeneralNode(Token t)
    {
        ref = t;
    }
}

