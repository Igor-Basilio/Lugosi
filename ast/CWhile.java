package ast;

import java.util.ArrayList;

public class CWhile extends Comando{
	public int linha;
	public Exp exp;
	public ArrayList<Comando> bloco;
	
	public CWhile(int linha,Exp exp, ArrayList<Comando> bloco)
	{
	  this.linha = linha;
	  this.exp = exp;
	  this.bloco = bloco;
	} 

    public String gen_cpp()
    {   
        StringBuilder res = new StringBuilder();

        res.append("while(");
        res.append(exp.gen_cpp());
        res.append(") {");

        for(Comando c : bloco)
        {
            res.append(c.gen_cpp());
            res.append('\n');
        }

        res.append('}');
        return res.toString();
    }
}
