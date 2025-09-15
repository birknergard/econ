# Use Node 20 LTS (supports your dependencies)
FROM node:20-buster-slim

# Set environment
ARG NODE_ENV=development
ENV NODE_ENV=$NODE_ENV

ARG PORT=8081
ENV PORT=$PORT
EXPOSE $PORT 8082 8083

# Install global packages
ENV NPM_CONFIG_PREFIX=/home/node/.npm-global
ENV PATH=/home/node/.npm-global/bin:$PATH
RUN npm install -g expo-cli@latest --unsafe-perm

# Create working directory as root and set permissions
RUN mkdir -p /opt/frontend && chown node:node /opt/frontend
WORKDIR /opt/frontend
ENV PATH=/opt/frontend/.bin:$PATH

# Copy dependency files and install as node
COPY ./package.json ./package-lock.json ./
RUN npm install
RUN chown -R node:node /opt/frontend

# Switch to node user
USER node

# Set app directory (for bind mount)
WORKDIR /opt/frontend/app

# Default command
ENTRYPOINT ["npm", "run"]

# Generate services
CMD ["generate:api"]

# Run as web
CMD ["web"]
