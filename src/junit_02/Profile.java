package junit_02;

import java.util.HashMap;
import java.util.Map;

// 좀 더 실전에 가까운 테스트 
// 구직 웹사이트 - 고용주와 구직자를 매치 
// 다수의 객관식 혹은 yes-no 질문에 대한 대답을 하는 프로파일 생성 
public class Profile {
	// 질문에 대한 답변
	private Map<String, Answer> answers = new HashMap<>();
	private int score;
	private String name;
	
	public Profile(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	// answer 객체를 profile에 추가 
	public void add(Answer answer) {
		answers.put(answer.getQuestionText(), answer);
	}
	
	// 다수의 Criterion 객체를 담는 Criteria 객체 
	public boolean matches(Criteria criteria) {
		score = 0;
		
		boolean kill = false;
		boolean anyMatches = false;
		
		for(Criterion criterion: criteria) {
			Answer answer = answers.get(criterion.getAnswer().getQuestionText());
			boolean match = criterion.getWeight() == Weight.DontCare || answer.match(criterion.getAnswer());
			
			if(!match && criterion.getWeight() == Weight.MustMatch) {
				kill = true;
			}
			
			if(match) {
				score += criterion.getWeight().getValue();
			}
			anyMatches |= match;
		}
		
		if(kill) {
			return false;
		}
		return anyMatches;
	}
	
	public int score() {
		return score;
	}
}
