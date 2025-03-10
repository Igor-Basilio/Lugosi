package ast;

import java.util.ArrayList;

public class CPrint extends Comando{
	public int linha;
	public Exp exp;
	
	
	public CPrint(int linha, Exp exp)
	{
	  this.linha = linha;
	  this.exp = exp;
	} 

    public String gen_cpp()
    {
        StringBuilder res = new StringBuilder();
        
        res.append("cout << ");
        res.append(exp.gen_cpp());
        res.append(";\n");

        return res.toString();
    }
}
