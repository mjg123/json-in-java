# 3 Ways of working with JSON in Java

Code to support this blog post: (link TBC)

This repo contains examples of how to work with JSON in Java. The blog post discusses
three methods, with examples using [Jackson](https://github.com/FasterXML/jackson) and [Gson](https://github.com/google/gson).

The following classes are used as examples and have `main` methods intended to be run from an IDE.

## Tree model

  - [GsonTreeModel](https://github.com/mjg123/json-in-java/blob/master/src/main/java/lol/gilliard/jsonparse/treemodels/GsonTreeModel.java)
  - [JacksonTreeModel](https://github.com/mjg123/json-in-java/blob/master/src/main/java/lol/gilliard/jsonparse/treemodels/JacksonTreeModel.java)
  
## Data binding

  - [NeoSummary](https://github.com/mjg123/json-in-java/blob/master/src/main/java/lol/gilliard/jsonparse/databinding/simple/NeoSummary.java)
  - [ComplexDataBindingJackson](https://github.com/mjg123/json-in-java/blob/master/src/main/java/lol/gilliard/jsonparse/databinding/complex/jackson/ComplexDataBindingJackson.java)
  - [ComplexDataBindingGson](https://github.com/mjg123/json-in-java/blob/master/src/main/java/lol/gilliard/jsonparse/databinding/complex/gson/ComplexDataBindingGson.java)
  
## Path extraction

  - [JsonPathExample](https://github.com/mjg123/json-in-java/blob/master/src/main/java/lol/gilliard/jsonparse/jsonpath/JsonPathExample.java)