
def call(String name='demo'){
  
  
  pipeline{
    
    agent any
   
 

    
    stages{
        
       stage("Git checkout")
       {
           
           steps{
               
               mail bcc: '', body: '''Hi,

This is to inform you that your recent build is failed.''', cc: '', from: '', replyTo: '', subject: 'Jenkins Build Failure ', to: 'gaursomya@yahoo.com'
          
                }
          }
          
          
    }}
  
  
  
  
  
  
  
  
  
  
  
  
  
}
