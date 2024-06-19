FROM node:18-alpine

WORKDIR /home/app

COPY package.json ./
COPY app.js ./
RUN npm install
EXPOSE 8080

CMD [ "node", "app.js" ]