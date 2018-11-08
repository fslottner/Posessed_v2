package paket;

import java.util.LinkedList;

public class AbilityPosess extends Ability {

	private int range;
	private int time;

	public AbilityPosess(int range, int time, Handler handler, NPC owner) {
		super(handler, owner);

		this.range = range;
		this.time = time;

	}

	public void useFunction() {

		LinkedList<NPC> validTargets = Library.filterClass(NPC.class,
				Library.filterDistance(owner, handler.object, range));

	}

}
