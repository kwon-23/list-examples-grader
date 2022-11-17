# Create your grading script here
set -e
CPATH=".:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar"

rm -rf student-submission
git clone $1 student-submission

cd student-submission
if [[ ! -f "ListExamples.java" ]]
then
    echo "File ListExamples.java could not be found"
    exit
fi

cp ListExamples.java ..
cd ..

set +e
javac -cp $CPATH TestListExamples.java ListExamples.java

if [[ $? -eq 0 ]]
then 
    echo "Compilation of code failed."
    exit
fi

java -cp $CPATH org.junit.runner.JUnitCore TestListExamples > out.txt