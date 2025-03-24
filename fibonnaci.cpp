#include <iostream>
using namespace std;

int fibonnaci( int n) {
int result, c_n;
int prev, temp;
c_n = n;

prev = 0.0;

result = 1.0;

while(c_n>1.0) {temp = result;

result = prev+result;

prev = temp;

c_n = c_n-1.0;

}
return result;

}

int main(void) {
int s;
s = fibonnaci(22.0);

cout << s+1.0;

return 0.0;

}

