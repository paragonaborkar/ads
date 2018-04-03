package Test;

public class Test {

	public static void main(String[] args) {
		
		//-replace '/vol/' -replace '[/].*$')
		String str="/vol/uat_cifs1_noqtree";
		System.out.println(str.replace("/vol/", "[/].*$"));
	}
}
