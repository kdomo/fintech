docker run -d \
--name fintech-redis \
-e REDIS_PASSWORD="fintech" \
-p 6379:6379 \
redis:latest