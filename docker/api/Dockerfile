# FROM openjdk:18-buster as base
# FROM openjdk:18-jdk-alpine3.14 as base
FROM amazoncorretto:8 as base

ENV SBT_VERSION 1.2.4
ENV SCALA_VERSION 2.12.8

WORKDIR /app

# RUN apk update && \
#     apk upgrade && \
#     apk add --update --no-cache
# RUN apk add curl

# RUN apt-get install software-properties-common
# RUN apt-get install python-software-properties
# RUN add-apt-repository ppa:webupd8team/java
# RUN apt-get update
# RUN apt-get install wget
# RUN apt-get install openjdk-8-jdk

# RUN \
#   curl -fsL "https://github.com/sbt/sbt/releases/download/v$SBT_VERSION/sbt-$SBT_VERSION.tgz" | tar xfz - -C /usr/share && \
#   chown -R root:root /usr/share/sbt && \
#   chmod -R 755 /usr/share/sbt && \
#   ln -s /usr/share/sbt/bin/sbt /usr/local/bin/sbt

# RUN \
#   echo "deb https://repo.scala-sbt.org/scalasbt/debian all main" | tee /etc/apt/sources.list.d/sbt.list && \
#   echo "deb https://repo.scala-sbt.org/scalasbt/debian /" | tee /etc/apt/sources.list.d/sbt_old.list && \
#   curl -sL "https://keyserver.ubuntu.com/pks/lookup?op=get&search=0x2EE0EA64E40A89B84B2DF73499E82A75642AC823" | apt-key add && \
#   apt-get update && \
#   apt-get install sbt 1.2.4

# RUN \
#   wget https://downloads.lightbend.com/scala/2.12.8/scala-2.12.8.deb && \
#   dpkg -i scala-2.12.8.deb

# sbt
RUN rm -f /etc/yum.repos.d/bintray-rpm.repo
RUN curl -L https://www.scala-sbt.org/sbt-rpm.repo > sbt-rpm.repo
RUN mv sbt-rpm.repo /etc/yum.repos.d/
RUN yum -y install sbt

FROM base as dev_mode

# RUN sbtl

ENTRYPOINT $0 $@

FROM base as prod

# アプリのソースをイメージ内にコピー
COPY ./ ./

RUN sbt compile