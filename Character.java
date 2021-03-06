public class Character {
	private String name;	//character name
	private int level;	//character level
	private double exp;
	private int health;
	private int maxHealth;
	private int attack;
	private int defence;
	private int enemiesDefeted;
	private Moves [] learnedMoves;

	public Character(){
		name = "player";
		level = 1;
		exp = 0;
		health = 100;
		maxHealth = 100;
		attack = 20;
		defence = 20;
		enemiesDefeted = 0;
		learnedMoves = new Moves[3];
 	}
	
	public Character(String character, int lvl, double xp, int hp, int mHP, int att, int def, int count, Moves starterMove) {
		name = character;
		level = lvl;
		exp = xp;
		health = hp;
		maxHealth = mHP;
		attack = att;
		defence = def;
		enemiesDefeted = count;
		learnedMoves [0] = starterMove;
	}
	
	//setter classes defined here
	public void setName(String character) {
		name = character;
	}
	public void setLevel(int lvl) {
		level = lvl;
	}
	public void setEXP(double xp) {
		exp = xp;
	}
	public void setHP(int hp) {
		health = hp;
	}
	public void setMHP(int mHP) {
		maxHealth = mHP;
	}
	public void setATT(int att) {
		attack = att;
	}
	public void setDEF(int def) {
		defence = def;
	}
	public void setEnemiesDefeted(int count) {
		enemiesDefeted = count;
	}
	public void setMoves(Moves [] newMoves) {
		learnedMoves = newMoves;
	}
	
	//getter classes defined here
	public String getName() {
		return name;
	}
	public int getLevel() {
		return level;
	}
	public double getEXP() {
		return exp;
	}
	public int getHP() {
		return health;
	}
	public int getMHP() {
		return maxHealth;
	}
	public int getATT() {
		return attack;
	}
	public int getDEF() {
		return defence;
	}
	public int getEnemiesDefeted() {
		return enemiesDefeted;
	}
	public Moves [] getMoves() {
		return learnedMoves;
	}
	
	//Status classes
	public void levelUp() {
		level++;
	}
	public void levelDown() {	//maybe used for temporary items/pots?
		level--;
	}
	public void earnEXP(double xp) {
		exp += xp;
		if (exp >= level*level*1000) {
			level++;
		}
	}
	public void loseEXP(double xp) {
		exp -= xp;
	}
	public void heal(int healBack) {
		health += healBack;
	}
	public void damaged(int damage) {
		health -= damage;
	}
	public void HPup(int statpoints) {
		maxHealth += statpoints;
	}
	public void ATTup(int statpoints) {
		attack += statpoints;
	}
	public void DEFup(int statpoints) {
		defence += statpoints;
	}
	public void enemyKilled() {
		enemiesDefeted++;
	}
	
	//move classes
	public boolean addMove(Moves newMove) {
		for (int i = 0; i <= 3; i++) {
			if (learnedMoves[i] != null) {
				learnedMoves[i] = newMove;
				return true;
			}
		}
		return false;	//returns false if the user must be asked to replace an old move
	}
	
	public int getMovePosition(Moves move) {
		for (int i = 0; i < learnedMoves.length; i++) {
			if (move == learnedMoves[i]) {
				return i;
			}
		}
		return -1; //used as placeholder if no move found
	}
	
	public void swapMove(int movePos, Moves move) {
		learnedMoves[movePos] = move;
	}
	
	public void deleteMoveAtPostition(int movePos) { //need to test
		Moves[] outArray = new Moves[3]; 
		int j = 0;
		
		for (int i = 0; i >= 3; i++) {
			if (i == movePos) {
				i++;
			} else {
				outArray[j] = learnedMoves[i];
				j++;
			}
		}
		learnedMoves = outArray;
	}
	
	
	
	
	
}