pipeline{
    agent any
    tools{
        maven 'Maven'
    }
    stages{
        stage('checkout'){
            steps{
                git 'https://github.com/SubhadraChandu/healthcheckapp.git'
            }
        }
        stage('Build'){
            steps{
                sh 'mvn clean compile'
            }
        }
        stage('Test'){
            steps{
                sh 'mvn test'
                junit '**/target/surefire-reports/TEST-*.xml'
            }
        }
        stage('Deploy'){
            steps{
                input 'Do you approve the deployment'
                sh "ssh subhadrachandu@120.144.10.73 'nohup java -jar /Users/subhadra/Documents/IntelliJProjects/healthcheckapplication/target/healtcheck-ci-cd.jar &'"
            }
        }
    }
}