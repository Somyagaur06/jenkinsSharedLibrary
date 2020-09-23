
def call(){
  
  
  pipeline{
    
    agent any
    environment{
    
    PATH="/usr/share/maven/bin/:$PATH"
 }
 

    
    stages{
        
       stage("Git checkout")
       {
           
           steps{
               
               git 'https://github.com/Somyagaur06/jenkinsDemo.git'
                }
          }
          
          
          stage("Maven Build")
          {
          
          steps{
   
     dir('/var/lib/jenkins/workspace/sharedLibraryDemo/jenkinsDemo'){
  
         sh "mvn clean package"
         
          }
          
          }
          }
          
           stage("Tomcat-Deployment over SSH"){
          
          steps{
          
          sshagent(['deploy_user']){
          
         sh " scp -o StrictHostKeyChecking=no /var/lib/jenkins/workspace/sharedLibraryDemo/jenkinsDemo/target/*.war ubuntu@172.31.1.78:/opt/apache-tomcat/webapps "

          
          }
           }
          }
          
          
          
          }
          
          post{
           failure{
          mail bcc: '', body: '''Hi,

This is to inform you that your recent build is failed.''', cc: '', from: '', replyTo: '', subject: 'Jenkins Build Failure ', to: 'gaursomya@yahoo.com'
          
          }
          
          
          success{
          mail bcc: '', body: '''Hi,

This is to inform you that your recent build is successfull.''', cc: '', from: '', replyTo: '', subject: 'Jenkins Build Success ', to: 'gaursomya@yahoo.com'
          
          
          }
          }
          
 
          
        }
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
}
