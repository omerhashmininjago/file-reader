# file-reader
This app is a generic file reader

With help of xml configuration I am avoiding 
1. introducing extra DTOs for mapping the file to the DTO
2. converters required to map the DTO to the Entity

With the help of xml configuration, I am doing all validations which include
1. Mandatory
2. Data Type

With the help of xml configuration, I am able to trim fields

This has lowered lots of Java code, and hence lesser of unit testing is required
