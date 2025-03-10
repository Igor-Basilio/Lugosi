package ast;

import java.util.ArrayList;

public class Prog{

    public Main main;
    public ArrayList<Fun> fun;
    public Prog(Main main, ArrayList<Fun> fun)
    {
        this.main = main;
        this.fun = fun;
    }

    public String gen_cpp()
    {
        StringBuilder res = new StringBuilder();

        res.append("#include <iostream>\n");
        res.append("using namespace std;\n\n");
        for(Fun f : fun)
        {
            res.append(f.gen_cpp());
            res.append('\n');
        }
        res.append('\n');
        res.append(main.gen_cpp());
        res.append('\n');

        return res.toString();
    }

}

