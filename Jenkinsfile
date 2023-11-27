pipeline{
    agent any
    stages{
        stage('Build MAVEN') {
            steps {
                bat 'mvn clean install'
            }
        }
    }
}