cd acceptance
javac -cp .;..\build\classes\main TicTacToeKeywords.java
java -cp .;..\JavaSwingLibrary\swinglibrary-1.9.4.jar..\build\classes\main;C:\Users\Shay\Documents\RobotFramework\robotframework-2.9.jar org.robotframework.RobotFramework TicTacToeTests.txt TicTacToeGUITests.txt
cd ..