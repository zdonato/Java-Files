import java.util.ArrayList; 

public class Library{
	private ArrayList<Book> Books = new ArrayList<Book>(); 
    private String address; 
        
    public Library(String libAddress){
    	address = libAddress; 
    }
        
    static void printOpeningHours(){
        System.out.println("Libraries are open daily from 9am to 5pm."); 
    }
       
    void printAddress(){
        System.out.println(address); 
    }
        
    void addBook(Book newBook){
        Books.add(newBook);  
    }
        
    void printAvailableBooks(){
        if (Books.size() == 0){
    	    System.out.println("No books in the catalog.");
        } else {
			for (int i=0; i<Books.size(); i++){ 
           		if (Books.get(i) == null){
             		continue;
               	} else {
               		if (Books.get(i).isBorrowed() == false){
                   		System.out.println(Books.get(i).getTitle()); 
                   	} else {
                   		continue; 
                   	}
              	}
       		}
      	}
	}
        
    void borrowBook(String title){
		for (int k = 0; k < Books.size(); k++){
	   		if (Books.get(k) == null){
	       		System.out.println("Sorry this book is not in our catalog."); 
	           	break; 
	      	}
	       	if (Books.get(k).getTitle().equals(title)){
	       		if (Books.get(k).isBorrowed() == true){
	           		System.out.println("Sorry this book is already borrowed.");
	           		break; 
	        	} else {
	          		Books.get(k).Borrowed(); 
	               	System.out.println("You successfully borrowed "+ title + "."); 
	               	break; 
	           	}
	       	}
		}
    }

	void returnBook(String title){
		for (int k = 0; k < Books.size(); k++){
      		if (Books.get(k) == null) { 
           		System.out.println("Sorry this book is not in our catalog."); 
               	break; 
           	}
           	if (Books.get(k).getTitle().equals(title)){ 
              	Books.get(k).Returned();
               	System.out.println("You successfully returned " + title + ".");  
               	break; 
           	}
    	}
	}

    public static void main(String[] args) {
        // Create two libraries
        Library firstLibrary = new Library("10 Main St.");
        Library secondLibrary = new Library("228 Liberty St.");

        // Add four books to the first library
        firstLibrary.addBook(new Book("The Da Vinci Code"));
        firstLibrary.addBook(new Book("Le Petit Prince"));
        firstLibrary.addBook(new Book("A Tale of Two Cities"));
        firstLibrary.addBook(new Book("The Lord of the Rings"));

        // Print opening hours and the addresses
        System.out.println("Library hours:");
        printOpeningHours();
        System.out.println();

        System.out.println("Library addresses:");
        firstLibrary.printAddress();
        secondLibrary.printAddress();
        System.out.println();

        // Try to borrow The Lords of the Rings from both libraries
        System.out.println("Borrowing The Lord of the Rings:");
        firstLibrary.borrowBook("The Lord of the Rings");
        firstLibrary.borrowBook("The Lord of the Rings");
        secondLibrary.borrowBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of all available books from both libraries
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
        System.out.println();
        System.out.println("Books available in the second library:");
        secondLibrary.printAvailableBooks();
        System.out.println();

        // Return The Lords of the Rings to the first library
        System.out.println("Returning The Lord of the Rings:");
        firstLibrary.returnBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of available from the first library
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
    }
}