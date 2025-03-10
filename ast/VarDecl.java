package ast;

import java.util.ArrayList;

public class VarDecl{

   public String type;
   public ArrayList<String> var;
   
   public VarDecl(String type, ArrayList<String> var){
    	this.type = type;
    	this.var = var;
   }

   public String gen_cpp()
   {
       StringBuilder res = new StringBuilder();
       
       res.append(type);
       res.append(' ');

       for(int i=0; i < var.size() - 1; i++)
       {
            res.append(var.get(i));
            res.append(", ");
       }

       res.append(var.get(var.size() - 1));
       res.append(';');

       return res.toString();
   }

}
