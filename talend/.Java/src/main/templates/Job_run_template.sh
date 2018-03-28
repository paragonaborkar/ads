#!/bin/sh
cd `dirname $0`
ROOT_PATH=`pwd`
java ${talend.job.jvmargs} -cp ${talend.job.sh.classpath} ${talend.job.class} ${talend.job.sh.addition} "$@" 