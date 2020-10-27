![Java CI with Gradle](https://github.com/KyranRana/word-counter-java/workflows/Java%20CI%20with%20Gradle/badge.svg)

# Word Counter

This is a simple command line program written using Gradle and Java 11 which counts words.

This program can be run with the steps below: 

1. Go into the directory of this project using command line.
1. Install the program with `gradlew clean install`
1. Run the word counter command using `./build/install/WordCounter/bin/WordCounter --help`

### Command-Line Arguments

`-m`, `--mode` - Word counter to use to count words. Default is `ANY` which counts all words whether 
or not they exist in a dictionary. You can change mode to `ENGLISH` which filters out non-english 
words (be aware uses a data source consisting of only 10,000 words).  

`<textFile>` - Path to the text file to output the word frequency of
