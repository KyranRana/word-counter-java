# Word Counter

This is a simple command line program written using Gradle and Java 11 which counts words.

This program utilises a package called Picoli (https://picocli.info/) which is a mini command line 
framework. The reason I used this framework is because it allows the use of parameters and named 
options totally through annotations. It also provides other benefits such as exception 
handling and a generated usage guide based on the parameters and named options you create, and 
the descriptions you give them.

I felt this was convenient considering it enables this program to become more flexible going forward 
regarding the arguments it accepts. 

This program can be run with the steps below: 

1. Go into the directory of this project using command line.
1. Install the program with `gradlew clean install`
1. Run the word counter command using `./build/install/WordCounter/bin/WordCounter --help`

Command Arguments:

`-m`, `--mode` - Word counter to use to count words. Default is `ANY` which counts all words whether 
or not they exist in a dictionary. You can change mode to `ENGLISH` which filters out non-english 
words (be aware uses a data source consisting of only 10,000 words).  

`<textFile>` - Path to the text file to output the word frequency of