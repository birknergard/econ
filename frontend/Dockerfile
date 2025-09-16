# Use Node 20 LTS (supports your dependencies)
FROM node:20-buster-slim

WORKDIR /opt/frontend

COPY ./package*.json ./
RUN npm install

COPY . .

# RUN chown -R node:node /opt/frontend

# Default command
ENTRYPOINT ["npm", "run"]

# Generate service modules
CMD ["generate:api"]

# Run as web
CMD ["web"]

# Expose port
EXPOSE 8081 8082 8083

