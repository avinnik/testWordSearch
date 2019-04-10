The project is created in Eclipse (Photon)

The project is using JDK 1.8
To build it: you can just fetch it into a workspace build

From Eclipse it can be run either as Java application 
(main class is av.Program) or as Junit

I also created a runnable jar file (deliverables/WordSearch.jar)

Running from command in  Windows

cd into deliverables directory

Run as Java application:

Execute command "java -jar WordSearch.jar av.WordSearch"

Example:

..\WordSearch\deliverables>java -jar WordSearch.jar av.WordSearch
BONES (0,6),(0,7),(0,8),(0,9),(0,10)
KHAN (5,9),(5,8),(5,7),(5,6)
KIRK (4,7),(3,7),(2,7),(1,7)
SCOTTY (0,5),(1,5),(2,5),(3,5),(4,5),(5,5)
SPOCK (2,1),(3,2),(4,3),(5,4),(6,5)
SULU (3,3),(2,2),(1,1),(0,0)
UHURA (4,0),(3,1),(2,2),(1,3),(0,4)


Execute as Junit test
Execute command:
java -cp .;WordSearch.jar org.junit.runner.JUnitCore av.test.WordSearchTest

Example:

..\WordSearch\deliverables>java -cp .;WordSearch.jar org.junit.runner.JUnitCore av.test.WordSearchTest
JUnit version 4.12
........
Time: 0.01

OK (8 tests)

