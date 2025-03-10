package ast;


public class EFalse extends Exp{
	
	public EFalse()
	{
	  super();
	} 

    public String gen_cpp()
    {
        return "false";
    }

}
