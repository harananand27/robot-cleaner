# robot-cleaner

1) Import the Maven project using the pom.xml into any IDE
2) Run RobotCleanerApplication.java
3) Test POST endpoint at http://localhost:8080/robotclean 
4) Sample input 
{
    "roomSize": [4,4],
    "coords": [1,2],
    "patches" : [
    	[1, 0],
		[2, 2],
    	[2, 3]
	],
    "instructions": "NNESEESWNWW"
}
5) Sample output
{
    "coords": [
        1,
        3
    ],
    "patchesCleaned": 1
}
