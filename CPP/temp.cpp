#include <bits/stdc++.h>
using namespace std;

int main(int argc, char *argv[])
{
    int a[] = {1,2,3};
    __asm__("\npush %rax\npush %rbp\nmov %rsp, %rbp\nmov 16(%rbp), %rax\nmov %rax, 12(%rbp)\nmov %rbp, %rsp\npop %rbp\npop %rax");
    cout
    << a[0] << ' ' << a[1] << ' ' << a[2] << endl;
}
