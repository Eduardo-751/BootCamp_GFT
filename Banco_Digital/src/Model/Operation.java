package Model;

public class Operation {
	
	private double value;
	private Account origin;
	private Account destination;
	private OperationType operation;
	
	//Constructor
	public Operation(double value, Account origin, Account destination, OperationType operation) {
		this.value = value;
		this.origin = origin;
		this.destination = destination;
		this.operation = operation;
		
	}

	//Gets and Sets
	public Account getOrigin() {
		return origin;
	}
	public Account getDestination() {
		return destination;
	}
	public OperationType getOperation() {
		return operation;
	}

	//Methods
	@Override
	public String toString() {
		if(destination != null)
			return "Operation = " + operation + "\nOrigin = " + origin.getClient().getEmail() + "\nDestination = " + destination.getClient().getEmail() + "\nValue = " + value + "\n";
		else
			return "Operation = " + operation + "\nOrigin = " + origin.getClient().getEmail() + "\nValue = " + value + "\n";
	}
	
}
