#spring-cloud-sso
1. create Mysql DB: test
2. config application.yml set db url:port,username,password
3. run Junit: MysqlApplicationTests to create default user
4. run com.yp.cloud.OauthApplication
5. run com.yp.cloud.ResourceApplication
6. run com.yp.cloud.WebApplication
#run some commands to verify in the terminal
1. run "curl -d 'username=user&password=user' 'http://localhost:8081/api/user/login' -v" to get SESSIONID= 668192EDDF148E7BEB61EAD295FA34DB
2. run "curl "http://localhost:8081/oauth/authorize?client_id=ssoclient&redirect_uri=http://localhost:8082/&response_type=code&scope=openid&state=b9dtIn" -v -H 'Cookie:SESSIONID= 668192EDDF148E7BEB61EAD295FA34DB'" to get oauth code
3. run "curl -d "redirect_uri=http://localhost:8082/&grant_type=authorization_code&code=q0F801' 'ssoclient:ssosecret@localhost:8081/oauth/token' -v" to get access_token
4. run "curl -H 'Authorization: Bearer 53507876-d334-45ce-a55a-cf137e907a78'  http://localhost:8081/" to get result

for more details, see: http://www.jianshu.com/p/adcbb0caa79e