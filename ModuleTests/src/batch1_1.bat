set path="C:\Program Files\Java\jdk1.8.0_202\bin";
javac *.java
rmic SumServer
start rmiregistry
java -Djava.security.Policy=SumPolicy.policy SumRegister