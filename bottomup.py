import copy
def stackreduce(stack, op_rule, a):
	for i in list(range(1, len(stack))):
	    if ''.join(stack[i:]) in op_rule:
	        newnonterminal = productionrule[op_rule.index(''.join(stack[i:]))][0]
	        del stack[''.join(stack[0:]).find(''.join(stack[i:])):]
	        print("New Non Terminal is ", end='')
	        print(newnonterminal)
        	stack.append(newnonterminal)
        	print("After Reducing stack is ",end='')
        	print(stack)
        	if len(tempqueue) == 1 and a == 0:
        	    pass
        	elif len(tempqueue) > 1:
        	    stackreduce(stack, op_rule, a)
        	else:
        	    a = a+1
a = 0
i=0
y= int(input("Enter the number of production rules:"))
print()
productionrule = []
for i in range(y):
    newrule = input("Enter Production Rule Number "+ str(i+1) + " : ")
    productionrule.append(newrule)
queue = [x for x in input("\nEnter the Input Symbols: ")]

queue.append('$')
stack = ['$']
tempqueue = copy.deepcopy(queue)
print("\nProduction Rules are: ")

print(*productionrule, sep="\n")
print("--------------------------------------")
op_rule = [eachrule[3:] for eachrule in productionrule]
for eachsymbol in queue[:len(queue)-1]:
	print("\nInput Symbol queue ", end='')
	print(tempqueue)
	print("Stack ", end='')
	print(stack)
	print("Taken input symbols is ", end='')
	print(eachsymbol)
	stack.append(each_symbol)
	tempqueue.pop(0)
	stackreduce(stack, op_rule, a)
print("--------------------------------------")
print("Stack is ", end='')
print(stack)
print("Queue is ", end='')
print(tempqueue)
if stack[0] == '$' and stack[1] == productionrule[0][0] and tempqueue[0] == '$':
	print("Accepted, Successful Parsing")
else:
	print("Failed, Unsuccessful Parsing")
