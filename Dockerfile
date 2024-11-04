FROM gradle:8.4.0-jdk21

WORKDIR /hexlet-javalin

COPY . .

RUN gradle installDist

CMD ./build/install/HexletJavalin/bin/HexletJavalin