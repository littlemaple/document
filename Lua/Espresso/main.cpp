#include <iostream>

using namespace std;

int main()
{
    int countSize(int n);
    cout<<"res:"<<   countSize(9)<<endl;
    return 0;
}


 int countSize(int n){
    int k=0;
    while(n>0){

        n=n&(n-1);
     cout<<n<<endl;
        k++;
    }
    return k;
}
