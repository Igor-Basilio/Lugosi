package ast;

import java.util.ArrayList;

public class Fun{
	public String nome;
	public ArrayList<ParamFormalFun> params;
	public String retorno;
	public ArrayList<VarDecl> vars;
	public ArrayList<Comando> body;
	
	public Fun(String nome,ArrayList<ParamFormalFun> params, String retorno,ArrayList<VarDecl> vars,ArrayList<Comando> body)
	{
		this.nome = nome;
		this.params = params;
		this.retorno = retorno;
		this.vars = vars;
		this.body = body;
	}

    public String gen_cpp()
    {
        StringBuilder res = new StringBuilder();

        res.append(retorno);
        res.append(' ');
        res.append(nome);
        res.append("( ");

        for(int i=0; i < params.size() - 1; i++)
        {
            res.append(params.get(i).gen_cpp());
            res.append(", ");
        }
        res.append(params.get(params.size() - 1).gen_cpp());

        res.append(") {\n");
        
        for(VarDecl v : vars)
        {
            res.append(v.gen_cpp());
            res.append('\n');
        }

        for(Comando c : body)
        {
            res.append(c.gen_cpp());
            res.append('\n');
        }
        res.append('}');

        return res.toString();
    }
}
