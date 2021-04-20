all:
	java -jar jtb132di.jar -te minijava.jj
	java -jar javacc5.jar minijava-jtb.jj
	javac Main.java

run: execute
execute:
	java Main

clean:
	rm -f sytaxtree/ visitor/ *~ *.class JavaCharStream.java  Mini*.java ParseException.java Token*.java minijava-jtb.jj

.PHONY: all run execute clean