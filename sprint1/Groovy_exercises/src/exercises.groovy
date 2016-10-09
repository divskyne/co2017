import java.util.List;

def name = "my name"
def date = new Date().format ("dd-mm-yyyy")
def fruitBag = ["orange","banana","coconut"]

// ex 01 (*). print "my name: 06-18-2016" on the output console using a GString

// ex 02 (*). use a loop for printing the members of
// the collection fruitBag

// ex 03 (*). define a function that given a range of integers,
// determines the average

// ex 04 (**). using a closure check whether fruitBag
// contains 'banana'

// ex 05 (**). using a closure check whether all the words
// in fruitBag contain the letter 'n'

/*			Begin		*/

//ex 01
println	name+":"+" "+date

//ex 02
for (fruit in fruitBag)
{
	println fruit
}

//ex 03
def findAverage(List nums)
{
	def sum
	for (i in nums)
	{
		sum+=i
	}
	sum=sum/2
}

//ex 04
println "Does fruitBag contains 'banana': "+fruitBag.contains("banana")

//ex 05
def containsN = fruitBag.collect{it -> it.contains("n")}
println "The words in fruitBag that contain the letter 'n': "+containsN