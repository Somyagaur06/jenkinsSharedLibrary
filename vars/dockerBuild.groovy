def call(){


node{
 
  


 stage("Git Checkout")
 {
 
   git 'https://github.com/Somyagaur06/jenkinsDemo.git'
 
 
 }



stage("Maven Build"){

 dir("/var/lib/jenkins/workspace/sharedLibrary2/jenkinsDemo"){

docker.image('maven:latest').inside{
 
 



sh "mvn clean package"

}}}


stage("Tomcat Deployment"){


sshagent(['deploy_user']){
          
  sh " scp -o StrictHostKeyChecking=no /var/lib/jenkins/workspace/sharedLibrary2/jenkinsDemo/target/*.war ubuntu@172.31.1.78:/opt/apache-tomcat/webapps "

          
}}
          
          

























}}






































