pipeline{
    agent any  
    stages{
        stage('Build MAVEN') {
            steps {
                bat 'mvn clean install -DskipTests=true'
            }
        }
        stage('Testes Unitarios') {
            steps{
                bat 'mvn test'
            }
        }
        stage('SonarQube') {
            environment{
                scannerHome = tool 'SONAR_SCANNER'
            }
            steps{
                withSonarQubeEnv('SONAR_LOCAL'){
                    bat "${scannerHome}/bin/sonar-scanner -e -Dsonar.projectKey=jenkins-test2 -Dsonar.projectName='jenkins-test2' -Dsonar.host.url=http://localhost:9000 -Dsonar.token=sqp_57edf26224e2b11859c51e620667740b14ef2753"
                }
                
            }
        }


        
        stage('Build Image') {
            steps {
                script {
                    bat 'docker build -t lucasycosta/tst-jenkins .'
                }
            }
        }
        stage('Run Container') {
            steps {
                script {
                    bat 'docker run --rm --name jenkins-teste -p 8080:8080 lucasycosta/tst-jenkins'
                }
            }
        }
    }
}