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
 ------------ 
 
 nginx->conf.d-> oauth-backend-client.conf dosyası
 
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