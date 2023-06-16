# Deploy docker

    docker build . -t config-server
    docker run -d --name config-server -p 7070:7070 config-server