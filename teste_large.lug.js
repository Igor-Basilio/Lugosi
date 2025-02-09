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

async function main()
{
   let isEven;
   let sumOfSquares, rs;
   let num;


   try {
      num = parseInt( await readIO("") );
   }catch(err)
   {
      console.log("Erro: ", err);
   }finally{
      rl.close();
   }

   isEven = checkEven(num ) ;
   if(isEven ){

   console.log("Number is even\n" );

   };
   sumOfSquares = calculateSumOfSquares(1 ,5 ) ;
   console.log(sumOfSquares );
   rs = power(5 ,2 ) ;
   console.log(rs );
   return 0 ;

}

main(); 

function calculateSumOfSquares(start, end)
{
   let sum;

   sum = 0.0 ;
   while (start <= end )
   {
   sum = (sum + power(start ,2 ) );
   start = (start + 1 );

   };
   return sum ;

}

function power(base, exponent)
{
   let result;

   result = 1.0 ;
   if((exponent == 0 )){

   return 1 ;

   };
   while (exponent > 0 )
   {
   result = (result * base );
   exponent = (exponent - 1 );

   };
   return result ;

}

function checkEven(num)
{
   let c;

   c = (num % 2 );
   if(c == 0 ){

   return true ;

   };
   return false ;

}


