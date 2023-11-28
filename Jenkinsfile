pipeline{
    agent any  

    tools{
        maven 'MAVEN_LOCAL'
    }

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
                bat "${scannerHome}/bin/sonar-scanner -e -Dsonar.projectKey=tst-jenkins -Dsonar.projectName='tst-jenkins' -Dsonar.host.url=http://localhost:9000 -Dsonar.java.binaries=target -Dsonar.token=sqp_dce8b7f508a420f1f53412b1be2de41706efa516"
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
                    bat 'docker stop jenkins-teste'
                }
            }
        }
    }
}