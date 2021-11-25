package junit_01;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ScoreCollectionTest {

	@Test
	void test() {	// 타깃 클래스(테스트 대상 클래스)
		// fail() 메서드로 인해 의도적으로 테스트 실패 상황을 만듦 -> 나중에 다른 테스트 코드로 교체
		fail("Not yet implemented");
	}
	
	@Test
	public void answersArithmeticMeanOfTwoNumbers() {
		// 준비(arrage)
		// ScoreCollection 인스턴스를 생성 
		ScoreCollection collection = new ScoreCollection();	
		// Scoreable 구현 객체로 add() 메서드 두번 호출(람다표현식을 사용해 Scoreable 인스턴스에서 원하는 값을 반환하도록 지정)
		collection.add(() -> 5);	
		collection.add(() -> 7);
		
		// 실행(act)
		int actualResult = collection.arithmeticMean();
	      
		// 단언(assert)
		// assertThat(실제 결과, matcher객체 - equalTo 매처로 실제 값과 기대값인 6을 비교)
		assertThat(actualResult, equalTo(6));
	   }
}
