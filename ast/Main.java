package ast;

import java.util.ArrayList;

public class Main{

	public ArrayList<VarDecl> vars;
	public ArrayList<Comando> coms;
	
	public Main(ArrayList<VarDecl> vars,ArrayList<Comando> coms)
	{
		this.vars = vars;
		this.coms = coms;
	}

    public String gen_cpp()
    {
        StringBuilder res = new StringBuilder();

        res.append("int main(void) {\n");

        for(VarDecl v : vars)
            res.append(v.gen_cpp() + '\n');

        for(Comando c : coms)
            res.append(c.gen_cpp() + '\n');

        res.append("}");

        return res.toString();
    }

}
