package junit_02;

//고용주가 구직자를 찾거나 그 반대 
public class Criterion implements Scoreable {
	   private Weight weight;
	   private Answer answer;
	   private int score;

	   public Criterion(Answer answer, Weight weight) {
	      this.answer = answer;
	      this.weight = weight;
	   }
	   
	   public Answer getAnswer() { return answer; }
	   public Weight getWeight() { return weight; }
	   
	   public void setScore(int score) { this.score = score; }
	   public int getScore() { return score; }
	}
