# progetto_ing_software

Comandi per eseguire il codice


javac -cp ".:./JunitJars/junit-4.13.jar:./JunitJars/hamcrest-core-1.3.jar" myAdapter/*.java myTest/*.java

java -cp ".:./JunitJars/junit-4.13.jar:./JunitJars/hamcrest-core-1.3.jar" myTest.TestRunner

javadoc -cp ".:./JunitJars/junit-4.13.jar:./JunitJars/hamcrest-core-1.3.jar" -d ./documentazione -sourcepath . myAdapter myTest