#!/bin/bash

echo "Iniciando config-server..."

docker compose up -d config-server 

sleep 300


echo "Esperando a que config-server esté disponible..."
until docker compose exec config-server nc -z localhost 7070; do
  sleep 1
done

echo "Iniciando registry-server..."
docker compose up -d registry-server 

echo "Esperando a que registry-server esté disponible..."
until docker compose exec registry-server nc -z localhost 8090; do
  sleep 1
done

echo "Iniciando el gateway-server..."
docker compose up -d gateway-server 

echo "Esperando a que gateway-server esté disponible..."
until docker compose exec gateway-server nc -z localhost 8080; do
  sleep 1
done


echo "Iniciando el admin-server..."
docker compose up -d admin-server 

echo "Esperando a que admin-server esté disponible..."
until docker compose exec admin-server nc -z localhost 6060; do
  sleep 1
done



echo "Iniciando el ms-auth..."
cd ms-auth
docker compose up -d  mysql-auth
echo "Esperando a que mysql-auth esté disponible..."
until docker compose exec mysql-auth sh -c 'curl -sSf "http://localhost:3306" > /dev/null'; do
  sleep 1
done
docker compose up -d ms-auth


echo "Iniciando el ms-asistencia..."
cd .. && cd ms-asistencia
docker compose up -d mysql-asistencia
echo "Esperando a que mysql-asistencia esté disponible..."
until docker compose exec mysql-asistencia sh -c 'curl -sSf "http://localhost:3306" > /dev/null'; do
  sleep 1
done
docker compose up -d ms-asistencia


echo "Iniciando el ms-configuracion..."
cd .. && cd ms-configuracion
docker compose up -d  mysql-configuration
echo "Esperando a que mysql-configuration esté disponible..."
until docker compose exec mysql-configuration sh -c 'curl -sSf "http://localhost:3306" > /dev/null'; do
  sleep 1
done
docker compose up -d ms-configuration


echo "Iniciando el bff-asistencia-web..."
cd .. && cd ms-bff-asistencia-web
docker compose up -d  

echo "Iniciando el ms-evento..."
cd .. && cd ms-evento
docker compose up -d  mysql-evento
echo "Esperando a que mysql-evento esté disponible..."
until docker compose exec mysql-evento sh -c 'curl -sSf "http://localhost:3306" > /dev/null'; do
  sleep 1
done
docker compose up -d ms-evento

echo "Todos los servicios están disponibles. Continuando con el script..."
