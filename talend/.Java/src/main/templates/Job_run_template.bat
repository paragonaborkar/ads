%~d0
cd %~dp0
java ${talend.job.jvmargs} -cp ${talend.job.bat.classpath} ${talend.job.class} ${talend.job.bat.addition} %* 