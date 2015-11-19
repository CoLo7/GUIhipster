package hipster.model;

public class Hipster 
{
	private String name;
	private String [] hipsterPhrases;
	private Book [] hipsterBooks;
	
	public Hipster()
	{
		this.name = "";
		this.hipsterPhrases = new String[4];
		this.hipsterBooks = new Book[3];
		setupArray();
		setupBooks();
	}
	
	private void setupArray()
	{
		hipsterPhrases[0] = "That is so mainsteam!";
		hipsterPhrases[1] = "I don't mean to sound like a hipster, but,";
		hipsterPhrases[2] = "insert sarcastic";
		hipsterPhrases[3] = "I was into some before it was cool";
	}
	
	private void setupBooks()
	{
		Book firstBook, secondBook, thirdBook;
		
		firstBook = new Book();
		firstBook.setAuthor("Neal Stephenson");
		firstBook.setTitle("Diamond Age");
		firstBook.setSubject("Science Fiction");
		firstBook.setPageCount(405);
		firstBook.setPrice(24.99);
		
		secondBook = new Book();
		secondBook.setAuthor("Neal Stephenson");
		secondBook.setTitle("Diamond Age");
		secondBook.setSubject("Science Fiction");
		secondBook.setPageCount(405);
		secondBook.setPrice(24.99);
		
		thirdBook = new Book(457, "John Doe", "The Subject", "That One Book", 32.99);
		
		hipsterBooks[0] = firstBook;
		hipsterBooks[1] = secondBook;
		hipsterBooks[2] = thirdBook;		
	}
	
	public String getName() 
	{
		return name;
	}

	public String[] getHipsterPhrases() {
		return hipsterPhrases;
	}

	public Book[] getHipsterBooks() {
		return hipsterBooks;
	}

	public void setHipsterBooks(Book[] hipsterBooks) {
		this.hipsterBooks = hipsterBooks;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	public void setHipsterPhrases(String[] hipsterPhrases) {
		this.hipsterPhrases = hipsterPhrases;
	}

}
