pipeline {
    agent any
    stages {  
	
	stage ('test:unit') {
			steps { 
				sh '''#!/bin/bash
				set -ex
			
				mvn -s settings.xml clean test '''
			}
		}
		stage ('build:install') {
			steps { 
				sh '''#!/bin/bash		
				set -ex	   
				mvn -s settings.xml package '''
			}
		}
		stage('deploy:dev') {
			environment {
				ANYPOINT_CREDENTIALS = credentials('anypoint.credentials') 
			}
			steps {				
				sh '''#!/bin/bash
				set -ex
				
				mvn -s settings.xml deploy \
				-DmuleDeploy \
				-DskipTests \
				-Danypoint.credentials.user=${ANYPOINT_CREDENTIALS_USR} \
				-Danypoint.credentials.pwd=${ANYPOINT_CREDENTIALS_PSW} \
				-Ddeploy.appname.prefix=dev- \
				-Ddeploy.environment=Dev \
				'''
			}
		}
		
		
		stage (googlestorage) {
		
		steps {
			sh '''#!/bin/bash
				set -ex
			gcloud auth activate-service-account --key-file /data/secret/mulsoft-account-technology-platform-235213.json	
			gsutil cp target/*.jar gs://shareservice-mulesoft-artifacts/mule-app-cicd-1.0.0-SNAPSHOT-mule-application-$BUILD_NUMBER.jar
			
		'''
			
			}
		}
		
    }
}		 		
		

		
