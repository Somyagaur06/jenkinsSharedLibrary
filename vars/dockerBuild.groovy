def call(){


node{



 stage("Git Checkout")
 {
 
   git 'https://github.com/Somyagaur06/jenkinsDemo.git'
 
 
 }



stage("Maven Build"){


docker.image('maven:latest').inside{
 
 

sh "cd /var/lib/jenkins/workspace/declarativeDemo/jenkinsDemo"

sh "mvn clean package"

}}


stage("Tomcat Deployment"){


sshagent(['deploy_user']){
          
  sh " scp -o StrictHostKeyChecking=no /var/lib/jenkins/workspace/sharedLibrary2/jenkinsDemo/target/*.war ubuntu@172.31.1.78:/opt/apache-tomcat/webapps "

          
          }}
          
          

























}}






































