pipeline{
    agent any
    stages{
        stage('Build Backend'){
            steps{
                bat'mvn clean package -DskipTests=true'
            }
        }
        stage(){
            steps{
                dir('C://Users//lycya//.jenkins//workspace//teste//target'){
                    bat 'java -jar test-jar-jenkins-0.0.1-SNAPSHOT.jar'
                }
            }
        }
    }
}