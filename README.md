# <ins>**Edit-Distance-based-Motif-Search**</ins>
# Description
This is software that creates 20 different combinations of genes and performs Motif-Search on it.

The code is written through **JAVA**.

# [Objective](https://github.com/blank0826/Edit-Distance-based-Motif-Search/blob/master/Assignment.java)
  
  This program takes input from "Data.txt" and stores necessary information into variables. Then it creates 20 different gene combinations and then checks for the edit distance while simultaneously printing it in the "Out.txt"
  
## **<ins>Member Functions</ins>**
  **<ins>1. printAllNeighboursWEditDistance(ArrayList<ArrayList<String>>, int, int, int, int)**</ins><br/>
  We first select a string of length L and then check all the strings that are available and check for edit distance and if it satifies then show it in the output file.
  **<ins>2. calculateEditDistance(String, String, int, int)**</ins><br/>
    This calculates the edit distance between 2 strings and perform operations of insertion,deletion and substitution based on the cost given through input.<br/>
  
  **<ins>3. createAllSubstrings(String, int, int)**</ins><br/>
  Creates all the substrings of the String that are in between the length of the given length and all the possible lengths of substrings that can be possible.<br/>
  
  **<ins>4. createRandomString(char[])</ins>**<br/>
  This function creates random strings based on the gene types: A, G, T, C <br/><br/>  
  
  **Complete Documentation:** [Report](https://github.com/blank0826/Edit-Distance-based-Motif-Search/blob/master/Report.docx)

# Local Setup

## Pre-Requisites
An IDE that supports Java.
## Installation and Execution
1. Pull this code into any folder.<br />
2. Open this folder in your preferred IDE.<br />
3. Build the Project.<br />
4. Run the [Motif_Search](https://github.com/blank0826/Edit-Distance-based-Motif-Search/blob/master/Motif%20Search.java) file.<br />

___Check Data.txt and Output.txt for input and output respectively.___
  
# Contact
## [Aditya Srivastava](mailto:aditya26052002@gmail.com?subject=GitHub)
