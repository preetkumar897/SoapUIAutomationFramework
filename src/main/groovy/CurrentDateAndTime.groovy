package groovy

class CurrentDateAndTime {
 
	static def dt(){
		def date = new Date()
		def dts = date.format("yyyy-MM-dd-HH-mm-ss")
		println (dts)
		println 'hello world'
		}
		
	
		
		static void main(String[] args) {
			dt();
		}
	
	
}
