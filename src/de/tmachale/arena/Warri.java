package de.tmachale.arena;

public class Warri {

	private int life, attack, agi;
	public int getLife(){
		return life;
	}
	public void setLife(int life) {
		this.life = life;
	}
	public int getAttack() {
		return attack;
	}
	public void setAttack(int attack) {
		this.attack = attack;
	}
	public int getAgi() {
		return agi;
	}
	public void setAgi(int agi) {
		this.agi = agi;
	}
	public void setAgiForPc(int agi) {
		this.agi = agi-life-attack;
	}
	
}
