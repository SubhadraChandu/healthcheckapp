pipeline {
    agent any
    tools{
        jdk "Java-1.8"
        Maven "Maven-3.0.5"
       }
    stages {
        stage('Build') {
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
            post {
	          always {
	                    junit 'target/surefire-reports/*.xml'
	                }
	            }
	        }
	        stage('Deliver') {
	            steps {
	                sh './jenkins/scripts/deliver.sh'
	            }
	        }
	    }
	}
