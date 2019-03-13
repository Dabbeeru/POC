     pipeline {
	     
	     environment {
    registry = "dilleswari/learning"
    registryCredential = 'dockerhub'
  }
          agent any
          stages {
              stage('Checkout external proj') {
                steps {
                    git branch: 'master',
                        credentialsId: 'gitlab',
                    url: 'https://github.com/Dabbeeru/POC.git'
        
                    sh "ls -lat"
                }
        		}
        	
            
              
            stage('creating package') {
      steps {
        withCredentials([[$class: 'UsernamePasswordMultiBinding', credentialsId:'anypoint.credentials', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD']]) 
        {
    sh 'echo "USERNAME $USERNAME PASSWORD $PASSWORD" '
           
  configFileProvider([configFile(fileId: 'maven-settings', variable: 'SETTINGS')]) {
                    sh '

docker run -it --rm --name my-maven-project -v "$PWD":/usr/src/app -w /usr/src/app maven:3.0.5-jdk-8 mvn clean install'  
  }
}
			
		}
			}
stage('Building image') {
      steps{
        script {
          docker.build registry + ":$BUILD_NUMBER"
		 sh 'docker build -t testimg '
        }
      }
    }
  

     }
     } 
