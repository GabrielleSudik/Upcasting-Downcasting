class Machine{
	public void start() {
		System.out.println("Machine started.");
	}
}

class Camera extends Machine{
	public void start() {
		System.out.println("Camera started.");
	}
	
	public void snap() {
		System.out.println("Photo taken.");
	}
}


public class Application {

	public static void main(String[] args) {
		
		Machine mech1 = new Machine();
		Camera camera1 = new Camera();
		
		mech1.start();
		camera1.start();
		camera1.snap();
		
		//upcasting: it's how you change the variables
		//that refer to objects.
		Machine mech2 = camera1;
		
		//what this does is take the variable of camera1
		//(which refers to an object of Camera)
		//and makes the variable mech2 also refer to that same object
		//this is "up" because it goes from child to parent
		
		mech2.start();
		//mech2 now refers to a Camera object, so the Camera start method ran
		//BUT the variable type is still a Machine
		//and Machine can call only start, not snap.
		//so the following won't work, because there is no snap in Machine:
		//mech2.snap();
		
		//in other words, the variable type determines which methods can be called
		//but the variable's reference determines which method will run!
		
		//downcasting: 
		Machine mech3 = new Camera();
		Camera camera2 = (Camera)mech3;
		//when you downcast, you have to add which class you're casting to
		//like (Camera), so java knows what you're doing
		//like when you casted numerical values
		camera2.start();
		camera2.snap();
		
		//here's something that WON'T work:
		Machine mech4 = new Machine();
		Camera camera3 = (Camera)mech4;
		camera3.start();
		camera3.snap();
		//you'll get a runtime exception error.
		//why? because mech4 is a Machine
		//unlike mech3 which is a Camera.
		//I admit, I'm confused now lol.
		
		//upcasting is safe because child is always part of parent
		//downcasting is unsafe because child is not always part of parent
		//that's why we need the explicit (stuff) when we downcast
		
		//Finally, I have no idea when this would be used.
	}
}
