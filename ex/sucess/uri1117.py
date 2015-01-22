aviso = 'nota invalida'
 
def ler():
    global aviso 
    nota = input()
     
    while nota > 10 or nota < 0:
        print aviso
        nota = input()
 
    return nota
 
n1 = ler()
n2 = ler()
print 'media = %.2f' % (float(n1+n2)/2)
