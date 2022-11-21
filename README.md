# 🍀 Clover
![image](https://user-images.githubusercontent.com/55950561/202984845-c8b0298d-4d78-4a47-b2c5-b68e9eec38e3.png)

## Description
Clover provides a quant investment strategy for private investors.

**You can get information about**
- Stock chart for all domestic stocks
- A real-time buy/sell signal
- Reliability of the signal

**Key features of back-end**
- Provide names and codes for all listed stocks.
- Run the Python module and get buy/sell signal and its reliablity.
- Automatic update of listed stocks through scheduling.

This repository is Clover's backend repository and the entire project is available [here](https://github.com/hongcana/Clover_Project).

## Service architecture
<p align="center"><img src="https://user-images.githubusercontent.com/55950561/202979270-0d7ee86e-e287-40db-bc3e-4a168b00aa46.png" width="800" height="496"/></p>

## Technologies
- ubuntu 20.04
- Java 11.0.17
- Spring Boot 2.7.5
- Gradle 7.1.1
- MySQL
- AWS - EC2, RDS

## Difficulties and workarounds in implementation
- Executing Python module.
  - It couldn't be solved using 'Jython'. This is because Python packages such as numpy and pandas could not be run.
  - Implementing through aws ec2 instance(ubuntu) worked. The relevant code can be found [here](https://github.com/pyh-dotcom/clover_backend/blob/master/src/main/java/com/example/clover_backend/service/ExecutePython.java).
- Building a Spring Boot project via terminal.
  - Solved by allocating memory as swap space by using a swap file.

## Video
