# <ins>**Edit-Distance-based-Motif-Search**</ins>
# Description
This is software that creates 20 different combination of genes and perform Motif-Search on it.

The code is written through **JAVA**.

## Objective

### [Edit Distance Motif Search](https://github.com/blank0826/Edit-Distance-based-Motif-Search/blob/master/Assignment.java)
----
  
### **<ins>Member Functions</ins>**
  **<ins>1. Dataset**</ins><br/>
  It consisted of 7 columns which consisted of comments, whether it is hateful or can be used in normal language, count of how much of each category is in the comment.<br/>
  
  **<ins>2. Setting up Data;**</ins><br/>
    Store comments and counts in an array from the dataset. Map the comments based on the count in the dataset. Used stemmer and stopwords to remove any filler words in the comments.<br/>
  
  **<ins>3. Training and Testing of the Data**</ins><br/>
  Divide the dataset into 2 parts based on comments and labels. After that, create the matrix of tokenized counts using Count Vectorizer.<br/>
  Then use train_test_split to divide the data into training and testing be specifying that each of them has 33% of the data and the random state was set to 42 so that it gives almost the same answer in each execution.<br/>
  After division, use the training data to train the system ,and then later it can be used to check the comments.<br/>
  
  **<ins>4. hate_speech_detection() [Main Function]</ins>**<br/>
  This is the main function. Initially, streamlit is set up which is used for showing input and output in python code in the form of a website. Then we take input from the user and send it into the decision classifier to tell the category of the comment. Then output it into the website. <br/><br/>
  
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
