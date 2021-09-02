docker run \
  --publish 127.0.0.1:9000:9000 \
  --tty \
  --mount type=bind,source="$(pwd)",destination=/app \
  todo-app-api:0.0.1