
all:
	javac *.java

jar:
	javac *.java
	jar -cvfe WonderGames.jar Driver *.class assets

clean:
	rm *.jar
	rm *.class