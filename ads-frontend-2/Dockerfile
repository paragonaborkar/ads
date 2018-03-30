#  Create a new image from the base nodejs 7 image.
FROM node:8.9.4

#creates a mount point with the specified name.
#VOLUME /tmp

# Create the target directory in the image
RUN mkdir -p /usr/local/ads/ads-frontend

# Set the created directory as the working directory
WORKDIR /usr/local/ads/ads-frontend

# Copy the package.json inside the working directory
COPY ./ads-frontend-2/package.json /usr/local/ads/ads-frontend/package.json

# Install required dependencies
RUN npm install

# Copy the client application source files. You can use .dockerignore to exlcude files. Works just as .gitignore does.
COPY ./ads-frontend-2 /usr/local/ads/ads-frontend

# Open port 4200. This is the port that our development server uses
EXPOSE 4200

# Start the application. This is the same as running ng serve.
CMD ["npm", "start"]


# docker build -t ads-frontend:latest --rm=true .
# docker run -p 4200:4200 -itv --name ads-frontend-container --link ads-backend-container:ads-backend ads-frontend

# docker run -p 4200:4200 -itd --name ads-frontend-container ads-frontend