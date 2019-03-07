     pipeline {
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
                    sh '/var/lib/jenkins/tools/hudson.tasks.Maven_MavenInstallation/mvn_3.5.4/bin/mvn clean install'  
  }
}
			
		}
			}

  

     }
     } 
