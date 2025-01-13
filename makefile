
all: javacc java

javacc: Lugosi.jj
	javacc Lugosi.jj

java: 
	javac -d . *.java

clean:
	-rm -r parser
	-rm -r syntacticTree
	-rm *.class

