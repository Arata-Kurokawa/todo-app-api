docker build \
  --no-cache \
  --tag todo-app-api:0.0.1 \
  --target ${1:-dev}_mode \
  --file docker/api/Dockerfile \
  .