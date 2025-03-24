package ast;

import java.util.ArrayList;

public class EChamadaFun extends Exp{
	public String fun;
	public ArrayList<Exp> args;
	
	public EChamadaFun(String fun, ArrayList<Exp> args)
	{
	  this.fun = fun;
	  this.args = args;
	} 

    public String gen_cpp()
    {
        StringBuilder res = new StringBuilder();

        res.append(fun);
        res.append('(');

        for(int i=0; i < args.size() - 1; i++ )
        {
            res.append(args.get(i).gen_cpp());
            res.append(", ");
        }

        if(args.size() >= 1)
            res.append(args.get(args.size() - 1).gen_cpp());
        res.append(')');

        return res.toString();
    }
}
