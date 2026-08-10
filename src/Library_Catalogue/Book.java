package Library_Catalogue;

public class Book extends LibraryItemBase implements LibraryItem {

    private String title;
    private String author;
    private int pages;

    // Default constructor
    public Book() {
    }

    // Overloaded constructor
    public Book(String title, String author, int pages, String shelfCode) {
        setTitle(title);
        setAuthor(author);
        setPages(pages);
        setShelfCode(shelfCode);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title == null || title.isEmpty()) {
            System.out.println("Name cannot be empty.");
        } else {
            this.title = title;
        }
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        if (pages > 0) {
            this.pages = pages;
        } else {
            this.pages = 0;
            System.out.println("Pages must be above 0.");
        }
    }

    @Override
    public String getLabel() {
        return "Book: " + title;
    }

    @Override
    public void printAllInfo() {
        System.out.println(
                "Book: " + title
                        + " by " + author
                        + " (" + pages + " pages)"
                        + " [Shelf " + getShelfCode() + "]"
        );
    }
}


