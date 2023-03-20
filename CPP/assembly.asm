push %rax
push %rbp
mov %rsp, %rbp
mov 16(%rbp), %rax
mov %rax, 12(%rbp)
mov %rbp, %rsp
pop %rbp
pop %rax