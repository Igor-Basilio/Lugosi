package ast;


public class CReadInput extends Comando{
	public int linha;
	public String var;
	
	
	public CReadInput(int linha,String var)
	{
	  this.linha = linha;
	  this.var = var;
	} 

    public String gen_cpp()
    {  
        StringBuilder res = new StringBuilder();
       
        res.append("cin >> "); 
        res.append(var);
        res.append(";\n");

        return res.toString();
    }

}
