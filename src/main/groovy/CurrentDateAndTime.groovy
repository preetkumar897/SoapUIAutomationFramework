package groovy
import genericlib.ExcelReader;

class CurrentDateAndTime {
 
	static def dt(){
		def date = new Date()
		def dts = date.format("yyyy-MM-dd-HH-mm-ss")
		println (dts)
		println 'hello preet'
		}
		
	
		
		static void main(String[] args) {
//			dt();
			ExcelReader excel = new ExcelReader();
			excel.excelFileReader();
		}
	
	
}
