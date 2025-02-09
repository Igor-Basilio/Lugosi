const readline = require('readline');

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});

function readIO(prompt)
{
  return new Promise((resolve) => {
    rl.question(prompt, resolve);
  });
}

function calculate(num1, num2)
{
   let result_and;

   result_and = num1 + num2 ;
   return result_and ;

}

async function main()
{
   let teste, res, fn, another_one;
   let mof;
   let valor;
   let hello;
   let ler_valor;

   teste = 9.0E20 ;
   console.log(teste );
   another_one = 20 + 30 + 40 * (5 + 9 );
   hello = ("Hello, World!\n" + "And Lugosi too !" );
   console.log(hello );
   valor = true ;
   valor = (20 < 30 )+ (5 );

   try {
      ler_valor = parseInt( await readIO("") );
   }catch(err)
   {
      console.log("Erro: ", err);
   }finally{
      rl.close();
   }

   ler_valor = ler_valor + 5 + fib(10 ) ;
   if(ler_valor > 5 ){

   console.log(ler_valor );

   };
   console.log(5 );
   calculate(20 ,30 );
   return 0 ;

}

main(); 

function fib(n)
{
   let n1, result, n2;

   n1 = 0 ;
   n2 = 3 ;
   while ((n1 * 2 )< n )
   {
   result = (n1 + n2 );
   n1 = (n1 + 1 )+ (3 + 4 );

   };
   return result ;

}


