docker build -f Dockerfile -t tv-api .
docker run -p 8080:8080 -it tv-api
