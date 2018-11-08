package paket;

public abstract class Ability {
	
	protected Handler handler;
	
	protected NPC owner;

	
	public Ability(Handler handler, NPC owner) {
		this.handler = handler;
		this.owner = owner;
	}
	
	public abstract void useFunction();
	
}
