from ntpath import split
f = open("input02.txt","r")
f.readline()
n = int(f.readline().split()[0])
print("n="+str(n))
a = f.readline().split()
f.close()
f = open("pyout.txt","w")
for i in range(n):
    f.write(str(i)+"\t"+a[i]+"\n")
f.close()

 