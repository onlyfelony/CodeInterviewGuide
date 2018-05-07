package Chapter1_Stack_Queue;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 猫狗队列☆
 */
public class P4_Cat_DogQueue {
	private Queue<P4_MyPet> dogQueue;
	private Queue<P4_MyPet> catQueue;
	private long numCount;
	
	public P4_Cat_DogQueue(){
		dogQueue = new LinkedList<P4_MyPet>();//用LinkedList实现队列
		catQueue = new LinkedList<P4_MyPet>();
		
	}
	
	public void add(P4_Pet pet){
		P4_MyPet myPet = new P4_MyPet(pet,numCount++);
		if(myPet.getPetType().equals("dog")){
			dogQueue.add(myPet);
		}else if(myPet.getPetType().equals("cat")){
			catQueue.add(myPet);
		}else{
			throw new RuntimeException("not dog or cat!");
		}
		
	}
	
	public P4_Pet pollAll(){
		if(dogQueue.isEmpty()&&catQueue.isEmpty()){
			throw new RuntimeException("You queue is empty !");
		}else if(dogQueue.isEmpty()){
			return catQueue.poll().getPet();
		}else if(catQueue.isEmpty()){
			return dogQueue.poll().getPet();
		}else{
			if(catQueue.peek().getCount()>dogQueue.peek().getCount()){
				return dogQueue.poll().getPet();
			}else{
				return catQueue.poll().getPet();
			}
		}
		
		
	}
	
	public P4_Dog pollDog(){
		if(dogQueue.isEmpty()){
			throw new RuntimeException("You dogQueue is empty !");
		}else{
			return (P4_Dog) dogQueue.poll().getPet(); 
		}
		
		
		
	}
	
	public P4_Cat pollCat(){
		if(catQueue.isEmpty()){
			throw new RuntimeException("You catQueue is empty !");
		}else{
			return (P4_Cat) catQueue.poll().getPet(); 
		}
		
	}
	
	public boolean isEmpty(){
		if(dogQueue.isEmpty()&&catQueue.isEmpty()){
			return true;
		}else{
			return false;
		}
	}
	
	
	public boolean isDogEmpty(){
		return dogQueue.isEmpty();
	}

	public boolean isCatEmpty(){
		return catQueue.isEmpty();
	}
	
	
	public static void main(String[] args) {
		
		P4_Cat_DogQueue test = new P4_Cat_DogQueue();

		P4_Pet dog1 = new P4_Dog();
		P4_Pet cat1 = new P4_Cat();
		P4_Pet dog2 = new P4_Dog();
		P4_Pet cat2 = new P4_Cat();
		P4_Pet dog3 = new P4_Dog();
		P4_Pet cat3 = new P4_Cat();

		test.add(dog1);
		test.add(cat1);
		test.add(dog2);
		test.add(cat2);
		test.add(dog3);
		test.add(cat3);



		while (!test.isDogEmpty()) {
			System.out.println(test.pollDog().getType());
		}
		while (!test.isEmpty()) {
			System.out.println(test.pollAll().getType());
		}
	}

}
