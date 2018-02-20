#  Create a new image from the base nodejs 7 image.
FROM node:8.9.4

#creates a mount point with the specified name.
#VOLUME /tmp

# Create the target directory in the imahge
RUN mkdir -p /usr/src/ads-frontend

# Set the created directory as the working directory
WORKDIR /usr/src/ads-frontend

# Copy the package.json inside the working directory
COPY package.json /usr/src/ads-frontend

# Install required dependencies
RUN npm install

# Copy the client application source files. You can use .dockerignore to exlcude files. Works just as .gitignore does.
COPY . /usr/src/ads-frontend

# Open port 4200. This is the port that our development server uses
EXPOSE 4200

# Start the application. This is the same as running ng serve.
CMD ["npm", "start"]


# docker build -t ads-frontend:latest --rm=true .
# docker run -p 4200:4200 -it -v  --detach --name ads-frontend-container --link ads-backend-container:ads-backend ads-frontend