python Gen.py >TestCase.in
javac FlexZach.java 
java FlexZach <TestCase.in >TestCase.ans
javac FlexibleSpace.java 
java FlexibleSpace <TestCase.in >Comparable.ans
FC TestCase.ans Comparable.ans
