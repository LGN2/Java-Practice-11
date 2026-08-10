package Library_Catalogue;

public class Magazine extends LibraryItemBase implements LibraryItem {

    private String name;
    private int issueNumber;
    private String month;

    // Default constructor
    public Magazine() {
    }

    // Overloaded constructor
    public Magazine(String name, int issueNumber, String month, String shelfCode) {
        setName(name);
        setIssueNumber(issueNumber);
        setMonth(month);
        setShelfCode(shelfCode);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            IO.println("Name cannot be empty.");
        } else {
            this.name = name;
        }
    }

    public int getIssueNumber() {
        return issueNumber;
    }

    public void setIssueNumber(int issueNumber) {
        if (issueNumber >= 1 && issueNumber <= 500) {
            this.issueNumber = issueNumber;
        } else {
            IO.println("Invalid issue number.");
        }
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    @Override
    public String getLabel() {
        return "Magazine: " + name;
    }

    @Override
    public void printAllInfo() {
        IO.println("Magazine: " + name
                + " | Issue " + issueNumber
                + " | " + month
                + " [Shelf " + getShelfCode() + "]"
        );
    }
}


