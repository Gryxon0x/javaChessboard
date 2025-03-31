package junit4;


import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;

import org.junit.Test;

public class HamcrestTest {
	
	@Test
	public void trojkatRownoboczny() {
		Trojkat trojkat = new Trojkat(2, 2, 2);
		assertThat(trojkat.toString(), equalTo("trójkąt równoboczny"));
	}
	
	@Test 
	public void dobryTrojkat() {		
		Trojkat trojkat = new Trojkat(2, 3, 4);
		assertThat(trojkat.toString(), endsWith("równoboczny"));
	}
	
	@Test 
	public void dobryTrojkat4() {		
		Trojkat trojkat = new Trojkat(3, 4, 5);
		assertThat(trojkat.toString(), containsString("prostokątny"));
	}
	
	@Test 
	public void dobryTrojkat2() {
		Trojkat trojkat = new Trojkat(3, 2, 4);
		assertThat(trojkat.toString(), not(endsWith("trójkąt")));
	}
	
	@Test 
	public void dobryTrojkat3() {
		Trojkat trojkat = new Trojkat(3, 2, 4);
		assertThat(trojkat.toString()).isNotEmpty();		
	}
}
