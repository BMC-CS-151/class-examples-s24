def double(numAdds):
    arrLen = 1
    numElems = 0
    numExpansions = 0
    numOps = 0


    for i in range(0, numAdds):
        if numElems == arrLen:
            numExpansions += 1
            arrLen *= 2
            numElems += 1
            numOps += numElems
        else:
            numElems += 1
            numOps += 1

    print("For", numAdds, "add ops:")
    print("total number of operations: T(", numAdds,") =", numOps)
    print("total number of expansions: k(", numAdds ,") =", numExpansions)

double(8)
print()
double(128)
print()
double(2048)
print()
double(16384)
