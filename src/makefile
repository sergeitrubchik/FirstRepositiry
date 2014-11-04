
JC=javac -g

run: build
	java Test 0 2

runa: build
	java -ea Test 0 2

build: 	NonlinearEquation.class \
	Test.class

NonlinearEquation.class: NonlinearEquation.java makefile
	$(JC) $<

Test.class: Test.java makefile
	$(JC) $<

clean:
	-del NonlinearEquation.class
	-del Test.class

.java.class:
	$(JC) $<
