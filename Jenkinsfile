pipeline {
    agent any
    tools{
        jdk "jdk1.8"
        Maven "apache-maven-3.0.5"
    }
    stages {
        stage('Checkout') {
            steps {
            git url: 'https://github.com/SubhadraChandu/healthcheckapp.git'
        }
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
	}
