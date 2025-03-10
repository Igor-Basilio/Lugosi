package ast;

import java.util.ArrayList;

public class CReturn extends Comando{
	public int linha;
	public Exp exp;
	
	
	public CReturn(int linha,Exp exp)
	{
	  this.linha = linha;
	  this.exp = exp;
	} 

    public String gen_cpp()
    {
        StringBuilder res = new StringBuilder();

        res.append("return ");
        res.append(exp.gen_cpp());
        res.append(";\n");
        
        return res.toString();
    }
}
