FROM node:18-alpine as builder

WORKDIR /home/app

COPY package.json .
RUN npm install
COPY . .
RUN npm run build

FROM nginx:latest
WORKDIR /usr/share/nginx/html
RUN rm -rf ./*
COPY --from=builder /home/app/build .
ENTRYPOINT [ "nginx", "-g", "daemon off;" ]