package solution

def name = "my name"
def date = new Date().format ("dd-mm-yyyy")
def fruitBag = ["orange","banana","coconut"]

// ex 01 (*). print "my name: 06-18-2016" on the output console using a GString
println "$name: $date"

// ex 02 (*). use a loop for printing the members of 
// the collection fruitBag
for (fruit in fruitBag) {
	println fruit
}

// ex 03 (*). define a function that given a range of integers, 
// determines the average
def avg(range) {
	def avg = 0;
	def pos = 0;
	for (i in range) {
		avg += i
		pos += 1
	}
	avg/pos
	
	// a one-liner solution for Groovy lovers 
	// range.sum()/range.size()
}

println avg(0..9)==4.5 // must be true
println avg(0..100)==50 // must be true

// ex 04 (**). using a closure check whether fruitBag 
// contains 'banana' 
println 'banana' == fruitBag.find({it=='banana'})

// ex 05 (**). using a closure check whether all the words
// in fruitBag contain the letter 'n'
println fruitBag.every({it.contains('n')})


