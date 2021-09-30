docker run \
  --detach \
  --publish 127.0.0.1:9000:9000 \
  --tty \
  --mount type=bind,source="$(pwd)",destination=/app \
  --mount type=bind,source="${HOME}/.ivy2/",destination=/root/.ivy2 \
  todo-app-api:0.0.1 \
  /bin/bash