---
curl -X POST -d "grant_type=password&username=b&password=b&client_id=demo&client_secret=demo" http://localhost:18085/oauth/token

curl -X POST --user "demo:demo" -d "grant_type=password&username=b&password=b" http://localhost:18085/oauth/token

curl http://localhost:18084/api/employee-list-all/ -H "Authorization: Bearer 719b5c4f-42af-4a17-a7f1-81a0ae86ced2"

curl -X POST -H "Authorization: Basic ZGVtbzpkZW1v"  -d "grant_type=password&username=b&password=b&client_id=demo&client_secret=demo&scope=demoScope" http://localhost:18085/oauth/token

curl -X POST -d "grant_type=password&username=b&password=s&client_id=demo&client_secret=demo&scope=demoScope" http://localhost:18085/oauth/token

curl http://localhost:18085/api/user/hello -H "Authorization: Bearer 3dc7ca50-7091-41a5-8e3f-a00c56ff9b46"


=======
nginx->nginx.conf dosyası

  # oauth-backend-client-project in load balance
        upstream oauth-backend-client {
                #ip_hash;
                server 192.168.1.101:28084;
                server 192.168.1.103:28084;
        }

        ##  baska bir proje varsa onun load balance ı
        #  upstream bakcend2 {
        #        server ip:port;
        ## }

 
server {


        listen 80;
        listen [::]:80;
        root /var/www/html;
        server_name 192.168.1.101;
        location / {
                root /var/www/html/oauth-backed-folder;
                try_files $uri $uri/ /index.html;
        }

        location /backend/ {
                proxy_set_header Host $host;
                proxy_set_header X-Real-IP $remote_addr;
                proxy_set_header        X-Forwarded-For $proxy_add_x_forwarded_for;
                proxy_set_header        X-Forwarded-Proto $scheme;
                proxy_set_header X-Forwarded-For $remote_addr;
                proxy_pass http://oauth-backend-client/;
        }

}

