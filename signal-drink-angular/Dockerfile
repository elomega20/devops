
# Étape de build
FROM node:latest AS build
WORKDIR /app
COPY package*.json ./
RUN npm install --force
RUN npm cache clean --force
COPY . ./

RUN npm run build

# Étape de serveur
FROM nginx:latest AS ngi
COPY --from=build /app/dist/angular-signals-example /usr/share/nginx/html
COPY nginx.conf /etc/nginx/conf.d/default.conf
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]

