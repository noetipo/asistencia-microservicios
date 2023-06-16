# Deploy docker

    docker build . -t registry-server
    docker run -d --name registry-server -p 8090:8090 registry-server