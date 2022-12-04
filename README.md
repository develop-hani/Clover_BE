# 🍀 Clover
![image](https://user-images.githubusercontent.com/55950561/202984845-c8b0298d-4d78-4a47-b2c5-b68e9eec38e3.png)

## Description of the Program
Clover provides a quant investment strategy for private investors by analyzing individual stock for the past 10 years of performance and future outlook.

**By executing the Program, You may obtain information on:**
- Stock chart for all domestic stocks;
- A real-time buy/sell signal; and
- Reliability of the signal.

**Key features of back-end include:**
- Providing names and codes for all listed stocks;
- Executing the Python module to obtain buy/sell signal and its reliability; and
- Automatic updating of listed stocks through scheduling.

This repository is reserved for entire Clover's backend source code. Entire project information can be attained by clicking [here](https://github.com/hongcana/Clover_Project).

## Service architecture
The structure of Clover is illustrated in the figure below.
![image](https://user-images.githubusercontent.com/55950561/202979270-0d7ee86e-e287-40db-bc3e-4a168b00aa46.png)
Any Client can easily receive service by connecting to Clover through web browser as shown in the figure.

## Technologies
Technologies deployed in the execution of Clover are listed below:
- ubuntu 20.;
- Java 11.0.17;
- Spring Boot 2.7.5;
- Gradle 7.1.1;
- MySQL; and
- AWS - EC2, RDS.

## Encountered difficulties developed solutions
- Executing Python module on the Windows was difficult to achieve. Some attempts were made to resolve this difficulty are described below.
  - 'Jython' library was used in order to execute Python module on JVM. However, this attempt was not successful because of limited functions of ‘Jython’ which does not assist Python packages such as NumPy and Pandas.
  - Executing Python module through aws ec2 instance(ubuntu) were found to be suitable and successful. The relevant code can be found [here](https://github.com/pyh-dotcom/clover_backend/blob/master/src/main/java/com/example/clover_backend/service/ExecutePython.java).
- Building a Spring Boot project via such terminal as free tier instance was a tremendous challenge. This challenge was resolved with an attempt of:
  - Allocating memory to work as swap space by using a swap file.

## Video
[Introduction](https://www.youtube.com/watch?v=jG0JP-SeEwg&list=PLnKrqpcAkEaZUqkWs9yIvp65edSJn6XuR&index=21)
