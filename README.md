# Find-treasure
Finding treasure problem using Graph-theory in Clojure.

## Description

This problem is aimed to find the threasure from the source. The source will be the top-left symbol in given input. 

There are three types of the symbols, '-' means one can travese through that path. While '#' means one can not go through that path and the treasure will be symbolized by '@'. The clojure program will read the input from map.txt file.

## Example : 

**1. Input :**
```
---#--
-#---#
####-@
```

**Output:** Treasure is reachable.

**2. Input :**
```
---##@
-#---#
####--
```

**Output:** Treasure is not reachable.

## Run the program in macOS
```
brew install clojure/tools/clojure
clj treasure.clj
```
