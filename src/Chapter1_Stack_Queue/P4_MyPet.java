package Chapter1_Stack_Queue;

/*
 * �Զ�������࣬���ʱ���
 */
public class P4_MyPet {
	private P4_Pet pet;
	private long count;// ʱ���

	public P4_MyPet(P4_Pet pet, long count) {
		super();
		this.pet = pet;
		this.count = count;
	}

	public P4_Pet getPet() {
		return pet;
	}

	public long getCount() {
		return count;
	}

	public String getPetType() {
		return pet.getType();
	}

}
