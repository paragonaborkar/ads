#! /bin/sh

cp=""
for i in lib/* 
do
cp=${cp}:${i}
done
java -cp ${cp} com.javax0.license3j.License3j $*
echo ${cp}