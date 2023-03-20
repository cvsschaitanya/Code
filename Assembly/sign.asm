section	.text
    global _start     

section .bss
    number resb 10
    count resb 10

section .code

_addcount:
    push ebx
    add eax, esi
    mov bl, [eax]
    inc bl
    mov [eax], bl
    sub eax, esi
    pop ebx
    ret

_addpositive:
    push eax
    mov eax, 0
    call _addcount
    pop eax
    ret

_addnegative:
    push eax
    mov eax, 1
    call _addcount
    pop eax
    ret

_addzero:
    push eax
    mov eax, 2
    call _addcount
    pop eax
    ret

_decide:
    push eax
    xor eax, eax
    mov al, [number]
    cmp al, 48
    jne nonzero
    je zero

    zero:
        call _addzero
        jmp end_decide
    
    nonzero:
        cmp al, 45
        je negat
        call _addpositive
        jmp end_decide

        negat:
            call _addnegative
            jmp end_decide

    end_decide:
        pop eax
        ret

_extract:
    push ebx
    push ecx
    push edi
    push edx
    mov edi, 10
    lea ebx, [count]
    xor eax, eax
    xor ecx, ecx

    while_loop1:
        mov cl, [ebx]
        cmp cl, 10
        je end_of_while1

        sub cl, 48
        mul edi
        add ax, cx
        inc ebx 
        jmp while_loop1
    end_of_while1:

    pop edx
    pop edi
    pop ecx
    pop ebx
    ret

_printInt:
    push ebx
    push ecx
    push esi
    push edi
    push edx
    mov edi, 10
    lea ebx, [buf]

    mov edx, 0x20202020
    mov [buf], edx

    cmp eax, 0
    jne while_loop2
    
    ; Print zero
    add al, 48
    mov [buf], al

    jmp finally_print
    
    
    while_loop2:
        cmp eax, 0
        je end_of_while2

        xor edx, edx
        div edi
        add edx, 48
        mov [ebx], dl
        inc ebx 
        jmp while_loop2
    end_of_while2:

    finally_print:
        lea edi, [buf]
        mov esi, edi
        add esi, 3
        mov edx, 1
        ploop:
            mov	ecx, esi      
            mov	ebx, 1        
            mov	eax, 4        
            int	0x80

            dec esi
            cmp esi, edi
            jge ploop

        mov al, 10
        mov [buf], al

        mov edx, 1
        mov	ecx, buf      
        mov	ebx, 1        
        mov	eax, 4        
        int	0x80

        pop edx
        pop edi
        pop esi
        pop ecx
        pop ebx
        ret

_start:	       
    lea esi, [ans]

    ; Prompt for count
    mov edx, len1
    mov	ecx, prompt1     
    mov	ebx, 1        
    mov	eax, 4        
    int	0x80         
	
    ; Read count
    mov edx, 100
    mov ecx, count
    mov ebx, 0
    mov eax, 3
    int 0x80

    ; Extract count into eax
    call _extract

    ; loop count times
    mov edi, eax
    floop:
        ; Prompt for number
        mov edx, len2
        mov	ecx, prompt2      
        mov	ebx, 1        
        mov	eax, 4        
        int	0x80 

        ; Read number
        mov edx, 100
        mov ecx, number
        mov ebx, 0
        mov eax, 3
        int 0x80
    
        call _decide
        dec edi
        jnz floop
	
    ; Print result
    lea esi, [ans]
    ; Print Positive numbers
    mov edx, len3
    mov	ecx, prompt3      
    mov	ebx, 1        
    mov	eax, 4        
    int	0x80 

    xor eax, eax
    mov al, [esi]
    call _printInt

    ; Print Negative numbers
    inc esi
    mov edx, len4
    mov	ecx, prompt4      
    mov	ebx, 1        
    mov	eax, 4        
    int	0x80 

    xor eax, eax
    mov al, [esi]
    call _printInt

    ; Print Zero Numbers
    inc esi
    mov edx, len5
    mov	ecx, prompt5      
    mov	ebx, 1        
    mov	eax, 4        
    int	0x80 

    xor eax, eax
    mov al, [esi]
    call _printInt

    ; exit
    mov	eax, 1         
    int	0x80          
    
section	.data
ans db 0,0,0,10
buf db '    ',10

prompt1 db 'How many numbers: ', 0
prompt2 db 'Enter a number: ', 0
prompt3 db 'Positive: ', 0
prompt4 db 'Negative: ', 0
prompt5 db 'Zero:     ', 0

len1 equ prompt2 - prompt1      
len2 equ prompt3 - prompt2      
len3 equ prompt4 - prompt3      
len4 equ prompt5 - prompt4      
len5 equ $ - prompt5     





