
Deploy infra

    docker compose up -d config-server --build --force-recreate
    docker compose up -d registry-server --build --force-recreate
    docker compose up -d gateway-server --build --force-recreate
    docker compose up -d admin-server --build --force-recreate

deploy service 

    docker compose up -d  --build --force-recreate

Crear Demonio 
/etc/systemd/system/asistencia.service

    [Unit]
    Description=Inicio asistencia

    [Service]
    ExecStart=/home/asistencia-microservicios/deploy.sh

    [Install]
    WantedBy=multi-user.target
