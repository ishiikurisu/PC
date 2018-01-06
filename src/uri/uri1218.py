import sys
 
nc = 0
while True:
    try:
        tamanho = input()
        inlet = raw_input().split()
        pares = fem = mas = 0
        if nc is not 0: print ''
         
        for i in range(len(inlet)/2):
            tam = int(inlet[2*i])
            sex = inlet[2*i+1]
             
            if tam is tamanho:
                pares += 1
                # fem += 1 if sex is 'F' else mas += 1
                if sex is 'F': fem +=1
                else: mas += 1
 
        nc += 1
        print 'Caso %i:' % nc
        print 'Pares Iguais: %i' % pares
        print 'F: %i' % fem
        print 'M: %i' % mas
    except:
        break
    
