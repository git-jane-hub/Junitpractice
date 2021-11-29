package junit_02;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ProfileTest {

	//@Test
	public void test() {
		// profile을 생성
		Profile profile = new Profile("Bull Hockey, Inc.");
		// 질문을 만듦(상여를 받았나요?)
		Question question = new BooleanQuestion(1, "Got bonuses?");
		// 
		Answer profileAnswer = new Answer(question, Bool.FALSE);
		// criterion 객체를 만들어 답변과 가중치를 저장하는데, 
		Criteria criteria = new Criteria();
		// criteriaAnswer은 같은 질문과 기대하는 정답을 포함 
		Answer criteriaAnswer = new Answer(question, Bool.TRUE);
		Criterion criterion = new Criterion(criteriaAnswer, Weight.MustMatch);
		// criterion 객체를 criteria 객체에 추가
		criteria.add(criterion);
	}
	
	@Test
	public void matchAnswerFalseWhenMustMatchCriteriaNotMet() {
		Profile profile = new Profile("Bull Hockey, Inc.");
		Question question = new BooleanQuestion(1, "Got bonuses?");
		Answer profileAnswer = new Answer(question, Bool.FALSE);
		profile.add(profileAnswer);
		Criteria criteria = new Criteria();
		Answer criteriaAnswer = new Answer(question, Bool.TRUE);
		Criterion criterion = new Criterion(criteriaAnswer, Weight.MustMatch);
		criteria.add(criterion);
		boolean matches = profile.matches(criteria);
		assertFalse(matches);
	}

}
