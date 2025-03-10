package ast;


public class ETrue extends Exp{
	
	public ETrue()
	{
	  super();
	} 

    public String gen_cpp()
    {
        return "true";
    }

}
