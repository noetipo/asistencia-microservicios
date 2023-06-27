#!/bin/bash

echo "Iniciando config-server..."

docker compose up -d config-server --build --force-recreate

echo "Esperando a que config-service esté disponible..."
until docker compose exec config-server nc -z localhost 7070; do
  sleep 1
done

echo "Iniciando registry-server..."
docker compose up -d registry-server --build --force-recreate

echo "Esperando a que registry-server esté disponible..."
until docker compose exec registry-server nc -z localhost 8090; do
  sleep 1
done


echo "Iniciando el gateway-server..."
docker compose up -d gateway-server --build --force-recreate

echo "Esperando a que gateway-server esté disponible..."
until docker compose exec gateway-server nc -z localhost 8080; do
  sleep 1
done


echo "Iniciando el admin-server..."
docker compose up -d admin-server --build --force-recreate

echo "Esperando a que admin-server esté disponible..."
until docker compose exec admin-server nc -z localhost 6060; do
  sleep 1
done




echo "Todos los servicios están disponibles. Continuando con el script..."
