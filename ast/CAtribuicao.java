package ast;


public class CAtribuicao extends Comando{
	public int linha;
	public String var;
	public Exp exp;
	
	public CAtribuicao(int linha,String var, Exp exp)
	{
	  this.linha = linha;	
	  this.var = var;
	  this.exp = exp;
	} 

    public String gen_cpp()
    {
        StringBuilder res = new StringBuilder();
        
        res.append(var);
        res.append(" = ");
        res.append(exp.gen_cpp());
        res.append(";\n");
        
        return res.toString();
    }
}
